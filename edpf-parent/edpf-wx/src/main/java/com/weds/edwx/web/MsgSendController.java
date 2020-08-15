package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.MsgSendEntity;
import com.weds.edwx.service.MsgSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author sxm
 * @Description MsgSend管理
 * @Date 2018-12-19
 */
@RestController
@RequestMapping(value = "/msgSend")
@Api(value = "MsgSend管理", description = "MsgSend管理")
public class MsgSendController extends BaseController {
    @Autowired
    private MsgSendService msgSendService;
    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MsgSend信息", notes = "新增MsgSend信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody MsgSendEntity record) {
        msgSendService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MsgSend信息", notes = "更新MsgSend信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody MsgSendEntity record) {
        msgSendService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MsgSend清单", notes = "查询MsgSend清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgSendEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MsgSendEntity> record) {
        setPageHelper(record);
        MsgSendEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MsgSendEntity();
        }
        List<MsgSendEntity> list = msgSendService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MsgSendEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询MsgSend列表", notes = "查询MsgSend列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MsgSendEntity>> selectListByEntity(@RequestBody MsgSendEntity record) {
        List<MsgSendEntity> list = msgSendService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MsgSend信息", notes = "删除MsgSend信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long id) {
        msgSendService.deleteByPrimaryKey(id);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MsgSend信息", notes = "查询MsgSend信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MsgSendEntity> selectByPrimaryKey(@RequestParam Long id) {
        MsgSendEntity entity = msgSendService.selectByPrimaryKey(id);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询MsgSend信息", notes = "关键字查询MsgSend信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MsgSendEntity>> selectListByKeys(@RequestBody BasePageSearch<MsgSendEntity> record) {
        setPageHelper(record);
        List<MsgSendEntity> list = msgSendService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<MsgSendEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除MsgSend信息", notes = "批量删除MsgSend信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<MsgSendEntity> list = JSONObject.parseArray(keys, MsgSendEntity.class);
        // msgSendService.deleteBatchByKeys(list);
        for (MsgSendEntity entity : list) {
            msgSendService.deleteByPrimaryKey(entity.getId());
        }
        return succMsg();
    }
}