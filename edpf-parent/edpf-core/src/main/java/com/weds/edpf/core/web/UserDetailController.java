package com.weds.edpf.core.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.entity.UserDetailEntity;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.service.UserDetailService;
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
import java.util.List;

/**
 * @Author
 * @Description 人员详细信息管理
 * @Date 2019-09-27
 */
@RestController
@RequestMapping(value = "/userDetail")
@Api(value = "人员详细信息管理", description = "人员详细信息管理")
public class UserDetailController extends BaseController {
    @Resource
    private UserDetailService userDetailService;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增人员详细信息信息", notes = "新增人员详细信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid UserDetailEntity record) {
        record.setUserId(StringUtils.getUUID());
        userDetailService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新人员详细信息信息", notes = "更新人员详细信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid UserDetailEntity record) {
        userDetailService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询人员详细信息清单", notes = "查询人员详细信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<UserDetailEntity>> selectListPageByEntity(@RequestBody BasePageSearch<UserDetailEntity> record) {
        setPageHelper(record);
        UserDetailEntity entity = record.getSearch();
        if (entity == null) {
            entity = new UserDetailEntity();
        }
        List<UserDetailEntity> list = userDetailService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new UserDetailEntity[0]), new String[]{"01016", "01017", "01018", "01019", "01020"});
        return succMsgData(new BaseCommPager<UserDetailEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出人员详细信息信息", notes = "导出人员详细信息信息")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody UserDetailEntity record) {
        List<UserDetailEntity> list = userDetailService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new UserDetailEntity[0]), new String[]{"01016", "01017", "01018", "01019", "01020"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询人员详细信息列表", notes = "查询人员详细信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<UserDetailEntity>> selectListByEntity(@RequestBody UserDetailEntity record) {
        List<UserDetailEntity> list = userDetailService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new UserDetailEntity[0]), new String[]{"01016", "01017", "01018", "01019", "01020"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除人员详细信息信息", notes = "删除人员详细信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String userId) {
        userDetailService.deleteByPrimaryKey(userId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询人员详细信息信息", notes = "查询人员详细信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<UserDetailEntity> selectByPrimaryKey(@RequestParam String userId) {
        UserDetailEntity entity = userDetailService.selectByPrimaryKey(userId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "批量删除人员详细信息信息", notes = "批量删除人员详细信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<UserDetailEntity> list) {
        List<UserDetailEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                userDetailService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}