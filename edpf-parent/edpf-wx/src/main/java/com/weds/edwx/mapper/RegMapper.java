package com.weds.edwx.mapper;

import com.weds.edwx.entity.RegEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-27
 */
@MyBatisDao
public interface RegMapper {

    RegEntity selectByPrimaryKey();
}