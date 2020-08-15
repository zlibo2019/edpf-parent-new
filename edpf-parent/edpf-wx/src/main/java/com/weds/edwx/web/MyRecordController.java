package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.edwx.entity.MyRecordEntity;
import com.weds.edwx.service.MyRecordService;
import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/myRecord")
@Api(value = "申请记录列表",description = "申请记录列表")
public class MyRecordController extends BaseController {

    @Autowired
    private MyRecordService myRecordService;

    @Logs
    @ApiOperation(value = "获取我申请的记录",notes = "获取我申请的记录" )
    @RequestMapping(value = "/getMyApplication", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MyRecordEntity>> getMyApplication(@RequestBody BasePageSearch<MyRecordEntity> record){
        setPageHelper(record);
        MyRecordEntity entity = record.getSearch();
        if(entity == null){
            entity = new MyRecordEntity();
        }
        List<MyRecordEntity> list = myRecordService.getMyApplication(entity.getLx(),entity.getUserSerial());
        return succMsgData(new BaseCommPager<MyRecordEntity>(list));
    }

    @Logs
    @ApiOperation(value = "获取待我审批的记录",notes = "获取待我审批的记录")
    @RequestMapping(value = "/getMyApproval",method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MyRecordEntity>> getMyApproval(@RequestBody BasePageSearch<MyRecordEntity> record)throws Exception{
        setPageHelper(record);
        MyRecordEntity entity = record.getSearch();
        if(entity == null){
            entity = new MyRecordEntity();
        }
        List<MyRecordEntity> list = myRecordService.getMyApproval(entity.getLx(),entity.getUserSerial());
        return succMsgData(new BaseCommPager<MyRecordEntity>(list));
    }

    @Logs
    @ApiOperation(value = "获取已经审批的记录",notes = "获取已经审批的记录")
    @RequestMapping(value = "/getMyApproved",method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MyRecordEntity>> getMyApproved(@RequestBody BasePageSearch<MyRecordEntity> record){
        setPageHelper(record);
        MyRecordEntity entity = record.getSearch();
        if(entity == null){
            entity = new MyRecordEntity();
        }
        List<MyRecordEntity> list = myRecordService.getMyApproved(entity.getUserSerial());
        return succMsgData(new BaseCommPager<MyRecordEntity>(list));
    }

    @Logs
    @ApiOperation(value = "获取抄送我的记录",notes = "获取抄送我的记录")
    @RequestMapping(value = "/getMyMessage",method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MyRecordEntity>> getMyMessage(@RequestBody BasePageSearch<MyRecordEntity> record){
        setPageHelper(record);
        MyRecordEntity entity = record.getSearch();
        if(entity == null){
            entity = new MyRecordEntity();
        }
        List<MyRecordEntity> list = myRecordService.getMyMessage(entity.getUserSerial());
        return succMsgData(new BaseCommPager<MyRecordEntity>(list));
    }



}
