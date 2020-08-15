package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.MsgSendEntity;
import com.weds.edwx.entity.RepairInfoEntity;
import com.weds.edwx.entity.RepairTypeParamEntity;
import com.weds.edwx.entity.UserEntity;
import com.weds.edwx.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author sxm
 * @Description RepairInfo管理
 * @Date 2019-02-23
 */
@RestController
@RequestMapping(value = "/repairInfo")
@Api(value = "RepairInfo管理", description = "RepairInfo管理")
public class RepairInfoController extends BaseController {
    @Autowired
    private RepairInfoService repairInfoService;
    @Resource
    private SystemService systemService;
    @Resource
    private RepairTypeParamService repairTypeParamService;
    @Resource
    private MsgSendService msgSendService;
    @Resource
    private UserService userService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增RepairInfo信息", notes = "新增RepairInfo信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody RepairInfoEntity record) {
        Date date = new Date();
        String id = StringUtils.getUUID();
        record.setStartDate(date);
        record.setCtDate(date);
        record.setLtDate(date);
        RepairTypeParamEntity repairTypeParamEntity = repairTypeParamService.selectByPrimaryKey("0", record.getRepairType());
        record.setRepairUser(repairTypeParamEntity.getUserSerial());
        record.setId(id);
        String repairPhoto = null;
        try {
            repairPhoto = systemService.wxImageDownLoad(record.getRepairPhoto());
        } catch (Exception e) {
            e.printStackTrace();
        }
        record.setRepairPhoto(repairPhoto);
        repairInfoService.insertSelective(record);

        MsgSendEntity entity = new MsgSendEntity();
        String strDate = DateUtils.getCurrentDateTime();
        entity.setUserSerial(Long.valueOf(repairTypeParamEntity.getUserSerial()));
        entity.setMsgState(0);
        entity.setRecordDate(strDate);
        entity.setInsertDate(strDate);
        entity.setTempletId("100900");
        Map<String, String> map = new HashMap<>();
        map.put("repairType", repairTypeParamEntity.getTypeName());
        map.put("repairDate", DateUtils.formatDate(date, DateUtils.DATE_TIME_FORMAT));
        UserEntity userEntity = userService.selectByPrimaryKey(Long.valueOf(repairTypeParamEntity.getUserSerial()));
        map.put("userName", userEntity.getUserLname());
        map.put("userTel", record.getInitiatorTel());
        map.put("initiatorRemark", record.getInitiatorRemark());
        entity.setMesContent(toJson(map));
        entity.setMsgXh(id);
        msgSendService.insertSelective(entity);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新RepairInfo信息", notes = "更新RepairInfo信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody RepairInfoEntity record) {
        MsgSendEntity entity = new MsgSendEntity();
        Date date = new Date();
        if ("1".equals(record.getRepairState())) {
            record.setEndDate(date);

            String resultPhoto = null;
            try {
                resultPhoto = systemService.wxImageDownLoad(record.getResultPhoto());
            } catch (Exception e) {
                e.printStackTrace();
            }
            record.setResultPhoto(resultPhoto);

            RepairInfoEntity repairInfoEntity = repairInfoService.selectByPrimaryKey(record.getId());
            String strDate = DateUtils.getCurrentDateTime();
            entity.setUserSerial(Long.valueOf(repairInfoEntity.getInitiatorUser()));
            entity.setMsgState(0);
            entity.setRecordDate(strDate);
            entity.setInsertDate(strDate);
            entity.setTempletId("100902");
            Map<String, String> map = new HashMap<>();
            // String temp = DateUtils.formatDate(repairInfoEntity.getStartDate(), DateUtils.DATE_TIME_FORMAT);
            String content = "您提交的报修已维修完成";
            map.put("content", content);
            UserEntity userEntity = userService.selectByPrimaryKey(Long.valueOf(repairInfoEntity.getRepairUser()));
            map.put("userName", userEntity.getUserLname());
            map.put("repairDate", strDate);
            entity.setMesContent(toJson(map));
            entity.setMsgXh(record.getId());
            msgSendService.insertSelective(entity);
        }

        if ("1".equals(record.getReadFlag())) {
            record.setEndDate(date);
            RepairInfoEntity repairInfoEntity = repairInfoService.selectByPrimaryKey(record.getId());
            String strDate = DateUtils.getCurrentDateTime();
            entity.setUserSerial(Long.valueOf(repairInfoEntity.getInitiatorUser()));
            entity.setMsgState(0);
            entity.setRecordDate(strDate);
            entity.setInsertDate(strDate);
            entity.setTempletId("100901");
            Map<String, String> map = new HashMap<>();
            map.put("id", record.getId());
            UserEntity userEntity = userService.selectByPrimaryKey(Long.valueOf(repairInfoEntity.getRepairUser()));
            map.put("operateDate", strDate);
            map.put("repairState", "处理中");
            map.put("userName", userEntity.getUserLname());
            entity.setMesContent(toJson(map));
            entity.setMsgXh(record.getId());
            msgSendService.insertSelective(entity);
        }

        record.setLtDate(date);
        repairInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询RepairInfo清单", notes = "查询RepairInfo清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RepairInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RepairInfoEntity> record) {
        setPageHelper(record);
        RepairInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RepairInfoEntity();
        }
        List<RepairInfoEntity> list = repairInfoService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<RepairInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询RepairInfo列表", notes = "查询RepairInfo列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RepairInfoEntity>> selectListByEntity(@RequestBody RepairInfoEntity record) {
        List<RepairInfoEntity> list = repairInfoService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除RepairInfo信息", notes = "删除RepairInfo信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String id) {
        repairInfoService.deleteByPrimaryKey(id);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询RepairInfo汇总信息", notes = "查询RepairInfo汇总信息")
    @RequestMapping(value = "/selectSumInfoByEntity", method = RequestMethod.POST)
    public JsonResult<List> selectSumInfoByEntity(@RequestBody RepairInfoEntity record) {
        List<Map> list = repairInfoService.selectSumInfoByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "查询RepairInfo信息", notes = "查询RepairInfo信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<RepairInfoEntity> selectByPrimaryKey(@RequestParam String id) {
        RepairInfoEntity entity = repairInfoService.selectByPrimaryKey(id);
        if (!StringUtils.isBlank(entity.getRepairPhoto())) {
            List<String> photoPath = new ArrayList<>();
            String[] temp = entity.getRepairPhoto().split(",");
            for (String str : temp) {
                try {
                    photoPath.add(ImageUtils.imgToBase64(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            entity.setPhotoList(photoPath);
        }

        if (!StringUtils.isBlank(entity.getResultPhoto())) {
            List<String> photoPath = new ArrayList<>();
            String[] temp = entity.getResultPhoto().split(",");
            for (String str : temp) {
                try {
                    photoPath.add(ImageUtils.imgToBase64(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            entity.setResultPhotoList(photoPath);
        }
        return succMsgData(entity);
    }
}