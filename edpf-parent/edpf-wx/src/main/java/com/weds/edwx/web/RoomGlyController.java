package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.RoomGlyEntity;
import com.weds.edwx.service.RoomGlyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author
 * @Description RoomGly管理
 * @Date 2019-11-28
 */
@RestController
@RequestMapping(value = "/roomGly")
@Api(value = "RoomGly管理", description = "RoomGly管理")
public class RoomGlyController extends BaseController {
    @Resource
    private RoomGlyService roomGlyService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增RoomGly信息", notes = "新增RoomGly信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid RoomGlyEntity record) {
        roomGlyService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询RoomGly清单", notes = "查询RoomGly清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<RoomGlyEntity>> selectListPageByEntity(@RequestBody BasePageSearch<RoomGlyEntity> record) {
        setPageHelper(record);
        RoomGlyEntity entity = record.getSearch();
        if (entity == null) {
            entity = new RoomGlyEntity();
        }
        List<RoomGlyEntity> list = roomGlyService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<RoomGlyEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询RoomGly列表", notes = "查询RoomGly列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<RoomGlyEntity>> selectListByEntity(@RequestBody RoomGlyEntity record) {
        List<RoomGlyEntity> list = roomGlyService.selectListByEntity(record);
        return succMsgData(list);
    }
}