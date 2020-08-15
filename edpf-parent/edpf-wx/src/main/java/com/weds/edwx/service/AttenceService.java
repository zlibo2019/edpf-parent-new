package com.weds.edwx.service;

import com.weds.core.utils.StringUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.AttenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AttenceService {

    @Autowired
    private AttenceMapper attenceMapper;

    @Autowired
    private ManagementService managementService;

    public List<AttenceEntity> getKqjl(AttenceParamEntity attenceParamEntity) {
        return attenceMapper.getKqjl(attenceParamEntity);
    }

    public List<KtJlEntity> selectDtRecord(Date start, Date end) {
        return attenceMapper.selectDtRecord(start, end);
    }

    /**
     * 移动考勤
     *
     * @param addAttenceParamEntity
     * @return
     */
    public int addKq(AddAttenceParamEntity addAttenceParamEntity) {
        int code = 0;
        if (addAttenceParamEntity.getFx().equals("1")) {
            //20190729去掉上班打三次卡的限制
            //if (attenceMapper.countJl(addAttenceParamEntity) <= 2){
            attenceMapper.addKq(addAttenceParamEntity);
            attenceMapper.insertLog(addAttenceParamEntity);
            managementService.pushMessage(addAttenceParamEntity.getUserSerial(), "", "", "", "99", addAttenceParamEntity.getSj(), null, "", addAttenceParamEntity.getAddress());
            code = 1;
            //} else if (attenceMapper.countJl(addAttenceParamEntity) > 2) {
            //code = 0;
            // }
        } else {
            attenceMapper.addKq(addAttenceParamEntity);
            attenceMapper.insertLog(addAttenceParamEntity);
            managementService.pushMessage(addAttenceParamEntity.getUserSerial(), "", "", "", "99", addAttenceParamEntity.getSj(), null, "", addAttenceParamEntity.getAddress());
            code = 1;
        }
        return code;
    }

    public int addWq(AddOutAttenceParamEntity addOutAttenceParamEntity) {
        int count = attenceMapper.selectCount();
        if (count == 0) {
            attenceMapper.addWq(addOutAttenceParamEntity);
            attenceMapper.insertWqLog(addOutAttenceParamEntity);
            return 1;
        } else if (attenceMapper.selectOutSide(addOutAttenceParamEntity) < count) {
            attenceMapper.addWq(addOutAttenceParamEntity);
            attenceMapper.insertWqLog(addOutAttenceParamEntity);
            return 1;
        } else {
            return 0;
        }
    }

    public List<RangeEntity> getRangeByUser(String userSerial) {
        return attenceMapper.getRangeByUser(userSerial);
    }

    public List<RangeEntity> getRange() {
        return attenceMapper.getRange();
    }


    public List<ShiftsEntity> selectZtBanci(String banciId) {
        return attenceMapper.selectZtBanci(banciId);
    }

    public List<AttenceEntity> getKq(AttenceParamEntity attenceParamEntity) {
        return attenceMapper.getKq(attenceParamEntity);
    }

    public AttenceEntity getKqDetail(AttenceParamEntity attenceParamEntity) {
        return attenceMapper.getKqDetail(attenceParamEntity);
    }

    public KtJlEntity getKqInfo(Integer bh) {
        return attenceMapper.getKqInfo(bh);
    }

    public List<AttenceSummaryEntity> newGetKqhz(AttenceParamEntity attenceParamEntity) {
        return attenceMapper.newGetKqhz(attenceParamEntity);
    }

    public List<AttenceJlEntity> newKqJl(AttenceParamEntity attenceParamEntity) {
        return attenceMapper.newKqJl(attenceParamEntity);
    }

    public List<AttenceMxEntity> newKqMx(AttenceParamEntity attenceParamEntity) {
        return attenceMapper.newKqMx(attenceParamEntity);
    }

    public List<OutsideEntity> selectWqListByEntity(OutsideEntity outsideEntity) {
        return attenceMapper.selectWqListByEntity(outsideEntity);
    }

    public OutsideEntity selectWqApproveUser(String userSerial) {
        return attenceMapper.selectWqApproveUser(userSerial);
    }

    @Transactional
    public int updateWqByPrimaryKeySelective(OutsideEntity outsideEntity) {
        OutsideEntity entity = attenceMapper.selectWxByPrimaryKey(outsideEntity.getId());
        AddAttenceParamEntity addAttenceParamEntity = new AddAttenceParamEntity();
        addAttenceParamEntity.setUserSerial(entity.getUserSerial());
        addAttenceParamEntity.setSj(entity.getRecordTime());
        addAttenceParamEntity.setFx(entity.getFx().toString());
        addAttenceParamEntity.setLname(entity.getUserLname());
        addAttenceParamEntity.setLx("0");
        addAttenceParamEntity.setJlType(2);
        if (!StringUtils.isBlank(entity.getDevSerial())) {
            addAttenceParamEntity.setDevSerial(Integer.parseInt(entity.getDevSerial()));
        }
        addAttenceParamEntity.setJlzpSerial(entity.getJlzpSerial());
        addAttenceParamEntity.setJing(entity.getLang());
        addAttenceParamEntity.setWei(entity.getLat());
        addAttenceParamEntity.setAddress(entity.getAddress());
        attenceMapper.addKq(addAttenceParamEntity);
        return attenceMapper.updateWqByPrimaryKeySelective(outsideEntity);
    }

    public OutsideEntity selectWxByPrimaryKey(Long id) {
        return attenceMapper.selectWxByPrimaryKey(id);
    }
}
