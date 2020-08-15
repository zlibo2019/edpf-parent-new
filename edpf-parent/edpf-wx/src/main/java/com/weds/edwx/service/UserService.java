package com.weds.edwx.service;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.jwt.JwtEntity;
import com.weds.bean.jwt.JwtParams;
import com.weds.bean.jwt.JwtUtils;
import com.weds.core.base.BaseService;
import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.UserEntity;
import com.weds.edwx.mapper.UserMapper;
import com.weds.scan.service.ScanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author sxm
 * @Description User管理
 * @Date 2018-11-26
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScanService scanService;

    private Logger log = LogManager.getLogger();

    @Autowired
    private JwtParams jwtParams;

    /**
     * 验证用户名或者密码是否正确
     */
    public UserEntity userLoginCheck(UserEntity record) {
        return userMapper.userLoginCheck(record);
    }

    public UserEntity selectByUserNo(String userNo) {
        return userMapper.selectByUserNo(userNo);
    }

    /**
     * 验证商户的用户名和密码是否正确
     */
    public UserEntity merchantLoginCheck(UserEntity record) {
        return userMapper.merchantLoginCheck(record);
    }

    /**
     * 根据userSerial获取用户信息
     *
     * @param userSerial
     * @return
     */
    public UserEntity selectByPrimaryKey(Long userSerial) {
        return userMapper.selectByPrimaryKey(userSerial);
    }

    /**
     * 根据unionId判断绑定关系
     *
     * @param code
     * @return
     */
    public UserEntity selectByUnionId(String code) {
        return userMapper.selectByUnionId(code);
    }

    /**
     * 登录之后获取token 的接口
     *
     * @param userEntity
     * @return
     */
    public String getToken(UserEntity userEntity) {
        JwtEntity jwtEntity = new JwtEntity();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userSerial", userEntity.getUserSerial());
        jsonObject.put("companyId", userEntity.getCompanyId());
        jwtEntity.setJwtParams(jwtParams);
        jwtEntity.setPdata(jsonObject);
        String token = "";
        try {
            token = JwtUtils.createJWT(jwtEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public UserEntity checkUserPwdBySerial(UserEntity userEntity) {
        return userMapper.checkUserPwdBySerial(userEntity);
    }

    /**
     * 修改密码
     */
    public int updatePwd(UserEntity userEntity) {
        return userMapper.updatePwd(userEntity);
    }

    /**
     * 获取卡片信息
     *
     * @param userEntity
     * @return
     */
    public UserEntity getCardInfo(UserEntity userEntity) {
        return userMapper.getCardInfo(userEntity);
    }

    /**
     * 插入挂失增量日志
     */
    public int insertPublic(UserEntity record) {
        return userMapper.insertPublic(record);
    }

    /**
     * 查找人员卡号信息
     *
     * @param record
     * @return
     */
    public UserEntity selectUserCard(UserEntity record) {
        return userMapper.selectUserCard(record);
    }

    /**
     * 查找二维码加密key
     */
    public String selectCodeKey(String regNo) {
        return userMapper.selectCodeKey(regNo);
    }

    /**
     * 生成二维码密钥
     *
     * @param codeStr
     * @return
     */
    public String genaratorCode(String codeStr) {
        Map<String, Object> param = new HashMap<>();
        param.put("DataStr", codeStr);
        param.put("ScanId", "1000002");
        try {
            JsonResult jsonResult = scanService.strMake(param);
            if (CoreConstants.SUCCESSED_FLAG.equals(jsonResult.getCode())) {
                return jsonResult.getData().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
	/*
	public int deleteByPrimaryKey(Long userSerial) {
		return userMapper.deleteByPrimaryKey(userSerial);
	}

	public int insert(UserEntity record) {
		return userMapper.insert(record);
	}

	public int insertSelective(UserEntity record) {
		return userMapper.insertSelective(record);
	}


	public int updateByPrimaryKeySelective(UserEntity record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserEntity record) {
		return userMapper.updateByPrimaryKey(record);
	}

	public List<UserEntity> selectListByEntity(UserEntity record) {
		return userMapper.selectListByEntity(record);
	}*/

}
