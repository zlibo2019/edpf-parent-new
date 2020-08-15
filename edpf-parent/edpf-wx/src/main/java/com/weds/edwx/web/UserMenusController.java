package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.utils.DateUtils;
import com.weds.edpf.core.service.CommonService;
import com.weds.edwx.entity.RepairTypeParamEntity;
import com.weds.edwx.entity.SystemMenusEntity;
import com.weds.edwx.entity.UserMenusEntity;
import com.weds.edwx.service.RepairTypeParamService;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description 用户功能管理管理
 * @Date 2018-11-24
 */
@RestController
@RequestMapping(value = "/userMenus")
@Api(value = "用户功能管理管理", description = "用户功能管理管理")
public class UserMenusController extends BaseController {

    @Autowired
    private UserMenusService userMenusService;

    @Autowired
    private SystemMenusService systemMenusService;

    @Resource
    private CommonService commonService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增用户功能管理信息", notes = "新增用户功能管理信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody UserMenusEntity record) {
        String date = DateUtils.getCurrentDateTime();
        userMenusService.deleteByUserId(record.getUserId());
        String[] menus = record.getMenuIds().split(",");
        int index = 0;
        for (String menu : menus) {
            UserMenusEntity userMenusEntity = new UserMenusEntity();
            userMenusEntity.setUserId(record.getUserId());
            userMenusEntity.setCtDate(date);
            userMenusEntity.setLtDate(date);
            userMenusEntity.setCompanyId(record.getCompanyId());
            userMenusEntity.setMenuId(menu);
            userMenusEntity.setMenuIdx(index);
            userMenusService.insertSelective(userMenusEntity);
            index++;
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新用户功能管理信息", notes = "更新用户功能管理信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody UserMenusEntity record) {
        record.setLtDate(DateUtils.getCurrentDateTime());
        userMenusService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户功能管理清单", notes = "查询用户功能管理清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserMenusEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserMenusEntity> record) {
        setPageHelper(record);
        UserMenusEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserMenusEntity();
        }
        List<UserMenusEntity> list = userMenusService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<UserMenusEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询用户功能管理列表", notes = "查询用户功能管理列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<?>> selectListByEntity(@RequestBody UserMenusEntity record) {
        List<String> menus = userMenusService.getExceptMenuId(record.getUserId());
        List<UserMenusEntity> list = userMenusService.selectListByEntity(record);
        List<Object> resp = new ArrayList<>();
        if (list.size() == 0) {
            SystemMenusEntity systemMenusEntity = new SystemMenusEntity();
            systemMenusEntity.setCompanyId(record.getCompanyId());
            systemMenusEntity.setSpareCol1(record.getSpareCol1());
            systemMenusEntity.setSpareCol2(record.getSpareCol2());
            systemMenusEntity.setUserSerial(record.getUserId());
            systemMenusEntity.setUserFlag(1);
            systemMenusEntity.setUseFlag(1);
            List<SystemMenusEntity> sysList = systemMenusService.selectListByEntity(systemMenusEntity);
            if (sysList.size() > 0) {
                for (SystemMenusEntity menusEntity : sysList) {
                    // 权限验证
                    if (!commonService.checkRight(menusEntity.getSpareCol4())) {
                        continue;
                    }

                    if (menus.contains(menusEntity.getMenuId())) {
                        continue;
                    }
                    resp.add(menusEntity);
                }
            }
            return succMsgData(resp);
        } else {
            for (UserMenusEntity menusEntity : list) {
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
    }

    @Logs
    @ApiOperation(value = "删除用户功能管理信息", notes = "删除用户功能管理信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String companyId, @RequestParam String userId, @RequestParam String menuId) {
        userMenusService.deleteByPrimaryKey(companyId, userId, menuId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询用户功能管理信息", notes = "查询用户功能管理信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserMenusEntity> selectByPrimaryKey(@RequestParam String companyId, @RequestParam String userId, @RequestParam String menuId) {
        UserMenusEntity entity = userMenusService.selectByPrimaryKey(companyId, userId, menuId);
        return succMsgData(entity);
    }
}