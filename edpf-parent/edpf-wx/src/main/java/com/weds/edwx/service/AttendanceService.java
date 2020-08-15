package com.weds.edwx.service;

import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.AttendanceMapper;
import com.weds.edwx.util.SHConstants;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ApprovalPersonService approvalPersonService;

    @Autowired
    private SystemService systemService;

    /**
     * 不匹配预设定流程. 东药定制版
     *
     * @param attendanceParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, String> insertAttendance(AttendanceParamEntity attendanceParamEntity) throws Exception {
        Map<String, String> repMap = new HashMap<>();
        //人员序号
        String userSerial = attendanceParamEntity.getUserSerial();
        String bh = attendanceParamEntity.getBh();
        Date sbsj = attendanceParamEntity.getSbsj();
        Date xbsj = attendanceParamEntity.getXbsj();
        String approver = attendanceParamEntity.getApprover();
        String processId = "SYS01";
        String xh = attendanceParamEntity.getXh();
        String copyUser = attendanceParamEntity.getCopyUser();

        int count_jl = attendanceMapper.findLrJl(userSerial, sbsj, xbsj);
        if (count_jl == 0) {
            String userDep = attendanceMapper.selectUserDep(userSerial);
            String userRole = attendanceMapper.selectUserRole(userSerial);

            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr = String.format("%02d", num);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            // 第一次请求自动生成
            if (xh == null || xh.equals("")) {
                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
            }
            if (approver != null && !approver.equals("")) {
                JsonResult responEntity = workFlowService.startProcess(xh, userSerial, userDep, userRole, "1", bh, approver, processId);
                if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
                    Map<String, String> result = (Map) responEntity.getData();
                    String checkProgress = result.get("approveId");
                    String checkPp = "$" + checkProgress.replace(",", "$,$") + "$";
                    attendanceParamEntity.setXh(xh);
                    attendanceParamEntity.setCheckProgress(checkProgress);
                    attendanceParamEntity.setCheckPp(checkPp);
                    attendanceParamEntity.setImgPath(systemService.wxImageDownLoad(attendanceParamEntity.getImgPath()));
                    attendanceMapper.insertAttendance(attendanceParamEntity);
                    //保存抄送人
                    if (copyUser != null && !copyUser.equals("")) {
                        managementService.insertCopyUser(xh, copyUser);
                    }
                    // 自定义审批人
                    managementService.approvalUser(approver, userSerial, processId);
                    //推送消息
                    if (sbsj == null) {
                        managementService.pushMessage(userSerial, checkProgress, xh, "0", "5", null, xbsj, "", "补出勤");
                    } else if (xbsj == null) {
                        managementService.pushMessage(userSerial, checkProgress, xh, "0", "5", sbsj, null, "", "补出勤");
                    } else {
                        managementService.pushMessage(userSerial, checkProgress, xh, "0", "5", sbsj, xbsj, "", "补出勤");
                    }
                    repMap.put("code", "1");
                    repMap.put("xh", xh);
                } else {
                    repMap.put("code", "3");
                    repMap.put("msg", responEntity.getMsg());
                }
            } else {
                //自定义审批人为空,返回businessKey,以及自定义审批ID,作为二次请求的参数.
                repMap.put("code", "2");
                repMap.put("processId", processId);
                repMap.put("xh", xh);
            }
        } else {
            repMap.put("code", "4");
        }
        return repMap;

    }


//    @Transactional(propagation= Propagation.REQUIRED)
//    public Map<String,String> insertAttendance(AttendanceParamEntity attendanceParamEntity) throws Exception{
//        Map<String,String> repMap = new HashMap<>();
//        //人员序号
//        String userSerial = attendanceParamEntity.getUserSerial();
//        String bh = attendanceParamEntity.getBh();
//        Date sbsj = attendanceParamEntity.getSbsj();
//        Date xbsj = attendanceParamEntity.getXbsj();
//        String approver = attendanceParamEntity.getApprover();
//        String processId = attendanceParamEntity.getProcessId();
//        String xh = attendanceParamEntity.getXh();
//        String copyUser = attendanceParamEntity.getCopyUser();
//
//        int count_jl = attendanceMapper.findLrJl(userSerial,sbsj,xbsj);
//
//        if (count_jl == 0){
//
//            String userDep = attendanceMapper.selectUserDep(userSerial);
//            String userRole = attendanceMapper.selectUserRole(userSerial);
//
//            Random random = new Random();
//            int num = random.nextInt(99);
//            String randomStr =String.format("%02d",num);
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            // 第一次请求自动生成
//            if (xh == null || xh.equals("")){
//                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
//            }
//            JsonResult responEntity = workFlowService.startProcess(xh,userSerial,userDep,userRole,"1",bh,approver,processId);
//
//            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
//
//                Map<String,String> result = (Map)responEntity.getData();
//                String checkProgress = result.get("approveId");
//                String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                attendanceParamEntity.setXh(xh);
//                attendanceParamEntity.setCheckProgress(checkProgress);
//                attendanceParamEntity.setCheckPp(checkPp);
//                attendanceParamEntity.setImgPath(systemService.wxImageDownLoad(attendanceParamEntity.getImgPath()));
//                attendanceMapper.insertAttendance(attendanceParamEntity);
//                if (copyUser != null && !copyUser.equals("")) {
//                    managementService.insertCopyUser(xh,copyUser);
//                }
//                // 自定义审批人
//                managementService.approvalUser(approver,userSerial,processId);
//                //推送消息
//                if (sbsj == null){
//                    managementService.pushMessage(userSerial,checkProgress,xh,"0","5",null,xbsj,"","补出勤");
//                } else if (xbsj == null) {
//                    managementService.pushMessage(userSerial,checkProgress,xh,"0","5",sbsj,null,"","补出勤");
//                } else {
//                    managementService.pushMessage(userSerial,checkProgress,xh,"0","5",sbsj,xbsj,"","补出勤");
//                }
//
//
//                repMap.put("code","1");
//                repMap.put("xh",xh);
//
//
//            } else if (WorkFlowConstants.NO_PROCESS_FLAG.equals(responEntity.getCode())) {
//                Map<String,String> result = (Map)responEntity.getData();
//                processId = result.get("processId");
//                if (approver != null && processId != null && !approver.equals("") && !processId.equals("")) {
//                    responEntity = workFlowService.startProcess(xh,userSerial,userDep,userRole,"1",bh,approver,processId);
//                    if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
//                        result = (Map) responEntity.getData();
//                        String checkProgress = result.get("approveId");
//                        String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                        attendanceParamEntity.setXh(xh);
//                        attendanceParamEntity.setCheckProgress(checkProgress);
//                        attendanceParamEntity.setCheckPp(checkPp);
//                        attendanceParamEntity.setImgPath(systemService.wxImageDownLoad(attendanceParamEntity.getImgPath()));
//                        attendanceMapper.insertAttendance(attendanceParamEntity);
//                        //保存抄送人
//                        if (copyUser != null && !copyUser.equals("")) {
//                            managementService.insertCopyUser(xh,copyUser);
//                        }
//                        // 自定义审批人
//                        managementService.approvalUser(approver,userSerial,processId);
//                        //推送消息
//                        if (sbsj == null){
//                            managementService.pushMessage(userSerial,checkProgress,xh,"0","5",null,xbsj,"","补出勤");
//                        } else if (xbsj == null) {
//                            managementService.pushMessage(userSerial,checkProgress,xh,"0","5",sbsj,null,"","补出勤");
//                        } else {
//                            managementService.pushMessage(userSerial,checkProgress,xh,"0","5",sbsj,xbsj,"","补出勤");
//                        }
//                        repMap.put("code","1");
//                        repMap.put("xh",xh);
//                    } else {
//                        repMap.put("code","3");
//                        repMap.put("msg",responEntity.getMsg());
//                    }
//                } else {
//                    //自定义审批人为空,返回businessKey,以及自定义审批ID,作为二次请求的参数.
//                    repMap.put("code","2");
//                    repMap.put("processId",result.get("processId"));
//                    repMap.put("xh",xh);
//                }
//            } else {
//                repMap.put("code","3");
//                repMap.put("msg",responEntity.getMsg());
//            }
//        } else {
//            repMap.put("code","4");
//        }
//        return repMap;
//    }


    /**
     * 查看补出勤记录
     *
     * @param attendanceParamEntity
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectAttendanceByXh(AttendanceParamEntity attendanceParamEntity) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String userSerial = attendanceParamEntity.getUserSerial();
        String xh = attendanceParamEntity.getXh();
        // 更新taksId
        workFlowService.updateTaskByBusinessKey(userSerial, xh);
        AttendanceEntity attendanceEntity = attendanceMapper.selectAttendanceByXh(xh);
        if (attendanceEntity != null) {
            List<String> list = attendanceMapper.selectApprovalName(attendanceEntity.getCheckProgress());
            String userName = "";
            for (int i = 0; i < list.size(); i++) {
                userName = userName.equals("") ? list.get(0) : userName + "," + list.get(0);
            }
            attendanceEntity.setCheckProgress(userName);
            String imgPath = attendanceEntity.getImgPath();
            if (imgPath != null && !imgPath.equals("")) {
                /**
                 * 图片转换为Basr64字符串
                 * 存到数组,传到前台.
                 */
                String[] path = imgPath.split(",");
                String[] img = new String[path.length];
                for (int i = 0; i < path.length; i++) {
                    img[i] = ImageUtils.imgToBase64(path[i]);
                }
                attendanceEntity.setImgPath(null);
                attendanceEntity.setImg(img);
            } else {
                attendanceEntity.setImg(new String[0]);
            }
            map.put("midData", attendanceEntity);
            map.put("botData", approvalPersonService.selectAttendanceBotData(xh));
        }
        return map;
    }

    /**
     * 撤销补出勤记录
     *
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult deleteAttendance(String userSerial, String xh, String reason) throws Exception {
        JsonResult responEntity = workFlowService.deleteProcessInstanceByBussinessKey(xh, reason);
        if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) { // 1 成功 0 失败
            AttendanceEntity attendanceEntity = attendanceMapper.selectAttendanceByXh(xh);
            attendanceMapper.insertKtPaibanRevoke(xh);
            attendanceMapper.deleteLrJlMore(userSerial, xh);
            attendanceMapper.updateKtQingjMore(xh, "", 4, "", "", "", "", "", 0, reason);
            managementService.pushMessage(userSerial, attendanceEntity.getCheckProgress(), xh, "4", "5", attendanceEntity.getSbsj(), attendanceEntity.getXbsj(), "", "补出勤");
        }
        return responEntity;
    }

    /**
     * 审批补出勤记录
     *
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult approvalAttendance(ApprovalParamEntity approvalParamEntity) {
        String xh = approvalParamEntity.getXh();
        String result = approvalParamEntity.getResult();
        String userSerial = approvalParamEntity.getUserSerial();
        String checkId = approvalParamEntity.getCheckId();
        String userName = managementService.findUserName(userSerial);
        int shjb = attendanceMapper.selectLeaveShjb(xh) + 1;

        String shsj = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        // 查询补出勤记录的时间
        AttendanceEntity attendanceEntity = attendanceMapper.selectTime(xh);
        JsonResult responEntity = workFlowService.completeTask(approvalParamEntity);
        if (WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())) {  // 审批完成 请假生效
            int flag = Integer.parseInt(result) == 1 ? 2 : 3;
            attendanceMapper.updateLrJlMore(userName, xh);
            // 修改数据库字段responEntity
            attendanceMapper.updateKtQingjMore(xh, Integer.toString(shjb), flag, "", "", userSerial, shsj, result, shjb, approvalParamEntity.getReason());
            if (flag == 2) {
                // 更新 lr_waich表 lt_kqingj表
                attendanceMapper.insertLrJl(checkId, userName + "-" + SHConstants.SHENHE);
                attendanceMapper.insertKtJl(checkId, userName + "-" + SHConstants.SHENHE);
                //审批通过,推送消息
                managementService.pushMessage("", "", xh, "2", "5", attendanceEntity.getSbsj(), attendanceEntity.getXbsj(), "", "补出勤");
            } else {
                //审批拒绝,推送消息
                managementService.pushMessage("", "", xh, "3", "5", attendanceEntity.getSbsj(), attendanceEntity.getXbsj(), "", "补出勤");
            }
        }
        if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {  // 审批成功
            int flag = 1;
            String checkProgress = responEntity.getData().toString();
            String checkPp = "$" + checkProgress.replace(",", "$,$") + "$";
            ;
            // 修改数据库字段
            attendanceMapper.updateKtQingjMore(xh, Integer.toString(shjb), flag, checkProgress, checkPp, userSerial, shsj, result, shjb, approvalParamEntity.getReason());
            managementService.pushMessage("", checkProgress, xh, "1", "5", attendanceEntity.getSbsj(), attendanceEntity.getXbsj(), "", "补出勤");
        }
        return responEntity;
    }
}