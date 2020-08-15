package com.weds.edpf.core.web;


import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.entity.DepEntity;
import com.weds.edpf.core.entity.DepUserEntity;
import com.weds.edpf.core.entity.TreeNodeEntity;
import com.weds.edpf.core.entity.UserBaseEntity;
import com.weds.edpf.core.service.DepService;
import com.weds.edpf.core.service.UserBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description Dep管理
 * @Date 2018-12-13
 */
@RestController
@RequestMapping(value = "/dep")
@Api(value = "Dep管理", description = "Dep管理")
public class DepController extends BaseController {
    @Autowired
    private DepService depService;

    @Autowired
    private UserBaseService userBaseService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增Dep信息", notes = "新增Dep信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public JsonResult<Object> insert(@RequestBody DepEntity record) {
        depService.insertSelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新Dep信息", notes = "更新Dep信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody DepEntity record) {
        depService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询Dep清单", notes = "查询Dep清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<DepEntity>> selectListPageByEntity(@RequestBody BasePageSearch<DepEntity> record) {
        setPageHelper(record);
        DepEntity entity = record.getSearch();
        if (entity == null) {
            entity = new DepEntity();
        }
        List<DepEntity> list = depService.selectListByEntity(entity);
        return succMsgData(new BaseCommPager<DepEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询Dep列表", notes = "查询Dep列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<DepEntity>> selectListByEntity(@RequestBody DepEntity record) {
        List<DepEntity> list = depService.selectListByEntity(record);
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除Dep信息", notes = "删除Dep信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam Long depSerial) {
        depService.deleteByPrimaryKey(depSerial);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询Dep信息", notes = "查询Dep信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<DepEntity> selectByPrimaryKey(@RequestParam Long depSerial) {
        DepEntity entity = depService.selectByPrimaryKey(depSerial);
        return succMsgData(entity);
    }

    @Logs
    @ApiOperation(value = "查询Dep用户人数", notes = "查询Dep用户人数")
    @RequestMapping(value = "/selectDeptUserInfo", method = RequestMethod.GET)
    public JsonResult<DepUserEntity> selectDeptUserInfo(@RequestParam Integer depParentNo) {
        List<DepEntity> depList = depService.selectDeptUserNums(depParentNo);
        UserBaseEntity record = new UserBaseEntity();
        record.setUserDep(depParentNo);
        List<UserBaseEntity> userList = userBaseService.selectListByEntity(record);
        try {
            for (UserBaseEntity userBaseEntity : userList) {
                if (!StringUtils.isBlank(userBaseEntity.getHeadImage())) {
                    userBaseEntity.setHeadImage(ImageUtils.imgToBase64(userBaseEntity.getHeadImage()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DepUserEntity depUserEntity = new DepUserEntity();
        depUserEntity.setDepList(depList);
        depUserEntity.setUserList(userList);
        return succMsgData(depUserEntity);
    }

    @Logs
    @ApiOperation(value = "查询机构树", notes = "查询机构树")
    @RequestMapping(value = "/selectOrgTree", method = RequestMethod.GET)
    public JsonResult<List<TreeNodeEntity>> selectOrgTree(@RequestParam Integer depParentNo) {
        List<DepEntity> depList = depService.selectOrgTree(depParentNo);
        TreeNodeEntity root = new TreeNodeEntity(depParentNo.toString());
        for (DepEntity depEntity : depList) {
            TreeNodeEntity treeNodeEntity = new TreeNodeEntity(depEntity.getDepSerial().toString(),
                    depEntity.getDepParent().toString(), depEntity.getDepName(), null, null);
            root.add(treeNodeEntity);
        }
        return succMsgData(root.getChildren());
    }

    @Logs
    @ApiOperation(value = "查询机构树异步", notes = "查询机构树异步")
    @RequestMapping(value = "/selectOrgTreeLazy", method = RequestMethod.GET)
    public JsonResult<List<TreeNodeEntity>> selectOrgTreeLazy(@RequestParam Integer depParentNo) {
        List<DepEntity> depList = depService.selectOrgTreeLazy(depParentNo);
        List<TreeNodeEntity> list = new ArrayList<>();
        for (DepEntity depEntity : depList) {
            TreeNodeEntity treeNodeEntity = new TreeNodeEntity(depEntity.getDepSerial().toString(), depEntity.getDepName(),
                    depEntity.getLeaf() == 0);
            list.add(treeNodeEntity);
        }
        return succMsgData(list);
    }
}