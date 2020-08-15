package com.weds.edwx.mapper;

import com.weds.edwx.entity.VisCardUserEntity;
import com.weds.edwx.entity.VisRegisterEntity;
import com.weds.core.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 管理
 * @Date 2019-03-20
 */
@MyBatisDao
public interface VisCardUserMapper {
    //查出该访客是否有未注销记录
    int selectCardCount(VisRegisterEntity visRegisterEntity);

    //查出该卡是否是正式员工的使用卡，避免误发
    int selectCardNormalCount(VisCardUserEntity visCardUserEntity);

    //给门控板下发增量
    int insertUpdate1Mj(VisRegisterEntity visRegisterEntity);

    //给梯控板下发增量
    int insertUpdate1Tk(VisRegisterEntity visRegisterEntity);

    //给考勤机下发增量
    int insertUpdate4Kq(VisRegisterEntity visRegisterEntity);

    int updateCancelCard(VisCardUserEntity visCardUserEntity);

    int cancelUpdate1Mj(VisRegisterEntity visRegisterEntity);

    int cancelUpdate1Tk(VisRegisterEntity visRegisterEntity);

    int cancelUpdate4Kq(VisRegisterEntity visRegisterEntity);

    int haveCards(Long visSerial);

    int haveCardsOrQrcode(@Param("cardHao") String cardHao, @Param("visSerial") Long visSerial);

    /**
     */
    int deleteByPrimaryKey(Integer xh);

    /**
     */
    int insert(VisCardUserEntity record);

    /**
     */
    int insertSelective(VisCardUserEntity record);

    /**
     */
    VisCardUserEntity selectByPrimaryKey(Integer xh);

    /**
     */
    int updateByPrimaryKeySelective(VisCardUserEntity record);

    /**
     */
    int updateByPrimaryKey(VisCardUserEntity record);

    /**
     */
    List<VisCardUserEntity> selectListByEntity(VisCardUserEntity record);

    /**
     */
    List<VisCardUserEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<VisCardUserEntity> list);
}