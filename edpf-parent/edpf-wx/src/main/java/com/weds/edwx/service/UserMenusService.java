package com.weds.edwx.service;

import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.DepUserEntity;
import com.weds.edwx.entity.RepairTypeParamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.UserMenusMapper;
import com.weds.edwx.entity.UserMenusEntity;

import javax.annotation.Resource;

/**
 * @Author sxm
 * @Description 用户功能管理管理
 * @Date 2018-11-24
 */
@Service
public class UserMenusService extends BaseService {

    @Autowired
    private UserMenusMapper userMenusMapper;

    @Autowired
    private RepairTypeParamService repairTypeParamService;

    @Autowired
    private DepUserService depUserService;

    @Autowired
    private ManagementService managementService;

    @Resource
    private WeiXinParams weiXinParams;

    private Logger log = LogManager.getLogger();

    public int deleteByPrimaryKey(String companyId, String userId, String menuId) {
        return userMenusMapper.deleteByPrimaryKey(companyId, userId, menuId);
    }

    public int insert(UserMenusEntity record) {
        return userMenusMapper.insert(record);
    }

    public int insertSelective(UserMenusEntity record) {
        return userMenusMapper.insertSelective(record);
    }

    public UserMenusEntity selectByPrimaryKey(String companyId, String userId, String menuId) {
        return userMenusMapper.selectByPrimaryKey(companyId, userId, menuId);
    }

    public int updateByPrimaryKeySelective(UserMenusEntity record) {
        return userMenusMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserMenusEntity record) {
        return userMenusMapper.updateByPrimaryKey(record);
    }

    public List<UserMenusEntity> selectListByEntity(UserMenusEntity record) {
        return userMenusMapper.selectListByEntity(record);
    }

    public int deleteByUserId(String userId) {
        return userMenusMapper.deleteByUserId(userId);
    }

    public List<String> getExceptMenuId(String userId) {
        List<String> menus = new ArrayList<>();
        if (!StringUtils.isBlank(weiXinParams.getExceptMenu())) {
            String[] strs = StringUtils.stringToArray(weiXinParams.getExceptMenu(), "#");
            for (String str : strs) {
                String[] items = str.split(",");
                if ("0".equals(items[0]) && "true".equals(items[1])) {
                    RepairTypeParamEntity entity = new RepairTypeParamEntity();
                    entity.setUserSerial(Integer.valueOf(userId));
                    List<RepairTypeParamEntity> temp = repairTypeParamService.selectListByEntity(entity);
                    if (temp.size() == 0) {
                        menus.add(items[2]);
                    }
                }

                if ("1".equals(items[0]) && "true".equals(items[1])) {
                    DepUserEntity entity = new DepUserEntity();
                    entity.setUserSerial(userId);
                    entity.setLx(0);
                    List<DepUserEntity> temp = depUserService.selectListByCondition(entity);
                    int num = managementService.existsCopyUser(7, Long.parseLong(userId));
                    if (temp.size() == 0 && num == 0) {
                        menus.add(items[2]);
                    }
                }
            }
        }
        return menus;
    }
}
