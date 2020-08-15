package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edmj.service.DoorfxRealService;
import com.weds.edmj.service.JrealMjCameraService;
import com.weds.edmj.service.MjUserRuleRealService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.DoorRealEntity;
import com.weds.edmj.service.DoorRealService;

/**
 * @Author lqj
 * @Description DoorReal管理
 * @Date 2019-07-29
 */
@RestController
@RequestMapping(value = "/doorReal")
@Api(value = "DoorReal管理", description = "DoorReal管理")
public class DoorRealController extends BaseController {
    @Autowired
    private DoorRealService doorRealService;
    @Autowired
    private DoorfxRealService doorfxRealService;
    @Autowired
    private MjUserRuleRealService mjUserRuleRealService;

    @Autowired
    private JrealMjCameraService jrealMjCameraService;

    @Autowired
    private DicFmtBean fmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增门", notes = "新增门")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid DoorRealEntity record) {
        //先判断门名称是否重复
        int countName = doorRealService.selectCountByEntity(record);
        if (countName > 0) {
            return failMsg("门名称重复，请重新输入");
        }
        if (StringUtils.isBlank(record.getDevSerial())) { //未关联设备
            record.setBh(doorRealService.getDoorBh());
            record.setSj(new Date());
            record.setFxFlg(0);
            record.setIsForcein(1);
            doorRealService.insertSelective(record);//新增门
            //新增门与场所关系
            doorRealService.insertDepDoorRelation(record);
        } else { //已关联设备
            if (doorRealService.selectDevStateByEntity(record) > 0) {
                return failMsg("该设备已经被其他门添加");
            }
            doorRealService.insertDoorInfo(record);//插入门相关表
            doorRealService.insertDoorfxInfo(record);//插入门方向相关表
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "修改门", notes = "修改门")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid DoorRealEntity record) {
        //查出来门禁信息
        DoorRealEntity old = doorRealService.selectByPrimaryKey(record.getBh());
        if (old == null) {
            return failMsg("您要修改的门不存在，请刷新后重试");
        }
        if (StringUtils.isBlank(record.getDoorName())) { //单独修改访客是否访问、请假是否能进出
            doorRealService.updateByPrimaryKeySelective(record);
            //插入日志
            return succMsg();
        }
        if (!old.getDoorName().equals(record.getDoorName())) {//门名称修改
            //判断门名称是否存在
            DoorRealEntity newDoor = new DoorRealEntity();
            newDoor.setDoorName(record.getDoorName());
            //先判断门名称是否重复
            int countName = doorRealService.selectCountByEntity(newDoor);
            if (countName > 0) {
                return failMsg("门名称重复，请重新输入");
            }
        }
        if (StringUtils.isBlank(record.getDevSerial())) { //未关联门控器
            if (!StringUtils.isBlank(old.getDevSerial())) { //以前关联门控器
                //插入全量日志更新 0，1，2，3
                //更新电子地图信息 前期不用
                //更新摄像头列表
                doorRealService.insertJrealUpdate(old, true, true);
            }
            //删除门方向表
            doorfxRealService.deleteByPrimaryKey(record.getBh());
            doorRealService.updateByPrimaryKeySelective(record);//更新门定义表
            return succMsg();
        }
        if (record.getDevSerial().equals(old.getDevSerial()) && old.getDevOrder() == record.getDevOrder() && record.getDevOrder() != 9) { //关联的门控器未修改
            doorRealService.updateDoorFxInfo(record); //修改门方定义表
            //插入增量日志
            doorRealService.insertWtMjVer(record);

        } else { //关联的门控器修改
            if (doorRealService.selectDevStateByEntity(record) > 0) {
                return failMsg("该设备已经被其他门添加，请刷新后重新选择");
            }
            //删除门方向表
            doorfxRealService.deleteByPrimaryKey(record.getBh());
            doorRealService.insertDoorfxInfo(record); //插入门方向定义表
            if (record.getDevOrder() == 9) {
                record.setDoorLx(1);
            } else {
                record.setDoorLx(0);
            }
            if (!StringUtils.isBlank(old.getDevSerial())) { //以前关联门控器
                //插入全量日志更新 0，1，2，3
                //更新电子地图信息 暂时不用
                //更新摄像头列表
                doorRealService.insertJrealUpdate(old, true, true);
            }
            //插入全量日志更新 0，1，2，3
            //更新电子地图信息 暂时不用
            //更新摄像头列表
            doorRealService.insertJrealUpdate(old, true, true);
        }
        doorRealService.updateByPrimaryKeySelective(record);//更新门定义表
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "删除门", notes = "删除门")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String bh) {
        //查出要删除的门信息
        DoorRealEntity doorRealEntity = doorRealService.selectByPrimaryKey(bh);
        if (doorRealEntity == null) {
            return failMsg("您要删除门的不存在，请刷新后重试");
        }
        //删除门定义表
        doorRealService.deleteByPrimaryKey(bh);
        //删除门方向表
        doorfxRealService.deleteByPrimaryKey(bh);
        //删除场所门列表
        doorRealService.deleteDepDoorRelation(doorRealEntity);
        //删除该门的授权信息 MJ_USER_RULE_REAL
        mjUserRuleRealService.deleteByGateBh(doorRealEntity.getBh());
        //删除摄像头信息 jreal_mj_camera
        jrealMjCameraService.deleteByGatebh(doorRealEntity.getBh());
        //插全量日志
        if (StringUtils.isBlank(doorRealEntity.getDevSerial())) {
            //jreal_update_0
            //jreal_update_1
            //更新摄像头列表
            doorRealService.insertJrealUpdate(doorRealEntity, false, true);
        }
        //插入操作日 wt_mj_log_real
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询门列表分页", notes = "查询门列表分页")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DoorRealEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DoorRealEntity> record) {
        setPageHelper(record);
        DoorRealEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DoorRealEntity();
        }
        List<DoorRealEntity> list = doorRealService.selectListByEntity(entity);
        fmtBean.DicFormat(list.toArray(new DoorRealEntity[0]), new String[]{"04002", "04003", "04006"});
        return succMsgData(new BaseCommPager<DoorRealEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询门信息", notes = "查询门信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DoorRealEntity> selectByPrimaryKey(@RequestParam String gateBh) {
        DoorRealEntity entity = doorRealService.selectByPrimaryKey(gateBh);
        fmtBean.DicFormat(entity, new String[]{"04002", "04003", "04004", "04006"});
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "批量删除门", notes = "批量删除门")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<DoorRealEntity> list = JSONObject.parseArray(keys, DoorRealEntity.class);
        List<DoorRealEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                //删除门定义表
                doorRealService.deleteBatchByKeys(delList);
                //删除门方向定义表
                doorfxRealService.deleteBatchByKeys(delList);
                //删除场所门列表
                doorRealService.deleteDepRelationBatchByKeys(list);
                //删除该门的授权信息 MJ_USER_RULE_REAL
                mjUserRuleRealService.deleteBatchByGateBh(list);
                //删除摄像头信息 jreal_mj_camera
                jrealMjCameraService.deleteBatchByGatebh(list);
                //插入增量日志
                //jreal_update_0
                //jreal_update_1

                delList.clear();
            }
        }
        //更新摄像头列表
        doorRealService.insertNowCmdNetCam();
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "门批量更换场所", notes = "门批量更换场所")
    @RequestMapping(value = "/updatePlace", method = RequestMethod.POST)
    public JsonResult<Object> updatePlace(@RequestBody @Valid DoorRealEntity record) {
        if (record.getGateList().size() == 0) {
            return failMsg("请至少选择一个门");
        }
        doorRealService.updatePlaceByGate(record);//门更换场所
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取强制门列表", notes = "获取强制门列表")
    @RequestMapping(value = "/selectForceList", method = RequestMethod.POST)
    public JsonResult<Object> selectForceList(@RequestBody DoorRealEntity record) {
        List<DoorRealEntity> list = doorRealService.selectForceList(record);//门更换场所
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "导出报表", notes = "导出报表")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody DoorRealEntity record) {
        List<DoorRealEntity> list = doorRealService.selectListByEntity(record);
        fmtBean.DicFormat(list.toArray(new DoorRealEntity[0]), new String[]{"01001", "04002", "04003", "04006"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }
}