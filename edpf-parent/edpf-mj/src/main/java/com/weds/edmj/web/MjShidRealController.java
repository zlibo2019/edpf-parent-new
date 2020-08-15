package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edmj.entity.MjRuleRealEntity;
import com.weds.edmj.entity.MjSdRuleRealEntity;
import com.weds.edmj.entity.WtMjVerEntity;
import com.weds.edmj.service.MjRuleRealService;
import com.weds.edmj.service.MjSdRuleRealService;
import com.weds.edmj.service.WtMjVerService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.MjShidRealEntity;
import com.weds.edmj.service.MjShidRealService;

/**
 * @Author sxm
 * @Description MjShidReal管理
 * @Date 2019-07-25
 */
@RestController
@RequestMapping(value = "/mjShidReal")
@Api(value = "MjShidReal管理", description = "MjShidReal管理")
public class MjShidRealController extends BaseController {
    @Autowired
    private MjShidRealService mjShidRealService;

    @Autowired
    private MjSdRuleRealService mjSdRuleRealService;

    @Autowired
    private MjRuleRealService mjRuleRealService;

    @Autowired
    private WtMjVerService wtMjVerService;

    @Resource
    private HttpServletRequest request;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MjShidReal信息", notes = "新增MjShidReal信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody @Valid MjShidRealEntity record) {
        if (record.getRuleNo() == 1) {
            return failMsg("默认时段不允许操作");
        }

        Map map = mjShidRealService.selectShidCount(record.getRuleNo().toString());
        int nums = Integer.parseInt(map.get("nums").toString());
        int num = Integer.parseInt(map.get("num").toString());
        if (nums >= 2000 && num >= 20) {
            return failMsg();
        }
        Map map2 = mjShidRealService.selectMaxBh();
        if (map2 == null) {
            record.setBh(1);
        } else {
            record.setBh(Integer.parseInt(map2.get("bh").toString()));
        }

        mjShidRealService.insertSelective(record);

        MjSdRuleRealEntity mjSdRuleRealEntity = new MjSdRuleRealEntity();
        mjSdRuleRealEntity.setRuleNo(record.getRuleNo().toString());
        mjSdRuleRealEntity.setSdNo(record.getBh().toString());
        mjSdRuleRealEntity.setSdLevel(0);
        mjSdRuleRealEntity.setSdRela(0);
        mjSdRuleRealService.insertSelective(mjSdRuleRealEntity);

        MjRuleRealEntity mjRuleRealEntity = new MjRuleRealEntity();
        mjRuleRealEntity.setRuleNo(record.getRuleNo());
        mjRuleRealEntity.setRuleCount(num + 1);
        mjRuleRealService.updateByPrimaryKeySelective(mjRuleRealEntity);

        WtMjVerEntity wtMjVerEntity = new WtMjVerEntity();
        wtMjVerEntity.setType(0);
        wtMjVerEntity.setLogLx(1);
        wtMjVerEntity.setLx(0);
        wtMjVerEntity.setLogBz(record.getBh().toString());
        wtMjVerEntity.setLogSj(new Date());
        wtMjVerEntity.setLogIp(request.getRemoteAddr());
        wtMjVerEntity.setGlyNo("");
        wtMjVerService.insertSelective(wtMjVerEntity);

        wtMjVerEntity = new WtMjVerEntity();
        wtMjVerEntity.setType(0);
        wtMjVerEntity.setLogLx(1);
        wtMjVerEntity.setLx(1);
        wtMjVerEntity.setLogBz(record.getRuleNo().toString() + "," + record.getBh().toString());
        wtMjVerEntity.setLogSj(new Date());
        wtMjVerEntity.setLogIp(request.getRemoteAddr());
        wtMjVerEntity.setGlyNo("");
        wtMjVerService.insertSelective(wtMjVerEntity);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MjShidReal信息", notes = "更新MjShidReal信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MjShidRealEntity record) {
        if (record.getRuleNo() == 1) {
            return failMsg("默认时段不允许操作");
        }

        mjShidRealService.updateByPrimaryKeySelective(record);

        WtMjVerEntity wtMjVerEntity = new WtMjVerEntity();
        wtMjVerEntity.setType(0);
        wtMjVerEntity.setLogLx(1);
        wtMjVerEntity.setLx(0);
        wtMjVerEntity.setLogBz(record.getBh().toString());
        wtMjVerEntity.setLogSj(new Date());
        wtMjVerEntity.setLogIp(request.getRemoteAddr());
        wtMjVerEntity.setGlyNo("");
        wtMjVerService.insertSelective(wtMjVerEntity);

        wtMjVerEntity = new WtMjVerEntity();
        wtMjVerEntity.setType(0);
        wtMjVerEntity.setLogLx(1);
        wtMjVerEntity.setLx(1);
        wtMjVerEntity.setLogBz(record.getRuleNo().toString() + "," + record.getBh().toString());
        wtMjVerEntity.setLogSj(new Date());
        wtMjVerEntity.setLogIp(request.getRemoteAddr());
        wtMjVerEntity.setGlyNo("");
        wtMjVerService.insertSelective(wtMjVerEntity);

        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjShidReal清单", notes = "查询MjShidReal清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjShidRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MjShidRealEntity> record) {
        setPageHelper(record);
        MjShidRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MjShidRealEntity();
        }
        List<MjShidRealEntity> list = mjShidRealService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MjShidRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询MjShidReal列表", notes = "查询MjShidReal列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MjShidRealEntity>> selectListByEntity(@RequestBody MjShidRealEntity record) {
        List<MjShidRealEntity> list = mjShidRealService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MjShidReal信息", notes = "删除MjShidReal信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @Transactional
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer bh) {
        MjShidRealEntity mjShidRealEntity = mjShidRealService.selectByPrimaryKey(bh);

        if (mjShidRealEntity.getRuleNo() == 1) {
            return failMsg("默认时段不允许操作");
        }

        mjShidRealService.deleteByPrimaryKey(bh);

        MjSdRuleRealEntity mjSdRuleRealEntity = new MjSdRuleRealEntity();
        mjSdRuleRealEntity.setRuleNo(mjShidRealEntity.getRuleNo().toString());
        mjSdRuleRealEntity.setSdNo(bh.toString());
        mjSdRuleRealService.deleteByCondition(mjSdRuleRealEntity);

        WtMjVerEntity wtMjVerEntity = new WtMjVerEntity();
        wtMjVerEntity.setType(0);
        wtMjVerEntity.setLogLx(3);
        wtMjVerEntity.setLx(0);
        wtMjVerEntity.setLogBz(mjShidRealEntity.getBh().toString());
        wtMjVerEntity.setLogSj(new Date());
        wtMjVerEntity.setLogIp(request.getRemoteAddr());
        wtMjVerEntity.setGlyNo("");
        wtMjVerService.insertSelective(wtMjVerEntity);

        wtMjVerEntity = new WtMjVerEntity();
        wtMjVerEntity.setType(0);
        wtMjVerEntity.setLogLx(3);
        wtMjVerEntity.setLx(1);
        wtMjVerEntity.setLogBz(mjShidRealEntity.getRuleNo().toString() + "," + mjShidRealEntity.getBh().toString());
        wtMjVerEntity.setLogSj(new Date());
        wtMjVerEntity.setLogIp(request.getRemoteAddr());
        wtMjVerEntity.setGlyNo("");
        wtMjVerService.insertSelective(wtMjVerEntity);

        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MjShidReal信息", notes = "查询MjShidReal信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MjShidRealEntity> selectByPrimaryKey(@RequestParam Integer bh) {
        MjShidRealEntity entity = mjShidRealService.selectByPrimaryKey(bh);
        if (entity.getRuleNo() == 1) {
            return failMsg("默认时段不允许操作");
        }

        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询MjShidReal信息", notes = "关键字查询MjShidReal信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MjShidRealEntity>> selectListByKeys(@RequestBody BasePageSearch<MjShidRealEntity> record) {
        setPageHelper(record);
        List<MjShidRealEntity> list = mjShidRealService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<MjShidRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除MjShidReal信息", notes = "批量删除MjShidReal信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<MjShidRealEntity> list) {
        // List<MjShidRealEntity> list = JSONObject.parseArray(keys, MjShidRealEntity.class);
        List<MjShidRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                mjShidRealService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增MjShidReal信息", notes = "批量新增MjShidReal信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<MjShidRealEntity> list = JSONObject.parseArray(data, MjShidRealEntity.class);
        mjShidRealService.insertBatch(list);
        return succMsg();
    }
}