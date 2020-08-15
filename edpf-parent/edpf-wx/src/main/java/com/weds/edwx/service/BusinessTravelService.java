package com.weds.edwx.service;

import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.BusinessTravelMapper;
import com.weds.edwx.util.SHConstants;
import com.weds.workflow.constants.WorkFlowConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BusinessTravelService {

    @Autowired
    private BusinessTravelMapper businessTravelMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ApprovalPersonService approvalPersonService;

    @Autowired
    private SystemService systemService;

    /**
     * 不匹配预设定流程, 东药定制
     * @param businessParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public Map<String,Object> insertBusinessTravel(BusinessParamEntity businessParamEntity) throws Exception {
        Map<String,Object> repMap = new LinkedHashMap<String, Object>();
        String userSerial = businessParamEntity.getUserSerial(); //人员序号
        Date kssj = businessParamEntity.getKssj(); //开始时间
        Date jssj = businessParamEntity.getJssj(); //结束时间
        String bh = businessParamEntity.getBh(); //假类编号
        String approver = businessParamEntity.getApprover(); //自定义审批人
        String processId = "SYS01"; //自定义审批ID
        String xh = businessParamEntity.getXh(); //申请编号
        String outMoney = businessParamEntity.getOutMoney(); // 预支金额
        if (outMoney != null && !outMoney.equals("")){
            if (outMoney.indexOf(".") == -1 ){
                if (outMoney.length() > 7 ){
                    repMap.put("code","5");
                    return repMap;
                }
            } else {
                if (outMoney.split("\\.")[0].length() > 7){
                    repMap.put("code","5");
                    return repMap;
                }
                if (outMoney.split("\\.")[1].length() > 2){
                    repMap.put("code","5");
                    return repMap;
                }
            }
        }

        float accommodationDays = businessParamEntity.getAccommodationDays();
        if (accommodationDays > 9999999){
            repMap.put("code","6");
            return repMap;
        }
        /**
         * 查询开始时间到结束时间内,传入人员所有的加班、请假记录
         */
        int countJia = businessTravelMapper.selectLrJiaba(userSerial,kssj,jssj);
        int countJiaMore = businessTravelMapper.selectLrJiabaMore(userSerial,kssj,jssj);
        int countLr = businessTravelMapper.selectLrKqingj(userSerial,kssj,jssj);
        int countLrMore = businessTravelMapper.selectLrKqingjMore(userSerial,kssj,jssj);
        /**
         * 判断时段内是否存在加班、请假记录。
         * 时间段内不存在记录，执行录入流程。
         * 时间段内存在记录，返回错误。
         */
        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0) {
            String userDep = businessTravelMapper.selectUserDep(userSerial);
            String userRole = businessTravelMapper.selectUserRole(userSerial);
            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr =String.format("%02d",num);
            if (xh == null || xh.equals("")){
                xh = DateUtils.formatDate(new Date(),"yyyyMMddHHmmss") + randomStr;  // 年月日时分秒 + 两位随机数
            }
            double leaveDays = DateUtils.getDateDiffDay(kssj,jssj) + 1 ;  // 请假天数
            if (approver != null  && !approver.equals("")){
                JsonResult responEntity =
                        workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
                if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
                    Map<String,String> result = (Map)responEntity.getData();
                    String checkProgress = result.get("approveId");
                    String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                    businessParamEntity.setXh(xh);
                    businessParamEntity.setCheckProgress(checkProgress);
                    businessParamEntity.setCheckPp(checkPp);
                    businessParamEntity.setImgPath(systemService.wxImageDownLoad(businessParamEntity.getImgPath()));
                    businessParamEntity.setProcessId(processId);
                    businessTravelMapper.insertBusinessTravel(businessParamEntity);
                    // 自定义审批人
                    managementService.approvalUser(approver,userSerial,processId);
                    // 保存自定义抄送人
                    if (businessParamEntity.getCopyUser() != null && !businessParamEntity.getCopyUser().equals("")) {
                        managementService.insertCopyUser(xh,businessParamEntity.getCopyUser());
                    }
                    // 推送消息
                    managementService.pushMessage(userSerial,checkProgress,xh,"0","1",kssj,DateUtils.addSeconds(jssj,86399),"","出差");
                    repMap.put("code","1");
                    repMap.put("xh",xh);
                } else {
                    repMap.put("code","3");
                    repMap.put("msg",responEntity.getMsg());
                }
            } else {
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
     * 录入出差申请
     */

//    @Transactional(propagation= Propagation.REQUIRED)
//    public Map<String,Object> insertBusinessTravel(BusinessParamEntity businessParamEntity) throws Exception {
//        Map<String,Object> repMap = new LinkedHashMap<String, Object>();
//        String userSerial = businessParamEntity.getUserSerial(); //人员序号
//        Date kssj = businessParamEntity.getKssj(); //开始时间
//        Date jssj = businessParamEntity.getJssj(); //结束时间
//        String bh = businessParamEntity.getBh(); //假类编号
//        String approver = businessParamEntity.getApprover(); //自定义审批人
//        String processId = businessParamEntity.getProcessId(); //自定义审批ID
//        String xh = businessParamEntity.getXh(); //申请编号
//        String outMoney = businessParamEntity.getOutMoney(); // 预支金额
//        if (outMoney != null && !outMoney.equals("")){
//            if (outMoney.indexOf(".") == -1 ){
//                if (outMoney.length() > 7 ){
//                    repMap.put("code","5");
//                    return repMap;
//                }
//            } else {
//                if (outMoney.split("\\.")[0].length() > 7){
//                    repMap.put("code","5");
//                    return repMap;
//                }
//                if (outMoney.split("\\.")[1].length() > 2){
//                    repMap.put("code","5");
//                    return repMap;
//                }
//            }
//
//        }
//
//        float accommodationDays = businessParamEntity.getAccommodationDays();
//        if (accommodationDays > 9999999){
//            repMap.put("code","6");
//            return repMap;
//        }
//
//        /**
//         * 查询开始时间到结束时间内,传入人员所有的加班、请假记录
//         */
//        int countJia = businessTravelMapper.selectLrJiaba(userSerial,kssj,jssj);
//        int countJiaMore = businessTravelMapper.selectLrJiabaMore(userSerial,kssj,jssj);
//        int countLr = businessTravelMapper.selectLrKqingj(userSerial,kssj,jssj);
//        int countLrMore = businessTravelMapper.selectLrKqingjMore(userSerial,kssj,jssj);
//        /**
//         * 判断时段内是否存在加班、请假记录。
//         * 时间段内不存在记录，执行录入流程。
//         * 时间段内存在记录，返回错误。
//         */
//        if (countJia == 0 && countJiaMore == 0 && countLr == 0 && countLrMore == 0) {
//            String userDep = businessTravelMapper.selectUserDep(userSerial);
//            String userRole = businessTravelMapper.selectUserRole(userSerial);
//            Random random = new Random();
//            int num = random.nextInt(99);
//            String randomStr =String.format("%02d",num);
//            if (xh == null || xh.equals("")){
//                xh = DateUtils.formatDate(new Date(),"yyyyMMddHHmmss") + randomStr;  // 年月日时分秒 + 两位随机数
//            }
//            double leaveDays = DateUtils.getDateDiff(kssj,jssj) + 1 ;  // 请假天数
//            /**
//             * 请求多级审批接口,判断流程是否成立.
//             * 返回值Code = 1,流程录入成功, 录入出差申请
//             * 返回值Code = 2,没有预设定流程,需要选择自定义审批人
//             * 返回其他, 错误.
//             */
//            JsonResult responEntity =
//                    workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,processId);
//            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 有预定的审批流程 或者 设置自定义审批流程成功
//                Map<String,String> result = (Map)responEntity.getData();
//                String checkProgress = result.get("approveId");
//                String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                businessParamEntity.setXh(xh);
//                businessParamEntity.setCheckProgress(checkProgress);
//                businessParamEntity.setCheckPp(checkPp);
//                businessParamEntity.setImgPath(systemService.wxImageDownLoad(businessParamEntity.getImgPath()));
//                businessTravelMapper.insertBusinessTravel(businessParamEntity);
//
//                // 保存自定义抄送人
//                if (businessParamEntity.getCopyUser() != null && !businessParamEntity.getCopyUser().equals("")) {
//                    managementService.insertCopyUser(xh,businessParamEntity.getCopyUser());
//                }
//                // 推送消息
//                managementService.pushMessage(userSerial,checkProgress,xh,"0","1",kssj,DateUtils.addSeconds(jssj,86399),"","出差");
//
//                /**
//                 * 出差录入成功后,返回请假详细
//                 */
//                repMap.put("code","1");
//                repMap.put("xh",xh);
//            } else if (WorkFlowConstants.NO_PROCESS_FLAG.equals(responEntity.getCode())) {  //  自定义审批流程
//                Map<String,String> result = (Map)responEntity.getData();
//                processId = result.get("processId");
//                if (approver != null && processId != null && !approver.equals("") && !processId.equals("")){  // 审批人不为空 ID不为空
//                    responEntity =
//                            workFlowService.startProcess(xh,userSerial,userDep,userRole,Double.toString(leaveDays),bh,approver,result.get("processId"));
//                    if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
//                        result = (Map)responEntity.getData();
//                        String checkProgress = result.get("approveId");
//                        String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                        businessParamEntity.setXh(xh);
//                        businessParamEntity.setCheckProgress(checkProgress);
//                        businessParamEntity.setCheckPp(checkPp);
//                        businessParamEntity.setImgPath(systemService.wxImageDownLoad(businessParamEntity.getImgPath()));
//                        businessParamEntity.setProcessId(processId);
//                        businessTravelMapper.insertBusinessTravel(businessParamEntity);
//
//                        // 自定义审批人
//                        managementService.approvalUser(approver,userSerial,processId);
//
//                        // 保存自定义抄送人
//                        if (businessParamEntity.getCopyUser() != null && !businessParamEntity.getCopyUser().equals("")) {
//                            managementService.insertCopyUser(xh,businessParamEntity.getCopyUser());
//                        }
//                        // 推送消息
//                        managementService.pushMessage(userSerial,checkProgress,xh,"0","1",kssj,DateUtils.addSeconds(jssj,86399),"","出差");
//
//                        repMap.put("code","1");
//                        repMap.put("xh",xh);
//                    } else {
//                        repMap.put("code","3");
//                        repMap.put("msg",responEntity.getMsg());
//                    }
//                } else {
//                    repMap.put("code","2");
//                    repMap.put("processId",result.get("processId"));
//                    repMap.put("xh",xh);
//                }
//
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
     * 查看出差记录
     * @param businessParamEntity
     * @return
     * @throws Exception
     */
    public Map<String,Object> selectUserBusiness(BusinessParamEntity businessParamEntity) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String userSerial = businessParamEntity.getUserSerial();
        String xh = businessParamEntity.getXh();
        // 更新taksId
        workFlowService.updateTaskByBusinessKey(userSerial,xh);
        BusinessTravelEntity businessTravelEntity = businessTravelMapper.selectBusinessByXh(xh);
        if (businessTravelEntity != null){
            //获取同行人员姓名
            if (businessTravelEntity.getTravelPeople() != null && !businessTravelEntity.getTravelPeople().equals("")) {
                List<String> list = managementService.getTravelPeopleName(businessTravelEntity.getTravelPeople());
                String travelPeople = "";
                for (int x = 0; x < list.size(); x++) {
                    travelPeople = travelPeople.equals("")?list.get(x):travelPeople+","+list.get(x);
                }
                businessTravelEntity.setTravelPeople(travelPeople);
            }

            // 查询待审批人的人员名称
            List<String> list = businessTravelMapper.selectApprovalName(businessTravelEntity.getCheckProgress());
            String userName = "";
            // 循环集合,拼接字符串
            for(int i = 0; i < list.size(); i ++){
                userName = userName.equals("")?list.get(0):userName+"、"+list.get(0);
            }
            businessTravelEntity.setCheckProgress(userName);
            String imgPath = businessTravelEntity.getImgPath();
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
                businessTravelEntity.setImgPath(null);
                businessTravelEntity.setImg(img);
            } else {
                businessTravelEntity.setImg(new String[0]);
            }
            // 出差记录详情
            map.put("midData",businessTravelEntity);
            // 申请人以及审批人详情
            map.put("botData",approvalPersonService.selectLeaveBotData(xh));
        }
        return map;
    }

    /**
     * 撤销出差记录
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult deleteBusiness(String userSerial, String xh,String reason) throws Exception{
        JsonResult responEntity = workFlowService.deleteProcessInstanceByBussinessKey(xh, reason);
        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){ // 1 成功 0 失败
            BusinessTravelEntity businessTravelEntity = businessTravelMapper.selectBusinessByXh(xh);
            businessTravelMapper.insertQingjRevoke(xh);
            businessTravelMapper.deleteLrWaichMore(xh);
            businessTravelMapper.deletrLrKqingjMore(xh);
            businessTravelMapper.updateKtQingjMore(xh,"",4,"","","","","",0,"");
            managementService.pushMessage(userSerial,businessTravelEntity.getCheckProgress(),xh,"4","1",businessTravelEntity.getKssj(),businessTravelEntity.getJssj(),"","出差");
        }

        return responEntity;
    }

    /**
     * 审核出差记录
     * @param approvalParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult approvalBusiness(ApprovalParamEntity approvalParamEntity) throws Exception{
        String xh = approvalParamEntity.getXh();
        String result = approvalParamEntity.getResult();
        String userSerial = approvalParamEntity.getUserSerial();
        String checkId = approvalParamEntity.getCheckId();
        String userName = managementService.findUserName(userSerial);
        int shjb = businessTravelMapper.selectBusinessShjb(xh) + 1;
        String shsj = DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        JsonResult responEntity = workFlowService.completeTask(approvalParamEntity);
        if(WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())){  // 审批完成 请假生效
            BusinessTravelEntity businessTravelEntity = businessTravelMapper.selectBusinessByXh(xh);
            businessTravelMapper.updateLrKqingjMore(userName,xh);
            int flag = Integer.parseInt(result) == 1?2:3;
            // 修改数据库字段responEntity
            businessTravelMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,"","",userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            if(flag == 2){
                // 更新 lr_waich表 lt_kqingj表
                businessTravelMapper.insertLrKqingj(checkId, SHConstants.SHENHE);
                businessTravelMapper.insertLrWaich(checkId, SHConstants.SHENHE);
                managementService.pushMessage("","",xh,"2","1",businessTravelEntity.getKssj(),businessTravelEntity.getJssj(),"","出差");
            } else {
                //审批拒绝,推送消息给申请人
                managementService.pushMessage("","",xh,"3","1",businessTravelEntity.getKssj(),businessTravelEntity.getJssj(),"","出差");
            }
        }
        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 审批成功
            int flag = 1;
            BusinessTravelEntity businessTravelEntity = businessTravelMapper.selectBusinessByXh(xh);
            String checkProgress = responEntity.getData().toString();
            String checkPp = "$" + checkProgress.replace(",","$,$") + "$";;
            // 修改数据库字段
            businessTravelMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,checkProgress,checkPp,userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            managementService.pushMessage("",checkProgress,xh,"1","1",businessTravelEntity.getKssj(),businessTravelEntity.getJssj(),"","出差");
        }

        return responEntity;
    }

}
