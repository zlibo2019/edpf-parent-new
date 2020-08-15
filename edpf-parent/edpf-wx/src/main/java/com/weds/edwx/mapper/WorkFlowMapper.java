package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface WorkFlowMapper {

    int updateTaskByBusinessKey(@Param("taskId") String taskId, @Param("xh") String xh);


}
