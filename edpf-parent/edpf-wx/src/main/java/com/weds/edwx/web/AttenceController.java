package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.core.utils.coder.AES7Coder;
import com.weds.core.utils.coder.Coder;
import com.weds.edpf.core.constant.CustomParams;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SettingParams;
import com.weds.edwx.entity.*;
import com.weds.edwx.service.*;
import com.weds.core.resp.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/attence")
public class AttenceController extends BaseController {

    @Autowired
    private AttenceService attenceService;

    @Resource
    private ManagementService managementService;

    @Resource
    private SettingParams settingParams;

    @Resource
    private SystemService systemService;

    @Resource
    private ScmParams scmParams;

    @Resource
    private CustomParams customParams;

    @Resource
    private MsgSendService msgSendService;

    @Logs
    @ApiOperation(value = "获取考勤记录?", notes = "获取考勤记录?")
    @RequestMapping(value = "/getKqjl", method = RequestMethod.POST)
    public JsonResult<Object> getKqjl(@RequestBody AttenceParamEntity attenceParamEntity) {
        List<AttenceEntity> list = attenceService.getKqjl(attenceParamEntity);
        if (list.size() > 0) {
            return succMsgData(list);
        } else {
            return failMsg("暂无考勤记录", list);
        }
    }

    @Logs
    @ApiOperation(value = "定位考勤打卡", notes = "定位考勤打卡")
    @RequestMapping(value = "/addKq", method = RequestMethod.POST)
    public JsonResult addKq(@RequestBody AddAttenceParamEntity addAttenceParamEntity) {
        try {
            String data = AES7Coder.decrypt(addAttenceParamEntity.getData(), new String(Coder.decryptBASE64(settingParams.getKey())));
            AddAttenceParamEntity entity = JSONObject.parseObject(data, AddAttenceParamEntity.class);
            entity.setJlType(1);
            try {
                if (!StringUtils.isBlank(entity.getImage())) {
                    String sj = DateUtils.formatDate(entity.getSj(), "yyyy-MM-dd");
                    String path = scmParams.getAttencePath() + File.separator + scmParams.getDevSerial().toString()
                            + File.separator + sj + File.separator;
                    String paths;
                    // synchronized (AttenceController.class) {
                    //     int fileNum = getMaxImageNum(path);
                    // paths = systemService.wxImageDownLoad(entity.getImage(), "jk" + String.format("%06d", fileNum),
                    //         "jpg", path, 1024, scmParams.getRootPath());
                    String fileNum = StringUtils.getUUID();
                    paths = systemService.wxImageDownLoad(entity.getImage(), "jk" + fileNum,
                            "jpg", path, 1024, scmParams.getRootPath());
                    entity.setJlzpSerial(fileNum);
                    // }
                    if (scmParams.isWatermark()) {
                        String[] temp = paths.split(",");
                        String remark = "打卡时间：" + DateUtils.formatDateTime(entity.getSj()) + "\n"
                                + "打卡地点：" + entity.getAddress();
                        for (String str : temp) {
                            ImageUtils.addWatermark(str, str, remark);
                        }
                    }
                    entity.setDevSerial(scmParams.getDevSerial());
                }
            } catch (Exception e) {
                e.printStackTrace();
                return failMsg();
            }
            //去掉移动端只能打三次卡的限制
            int code = attenceService.addKq(entity);
            if (code == 1) {
                return succMsg();
            } else {
                return message("603", "上班打卡最多三次", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public int test() {
        String sj = DateUtils.getCurrentDate();
        String path = scmParams.getAttencePath() + File.separator + scmParams.getDevSerial().toString()
                + File.separator + sj + File.separator;
        return getMaxImageNum(path);
    }

    private int getMaxImageNum(String path) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File file = new File(scmParams.getRootPath() + File.separator + path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] files = file.listFiles();
        int fileNum = 0;
        if (files.length > 0) {
            for (File file1 : files) {
                if (!file1.getName().endsWith("jpg")) {
                    continue;
                }
                int temp = Integer.parseInt(file1.getName().substring(2, file1.getName().lastIndexOf(".")));
                fileNum = Math.max(fileNum, temp);
            }
        }
        return fileNum + 1;
    }

    @Logs
    @ApiOperation(value = "外勤打卡", notes = "外勤打卡")
    @RequestMapping(value = "/addWq", method = RequestMethod.POST)
    public JsonResult addWq(@RequestBody AddOutAttenceParamEntity addOutAttenceParamEntity) {
        try {
            if (!StringUtils.isBlank(addOutAttenceParamEntity.getImages())) {
                String sj = DateUtils.formatDate(addOutAttenceParamEntity.getSj(), "yyyy-MM-dd");
                String path = scmParams.getAttencePath() + File.separator + scmParams.getDevSerial().toString()
                        + File.separator + sj + File.separator;
                String paths;
                // synchronized (AttenceController.class) {
                //     int fileNum = getMaxImageNum(path);
                // paths = systemService.wxImageDownLoad(addOutAttenceParamEntity.getImages(), "jk" + String.format("%06d", fileNum),
                //         "jpg", path, 1024, scmParams.getRootPath());
                String fileNum = StringUtils.getUUID();
                paths = systemService.wxImageDownLoad(addOutAttenceParamEntity.getImages(), "jk" + fileNum,
                        "jpg", path, 1024, scmParams.getRootPath());
                addOutAttenceParamEntity.setJlzpSerial(fileNum);
                // }

                if (scmParams.isWatermark()) {
                    String[] temp = paths.split(",");
                    String remark = "打卡时间：" + DateUtils.formatDateTime(addOutAttenceParamEntity.getSj()) + "\n"
                            + "打卡地点：" + addOutAttenceParamEntity.getAddress() + "\n"
                            + "备注信息：" + addOutAttenceParamEntity.getOutsideInfo();
                    for (String str : temp) {
                        ImageUtils.addWatermark(str, str, remark);
                    }
                }
                addOutAttenceParamEntity.setDevSerial(scmParams.getDevSerial());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        int code = attenceService.addWq(addOutAttenceParamEntity);
        if (code == 1) {
            if (scmParams.isOutside()) {
                OutsideEntity outsideEntity = new OutsideEntity();
                outsideEntity.setId(addOutAttenceParamEntity.getId());
                outsideEntity.setShenhe("system");
                attenceService.updateWqByPrimaryKeySelective(outsideEntity);

                String userName = managementService.findUserName(addOutAttenceParamEntity.getUserSerial());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username", userName);
                jsonObject.put("userplace", addOutAttenceParamEntity.getAddress());
                jsonObject.put("jlsj", DateUtils.formatDate(addOutAttenceParamEntity.getSj(), DateUtils.DATE_TIME_FORMAT));
                msgSendService.addMessage(Long.parseLong(addOutAttenceParamEntity.getUserSerial()), "100100", jsonObject,
                        null);
            }
            if (customParams.isOutsideMsg()) {
                OutsideEntity outsideEntity = attenceService.selectWqApproveUser(addOutAttenceParamEntity.getUserSerial());
                if (outsideEntity != null && !StringUtils.isBlank(outsideEntity.getUserSerial())) {
                    Map map = new HashMap();
                    // TODO: 2019/9/26 给审批人员发送消息
                    msgSendService.addMessage(Long.parseLong(outsideEntity.getUserSerial()), "", map,
                            addOutAttenceParamEntity.getId().toString());
                }
            }
            return succMsg();
        } else {
            return failMsg("超出外勤次数限制");
        }
    }

    @Logs
    @ApiOperation(value = "获取定位考勤经纬度及范围", notes = "获取定位考勤经纬度及范围")
    @RequestMapping(value = "/getRange", method = RequestMethod.POST)
    public JsonResult<Object> getRange(@RequestBody Map<String, String> map) {
        String userSerial = map.get("userSerial");
        List<RangeEntity> list = new ArrayList<>();
        if (customParams.getLocation() > 0) {
            list = attenceService.getRangeByUser(userSerial);
        } else {
            list = attenceService.getRange();
        }

        if (list.size() > 0) {
            return succMsgData(list);
        } else {
            return failMsg("暂无预设打卡范围,请到后台设置.", list);
        }
    }

    @Logs
    @ApiOperation(value = "获取班次信息", notes = "获取班次信息")
    @RequestMapping(value = "/newGetBanci", method = RequestMethod.POST)
    public JsonResult<Object> newGetBanci(@RequestBody Map<String, String> map) {
        String banciId = map.get("banciId");
        List<ShiftsEntity> list = attenceService.selectZtBanci(banciId);
        if (list.size() > 0) {
            return succMsgData(list);
        } else {
            return failMsg("班次不存在", list);
        }
    }

    @Logs
    @ApiOperation(value = "定位考勤获取打卡记录", notes = "定位考勤获取打卡记录")
    @RequestMapping(value = "/getKq", method = RequestMethod.POST)
    public JsonResult<Object> getKq(@RequestBody AttenceParamEntity attenceParamEntity) {
        //定位考勤页面，只能获取微信端的打卡记录，其他记录不可见
        List<AttenceEntity> list = attenceService.getKq(attenceParamEntity);
        if (list.size() > 0) {
            return succMsgData(list);
        } else {
            return failMsg("暂无数据");
        }
    }

    @Logs
    @ApiOperation(value = "定位考勤获取打卡记录", notes = "定位考勤获取打卡记录")
    @RequestMapping(value = "/getKqDetail", method = RequestMethod.POST)
    public JsonResult<Object> getKqDetail(@RequestBody AttenceParamEntity attenceParamEntity) {
        //定位考勤页面，只能获取微信端的打卡记录，其他记录不可见
        AttenceEntity attenceEntity = attenceService.getKqDetail(attenceParamEntity);
        if (attenceEntity != null) {
            String sj = DateUtils.formatDate(attenceEntity.getSj(), "yyyy-MM-dd");
            // String path = scmParams.getRootPath() + File.separator + scmParams.getAttencePath() + File.separator
            //         + scmParams.getDevSerial().toString() + File.separator + sj + File.separator
            //         + "jk" + String.format("%06d", attenceEntity.getJlzpSerial()) + ".jpg";
            String path = scmParams.getRootPath() + File.separator + scmParams.getAttencePath() + File.separator
                    + scmParams.getDevSerial().toString() + File.separator + sj + File.separator
                    + "jk" + attenceEntity.getJlzpSerial() + ".jpg";
            try {
                attenceEntity.setImage(ImageUtils.imgToBase64(path));
            } catch (Exception e) {
                return failMsg();
            }
            return succMsgData(attenceEntity);
        } else {
            return failMsg("暂无数据");
        }
    }

    @Logs
    @ApiOperation(value = "获取打卡记录", notes = "获取打卡记录")
    @RequestMapping(value = "/getKqInfo", method = RequestMethod.GET)
    public JsonResult<Object> getKqInfo(@RequestParam Integer bh) {
        //定位考勤页面，只能获取微信端的打卡记录，其他记录不可见
        KtJlEntity ktJlEntity = attenceService.getKqInfo(bh);
        if (ktJlEntity != null) {
            String sj = DateUtils.formatDate(ktJlEntity.getSj(), "yyyy-MM-dd");
            String path = scmParams.getRootPath() + File.separator + scmParams.getAttencePath() + File.separator
                    + ktJlEntity.getDevSerial() + File.separator + sj + File.separator
                    + "jk" + String.format("%06d", ktJlEntity.getJlzpSerial()) + ".jpg";
            try {
                ktJlEntity.setImage(ImageUtils.imgToBase64(path));
            } catch (Exception e) {
                return failMsg();
            }
            return succMsgData(ktJlEntity);
        } else {
            return failMsg("暂无数据");
        }
    }

    @Logs
    @ApiOperation(value = "获取考勤汇总数据", notes = "获取考勤汇总数据")
    @RequestMapping(value = "/kqHzNew", method = RequestMethod.POST)
    public JsonResult<Object> kqHzNew(@RequestBody AttenceParamEntity attenceParamEntity) {
        List<AttenceSummaryEntity> list = attenceService.newGetKqhz(attenceParamEntity);
        if (list.size() > 0) {
            return succMsgData(list);
        } else {
            return failMsg("暂无数据");
        }
    }

    @Logs
    @ApiOperation(value = "作用未知,原ASP newkq_jl接口", notes = "作用未知,原ASP newkq_jl接口")
    @RequestMapping(value = "/newKqJl", method = RequestMethod.POST)
    public JsonResult<Object> newKqJl(@RequestBody AttenceParamEntity attenceParamEntity) {
        attenceParamEntity.setFormatDate(DateUtils.formatDate(attenceParamEntity.getDates(), DateUtils.DATE_TIME_FORMAT));
        return succMsgData(attenceService.newKqJl(attenceParamEntity));
    }

    @Logs
    @ApiOperation(value = "作用未知,原ASP newkq_mx接口", notes = "作用未知,原ASP newkq_mx接口")
    @RequestMapping(value = "/newKqMx", method = RequestMethod.POST)
    public JsonResult<Object> newKqMx(@RequestBody AttenceParamEntity attenceParamEntity) {
        attenceParamEntity.setFormatDate(DateUtils.formatDate(attenceParamEntity.getDates(), DateUtils.DATE_TIME_FORMAT));
        return succMsgData(attenceService.newKqMx(attenceParamEntity));
    }


    @Logs
    @ApiOperation(value = "获取外勤记录", notes = "获取外勤记录")
    @RequestMapping(value = "/selectWqListByEntity", method = RequestMethod.POST)
    public JsonResult<Object> selectWqListByEntity(@RequestBody BasePageSearch<OutsideEntity> record) {
        setPageHelper(record);
        OutsideEntity entity = record.getSearch();
        if (entity == null) {
            entity = new OutsideEntity();
        }
        List<OutsideEntity> list = attenceService.selectWqListByEntity(entity);
        return succMsgData(new BaseCommPager<OutsideEntity>(list));
    }

    @Logs
    @ApiOperation(value = "更新外勤记录", notes = "更新外勤记录")
    @RequestMapping(value = "/updateWqByPrimaryKeySelective", method = RequestMethod.POST)
    public JsonResult<Object> updateWqByPrimaryKeySelective(@RequestBody OutsideEntity outsideEntity) {
        attenceService.updateWqByPrimaryKeySelective(outsideEntity);
        if (customParams.isOutsideMsg()) {
            OutsideEntity entity = attenceService.selectWxByPrimaryKey(outsideEntity.getId());
            Map map = new HashMap();
            // TODO: 2019/9/26 给申请人员发送消息
            msgSendService.addMessage(Long.parseLong(entity.getUserSerial()), "", map,
                    entity.getId().toString());

            // TODO: 2019/9/26 给抄送人员发送消息
            List<ManagementEntity> list = managementService.selectCopyUser("7", Long.parseLong(entity.getUserSerial()));
            for (ManagementEntity managementEntity : list) {
                msgSendService.addMessage(Long.parseLong(managementEntity.getUserSerial()), "", map,
                        entity.getId().toString());
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询外勤详情", notes = "查询外勤详情")
    @RequestMapping(value = "/selectWxByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<OutsideEntity> selectWxByPrimaryKey(@RequestParam Long id) {
        OutsideEntity outsideEntity = attenceService.selectWxByPrimaryKey(id);
        return succMsgData(outsideEntity);
    }
}
