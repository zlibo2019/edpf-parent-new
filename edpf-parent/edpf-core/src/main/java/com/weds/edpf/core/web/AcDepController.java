package com.weds.edpf.core.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.entity.AcDepEntity;
import com.weds.edpf.core.service.AcDepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Description AcDep管理
 * @Date 2019-10-17
 */
@RestController
@RequestMapping(value = "/acDep")
@Api(value = "AcDep管理", description = "AcDep管理")
public class AcDepController extends BaseController {
    @Resource
    private AcDepService acDepService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增AcDep信息", notes = "新增AcDep信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody @Valid AcDepEntity record) {
        acDepService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新AcDep信息", notes = "更新AcDep信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody @Valid AcDepEntity record) {
        acDepService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询AcDep清单", notes = "查询AcDep清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<AcDepEntity>> selectListPageByEntity(@RequestBody BasePageSearch<AcDepEntity> record) {
        setPageHelper(record);
        AcDepEntity entity = record.getSearch();
        if (entity == null) {
            entity = new AcDepEntity();
        }
        List<AcDepEntity> list = acDepService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<AcDepEntity>(list));
    }


    @Logs
    @ApiOperation(value = "查询AcDep列表", notes = "查询AcDep列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<AcDepEntity>> selectListByEntity(@RequestBody AcDepEntity record) {
        List<AcDepEntity> list = acDepService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "查询AcDep列表", notes = "查询AcDep列表")
    @RequestMapping(value = "/selectDinePlace", method = RequestMethod.GET)
    public JsonResult<List<AcDepEntity>> selectDinePlace() {
        List<AcDepEntity> list = acDepService.selectDinePlace();
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除AcDep信息", notes = "删除AcDep信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Integer depSerial) {
        acDepService.deleteByPrimaryKey(depSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询AcDep信息", notes = "查询AcDep信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<AcDepEntity> selectByPrimaryKey(@RequestParam Integer depSerial) {
        AcDepEntity entity = acDepService.selectByPrimaryKey(depSerial);
        return succMsgData(entity);
    }


    @Logs
    @ApiOperation(value = "批量删除AcDep信息", notes = "批量删除AcDep信息")
    @RequestMapping(value = "/deleteBatchByKeys", method = RequestMethod.POST)
    public JsonResult<Object> deleteBatchByKeys(@RequestBody List<AcDepEntity> list) {
        List<AcDepEntity> delList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            delList.add(list.get(i));
            if (delList.size() == 20 || i == list.size() - 1) {
                acDepService.deleteBatchByKeys(delList);
                delList.clear();
            }
        }
        return succMsg();
    }

}