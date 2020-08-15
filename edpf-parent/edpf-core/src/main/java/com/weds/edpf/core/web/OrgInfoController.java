package com.weds.edpf.core.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.SettingParams;
import com.weds.edpf.core.entity.DepEntity;
import com.weds.edpf.core.entity.OrgInfoEntity;
import com.weds.edpf.core.entity.OrgRelaEntity;
import com.weds.edpf.core.entity.TreeNodeEntity;
import com.weds.edpf.core.service.CommonService;
import com.weds.edpf.core.service.OrgInfoService;
import com.weds.edpf.core.service.OrgRelaService;
import com.weds.edpf.core.util.DicFmtBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author
 * @Description 机构基本信息管理
 * @Date 2019-09-25
 */
@RestController
@RequestMapping(value = "/orgInfo")
@Api(value = "机构基本信息管理", description = "机构基本信息管理")
public class OrgInfoController extends BaseController {
    @Resource
    private OrgInfoService orgInfoService;

    @Resource
    private OrgRelaService orgRelaService;

    @Resource
    private DicFmtBean dicFmtBean;

    @Resource
    private CommonService commonService;

    @Resource
    private SettingParams settingParams;

    @Resource
    private HttpServletResponse response;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "新增机构基本信息信息", notes = "新增机构基本信息信息")
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    @Transactional
    public JsonResult<Object> insert(@RequestBody @Valid OrgInfoEntity record) {
        OrgInfoEntity entity = orgInfoService.selectByPrimaryKey(record.getOrgId());
        if (entity != null) {
            return failMsg("机构编号已存在");
        }

        try {
            if (!StringUtils.isBlank(record.getOrgLogo())) {
                ImageUtils.base64ToFile(record.getOrgLogo(), record.getOrgId(), "jpeg", settingParams.getLogoPath(),
                        settingParams.getSysRoot());
                record.setOrgLogo("1");
            } else {
                record.setOrgLogo("0");
            }

            if (!StringUtils.isBlank(record.getBackImg())) {
                ImageUtils.base64ToFile(record.getBackImg(), record.getOrgId(), "jpeg", settingParams.getBackPath(),
                        settingParams.getSysRoot());
                record.setBackImg("1");
            } else{
                record.setBackImg("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }

        Date date = new Date();
        record.setCtDate(date);
        record.setLtDate(date);
        orgInfoService.insertSelective(record);

        OrgRelaEntity orgRelaEntity = new OrgRelaEntity();
        orgRelaEntity.setId(StringUtils.getUUID());
        orgRelaEntity.setOrgId(record.getOrgId());
        orgRelaEntity.setParentOrgId(record.getParentOrgId());
        try {
            orgRelaEntity.setStartDate(DateUtils.parseDate(CoreConstants.DEFAULT_START_DATE, DateUtils.DATE_TIME_FORMAT));
            orgRelaEntity.setEndDate(DateUtils.parseDate(CoreConstants.DEFAULT_END_DATE, DateUtils.DATE_TIME_FORMAT));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orgRelaService.insertSelective(orgRelaEntity);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "更新机构基本信息信息", notes = "更新机构基本信息信息")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody OrgInfoEntity record) {
        try {
            if (!StringUtils.isBlank(record.getOrgLogo())) {
                ImageUtils.base64ToFile(record.getOrgLogo(), record.getOrgId(), "jpeg", settingParams.getLogoPath(),
                        settingParams.getSysRoot());
                record.setOrgLogo("1");
            } else {
                record.setOrgLogo("0");
            }

            if (!StringUtils.isBlank(record.getBackImg())) {
                ImageUtils.base64ToFile(record.getBackImg(), record.getOrgId(), "jpeg", settingParams.getBackPath(),
                        settingParams.getSysRoot());
                record.setBackImg("1");
            } else {
                record.setBackImg("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }

        record.setLtDate(new Date());
        orgInfoService.updateByPrimaryKeySelective(record);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询机构基本信息清单", notes = "查询机构基本信息清单")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<OrgInfoEntity>> selectListPageByEntity(@RequestBody BasePageSearch<OrgInfoEntity> record) {
        setPageHelper(record);
        OrgInfoEntity entity = record.getSearch();
        if (entity == null) {
            entity = new OrgInfoEntity();
        }
        List<OrgInfoEntity> list = orgInfoService.selectListByEntity(entity);
        dicFmtBean.DicFormat(list.toArray(new OrgInfoEntity[0]), new String[]{"05001"});
        return succMsgData(new BaseCommPager<OrgInfoEntity>(list));
    }

    @Logs
    @ApiOperation(value = "查询机构树", notes = "查询机构树")
    @RequestMapping(value = "/selectOrgTree", method = RequestMethod.GET)
    public JsonResult<List<TreeNodeEntity>> selectOrgTree(@RequestParam String parentOrgId) {
        List<OrgInfoEntity> depList = orgInfoService.selectOrgTree(parentOrgId);
        TreeNodeEntity root = new TreeNodeEntity(parentOrgId);
        try {
            for (OrgInfoEntity orgInfoEntity : depList) {
                if ("1".equals(orgInfoEntity.getOrgLogo())) {
                    String path = settingParams.getSysRoot() + File.separator + settingParams.getLogoPath()
                            + File.separator + orgInfoEntity.getOrgId() + ".jpeg";
                    orgInfoEntity.setOrgLogo(ImageUtils.imgToBase64(path));
                } else {
                    orgInfoEntity.setOrgLogo(null);
                }

                if ("1".equals(orgInfoEntity.getBackImg())) {
                    String path = settingParams.getSysRoot() + File.separator + settingParams.getBackPath()
                            + File.separator + orgInfoEntity.getOrgId() + ".jpeg";
                    orgInfoEntity.setBackImg(ImageUtils.imgToBase64(path));
                } else {
                    orgInfoEntity.setBackImg(null);
                }
                TreeNodeEntity treeNodeEntity = new TreeNodeEntity(orgInfoEntity.getOrgId(),
                        orgInfoEntity.getParentOrgId(), orgInfoEntity.getOrgName(), null, null, orgInfoEntity);
                root.add(treeNodeEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsgData(root.getChildren());
    }

    @Logs
    @ApiOperation(value = "导出机构基本信息信息", notes = "导出机构基本信息信息")
    @RequestMapping(value = "/exportRpt", method = RequestMethod.POST)
    public void exportRpt(@RequestBody OrgInfoEntity record) {
        List<OrgInfoEntity> list = orgInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new OrgInfoEntity[0]), new String[]{"05001"});
        commonService.exportExcel(record.getColList(), list, record.getRptTitle(), response);
    }

    @Logs
    @ApiOperation(value = "查询机构基本信息列表", notes = "查询机构基本信息列表")
    @RequestMapping(value = "/selectListByEntity", method = RequestMethod.POST)
    public JsonResult<List<OrgInfoEntity>> selectListByEntity(@RequestBody OrgInfoEntity record) {
        List<OrgInfoEntity> list = orgInfoService.selectListByEntity(record);
        dicFmtBean.DicFormat(list.toArray(new OrgInfoEntity[0]), new String[]{"05001"});
        return succMsgData(list);
    }

    @Logs
    @ApiOperation(value = "删除机构基本信息信息", notes = "删除机构基本信息信息")
    @RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.DELETE)
    @Transactional
    public JsonResult<Object> deleteByPrimaryKey(@RequestParam String orgId) {
        int temp = orgInfoService.haveSubOrg(orgId);
        if (temp > 0) {
            return failMsg("存在下级机构，无法删除");
        }
        orgInfoService.deleteByPrimaryKey(orgId);
        orgInfoService.deleteOrgRela(orgId);
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "查询机构基本信息信息", notes = "查询机构基本信息信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public JsonResult<OrgInfoEntity> selectByPrimaryKey(@RequestParam String orgId) {
        OrgInfoEntity entity = orgInfoService.selectByPrimaryKey(orgId);
        try {
            if ("1".equals(entity.getOrgLogo())) {
                String path = settingParams.getSysRoot() + File.separator + settingParams.getLogoPath()
                        + File.separator + entity.getOrgId() + ".jpeg";
                entity.setOrgLogo(ImageUtils.imgToBase64(path));
            } else {
                entity.setOrgLogo(null);
            }

            if ("1".equals(entity.getBackImg())) {
                String path = settingParams.getSysRoot() + File.separator + settingParams.getBackPath()
                        + File.separator + entity.getOrgId() + ".jpeg";
                entity.setBackImg(ImageUtils.imgToBase64(path));
            } else {
                entity.setBackImg(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
        return succMsgData(entity);
    }
}