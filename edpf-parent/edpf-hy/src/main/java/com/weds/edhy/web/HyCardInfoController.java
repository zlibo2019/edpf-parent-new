package com.weds.edhy.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.StringUtils;
import com.weds.edhy.entity.HyCardInfoEntity;
import com.weds.edhy.service.HyCardInfoService;
import com.weds.edpf.core.service.CommonService;
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
 * @Description 卡片信息管理
 * @Date 2019-10-11
 */
@RestController
@RequestMapping(value = "/hyCardInfo")
@Api(value = "卡片信息管理", description = "卡片信息管理")
public class HyCardInfoController extends BaseController {
    @Resource
    private HyCardInfoService hyCardInfoService;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增卡片信息信息", notes = "新增卡片信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid HyCardInfoEntity record) {
        record.setCardId(StringUtils.getUUID());
        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        hyCardInfoService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新卡片信息信息", notes = "更新卡片信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid HyCardInfoEntity record) {
        record.setLtDate(new Date());
        hyCardInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询卡片信息清单", notes = "查询卡片信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<HyCardInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<HyCardInfoEntity> record) {
        setPageHelper(record);
        HyCardInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new HyCardInfoEntity();
        }
        List<HyCardInfoEntity> list = hyCardInfoService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new HyCardInfoEntity[0]), new String[]{"05001", "01001"});
        return succMsgData(new BaseCommPager<HyCardInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "导出卡片信息信息", notes = "导出卡片信息信息")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody HyCardInfoEntity record) {
        List<HyCardInfoEntity> list = hyCardInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new HyCardInfoEntity[0]), new String[]{"05001", "01001"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询卡片信息列表", notes = "查询卡片信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<HyCardInfoEntity>> selectListByEntity(@RequestBody HyCardInfoEntity record) {
        List<HyCardInfoEntity> list = hyCardInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new HyCardInfoEntity[0]), new String[]{"05001", "01001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除卡片信息信息", notes = "删除卡片信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String cardId) {
        hyCardInfoService.deleteByPrimaryKey(cardId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询卡片信息信息", notes = "查询卡片信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<HyCardInfoEntity> selectByPrimaryKey(@RequestParam String cardId) {
        HyCardInfoEntity entity = hyCardInfoService.selectByPrimaryKey(cardId);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "批量删除卡片信息信息", notes = "批量删除卡片信息信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<HyCardInfoEntity> list) {
        List<HyCardInfoEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                hyCardInfoService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }
}