package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.entity.RoleFunctionEntity;
import com.weds.edpf.core.entity.SysFunctionEntity;
import com.weds.edpf.core.entity.TreeNodeEntity;
import com.weds.edpf.core.service.RoleFunctionService;
import com.weds.edpf.core.service.SysFunctionService;
import com.weds.edpf.core.util.DicFmtBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author sxm
 * @Description 权限管理管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/sysFunction")
@Api(value = "权限管理管理", description = "权限管理管理")
public class SysFunctionController extends BaseController {
    @Autowired
    private SysFunctionService sysFunctionService;

    @Autowired
    private RoleFunctionService roleFunctionService;

    @Autowired
    private DicFmtBean dicFmtBean;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增权限管理信息", notes = "新增权限管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody SysFunctionEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        sysFunctionService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增权限管理信息", notes = "批量新增权限管理信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    @Transactional
    public JsonResult<Object> insertBatch(@RequestBody List<SysFunctionEntity> list) {
        sysFunctionService.deleteAll();
        if (list.size() > 0) {
            sysFunctionService.insertBatch(list);
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "删除全部权限管理信息", notes = "删除全部权限管理信息")
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteAll() {
        sysFunctionService.deleteAll();
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新权限管理信息", notes = "更新权限管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody SysFunctionEntity record) {
        record.setLtDate(new Date());
        sysFunctionService.updateByPrimaryKey(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询权限管理清单", notes = "查询权限管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<SysFunctionEntity>> selectListPageByEntity(@RequestBody BasePageSearch<SysFunctionEntity> record) {
        setPageHelper(record);
        SysFunctionEntity entity = record.getSearch();
        if (entity == null) {
            entity = new SysFunctionEntity();
        }
        List<SysFunctionEntity> list = sysFunctionService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new SysFunctionEntity[0]), new String[]{"01001", "01002", "01003"});
        return succMsgData(new BaseCommPager<>(list));
    }

    @Logs
    @ApiOperation(value = "查询权限管理列表", notes = "查询权限管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<SysFunctionEntity>> selectListByEntity(@RequestBody SysFunctionEntity record) {
        List<SysFunctionEntity> list = sysFunctionService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new SysFunctionEntity[0]), new String[]{"01001", "01002", "01003"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除权限管理信息", notes = "删除权限管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String functionId) {
        RoleFunctionEntity roleFunctionEntity = new RoleFunctionEntity();
        roleFunctionEntity.setFunctionId(functionId);
        List<RoleFunctionEntity> list = roleFunctionService.selectListByEntity(roleFunctionEntity);
        if (list.size() > 0) {
            return failMsg("功能已使用，无法删除！");
        }
        sysFunctionService.deleteByPrimaryKey(functionId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询权限管理信息", notes = "查询权限管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<SysFunctionEntity> selectByPrimaryKey(@RequestParam String functionId) {
        SysFunctionEntity entity = sysFunctionService.selectByPrimaryKey(functionId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询权限管理信息", notes = "关键字查询权限管理信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<SysFunctionEntity>> selectListByKeys(@RequestBody BasePageSearch<SysFunctionEntity> record) {
        setPageHelper(record);
        List<SysFunctionEntity> list = sysFunctionService.selectListByKeys(record.getSearch().getKeys());
        dicFmtBean.DicFormat(list.toArray(new SysFunctionEntity[0]), new String[]{"01001", "01002", "01003"});
        return succMsgData(new BaseCommPager<SysFunctionEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除权限管理信息", notes = "批量删除权限管理信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<SysFunctionEntity> list = JSONObject.parseArray(keys, SysFunctionEntity.class);
        // sysFunctionService.deleteBatchByKeys(list);
        for (SysFunctionEntity entity : list) {
            sysFunctionService.deleteByPrimaryKey(entity.getFunctionId());
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询功能树", notes = "查询功能树")
    @RequestMapping(value = "/selectTreeData", method = RequestMethod.POST)
    public JsonResult<List<TreeNodeEntity>> selectTreeData(@RequestBody SysFunctionEntity record) {
        String parentId = "xxx";
        if (StringUtils.isBlank(record.getParentFunction())) {
            record.setParentFunction(parentId);
        } else {
            parentId = record.getParentFunction();
        }
        List<SysFunctionEntity> list = sysFunctionService.selectTreeData(record);
        TreeNodeEntity root = new TreeNodeEntity(parentId);
        for (SysFunctionEntity entity : list) {
            TreeNodeEntity treeNodeEntity = new TreeNodeEntity(entity.getFunctionId(),
                    entity.getParentFunction(),
                    entity.getFunctionName(),
                    entity.getFunctionIcon(),
                    entity.getFunctionUrl());
            root.add(treeNodeEntity);
        }
        return succMsgData(root.getChildren());
    }

    @Logs
    @ApiOperation(value = "查询功能树", notes = "查询功能树")
    @RequestMapping(value = "/selectAllTreeData", method = RequestMethod.GET)
    public JsonResult<List<TreeNodeEntity>> selectAllTreeData() {
        SysFunctionEntity record = new SysFunctionEntity();
        String parentId = "xxx";
        if (StringUtils.isBlank(record.getParentFunction())) {
            record.setParentFunction(parentId);
        }
        List<SysFunctionEntity> list = sysFunctionService.selectTreeData(record);
        TreeNodeEntity root = new TreeNodeEntity(parentId);
        for (SysFunctionEntity entity : list) {
            TreeNodeEntity treeNodeEntity = new TreeNodeEntity(entity.getFunctionId(),
                    entity.getParentFunction(),
                    entity.getFunctionName(),
                    entity.getFunctionIcon(),
                    entity.getFunctionUrl());
            root.add(treeNodeEntity);
        }
        return succMsgData(root.getChildren());
    }

    @Logs
    @ApiOperation(value = "查询功能列表", notes = "查询功能列表")
    @RequestMapping(value = "/selectFunList", method = RequestMethod.POST)
    public JsonResult<List<SysFunctionEntity>> selectFunList(@RequestBody SysFunctionEntity record) {
        String parentId = "xxx";
        if (StringUtils.isBlank(record.getParentFunction())) {
            record.setParentFunction(parentId);
        }
        List<SysFunctionEntity> list = sysFunctionService.selectTreeData(record);
        return succMsgData(list);
    }
}