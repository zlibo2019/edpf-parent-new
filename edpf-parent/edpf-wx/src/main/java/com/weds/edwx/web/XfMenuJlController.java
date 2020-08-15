package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.XfMenuJlEntity;
import com.weds.edwx.service.XfMenuJlService;
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
 * @Description XfMenuJl管理
 * @Date 2019-11-27
 */
@RestController
@RequestMapping(value = "/xfMenuJl")
@Api(value = "XfMenuJl管理", description = "XfMenuJl管理")
public class XfMenuJlController extends BaseController {
    @Resource
    private XfMenuJlService xfMenuJlService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增XfMenuJl信息", notes = "新增XfMenuJl信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid XfMenuJlEntity record) {
        xfMenuJlService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新XfMenuJl信息", notes = "更新XfMenuJl信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid XfMenuJlEntity record) {
        xfMenuJlService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询XfMenuJl清单", notes = "查询XfMenuJl清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<XfMenuJlEntity>> selectListPageByEntity(@RequestBody BasePageSearch<XfMenuJlEntity> record) {
        setPageHelper(record);
        XfMenuJlEntity entity = record.getSearch();
        if (entity == null) {
            entity = new XfMenuJlEntity();
        }
        List<XfMenuJlEntity> list = xfMenuJlService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<XfMenuJlEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询XfMenuJl列表", notes = "查询XfMenuJl列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<XfMenuJlEntity>> selectListByEntity(@RequestBody XfMenuJlEntity record) {
        List<XfMenuJlEntity> list = xfMenuJlService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除XfMenuJl信息", notes = "删除XfMenuJl信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer xh) {
        xfMenuJlService.deleteByPrimaryKey(xh);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询XfMenuJl信息", notes = "查询XfMenuJl信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<XfMenuJlEntity> selectByPrimaryKey(@RequestParam Integer xh) {
        XfMenuJlEntity entity = xfMenuJlService.selectByPrimaryKey(xh);
        return succMsgData(entity);
    }
}