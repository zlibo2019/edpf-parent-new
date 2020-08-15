package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface CustomizedMapper {

    void sendMessage(@Param("personLx") int personLx,@Param("num") int num);

}
