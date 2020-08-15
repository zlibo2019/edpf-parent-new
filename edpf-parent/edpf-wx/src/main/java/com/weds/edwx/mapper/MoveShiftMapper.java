package com.weds.edwx.mapper;

import com.weds.edwx.entity.MoveShiftEntity;
import com.weds.edwx.entity.MoveShiftParamEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface MoveShiftMapper {

    MoveShiftEntity selectMoveShiftByXh(String xh);

    List<String> selectApprovalName(@Param("userSerials") String userSerials);

    int findMoveShift(@Param("userSerial") String userSerial,@Param("tbrq") Date tbrq);

    int insertMoveShift(MoveShiftParamEntity moveShiftParamEntity);

    String selectUserDep(String userSerial);

    String selectUserRole(String userSerial);

    int insertPaiBanRevoke(String xh);

    int deleteTiaoMore(String xh);

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

    int selectMoveShiftShjb(String xh);

    int insertKtTiao(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    int insertKtTiaoB(@Param("checkId") String checkId,@Param("shenhe") String shenhe);

    String getPaiba(@Param("userSerial") String userSerial,@Param("paiba") String paiba, @Param("rq") String rq);

    MoveShiftEntity getBanci(@Param("banci") String banci);

    List<MoveShiftEntity> getBanciAll();

    int updateKtTiaoMore(@Param("userName") String userName,@Param("xh") String xh);

    int updatePaiba(@Param("xh") String xh);

}
