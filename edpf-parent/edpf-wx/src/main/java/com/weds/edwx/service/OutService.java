package com.weds.edwx.service;

import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.OutMapper;
import com.weds.edwx.util.SHConstants;
import com.weds.workflow.constants.WorkFlowConstants;
import io.swagger.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OutService {

    @Autowired
    private OutMapper outMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ApprovalPersonService approvalPersonService;

    @Autowired
    private SystemService systemService;




    /**
     * 查找请假记录
     * @param outParamEntity
     * @return
     * @throws Exception
     */
    public Map<String,Object> selectOutByXh(OutParamEntity outParamEntity) throws Exception{
        Map<String,Object> map = new HashMap<>();
        String userSerial = outParamEntity.getUserSerial();
        String xh = outParamEntity.getXh();
        // 更新taksId
        workFlowService.updateTaskByBusinessKey(userSerial,xh);
        OutEntity outEntity = outMapper.selectOutByXh(xh);
        if (outEntity != null){
            List<String> list = outMapper.selectApprovalName(outEntity.getCheckProgress());
            String userName = "";
            for(int i = 0; i < list.size(); i ++){
                userName = userName.equals("")?list.get(0):userName+","+list.get(0);
            }
            outEntity.setCheckProgress(userName);
            // 图片路径
            String imgPath = outEntity.getImgPath();
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
                outEntity.setImgPath(null);
                outEntity.setImg(img);
            } else {
                outEntity.setImg(new String[0]);
            }
            map.put("midData",outEntity);
            map.put("botData",approvalPersonService.selectLeaveBotData(xh));
        }
        return map;
    }

    /**
     *
     * @param outParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public Map<String,Object> insertOut(OutParamEntity outParamEntity) throws Exception{
        Map<String,Object> repMap = new LinkedHashMap<String, Object>();
        String userSerial = outParamEntity.getUserSerial();
        Date kssj = outParamEntity.getKssj();
        Date jssj = outParamEntity.getJssj();
        String bh = outParamEntity.getBh();
        String approver = outParamEntity.getApprover();
        String processId = "SYS01";
        String xh = outParamEntity.getXh();
        String copyUser = outParamEntity.getCopyUser();

        int countJia = outMapper.selectLrJiaba(userSerial,kssj,jssj);
        int countJiaMore = outMapper.selectLrJiabaMore(userSerial,kssj,jssj);
        int countLr = outMapper.selectLrKqingj(userSerial,kssj,jssj);
        int countLrMore = outMapper.selectLrKqingjMore(userSerial,kssj,jssj);

        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0) {  // 时段内没有冲突的请假或者加班记录
            String userDep = outMapper.selectUserDep(userSerial);
            String userRole = outMapper.selectUserRole(userSerial);
            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr =String.format("%02d",num);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

            if (xh == null || xh.equals("")){
                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
            }
            Date before = kssj;
            Date after = jssj;
            double leaveDays = DateUtils.getDateDiffDay(before,after) + 1 ;  // 请假天数
            if (approver != null && processId != null && !approver.equals("") && !processId.equals("")){  // 审批人不为空 ID不为空
                JsonResult responEntity =
                        workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
                if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){

                    Map<String,String> result = (Map)responEntity.getData();
                    String checkProgress = result.get("approveId");
                    String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                    outParamEntity.setXh(xh);
                    outParamEntity.setCheckProgress(checkProgress);
                    outParamEntity.setCheckPp(checkPp);
                    outParamEntity.setImgPath(systemService.wxImageDownLoad(outParamEntity.getImgPath()));
                    outMapper.insertOut(outParamEntity);
                    if (copyUser != null && !copyUser.equals("")) {
                        managementService.insertCopyUser(xh,copyUser);
                    }
                    // 自定义审批人
                    managementService.approvalUser(approver,userSerial,processId);
                    managementService.pushMessage("",checkProgress,xh,"0","2",kssj,jssj,"","公出");
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
            managementService.updateApprovalLx(0,userSerial,approver);
        } else {
            repMap.put("code","4");
        }
        return repMap;
    }




    /**
     * 新增外出申请
     */
