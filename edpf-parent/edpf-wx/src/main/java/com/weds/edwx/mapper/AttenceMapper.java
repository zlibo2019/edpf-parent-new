package com.weds.edwx.mapper;

import com.weds.edwx.entity.*;
import com.weds.core.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@MyBatisDao
public interface AttenceMapper {

    List<AttenceEntity> getKqjl(AttenceParamEntity attenceParamEntity);

    List<KtJlEntity> selectDtRecord(@Param("start") Date start, @Param("end") Date end);

    int selectCount();

    /**
     * 新增考勤记录
     *
     * @param addAttenceParamEntity
     * @return
     */
    int addKq(AddAttenceParamEntity addAttenceParamEntity);

    /**
     * 查找上班时段的打卡记录
     *
     * @param addAttenceParamEntity
     * @return
     */
    int countJl(AddAttenceParamEntity addAttenceParamEntity);

    /**
     * 日志
     *
     * @param addAttenceParamEntity
     * @return
     */
    int insertLog(AddAttenceParamEntity addAttenceParamEntity);

    /**
     * 获取移动考勤经纬度,范围
     *
     * @return
     */
    List<RangeEntity> getRangeByUser(String userSerial);

    /**
     * 获取移动考勤经纬度,范围
     *
     * @return
     */
    List<RangeEntity> getRange();

    /**
     * 外勤打卡
     *
     * @param addOutAttenceParamEntity
     * @return
     */
    int addWq(AddOutAttenceParamEntity addOutAttenceParamEntity);

    /**
     * 查看外勤
     *
     * @param addOutAttenceParamEntity
     * @return
     */
    int selectOutSide(AddOutAttenceParamEntity addOutAttenceParamEntity);

    /**
     * 外勤日志
     *
     * @param addOutAttenceParamEntity
     * @return
     */
    int insertWqLog(AddOutAttenceParamEntity addOutAttenceParamEntity);

    /**
     * 获取班次信息
     *
     * @param banciId
     * @return
     */
    List<ShiftsEntity> selectZtBanci(@Param("banciId") String banciId);

    List<AttenceEntity> getKq(AttenceParamEntity attenceParamEntity);

    AttenceEntity getKqDetail(AttenceParamEntity attenceParamEntity);

    List<AttenceSummaryEntity> newGetKqhz(AttenceParamEntity attenceParamEntity);

    List<AttenceJlEntity> newKqJl(AttenceParamEntity attenceParamEntity);

    List<AttenceMxEntity> newKqMx(AttenceParamEntity attenceParamEntity);

    List<OutsideEntity> selectWqListByEntity(OutsideEntity outsideEntity);

    OutsideEntity selectWqApproveUser(@Param("userSerial") String userSerial);

    int updateWqByPrimaryKeySelective(OutsideEntity outsideEntity);

    OutsideEntity selectWxByPrimaryKey(@Param("id") Long id);

    KtJlEntity getKqInfo(@Param("bh") Integer bh);

}
