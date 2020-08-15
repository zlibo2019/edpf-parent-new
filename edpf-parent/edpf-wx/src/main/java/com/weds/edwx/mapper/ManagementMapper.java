package com.weds.edwx.mapper;

import com.weds.edwx.entity.ManagementEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface ManagementMapper {

    String findUserApproval(String userSerial);

    ManagementEntity selectApprovalUser(String userSerial);

    List<ManagementEntity> seletCopyUser(@Param("lx") String lx, @Param("userSerial") Long userSerial);

    String selectApprovalSerial(String userSerial);

    int updateApprovalLx(@Param("lx") int lx, @Param("userSerial") String userSerial, @Param("approvalSerial") String approvalSerial);

    List<ManagementEntity> getTravelPeople(String userSerial);

    int findCopyUser(@Param("lx") String lx, @Param("userSerial") Long userSerial);

    int existsCopyUser(@Param("lx") int lx, @Param("userSerial") Long userSerial);

    String findUserName(String userSerial);

    int insertMsgSend(@Param("userSerial") String userSerial,
                      @Param("msgState") String msgState,
                      @Param("recordDate") String recordDate,
                      @Param("insertDate") String insertDate,
                      @Param("templetId") String templetId,
                      @Param("mesContent") String mesContent,
                      @Param("msgXh") String msgXh);

    String selectLrJl(String xh);

    String selectCheckProgress(String xh);

    String selectKtTiao(String xh);

    String selectJiaBan(String xh);

    String selectQingJia(String xh);

    int insertApproval(@Param("userSerial") String userSerial, @Param("approval") String approval);

    /**
     * 清空自定义抄送人员
     *
     * @param xh
     * @return
     */
    int deleteCopyUser(@Param("xh") String xh);

    /**
     * 新增自定义抄送人员
     *
     * @param xh
     * @param sj
     * @param copyUser
     * @return
     */
    int insertCopyUser(@Param("xh") String xh, @Param("sj") String sj, @Param("copyUser") String copyUser);

    /**
     * 查找自定义抄送人
     *
     * @param xh
     * @return
     */
    List<ManagementEntity> selectCustomCopyUser(@Param("xh") String xh);

    /**
     * 查找同行人员姓名
     *
     * @param userSerials
     * @return
     */
    List<String> getTravelPeopleName(@Param("userSerials") String userSerials);


}
