package com.weds.edwx.mapper;

import com.weds.core.annotation.MyBatisDao;
import com.weds.edwx.entity.LeaveEntity;
import com.weds.edwx.entity.LeaveParamEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface LeaveMapper {

     int insertLeave(LeaveParamEntity leaveParamEntity);

     int insertLeave_dz(LeaveParamEntity leaveParamEntity);

     LeaveEntity selectLeaveByXh(String xh);

     String selectUserDep(String userSerial);
     String selectUserRole(String userSerial);

     int selectLrJiaba(@Param("userSerial") String userSerial, @Param("kssj") Date kssj, @Param("jssj") Date jssj);

     int selectLrJiabaMore(@Param("userSerial") String userSerial,@Param("kssj") Date kssj,@Param("jssj") Date jssj);

     int selectLrKqingj(@Param("userSerial") String userSerial,@Param("kssj") Date kssj,@Param("jssj") Date jssj);

     int selectLrKqingjMore(@Param("userSerial") String userSerial,@Param("kssj") Date kssj,@Param("jssj") Date jssj);

     List<String> selectApprovalName(@Param("userSerials") String userSerials);

     int deleteLrWaichMore(String xh);

     int deletrLrKqingjMore(String xh);

     int insertQingjRevoke(String xh);

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

     int selectLeaveShjb(String xh);

     int insertLrWaich(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

     int insertLrKqingj(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

     /**
      * 获取假类编号以及名称.
      * @return
      */
     List<LeaveEntity> selectLeave();


     LeaveEntity selectTime(String xh);

     int updateLrKqingjMore(@Param("userName") String userName,@Param("xh") String xh);



     int updateUserDays(@Param("userSerial") String userSerial,@Param("xh") String xh);
}
