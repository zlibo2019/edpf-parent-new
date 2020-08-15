package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.service.CommonService;
import com.weds.edwx.entity.RepairTypeParamEntity;
import com.weds.edwx.entity.SystemMenusEntity;
import com.weds.edwx.entity.UserMenusEntity;
import com.weds.edwx.service.SystemMenusService;
import com.weds.edwx.service.UserMenusService;
import com.weds.core.base.BaseCommPager;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BasePageSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description 系统功能管理管理
 * @Date 2018-11-24
 */
@RestController
@RequestMapping(value = "/systemMenus")
@Api(value = "系统功能管理管理", description = "系统功能管理管理")
public class SystemMenusController extends BaseController {
    @Autowired
    private SystemMenusService systemMenusService;

    @Autowired
    private UserMenusService userMenusService;

    @Resource
    private CommonService commonService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "查询系统功能管理清单", notes = "查询系统功能管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<SystemMenusEntity>> selectListPageByEntity(@RequestBody BasePageSearch<SystemMenusEntity> record) {
        setPageHelper(record);
        SystemMenusEntity entity = record.getSearch();
        if (entity == null) {
            entity = new SystemMenusEntity();
        }
        List<SystemMenusEntity> list = systemMenusService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<SystemMenusEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询系统功能管理列表", notes = "查询系统功能管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<SystemMenusEntity>> selectListByEntity(@RequestBody SystemMenusEntity record) {
        List<SystemMenusEntity> list = systemMenusService.selectListByEntity(record);
        List<String> menus = userMenusService.getExceptMenuId(record.getUserId());
        List<SystemMenusEntity> resp = new ArrayList<>();
        for (SystemMenusEntity menusEntity : list) {
            // 权限验证
            if (!commonService.checkRight(menusEntity.getSpareCol4())) {
                continue;
            }

            if (menus.contains(menusEntity.getMenuId())) {
                continue;
            }
            resp.add(menusEntity);
        }
        return succMsgData(resp);
    }

    @Logs
    @ApiOperation(value = "查询系统功能管理信息", notes = "查询系统功能管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<SystemMenusEntity> selectByPrimaryKey(@RequestParam String companyId, @RequestParam String menuId) {
        SystemMenusEntity entity = systemMenusService.selectByPrimaryKey(companyId, menuId);
        return succMsgData(entity);
    }
}