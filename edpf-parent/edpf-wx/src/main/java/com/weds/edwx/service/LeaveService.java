package com.weds.edwx.service;

import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.LeaveMapper;
import com.weds.edwx.util.SHConstants;
import com.weds.workflow.constants.WorkFlowConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ApprovalPersonService approvalPersonService;

    @Autowired
    private SystemService systemService;


    /**
     * 不匹配预设定请假流程, 东药定制方法.
     * @param leaveParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public Map<String,Object> insertLeave_dz(LeaveParamEntity leaveParamEntity) throws Exception{
        Map<String,Object> repMap = new HashMap<String, Object>();
        String userSerial = leaveParamEntity.getUserSerial(); //人员序号
        Date kssj = leaveParamEntity.getKssj(); //开始时间
        Date jssj = leaveParamEntity.getJssj(); //结束时间
        String bh = leaveParamEntity.getBh(); //假类编号
        String approver = leaveParamEntity.getApprover(); //自定义审批人
        String processId = leaveParamEntity.getProcessId(); //自定义审批ID
        String xh = leaveParamEntity.getXh(); // 申请编号
        String copyUser = leaveParamEntity.getCopyUser(); //抄送人员
        String leaveLength = leaveParamEntity.getLeaveLength();
        if (leaveLength != null && !leaveLength.equals("")){
            if (leaveLength.indexOf(".") == -1){
                if (leaveLength.length() > 10){
                    repMap.put("code","5");
                    return repMap;
                }
            } else {
                if (leaveLength.split("\\.")[0].length() > 10){
                    repMap.put("code","5");
                    return repMap;
                }
            }
        }
        int countJia = leaveMapper.selectLrJiaba(userSerial,kssj,jssj);
        int countJiaMore = leaveMapper.selectLrJiabaMore(userSerial,kssj,jssj);
        int countLr = leaveMapper.selectLrKqingj(userSerial,kssj,jssj);
        int countLrMore = leaveMapper.selectLrKqingjMore(userSerial,kssj,jssj);
        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0){
            String userDep = leaveMapper.selectUserDep(userSerial);
            String userRole = leaveMapper.selectUserRole(userSerial);
            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr =String.format("%02d",num);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            // 第一次请求自动生成
            if (xh == null || xh.equals("")){
                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
            }
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            double leaveDays = DateUtils.getDateDiffDay(kssj,jssj) + 1 ;
            // 自定义审批人不为空
            if (approver != null && !approver.equals("")) {
                processId = "SYS01";
                JsonResult responEntity =
                        workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
                if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
                    Map<String,String> result = (Map)responEntity.getData();
                    String checkProgress = result.get("approveId");
                    String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                    leaveParamEntity.setXh(xh);
                    leaveParamEntity.setCheckProgress(checkProgress);
                    leaveParamEntity.setCheckPp(checkPp);
                    leaveParamEntity.setImgPath(systemService.wxImageDownLoad(leaveParamEntity.getImgPath()));
                    int resultNum =  leaveMapper.insertLeave_dz(leaveParamEntity);
                    if (resultNum == 0){
                        repMap.put("code","6");
                        return repMap;
                    }
                    if (copyUser != null && !copyUser.equals("")) {
                        managementService.insertCopyUser(xh,copyUser);
                    }
                    // 自定义审批人
                    managementService.approvalUser(approver,userSerial,processId);
                    managementService.pushMessage(userSerial,checkProgress,xh,"0","0",kssj,jssj,"","请假");
                    repMap.put("code","1");
                    repMap.put("xh",xh);
                } else {
                    repMap.put("code","3");
                    repMap.put("msg",responEntity.getMsg());
                }
            } else {
                //自定义审批人为空,返回businessKey,以及自定义审批ID,作为二次请求的参数.
                repMap.put("code","2");
                repMap.put("processId",processId);
                repMap.put("xh",xh);
            }
        } else {
            repMap.put("code","4");
        }
        return repMap;
    }

    /**
     * 新增请假记录申请
     * @return
     * @throws Exception
     */
       @Transactional(propagation= Propagation.REQUIRED)
    public Map<String,Object> insertLeave(LeaveParamEntity leaveParamEntity) throws Exception {
        Map<String,Object> repMap = new HashMap<String, Object>();
        String userSerial = leaveParamEntity.getUserSerial(); //人员序号
        Date kssj = leaveParamEntity.getKssj(); //开始时间
        Date jssj = leaveParamEntity.getJssj(); //结束时间
        String bh = leaveParamEntity.getBh(); //假类编号
        String approver = leaveParamEntity.getApprover(); //自定义审批人
        String processId = leaveParamEntity.getProcessId(); //自定义审批ID
        String xh = leaveParamEntity.getXh(); // 申请编号
        String copyUser = leaveParamEntity.getCopyUser(); //抄送人员
        String leaveLength = leaveParamEntity.getLeaveLength();
        if (leaveLength != null && !leaveLength.equals("")){
            if (leaveLength.indexOf(".") == -1){
                if (leaveLength.length() > 10){
                    repMap.put("code","5");
                    return repMap;
                }
            } else {
                if (leaveLength.split("\\.")[0].length() > 10){
                    repMap.put("code","5");
                    return repMap;
                }
            }
        }
        int countJia = leaveMapper.selectLrJiaba(userSerial,kssj,jssj);
        int countJiaMore = leaveMapper.selectLrJiabaMore(userSerial,kssj,jssj);
        int countLr = leaveMapper.selectLrKqingj(userSerial,kssj,jssj);
        int countLrMore = leaveMapper.selectLrKqingjMore(userSerial,kssj,jssj);
        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0){
            String userDep = leaveMapper.selectUserDep(userSerial);
            String userRole = leaveMapper.selectUserRole(userSerial);
            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr =String.format("%02d",num);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            // 第一次请求自动生成
            if (xh == null || xh.equals("")){
                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
            }
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            double leaveDays = DateUtils.getDateDiffDay(kssj,jssj) + 1 ;
            JsonResult responEntity = workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) { // 有对应的规则，请求成功
                Map<String,String> result = (Map)responEntity.getData();
                String checkProgress = result.get("approveId");
                String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                leaveParamEntity.setXh(xh);
                leaveParamEntity.setCheckProgress(checkProgress);
                leaveParamEntity.setCheckPp(checkPp);
                leaveParamEntity.setImgPath(systemService.wxImageDownLoad(leaveParamEntity.getImgPath()));
                //int resultNum =
                        leaveMapper.insertLeave(leaveParamEntity);
                //if (resultNum == 0){
                   // repMap.put("code","6");
                    //return repMap;
               // }
                if (copyUser != null && !copyUser.equals("")) {
                    managementService.insertCopyUser(xh,copyUser);
                }
                // 自定义审批人
                managementService.approvalUser(approver,userSerial,processId);

                managementService.pushMessage(userSerial,checkProgress,xh,"0","0",kssj,jssj,"","请假");
                repMap.put("code","1");
                repMap.put("xh",xh);

            } else if(WorkFlowConstants.NO_PROCESS_FLAG.equals(responEntity.getCode())){ // 自定义审批流程
                Map<String,String> result = (Map)responEntity.getData();
                processId = result.get("processId");
                if (approver != null && processId != null && !approver.equals("") && !processId.equals("")){
                    /**
                     * 自定义审批人不为空,获取自定义审批ID后,重新请求多级审批录入接口.
                     * 返回1代表成功.
                     * 返回其他,参数异常
                     */
                    responEntity =
                            workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
                    if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
                        result = (Map)responEntity.getData();
                        String checkProgress = result.get("approveId");
                        String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                        leaveParamEntity.setXh(xh);
                        leaveParamEntity.setCheckProgress(checkProgress);
                        leaveParamEntity.setCheckPp(checkPp);
                        leaveParamEntity.setImgPath(systemService.wxImageDownLoad(leaveParamEntity.getImgPath()));
                        //int resultNum =
                                leaveMapper.insertLeave(leaveParamEntity);
//                        if (resultNum == 0){
//                            repMap.put("code","6");
//                            return repMap;
//                        }
                        if (copyUser != null && !copyUser.equals("")) {
                            managementService.insertCopyUser(xh,copyUser);
                        }
                        // 自定义审批人
                        managementService.approvalUser(approver,userSerial,processId);
                        managementService.pushMessage(userSerial,checkProgress,xh,"0","0",kssj,jssj,"","请假");
                        repMap.put("code","1");
                        repMap.put("xh",xh);
                    } else {
                        repMap.put("code","3");
                        repMap.put("msg",responEntity.getMsg());
                    }
                } else {
                    //自定义审批人为空,返回businessKey,以及自定义审批ID,作为二次请求的参数.
                    repMap.put("code","2");
                    repMap.put("processId",result.get("processId"));
                    repMap.put("xh",xh);
                }
            } else {
                repMap.put("code","3");
                repMap.put("msg",responEntity.getMsg());
            }
        }else{
            repMap.put("code","4");
        }
        return repMap;
    }

    /**
     * 查找请假记录
     * @param leaveParamEntity
     * @return
     * @throws Exception
     */
    public Map<String,Object> selectLeaveByXh(LeaveParamEntity leaveParamEntity) throws Exception{
        Map<String,Object> map = new HashMap<>();
        String userSerial = leaveParamEntity.getUserSerial();
        String xh = leaveParamEntity.getXh();
        // 更新taksId
        workFlowService.updateTaskByBusinessKey(userSerial,xh);
        LeaveEntity leaveEntity = leaveMapper.selectLeaveByXh(xh);
        if (leaveEntity != null){
            List<String> list = leaveMapper.selectApprovalName(leaveEntity.getCheckProgress());
            String userName = "";
            for(int i = 0; i < list.size(); i ++){
                userName = userName.equals("")?list.get(0):userName+","+list.get(0);
            }
            leaveEntity.setCheckProgress(userName);
            // 图片路径
            String imgPath = leaveEntity.getImgPath();
            if ( imgPath != null && !imgPath.equals("") ){
                /**
                 * 图片转换为Basr64字符串
                 * 存到数组,传到前台.
                 */
                String[] path = imgPath.split(",");
                String[] img = new String[path.length];
                for (int i = 0; i < path.length; i++) {
                    img[i] = ImageUtils.imgToBase64(path[i]);
                }
                leaveEntity.setImgPath(null);
                leaveEntity.setImg(img);
            } else {
                leaveEntity.setImg(new String[0]);
            }
            map.put("midData",leaveEntity);
            map.put("botData",approvalPersonService.selectLeaveBotData(xh));
        }
        return map;
    }

    /**
     * 撤销请假记录
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult deleteLeave(String userSerial,String xh,String reason) throws Exception {
        JsonResult responEntity = workFlowService.deleteProcessInstanceByBussinessKey(xh, reason);
        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){ // 1 成功 0 失败
            LeaveEntity leaveEntity = leaveMapper.selectLeaveByXh(xh);
            leaveMapper.updateUserDays(userSerial,xh);
            leaveMapper.insertQingjRevoke(xh);
            leaveMapper.deleteLrWaichMore(xh);
            leaveMapper.deletrLrKqingjMore(xh);
            leaveMapper.updateKtQingjMore(xh,"",4,"","","","","",0,reason);
            managementService.pushMessage(userSerial,leaveEntity.getCheckProgress(),xh,"4","0",leaveEntity.getKssj(),leaveEntity.getJssj(),"","请假");
        }
        return responEntity;
    }

    /**
     * 审批请假记录
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult approvalLeave(ApprovalParamEntity approvalParamEntity) {
        String xh = approvalParamEntity.getXh();
        String result = approvalParamEntity.getResult();
        String userSerial = approvalParamEntity.getUserSerial();
        String checkId = approvalParamEntity.getCheckId();
        String userName = managementService.findUserName(userSerial);
        int shjb = leaveMapper.selectLeaveShjb(xh) + 1;
        String shsj = DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        JsonResult responEntity = workFlowService.completeTask(approvalParamEntity);
        // 查询时间
        LeaveEntity leaveEntity = leaveMapper.selectTime(xh);
        if(WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())){  // 审批完成 请假生效
            int flag = Integer.parseInt(result) == 1?2:3;
            //修改审批人字段
            leaveMapper.updateLrKqingjMore(userName,xh);
            // 修改数据库字段responEntity
            leaveMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,"","",userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            if(flag == 2){
                managementService.pushMessage("","",xh,"2","0",leaveEntity.getKssj(),leaveEntity.getJssj(),"","请假");
                // 更新 lr_waich表 lt_kqingj表
                leaveMapper.insertLrKqingj(checkId, SHConstants.SHENHE);
                leaveMapper.insertLrWaich(checkId, SHConstants.SHENHE);
            } else {
                leaveMapper.updateUserDays(leaveEntity.getUserSerial(),xh);
                managementService.pushMessage("","",xh,"3","0",leaveEntity.getKssj(),leaveEntity.getJssj(),"","请假");
            }
        }
        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 审批成功
            int flag = 1;
            String checkProgress = responEntity.getData().toString();
            String checkPp = "$" + checkProgress.replace(",","$,$") + "$";;
            leaveMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,checkProgress,checkPp,userSerial,shsj,result,shjb,approvalParamEntity.getReason());

            managementService.pushMessage("",checkProgress,xh,"1","0",leaveEntity.getKssj(),leaveEntity.getJssj(),"","请假");
            // 修改数据库字段
        }
        return responEntity;
    }

    /**
     * 查询假类编号以及名称.
     * @return
     */
    public List<LeaveEntity> selectLeave(){
        return leaveMapper.selectLeave();
    }
}
