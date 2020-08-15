package com.weds.edwx.service;

import com.alibaba.fastjson.JSON;
import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.OverTimeMapper;
import com.weds.edwx.util.SHConstants;
import com.weds.workflow.constants.WorkFlowConstants;
import com.weds.workflow.service.WorkFlowEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OverTimeService {

    @Autowired
    private OverTimeMapper overTimeMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ApprovalPersonService approvalPersonService;

    @Autowired
    private SystemService systemService;


    /**
     * 查询加班记录
     * @param overTimeParamEntity
     * @return
     * @throws Exception
     */
    public Map<String,Object> selectOverTimeByXh(OverTimeParamEntity overTimeParamEntity) throws Exception{
        Map<String,Object> map = new HashMap<>();
        String userSerial = overTimeParamEntity.getUserSerial();
        String xh = overTimeParamEntity.getXh();
        // 更新taksId
        workFlowService.updateTaskByBusinessKey(userSerial,xh);
        OverTimeEntity overTimeEntity = overTimeMapper.selectOverTimeByXh(xh);
        if (overTimeEntity != null) {
            List<String> list = overTimeMapper.selectApprovalName(overTimeEntity.getCheckProgress());
            String userName = "";
            for(int i = 0; i < list.size(); i ++){
                userName = userName.equals("")?list.get(0):userName+","+list.get(0);
            }
            overTimeEntity.setCheckProgress(userName);
            // 图片路径
            String imgPath = overTimeEntity.getImgPath();
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
                overTimeEntity.setImgPath(null);
                overTimeEntity.setImg(img);
            } else {
                overTimeEntity.setImg(new String[0]);
            }
            map.put("midData",overTimeEntity);
            map.put("botData",approvalPersonService.selectOverTimeBotData(xh));
        }
        return map;
    }


    /**
     * 不匹配预设定流程, 东药定制
     * @param overTimeParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public Map<String,Object> insertOverTime(OverTimeParamEntity overTimeParamEntity) throws Exception {
        Map<String, Object> repMap = new LinkedHashMap<String, Object>();
        String userSerial = overTimeParamEntity.getUserSerial(); // 人员序号
        Date kssj = overTimeParamEntity.getKssj(); // 开始时间
        Date jssj = overTimeParamEntity.getJssj(); // 结束时间
        String bh = overTimeParamEntity.getBh(); // 加班编号
        String approver = overTimeParamEntity.getApprover(); // 自定义审批人
        String processId = "SYS01"; // 自定义审批ID
        String xh = overTimeParamEntity.getXh(); // 申请编号
        String copyUser = overTimeParamEntity.getCopyUser(); //抄送人员
        //计算加班的有效时长
        Long jsjg = (jssj.getTime() - kssj.getTime()) / (60 * 1000);
        overTimeParamEntity.setJsjg(Long.toString(jsjg));

        int countJia = overTimeMapper.selectLrJiaba(userSerial, kssj, jssj);
        int countJiaMore = overTimeMapper.selectLrJiabaMore(userSerial, kssj, jssj);
        int countLr = overTimeMapper.selectLrKqingj(userSerial, kssj, jssj);
        int countLrMore = overTimeMapper.selectLrKqingjMore(userSerial, kssj, jssj);
        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0) {
            String userDep = overTimeMapper.selectUserDep(userSerial);
            String userRole = overTimeMapper.selectUserRole(userSerial);
            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr =String.format("%02d",num);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            if (xh == null || xh.equals("")){
                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
            }

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date before = kssj;
            Date after = jssj;
            double leaveDays = DateUtils.getDateDiffDay(before,after) + 1 ;  // 请假天数

            if ( approver != null &&  !approver.equals("") ){  // 审批人不为空 ID不为空
                JsonResult responEntity =
                        workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
                if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
                    Map<String,String> result = (Map)responEntity.getData();
                    String checkProgress = result.get("approveId");
                    String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                    overTimeParamEntity.setXh(xh);
                    overTimeParamEntity.setCheckProgress(checkProgress);
                    overTimeParamEntity.setCheckPp(checkPp);
                    overTimeParamEntity.setImgPath(systemService.wxImageDownLoad(overTimeParamEntity.getImgPath()));
                    overTimeMapper.insertOverTime(overTimeParamEntity);
                    if (copyUser != null && !copyUser.equals("")) {
                        managementService.insertCopyUser(xh,copyUser);
                    }
                    // 自定义审批人
                    managementService.approvalUser(approver,userSerial,processId);
                    managementService.pushMessage("",checkProgress,xh,"0","3",kssj,jssj,"","加班");
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
            repMap.put("code", "4");
        }
        return repMap;
    }





    /**
     * 录入加班申请
     * @param overTimeParamEntity 加班申请入参实体类
     * @return
     * @throws Exception
     */
