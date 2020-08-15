package com.weds.edmj.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.edpf.core.entity.TreeNodeEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;


import com.weds.edmj.entity.DtAcDepEntity;
import com.weds.edmj.service.DtAcDepService;

/**
 * @Author sxm
 * @Description DtAcDep管理
 * @Date 2019-07-30
 */
@RestController
@RequestMapping(value = "/dtAcDep")
@Api(value = "DtAcDep管理", description = "DtAcDep管理")
public class DtAcDepController extends BaseController {
    @Autowired
    private DtAcDepService dtAcDepService;


    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增DtAcDep信息", notes = "新增DtAcDep信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid DtAcDepEntity record) {
        dtAcDepService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新DtAcDep信息", notes = "更新DtAcDep信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid DtAcDepEntity record) {
        dtAcDepService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DtAcDep清单", notes = "查询DtAcDep清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DtAcDepEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DtAcDepEntity> record) {
        setPageHelper(record);
        DtAcDepEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DtAcDepEntity();
        }
        List<DtAcDepEntity> list = dtAcDepService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<DtAcDepEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询DtAcDep列表", notes = "查询DtAcDep列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DtAcDepEntity>> selectListByEntity(@RequestBody DtAcDepEntity record) {
        List<DtAcDepEntity> list = dtAcDepService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除DtAcDep信息", notes = "删除DtAcDep信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer depSerial) {
        dtAcDepService.deleteByPrimaryKey(depSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询DtAcDep信息", notes = "查询DtAcDep信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DtAcDepEntity> selectByPrimaryKey(@RequestParam Integer depSerial) {
        DtAcDepEntity entity = dtAcDepService.selectByPrimaryKey(depSerial);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除DtAcDep信息", notes = "批量删除DtAcDep信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<DtAcDepEntity> list) {
        List<DtAcDepEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                dtAcDepService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "批量新增DtAcDep信息", notes = "批量新增DtAcDep信息")
    @RequestMapping(value = "/insertBatch", method = RequestMethod.PUT)
    public JsonResult<Object> insertBatch(@RequestParam String data) {
        List<DtAcDepEntity> list = JSONObject.parseArray(data, DtAcDepEntity.class);
        dtAcDepService.insertBatch(list);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询场所树", notes = "查询场所树")
    @RequestMapping(value = "/selectPlaceTree", method = RequestMethod.GET)
    public JsonResult<List<TreeNodeEntity>> selectPlaceTree(Integer depParent) {
        if (depParent == null) {
            depParent = 0;
        }
        List<DtAcDepEntity> list = dtAcDepService.selectPlaceTree(depParent);
        TreeNodeEntity root = new TreeNodeEntity(depParent.toString());
        for (DtAcDepEntity entity : list) {
            TreeNodeEntity treeNodeEntity = new TreeNodeEntity(entity.getDepSerial().toString(),
                    entity.getDepParent().toString(), entity.getDepName(), null, null);
            root.add(treeNodeEntity);
        }
        return succMsgData(root.getChildren());
    }
}