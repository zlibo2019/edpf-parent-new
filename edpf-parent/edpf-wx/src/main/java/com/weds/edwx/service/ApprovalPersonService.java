package com.weds.edwx.service;

import com.alibaba.fastjson.JSONObject;
import com.weds.edwx.entity.ApprovalPersonEntity;
import com.weds.edwx.mapper.ApprovalPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApprovalPersonService {

    @Autowired
    private ApprovalPersonMapper approvalPersonMapper;

    /**
     * 获取请假记录的申请人以及审批、待审批、撤销的操作人员信息
     * @param xh
     * @return
     */
    public List<ApprovalPersonEntity> selectLeaveBotData(String xh){
        List<ApprovalPersonEntity> list = new ArrayList<>();
        list.add(approvalPersonMapper.selectLeaveApplyUser(xh)); // 申请人
        int flag = approvalPersonMapper.selectFalg(xh); // 4 代表的撤销
        int shjb = approvalPersonMapper.selectShjb(xh);
        for(int i = 1; i <= shjb; i++ ){
            list.add(approvalPersonMapper.selectApprovalUser(xh,i));
        }
        if (flag == 4){
            list.add(approvalPersonMapper.selectRevokeUser(xh));
        }
        if (flag == 0 || flag == 1){ // 获取待审批人
            String userSerials = approvalPersonMapper.selectCheckProgress(xh);
            List<ApprovalPersonEntity> personList = approvalPersonMapper.selectUserName(userSerials);
            for (int z = 0; z < personList.size(); z++ ) {
                ApprovalPersonEntity approvalPersonEntity = personList.get(z);
                approvalPersonEntity.setType(5);
                list.add(approvalPersonEntity);
            }
        }
        return  list;
    }

    /**
     * 获取调班记录的申请人以及审批、待审批、撤销的操作人员信息
     * @param xh
     * @return
     */
    public List<ApprovalPersonEntity> selectShiftBotData(String xh){
        List<ApprovalPersonEntity> list = new ArrayList<>();
        list.add(approvalPersonMapper.selectShiftApplyUser(xh)); // 申请人
        int flag = approvalPersonMapper.selectFalg(xh); // 4 代表的撤销
        int shjb = approvalPersonMapper.selectShjb(xh);
        for(int i = 1; i <= shjb; i++ ){
            list.add(approvalPersonMapper.selectApprovalUser(xh,i));
        }
        if (flag == 4){
            list.add(approvalPersonMapper.selectRevokeUser(xh));
        }
        if (flag == 0 || flag == 1){ // 获取待审批人
            String userSerials = approvalPersonMapper.selectCheckProgress(xh);
            List<ApprovalPersonEntity> personList = approvalPersonMapper.selectUserName(userSerials);
            for (int z = 0; z < personList.size(); z++ ) {
                ApprovalPersonEntity approvalPersonEntity = personList.get(z);
                approvalPersonEntity.setType(5);
                list.add(approvalPersonEntity);
            }
        }
        return  list;
    }

    /**
     * 获取加班记录的申请人以及审批、待审批、撤销的操作人员信息
     * @param xh
     * @return
     */
    public List<ApprovalPersonEntity> selectOverTimeBotData(String xh){
        List<ApprovalPersonEntity> list = new ArrayList<>();
        list.add(approvalPersonMapper.selectOverTimeApplyUser(xh)); // 申请人
        int flag = approvalPersonMapper.selectFalg(xh); // 4 代表的撤销
        int shjb = approvalPersonMapper.selectShjb(xh);
        for(int i = 1; i <= shjb; i++ ){
            list.add(approvalPersonMapper.selectApprovalUser(xh,i));
        }
        if (flag == 4){
            list.add(approvalPersonMapper.selectRevokeUser(xh));
        }
        if (flag == 0 || flag == 1){ // 获取待审批人
            String userSerials = approvalPersonMapper.selectCheckProgress(xh);
            List<ApprovalPersonEntity> personList = approvalPersonMapper.selectUserName(userSerials);
            for (int z = 0; z < personList.size(); z++ ) {
                ApprovalPersonEntity approvalPersonEntity = personList.get(z);
                approvalPersonEntity.setType(5);
                list.add(approvalPersonEntity);
            }
        }
        return  list;
    }

    /**
     * 获取补出勤记录的申请人以及审批、待审批、撤销的操作人员信息
     * @param xh
     * @return
     */
    public List<ApprovalPersonEntity> selectAttendanceBotData(String xh) {
        List<ApprovalPersonEntity> list = new ArrayList<>();
        list.add(approvalPersonMapper.selectAttendanceApplyUser(xh)); // 申请人
        int flag = approvalPersonMapper.selectFalg(xh); // 4 代表的撤销
        int shjb = approvalPersonMapper.selectShjb(xh);
        for(int i = 1; i <= shjb; i++ ){
            list.add(approvalPersonMapper.selectApprovalUser(xh,i));
        }
        if (flag == 4){
            list.add(approvalPersonMapper.selectRevokeUser(xh));
        }
        if (flag == 0 || flag == 1){ // 获取待审批人
            String userSerials = approvalPersonMapper.selectCheckProgress(xh);
            List<ApprovalPersonEntity> personList = approvalPersonMapper.selectUserName(userSerials);
            for (int z = 0; z < personList.size(); z++ ) {
                ApprovalPersonEntity approvalPersonEntity = personList.get(z);
                approvalPersonEntity.setType(5);
                list.add(approvalPersonEntity);
            }
        }
        return  list;
    }




}