//    @Transactional(propagation= Propagation.REQUIRED)
//    public Map<String,Object> insertOut(OutParamEntity outParamEntity) throws Exception{
//        Map<String,Object> repMap = new LinkedHashMap<String, Object>();
//
//        String userSerial = outParamEntity.getUserSerial();
//        Date kssj = outParamEntity.getKssj();
//        Date jssj = outParamEntity.getJssj();
//        String bh = outParamEntity.getBh();
//        String approver = outParamEntity.getApprover();
//        String processId = outParamEntity.getProcessId();
//        String xh = outParamEntity.getXh();
//        String copyUser = outParamEntity.getCopyUser();
//
//        int countJia = outMapper.selectLrJiaba(userSerial,kssj,jssj);
//        int countJiaMore = outMapper.selectLrJiabaMore(userSerial,kssj,jssj);
//        int countLr = outMapper.selectLrKqingj(userSerial,kssj,jssj);
//        int countLrMore = outMapper.selectLrKqingjMore(userSerial,kssj,jssj);
//
//        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0){  // 时段内没有冲突的请假或者加班记录
//            String userDep = outMapper.selectUserDep(userSerial);
//            String userRole = outMapper.selectUserRole(userSerial);
//            Random random = new Random();
//            int num = random.nextInt(99);
//            String randomStr =String.format("%02d",num);
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//
//            if (xh == null || xh.equals("")){
//                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
//            }
//            Date before = kssj;
//            Date after = jssj;
//            double leaveDays = DateUtils.getDateDiff(before,after) + 1 ;  // 请假天数
//            JsonResult responEntity =
//                    workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
//            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 有预定的审批流程 或者 设置自定义审批流程成功
//                Map<String,String> result = (Map)responEntity.getData();
//                String checkProgress = result.get("approveId");
//                String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                outParamEntity.setXh(xh);
//                outParamEntity.setCheckProgress(checkProgress);
//                outParamEntity.setCheckPp(checkPp);
//                outParamEntity.setImgPath(systemService.wxImageDownLoad(outParamEntity.getImgPath()));
//                outMapper.insertOut(outParamEntity);
//                if (copyUser != null && !copyUser.equals("")) {
//                    managementService.insertCopyUser(xh,copyUser);
//                }
//                // 自定义审批人
//                managementService.approvalUser(approver,userSerial,processId);
//                managementService.pushMessage("",checkProgress,xh,"0","2",kssj,jssj,"","公出");
//                repMap.put("code","1");
//                repMap.put("xh",xh);
//
//            } else if (WorkFlowConstants.NO_PROCESS_FLAG.equals(responEntity.getCode())) {  //  自定义审批流程
//                Map<String,String> result = (Map)responEntity.getData();
//                processId = result.get("processId");
//                if (approver != null && processId != null && !approver.equals("") && !processId.equals("")){  // 审批人不为空 ID不为空
//                    responEntity =
//                            workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,result.get("processId"));
//                    if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
//
//                        result = (Map)responEntity.getData();
//                        String checkProgress = result.get("approveId");
//                        String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                        outParamEntity.setXh(xh);
//                        outParamEntity.setCheckProgress(checkProgress);
//                        outParamEntity.setCheckPp(checkPp);
//                        outParamEntity.setImgPath(systemService.wxImageDownLoad(outParamEntity.getImgPath()));
//                        outMapper.insertOut(outParamEntity);
//                        if (copyUser != null && !copyUser.equals("")) {
//                            managementService.insertCopyUser(xh,copyUser);
//                        }
//                        // 自定义审批人
//                        managementService.approvalUser(approver,userSerial,processId);
//                        managementService.pushMessage("",checkProgress,xh,"0","2",kssj,jssj,"","公出");
//                        repMap.put("code","1");
//                        repMap.put("xh",xh);
//                    } else {
//                        repMap.put("code","3");
//                        repMap.put("msg",responEntity.getMsg());
//                    }
//
//                } else {
//                    //自定义审批人为空,返回businessKey,以及自定义审批ID,作为二次请求的参数.
//                    repMap.put("code","2");
//                    repMap.put("processId",result.get("processId"));
//                    repMap.put("xh",xh);
//                }
//                managementService.updateApprovalLx(0,userSerial,approver);
//            } else {  // 其他错误
//                repMap.put("code","3");
//                repMap.put("msg",responEntity.getMsg());
//            }
//        }else{
//            repMap.put("code","4");
//        }
//        return repMap;
//    }

    /**
     * 撤销外出记录
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult deleteOut(String userSerial,String xh, String reason) throws Exception {
        JsonResult responEntity = workFlowService.deleteProcessInstanceByBussinessKey(xh, reason);
        if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
            OutEntity outEntity = outMapper.selectOutByXh(xh);
            outMapper.insertQingjRevoke(xh);
            outMapper.deleteLrWaichMore(xh);
            outMapper.deletrLrKqingjMore(xh);
            outMapper.updateKtQingjMore(xh,"",4,"","","","","",0,reason);
            managementService.pushMessage(userSerial,outEntity.getCheckProgress(),xh,"4","2",outEntity.getKssj(),outEntity.getJssj(),"","公出");
        }
        return responEntity;
    }

    /**
     * 审批外出记录
     * @param approvalParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult approvalOut(ApprovalParamEntity approvalParamEntity) throws Exception {
        String xh = approvalParamEntity.getXh();
        String result = approvalParamEntity.getResult();
        String userSerial = approvalParamEntity.getUserSerial();
        String checkId = approvalParamEntity.getCheckId();
        String userName = managementService.findUserName(userSerial);
        int shjb = outMapper.selectOutShjb(xh) + 1;
        String shsj = DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        JsonResult responEntity = workFlowService.completeTask(approvalParamEntity);
        OutEntity outEntity = outMapper.selectOutByXh(xh);
        if(WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())){  // 审批完成 请假生效
            int flag = Integer.parseInt(result) == 1?2:3;
            outMapper.updateLrKqingjMore(userName,xh);
            // 修改数据库字段responEntity
            outMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,"","",userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            if(flag == 2){
                // 更新 lr_waich表 lt_kqingj表
                outMapper.insertLrKqingj(checkId, SHConstants.SHENHE);
                outMapper.insertLrWaich(checkId, SHConstants.SHENHE);
                managementService.pushMessage("","",xh,"2","2",outEntity.getKssj(),outEntity.getJssj(),"","公出");
            } else {
                managementService.pushMessage("","",xh,"3","2",outEntity.getKssj(),outEntity.getJssj(),"","公出");
            }
        }
        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 审批成功
            int flag = 1;
            String checkProgress = responEntity.getData().toString();
            String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
            // 修改数据库字段
            outMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,checkProgress,checkPp,userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            managementService.pushMessage("",checkProgress,xh,"1","2",outEntity.getKssj(),outEntity.getJssj(),"","公出");
        }

        return responEntity;
    }
}
