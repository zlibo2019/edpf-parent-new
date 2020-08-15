package com.weds.edwx.mapper;

import com.weds.edwx.entity.DoorInfoEntity;
import com.weds.edwx.entity.DoorfxRealEntity;
import com.weds.edwx.entity.MjJlRealEntity;
import com.weds.edwx.entity.MjMobileEntity;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2018-12-22
 */
@MyBatisDao
public interface MjMobileMapper {

    List<MjMobileEntity> selectDoorList(MjMobileEntity record);

    int updateGateListOrder(DoorInfoEntity doorInfoEntity);

    int selectDoorFlg(MjMobileEntity record);

    int openDoor(DoorfxRealEntity record);

    int getOpenState(@Param("jcmdsig") int jcmdsig);

    int insertLog(MjMobileEntity record);

    DoorfxRealEntity selectDoorFlgByDevSerial(@Param("userSerial") Long userSerial, @Param("devSid") String devSid,
                                              @Param("devOrder") Integer devOrder, @Param("devLb") Integer devLb);

    MjJlRealEntity selectMjRecord(@Param("xh") Integer xh);
}