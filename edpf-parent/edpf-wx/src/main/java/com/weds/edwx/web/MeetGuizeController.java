package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.MeetGuizeEntity;
import com.weds.edwx.service.MeetGuizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author
 * @Description MeetGuize管理
 * @Date 2019-12-02
 */
@RestController
@RequestMapping(value = "/meetGuize")
@Api(value = "MeetGuize管理", description = "MeetGuize管理")
public class MeetGuizeController extends BaseController {
    @Resource
    private MeetGuizeService meetGuizeService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增MeetGuize信息", notes = "新增MeetGuize信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid MeetGuizeEntity record) {
        meetGuizeService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新MeetGuize信息", notes = "更新MeetGuize信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid MeetGuizeEntity record) {
        meetGuizeService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MeetGuize清单", notes = "查询MeetGuize清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetGuizeEntity>> selectListPageByEntity(@RequestBody BasePageSearch<MeetGuizeEntity> record) {
        setPageHelper(record);
        MeetGuizeEntity entity = record.getSearch();
        if (entity == null) {
            entity = new MeetGuizeEntity();
        }
        List<MeetGuizeEntity> list = meetGuizeService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<MeetGuizeEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询MeetGuize列表", notes = "查询MeetGuize列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<MeetGuizeEntity>> selectListByEntity(@RequestBody MeetGuizeEntity record) {
        List<MeetGuizeEntity> list = meetGuizeService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除MeetGuize信息", notes = "删除MeetGuize信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer meetBh) {
        meetGuizeService.deleteByPrimaryKey(meetBh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询MeetGuize信息", notes = "查询MeetGuize信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<MeetGuizeEntity> selectByPrimaryKey(@RequestParam Integer meetBh) {
        MeetGuizeEntity entity = meetGuizeService.selectByPrimaryKey(meetBh);
        return succMsgData(entity);
    }
}