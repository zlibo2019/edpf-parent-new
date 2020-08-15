package com.weds.edwx.mapper;

import com.weds.edwx.entity.AttendanceEntity;
import com.weds.edwx.entity.AttendanceParamEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface AttendanceMapper {

    String selectUserDep(String userSerial);

    String selectUserRole(String userSerial);

    int findLrJl(@Param("userSerial") String userSerial, @Param("sbsj") Date sbsj, @Param("xbsj") Date xbsj);

    /**
     * 新增补出勤记录
     * @param attendanceParamEntity
     * @return
     */
    int insertAttendance(AttendanceParamEntity attendanceParamEntity);

    AttendanceEntity selectAttendanceByXh(String xh);

    List<String> selectApprovalName(@Param("userSerials") String userSerials);

    /**
     * 获取业务审批级别
     * @param xh
     * @return
     */
    int selectLeaveShjb(String xh);

    /**
     * 修改Kt_qingj_more 表数据
     * @param xh
     * @param shjb
     * @param flag
     * @param checkProgress
     * @param checkPp
     * @param shenhe
     * @param shsj
     * @param shyj
     * @param num
     * @return
     */
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

    int insertKtPaibanRevoke(String xh);

    int deleteLrJlMore(@Param("userSerial") String userSerial,@Param("xh") String xh);

    int insertLrJl(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    int insertKtJl(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    AttendanceEntity selectTime(String xh);

    int updateLrJlMore(@Param("userName") String userName,@Param("xh") String xh);
}