//    @Transactional(propagation= Propagation.REQUIRED)
//    public Map<String,Object> insertOverTime(OverTimeParamEntity overTimeParamEntity) throws Exception {
//
//        Map<String,Object> repMap = new LinkedHashMap<String, Object>();
//        String userSerial = overTimeParamEntity.getUserSerial(); // 人员序号
//        Date kssj = overTimeParamEntity.getKssj(); // 开始时间
//        Date jssj = overTimeParamEntity.getJssj(); // 结束时间
//        String bh = overTimeParamEntity.getBh(); // 加班编号
//        String approver = overTimeParamEntity.getApprover(); // 自定义审批人
//        String processId = overTimeParamEntity.getProcessId(); // 自定义审批ID
//        String xh = overTimeParamEntity.getXh(); // 申请编号
//        String copyUser = overTimeParamEntity.getCopyUser(); //抄送人员
//        //计算加班的有效时长
//        Long jsjg = (jssj.getTime() - kssj.getTime()) / (60*1000);
//        overTimeParamEntity.setJsjg(Long.toString(jsjg));
//
//        int countJia = overTimeMapper.selectLrJiaba(userSerial,kssj,jssj);
//        int countJiaMore = overTimeMapper.selectLrJiabaMore(userSerial,kssj,jssj);
//        int countLr = overTimeMapper.selectLrKqingj(userSerial,kssj,jssj);
//        int countLrMore = overTimeMapper.selectLrKqingjMore(userSerial,kssj,jssj);
//        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0) {  // 时段内没有冲突的请假或者加班记录
//            String userDep = overTimeMapper.selectUserDep(userSerial);
//            String userRole = overTimeMapper.selectUserRole(userSerial);
//            Random random = new Random();
//            int num = random.nextInt(99);
//            String randomStr =String.format("%02d",num);
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            if (xh == null || xh.equals("")){
//                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
//            }
//
//            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date before = kssj;
//            Date after = jssj;
//            double leaveDays = DateUtils.getDateDiff(before,after) + 1 ;  // 请假天数
//            JsonResult responEntity =
//                    workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
//            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 有预定的审批流程 或者 设置自定义审批流程成功
//
//                Map<String,String> result = (Map)responEntity.getData();
//                String checkProgress = result.get("approveId");
//                String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                overTimeParamEntity.setXh(xh);
//                overTimeParamEntity.setCheckProgress(checkProgress);
//                overTimeParamEntity.setCheckPp(checkPp);
//                overTimeParamEntity.setImgPath(systemService.wxImageDownLoad(overTimeParamEntity.getImgPath()));
//                overTimeMapper.insertOverTime(overTimeParamEntity);
//                if (copyUser != null && !copyUser.equals("")) {
//                    managementService.insertCopyUser(xh,copyUser);
//                }
//                // 自定义审批人
//                managementService.approvalUser(approver,userSerial,processId);
//                managementService.pushMessage("",checkProgress,xh,"0","3",kssj,jssj,"","加班");
//                repMap.put("code","1");
//                repMap.put("xh",xh);
//            } else if (WorkFlowConstants.NO_PROCESS_FLAG.equals(responEntity.getCode())) {  //  自定义审批流程
//                Map<String,String> result = (Map)responEntity.getData();
//                processId = result.get("processId");
//                if ( approver != null && processId != null && !approver.equals("") && !processId.equals("") ){  // 审批人不为空 ID不为空
//                    responEntity =
//                            workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,result.get("processId"));
//                    if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
//
//                        result = (Map)responEntity.getData();
//                        String checkProgress = result.get("approveId");
//                        String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                        overTimeParamEntity.setXh(xh);
//                        overTimeParamEntity.setCheckProgress(checkProgress);
//                        overTimeParamEntity.setCheckPp(checkPp);
//                        overTimeParamEntity.setImgPath(systemService.wxImageDownLoad(overTimeParamEntity.getImgPath()));
//                        overTimeMapper.insertOverTime(overTimeParamEntity);
//                        if (copyUser != null && !copyUser.equals("")) {
//                            managementService.insertCopyUser(xh,copyUser);
//                        }
//                        // 自定义审批人
//                        managementService.approvalUser(approver,userSerial,processId);
//                        managementService.pushMessage("",checkProgress,xh,"0","3",kssj,jssj,"","加班");
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
//            } else {  // 其他错误
//                repMap.put("code","3");
//                repMap.put("msg",responEntity.getMsg());
//            }
//        } else {
//            repMap.put("code","4");
//        }
//        return repMap;
//    }


    /**
     * 撤销加班申请
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult deleteOverTime(String userSerial,String xh, String reason) throws Exception {
        JsonResult responEntity = workFlowService.deleteProcessInstanceByBussinessKey(xh, reason);
        if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
            OverTimeEntity overTimeEntity = overTimeMapper.selectOverTimeByXh(xh);
            overTimeMapper.insertPaiBanRevoke(xh);
            overTimeMapper.deleteJiabaMore(xh);
            overTimeMapper.updateKtQingjMore(xh,"",4,"","","","","",0,reason);
            managementService.pushMessage(userSerial,overTimeEntity.getCheckProgress(),xh,"4","3",overTimeEntity.getKssj(),overTimeEntity.getJssj(),"","加班");
        }
        return responEntity;
    }

    /**
     * 审批加班记录
     * @param approvalParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult approvalOverTime(ApprovalParamEntity approvalParamEntity) throws Exception {
        String xh = approvalParamEntity.getXh();
        String result = approvalParamEntity.getResult();
        String userSerial = approvalParamEntity.getUserSerial();
        String checkId = approvalParamEntity.getCheckId();
        int shjb = overTimeMapper.selectOverTimeShjb(xh) + 1;
        String userName = managementService.findUserName(userSerial);
        String shsj = DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        JsonResult responEntity = workFlowService.completeTask(approvalParamEntity);
        OverTimeEntity overTimeEntity = overTimeMapper.selectOverTimeByXh(xh);
        if(WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())){  // 审批完成 请假生效
            int flag = Integer.parseInt(result) == 1?2:3;
            overTimeMapper.updateLrJiaBaMore(userName,xh);
            overTimeMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,"","",userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            if(flag == 2){
                overTimeMapper.insertLrJiaBa(checkId, SHConstants.SHENHE);
                managementService.pushMessage("","",xh,"2","3",overTimeEntity.getKssj(),overTimeEntity.getJssj(),"","加班");
            } else {
                managementService.pushMessage("","",xh,"3","3",overTimeEntity.getKssj(),overTimeEntity.getJssj(),"","加班");
            }
        }

        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 审批成功
            int flag = 1;
            String checkProgress = responEntity.getData().toString();
            String checkPp = "$" + checkProgress.replace(",","$,$") + "$";;
            overTimeMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,checkProgress,checkPp,userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            managementService.pushMessage("",checkProgress,xh,"1","3",overTimeEntity.getKssj(),overTimeEntity.getJssj(),"","加班");
        }
        return responEntity;
    }
}
