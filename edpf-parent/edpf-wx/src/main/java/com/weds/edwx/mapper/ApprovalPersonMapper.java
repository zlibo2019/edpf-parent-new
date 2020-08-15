package com.weds.edwx.mapper;

import com.weds.edwx.entity.ApprovalPersonEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface ApprovalPersonMapper {
    /**
     * 查找请假申请人员信息
     * @param xh
     * @return
     */
    ApprovalPersonEntity selectLeaveApplyUser(String xh);

    ApprovalPersonEntity selectShiftApplyUser(String xh);

    ApprovalPersonEntity selectOverTimeApplyUser(String xh);

    ApprovalPersonEntity selectAttendanceApplyUser(String xh);

    ApprovalPersonEntity selectApprovalUser(@Param("xh") String xh,@Param("num") int num);

    ApprovalPersonEntity selectRevokeUser(String xh);

    int selectFalg(String xh);

    int selectShjb(String xh);

    String selectCheckProgress(String xh);

    List<ApprovalPersonEntity> selectUserName(@Param("userSerials") String userSerials);


}
