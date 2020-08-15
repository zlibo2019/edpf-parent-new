package com.weds.edwx.mapper;

import com.weds.edwx.entity.OverTimeEntity;
import com.weds.edwx.entity.OverTimeParamEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface OverTimeMapper {

    int insertOverTime(OverTimeParamEntity overTimeParamEntity);

    OverTimeEntity selectOverTimeByXh(String xh);

    List<String> selectApprovalName(@Param("userSerials") String userSerials);

    String selectUserDep(String userSerial);

    String selectUserRole(String userSerial);

    int selectLrJiaba(@Param("userSerial") String userSerial, @Param("kssj") Date kssj, @Param("jssj") Date jssj);

    int selectLrJiabaMore(@Param("userSerial") String userSerial,@Param("kssj") Date kssj,@Param("jssj") Date jssj);

    int selectLrKqingj(@Param("userSerial") String userSerial,@Param("kssj") Date kssj,@Param("jssj") Date jssj);

    int selectLrKqingjMore(@Param("userSerial") String userSerial,@Param("kssj") Date kssj,@Param("jssj") Date jssj);

    int insertPaiBanRevoke(String xh);

    int deleteJiabaMore(String xh);

    int updateKtQingjMore(@Param("xh") String xh,
                          @Param("shjb") String shjb,
                          @Param("flag") int flag,
                          @Param("checkProgress") String checkProgress,
                          @Param("checkPp") String checkPp,
                          @Param("shenhe") String shenhe,
                          @Param("shsj") String shsj,
                          @Param("shyj") String shyj,
                          @Param("num") int num,
                          @Param("reason") String reason);

    int selectOverTimeShjb(String xh);

    int insertLrJiaBa(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    int updateLrJiaBaMore(@Param("userName") String userName,@Param("xh") String xh);
}
