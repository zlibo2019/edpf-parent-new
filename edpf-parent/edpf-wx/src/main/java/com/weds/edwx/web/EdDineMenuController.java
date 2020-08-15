package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.entity.DictTypeEntity;
import com.weds.edpf.core.util.DicFmtBean;
import com.weds.edwx.entity.EdDineMealEntity;
import com.weds.edwx.entity.EdDineMealSettingEntity;
import com.weds.edwx.entity.EdDineMenuDetailEntity;
import com.weds.edwx.entity.EdDineMenuEntity;
import com.weds.edwx.service.EdDineMealSettingService;
import com.weds.edwx.service.EdDineMenuDetailService;
import com.weds.edwx.service.EdDineMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author sxm
 * @Description 菜谱定义管理
 * @Date 2019-04-15
 */
@RestController
@RequestMapping(value = "/edDineMenu")
@Api(value = "菜谱定义管理", description = "菜谱定义管理")
public class EdDineMenuController extends BaseController {
    @Autowired
    private EdDineMenuService edDineMenuService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增菜谱定义信息", notes = "新增菜谱定义信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid EdDineMenuEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        edDineMenuService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新菜谱定义信息", notes = "更新菜谱定义信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid EdDineMenuEntity record) {
        record.setLtDate(new Date());
        edDineMenuService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询菜谱定义清单", notes = "查询菜谱定义清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMenuEntity>> selectListPageByEntity(@RequestBody BasePageSearch<EdDineMenuEntity> record) {
        setPageHelper(record);
        EdDineMenuEntity entity = record.getSearch();
        if (entity == null) {
            entity = new EdDineMenuEntity();
        }
        List<EdDineMenuEntity> list = edDineMenuService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<EdDineMenuEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询菜谱定义列表", notes = "查询菜谱定义列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<EdDineMenuEntity>> selectListByEntity(@RequestBody EdDineMenuEntity record) {
        List<EdDineMenuEntity> list = edDineMenuService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除菜谱定义信息", notes = "删除菜谱定义信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String menuId) {
        edDineMenuService.deleteByPrimaryKey(menuId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询菜谱定义信息", notes = "查询菜谱定义信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<EdDineMenuEntity> selectByPrimaryKey(@RequestParam String menuId) {
        EdDineMenuEntity entity = edDineMenuService.selectByPrimaryKey(menuId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "关键字查询菜谱定义信息", notes = "关键字查询菜谱定义信息")
    @RequestMapping(value = "/selectListByKeys", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<EdDineMenuEntity>> selectListByKeys(@RequestBody BasePageSearch<EdDineMenuEntity> record) {
        setPageHelper(record);
        List<EdDineMenuEntity> list = edDineMenuService.selectListByKeys(record.getSearch().getKeys());
        return succMsgData(new BaseCommPager<EdDineMenuEntity>(list));
    }

    @Logs
    @ApiOperation(value = "批量删除菜谱定义信息", notes = "批量删除菜谱定义信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBatchByKeys(@RequestParam String keys) {
        List<EdDineMenuEntity> list = JSONObject.parseArray(keys, EdDineMenuEntity.class);
        List<EdDineMenuEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                edDineMenuService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}