package com.weds.edwx.mapper;

import com.weds.edwx.entity.OutEntity;
import com.weds.edwx.entity.OutParamEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface OutMapper {

    int insertOut(OutParamEntity outParamEntity);

    OutEntity selectOutByXh(String xh);

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

    int selectOutShjb(String xh);

    int insertLrWaich(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    int insertLrKqingj(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    int updateLrKqingjMore(@Param("userName") String userName,@Param("xh") String xh);

}
