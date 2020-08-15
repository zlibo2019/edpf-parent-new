package com.weds.edwx.service;

import com.weds.edwx.entity.MyRecordEntity;
import com.weds.edwx.entity.ResponEntity;
import com.weds.edwx.mapper.MyRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MyRecordService {

    @Autowired
    private MyRecordMapper myRecrdMapper;


    /**
     * 我申请的
     * @param lx 0:待审批 1:待审批 2:审批通过 3:审批拒绝 4:撤销
     * @param userSerial
     * @return
     */
    public List<MyRecordEntity> getMyApplication(String lx, String userSerial){
        return myRecrdMapper.getMyApplication(lx,userSerial);
    }

    /**
     * 获取待我审批的记录
     * @param lx 0,1 待审批 2 审批通过 3 审批未通过 4 撤销
     * @param userSerial 人员序号
     * @return
     */
    public List<MyRecordEntity> getMyApproval(String lx, String userSerial) throws Exception {
        /*ResponEntity responEntity = workFlowService.findAllTaskListByUserId(userSerial);
        List<Map<String,String>> repList = (List<Map<String, String>>) responEntity.getData();
        if (repList != null && repList.size() > 0){
            myRecrdMapper.updateCheckId(repList);
        }*/
        return myRecrdMapper.getMyApproval(lx,userSerial);
    }

    /**
     * 已审批的
     * @param userSerial
     * @return
     */
    public List<MyRecordEntity> getMyApproved(String userSerial){
        return myRecrdMapper.getMyApproved(userSerial);
    }


    /**
     * 抄送我的
     * @param userSerial
     * @return
     */
    public List<MyRecordEntity> getMyMessage(String userSerial){
        return myRecrdMapper.getMyMessage(userSerial);
    }



}
