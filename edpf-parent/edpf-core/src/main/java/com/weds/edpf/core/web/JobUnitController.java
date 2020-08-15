package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.utils.SpringContextHolder;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.JobUnitEntity;
import com.weds.edpf.core.service.JobUnitService;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.etl.entity.SchedulerEntity;
import com.weds.etl.service.SchedulerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 作业单元信息管理
 * @Date 2019-05-06
 */
@RestController
@RequestMapping(value = "/jobUnit")
@Api(value = "作业单元信息管理", description = "作业单元信息管理")
public class JobUnitController extends BaseController {
    @Autowired
    private JobUnitService jobUnitService;

    @Resource
    private SchedulerService schedulerService;

    @Autowired
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增作业单元信息信息", notes = "新增作业单元信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid JobUnitEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        jobUnitService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新作业单元信息信息", notes = "更新作业单元信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid JobUnitEntity record) {
        record.setLtDate(new Date());
        jobUnitService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询作业单元信息清单", notes = "查询作业单元信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JobUnitEntity>> selectListPageByEntity(@RequestBody BasePageSearch<JobUnitEntity> record) {
        setPageHelper(record);
        JobUnitEntity entity = record.getSearch();
        if (entity == null) {
            entity = new JobUnitEntity();
        }
        List<JobUnitEntity> list = jobUnitService.selectListByEntity(entity);
        try {
            for (JobUnitEntity jobUnitEntity : list) {
                jobUnitEntity.setJobState(schedulerService.getState(jobUnitEntity.getJobPath()).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dicFmtBean.DicFormat(list.toArray(new JobUnitEntity[0]), new String[]{"01009", "01010", "01001"});
        return succMsgData(new BaseCommPager<JobUnitEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询作业单元信息列表", notes = "查询作业单元信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<JobUnitEntity>> selectListByEntity(@RequestBody JobUnitEntity record) {
        List<JobUnitEntity> list = jobUnitService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new JobUnitEntity[0]), new String[]{"01009", "01010", "01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除作业单元信息信息", notes = "删除作业单元信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String jobId) {
        jobUnitService.deleteByPrimaryKey(jobId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询作业单元信息信息", notes = "查询作业单元信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<JobUnitEntity> selectByPrimaryKey(@RequestParam String jobId) {
        JobUnitEntity entity = jobUnitService.selectByPrimaryKey(jobId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询作业单元信息信息", notes = "关键字查询作业单元信息信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<JobUnitEntity>> selectListByKeys(@RequestBody BasePageSearch<JobUnitEntity> record) {
        setPageHelper(record);
        List<JobUnitEntity> list = jobUnitService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new JobUnitEntity[0]), new String[]{"01009", "01010", "01001"});
        return succMsgData(new BaseCommPager<JobUnitEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除作业单元信息信息", notes = "批量删除作业单元信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<JobUnitEntity> list = JSONObject.parseArray(keys, JobUnitEntity.class);
        List<JobUnitEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                jobUnitService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "启动作业", notes = "启动作业")
    @RequestMapping(value = "/restartJob", method = RequestMethod.GET)
    public JsonResult<Object> restartJob(@RequestParam String jobId) {
        JobUnitEntity jobUnitEntity = jobUnitService.selectByPrimaryKey(jobId);
        String path = jobUnitEntity.getJobPath();
        try {
            schedulerService.deleteJob(path);
            if (jobUnitEntity.getSeqType().equals("0")) {
                schedulerService.addDelayJob(path, Integer.parseInt(jobUnitEntity.getSeqExpr()));
            } else {
                schedulerService.addCronJob(path, jobUnitEntity.getSeqExpr());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "停止作业", notes = "停止作业")
    @RequestMapping(value = "/stopJob", method = RequestMethod.GET)
    public JsonResult<Object> stopJob(@RequestParam String jobId) {
        JobUnitEntity jobUnitEntity = jobUnitService.selectByPrimaryKey(jobId);
        String path = jobUnitEntity.getJobPath();
        try {
            schedulerService.deleteJob(path);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "获取所有作业状态", notes = "获取所有作业状态")
    @RequestMapping(value = "/getAllState", method = RequestMethod.GET)
    public JsonResult<List<SchedulerEntity>> getAllState() {
        try {
            List<SchedulerEntity> list = schedulerService.getAllState();
            return succMsgData(list);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "启动作业", notes = "启动作业")
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public JsonResult<Object> start() {
        try {
            schedulerService.start();
            return succMsg();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "停止作业", notes = "停止作业")
    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public JsonResult<Object> stop() {
        try {
            schedulerService.stop();
            return succMsg();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "暂停作业", notes = "暂停作业")
    @RequestMapping(value = "/pauseAll", method = RequestMethod.GET)
    public JsonResult<Object> pauseAll() {
        try {
            schedulerService.pauseAll();
            return succMsg();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return failMsg();
        }
    }

    @Logs
    @ApiOperation(value = "恢复作业", notes = "恢复作业")
    @RequestMapping(value = "/resumeAll", method = RequestMethod.GET)
    public JsonResult<Object> resumeAll() {
        try {
            schedulerService.resumeAll();
            return succMsg();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return failMsg();
        }
    }
}