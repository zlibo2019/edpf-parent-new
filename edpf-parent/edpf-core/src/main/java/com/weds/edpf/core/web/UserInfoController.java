package com.weds.edpf.core.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.UserInfoEntity;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.service.UserInfoService;
import com.weds.edpf.core.util.DicFmtBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author
 * @Description 人员基本信息管理
 * @Date 2019-09-27
 */
@RestController("userInfoControllerNew")
@RequestMapping(value = "/userInfoNew")
@Api(value = "人员基本信息管理", description = "人员基本信息管理")
public class UserInfoController extends BaseController {
    @Resource(name = "userInfoServiceNew")
    private UserInfoService userInfoService;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增人员基本信息信息", notes = "新增人员基本信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid UserInfoEntity record) {
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        userInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新人员基本信息信息", notes = "更新人员基本信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid UserInfoEntity record) {
        record.setLtDate(new Date());
        userInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询人员基本信息清单", notes = "查询人员基本信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserInfoEntity> record) {
        setPageHelper(record);
        UserInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserInfoEntity();
        }
        List<UserInfoEntity> list = userInfoService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new UserInfoEntity[0]), new String[]{"01014", "01015", "01012", "01013"});
        return succMsgData(new BaseCommPager<UserInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出人员基本信息信息", notes = "导出人员基本信息信息")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody UserInfoEntity record) {
        List<UserInfoEntity> list = userInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new UserInfoEntity[0]), new String[]{"01014", "01015", "01012", "01013"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询人员基本信息列表", notes = "查询人员基本信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserInfoEntity>> selectListByEntity(@RequestBody UserInfoEntity record) {
        List<UserInfoEntity> list = userInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new UserInfoEntity[0]), new String[]{"01014", "01015", "01012", "01013"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除人员基本信息信息", notes = "删除人员基本信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userId) {
        userInfoService.deleteByPrimaryKey(userId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询人员基本信息信息", notes = "查询人员基本信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserInfoEntity> selectByPrimaryKey(@RequestParam String userId) {
        UserInfoEntity entity = userInfoService.selectByPrimaryKey(userId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "批量删除人员基本信息信息", notes = "批量删除人员基本信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<UserInfoEntity> list) {
        List<UserInfoEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                userInfoService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}