package com.weds.edwx.mapper;

import com.weds.edwx.entity.LoginLogEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author sxm
 * @Description 管理
 * @Date 2018-11-26
 */
@MyBatisDao
public interface LoginLogMapper {
    /**
     */
    int insert(LoginLogEntity record);
}