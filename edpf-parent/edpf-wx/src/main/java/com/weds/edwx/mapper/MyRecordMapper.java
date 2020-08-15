package com.weds.edwx.mapper;

import com.weds.edwx.entity.MyRecordEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface MyRecordMapper {

    List<MyRecordEntity> getMyApplication(@Param("lx") String lx,@Param("userSerial") String userSerial);

    List<MyRecordEntity> getMyApplicationRevoke(@Param("lx") String lx, @Param("userSerial") String userSerial);

    List<MyRecordEntity> getMyApproval(@Param("lx") String lx, @Param("userSerial") String userSerial);

    List<MyRecordEntity> getMyApproved(@Param("userSerial") String userSerial);

    List<MyRecordEntity> getMyMessage(String userSerial);

    int updateCheckId(@Param("list") List<Map<String,String>> list);
}
