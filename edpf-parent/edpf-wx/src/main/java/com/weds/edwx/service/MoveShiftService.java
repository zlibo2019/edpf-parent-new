package com.weds.edwx.service;

import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edwx.entity.*;
import com.weds.edwx.mapper.MoveShiftMapper;
import com.weds.edwx.util.SHConstants;
import com.weds.workflow.constants.WorkFlowConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MoveShiftService {

    @Autowired
    private MoveShiftMapper moveShiftMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ApprovalPersonService approvalPersonService;

    @Autowired
    private SystemService systemService;

    /**
     * 查找调班记录
     * @param moveShiftParamEntity
     * @return
     * @throws Exception
     */
    public Map<String,Object> selectMoveShiftByXh(MoveShiftParamEntity moveShiftParamEntity) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String userSerial = moveShiftParamEntity.getUserSerial();
        String xh = moveShiftParamEntity.getXh();
        // 更新taksId
        workFlowService.updateTaskByBusinessKey(userSerial,xh);
        MoveShiftEntity moveShiftEntity = moveShiftMapper.selectMoveShiftByXh(xh);
        if (moveShiftEntity != null) {
            List<String> list = moveShiftMapper.selectApprovalName(moveShiftEntity.getCheckProgress());
            String userName = "";
            for(int i = 0; i < list.size(); i ++){
                userName = userName.equals("")?list.get(0):userName+"、"+list.get(0);
            }
            moveShiftEntity.setCheckProgress(userName);
            String imgPath = moveShiftEntity.getImgPath();
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
                moveShiftEntity.setImgPath(null);
                moveShiftEntity.setImg(img);
            } else {
                moveShiftEntity.setImg(new String[0]);
            }
            map.put("midData",moveShiftEntity);
            map.put("botData",approvalPersonService.selectShiftBotData(xh));
        }
        return map;
    }


    /**
     * 不匹配预设流程. 东药定制
     * @param moveShiftParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public Map<String,Object> insertMoveShift(MoveShiftParamEntity moveShiftParamEntity) throws Exception {
        Map<String, Object> repMap = new LinkedHashMap<String, Object>();

        String userSerial = moveShiftParamEntity.getUserSerial();
        Date tbrq = moveShiftParamEntity.getTbrq();
        String bh = moveShiftParamEntity.getBh();
        String approver = moveShiftParamEntity.getApprover();
        String processId = "SYS01";
        String xh = moveShiftParamEntity.getXh();
        String copyUser = moveShiftParamEntity.getCopyUser();
        int countShift =  moveShiftMapper.findMoveShift(userSerial,tbrq);
        if ( countShift == 0 ) {
            String userDep = moveShiftMapper.selectUserDep(userSerial);
            String userRole = moveShiftMapper.selectUserRole(userSerial);
            Random random = new Random();
            int num = random.nextInt(99);
            String randomStr =String.format("%02d",num);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            if (xh == null || xh.equals("")) {
                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
            }
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (approver != null && !approver.equals("") ){  // 审批人不为空 ID为空
                JsonResult responEntity =
                        workFlowService.startProcess(xh,userSerial,userDep,userRole,"1",bh,approver,processId);
                if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
                    Map<String,String> result = (Map)responEntity.getData();
                    String checkProgress = result.get("approveId");
                    String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
                    moveShiftParamEntity.setXh(xh);
                    moveShiftParamEntity.setCheckProgress(checkProgress);
                    moveShiftParamEntity.setCheckPp(checkPp);
                    moveShiftParamEntity.setImgPath(systemService.wxImageDownLoad(moveShiftParamEntity.getImgPath()));
                    moveShiftMapper.insertMoveShift(moveShiftParamEntity);
                    if (copyUser != null && !copyUser.equals("")) {
                        managementService.insertCopyUser(xh,copyUser);
                    }
                    // 自定义审批人
                    managementService.approvalUser(approver,userSerial,processId);
                    managementService.pushMessage(userSerial,checkProgress,xh,"0","4",null,null,sdf.format(tbrq),"调班");
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
         * 新增调班记录
         */
//    @Transactional(propagation= Propagation.REQUIRED)
//    public Map<String,Object> insertMoveShift(MoveShiftParamEntity moveShiftParamEntity) throws Exception{
//        Map<String,Object> repMap = new LinkedHashMap<String, Object>();
//
//        String userSerial = moveShiftParamEntity.getUserSerial();
//        Date tbrq = moveShiftParamEntity.getTbrq();
//        String bh = moveShiftParamEntity.getBh();
//        String approver = moveShiftParamEntity.getApprover();
//        String processId = moveShiftParamEntity.getProcessId();
//        String xh = moveShiftParamEntity.getXh();
//        String copyUser = moveShiftParamEntity.getCopyUser();
//
//        int countShift =  moveShiftMapper.findMoveShift(userSerial,tbrq);
//        if ( countShift == 0 ) {
//            String userDep = moveShiftMapper.selectUserDep(userSerial);
//            String userRole = moveShiftMapper.selectUserRole(userSerial);
//            Random random = new Random();
//            int num = random.nextInt(99);
//            String randomStr =String.format("%02d",num);
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            if (xh == null || xh.equals("")) {
//                xh = sdf.format(date) + randomStr;  // 年月日时分秒 + 两位随机数
//            }
//            sdf = new SimpleDateFormat("yyyy-MM-dd");
//            JsonResult responEntity =
//                    workFlowService.startProcess(xh,userSerial,userDep,userRole,"1",bh,approver,processId);
//            if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {  // 成功
//
//                Map<String,String> result = (Map)responEntity.getData();
//                String checkProgress = result.get("approveId");
//                String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                moveShiftParamEntity.setXh(xh);
//                moveShiftParamEntity.setCheckProgress(checkProgress);
//                moveShiftParamEntity.setCheckPp(checkPp);
//                moveShiftParamEntity.setImgPath(systemService.wxImageDownLoad(moveShiftParamEntity.getImgPath()));
//                moveShiftMapper.insertMoveShift(moveShiftParamEntity);
//                if (copyUser != null && !copyUser.equals("")) {
//                    managementService.insertCopyUser(xh,copyUser);
//                }
//                // 自定义审批人
//                managementService.approvalUser(approver,userSerial,processId);
//                managementService.pushMessage(userSerial,checkProgress,xh,"0","4",null,null,sdf.format(tbrq),"调班");
//                repMap.put("code","1");
//                repMap.put("xh",xh);
//
//            } else if (WorkFlowConstants.NO_PROCESS_FLAG.equals(responEntity.getCode())) {
//                Map<String,String> result = (Map)responEntity.getData();
//                processId = result.get("processId");
//                if (approver != null && processId != null && !approver.equals("") && !processId.equals("")){  // 审批人不为空 ID为空
//                    responEntity =
//                            workFlowService.startProcess(xh,userSerial,userDep,userRole,"1",bh,approver,result.get("processId"));
//                    if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())) {
//                        result = (Map)responEntity.getData();
//                        String checkProgress = result.get("approveId");
//                        String checkPp = "$" + checkProgress.replace(",","$,$") + "$";
//                        moveShiftParamEntity.setXh(xh);
//                        moveShiftParamEntity.setCheckProgress(checkProgress);
//                        moveShiftParamEntity.setCheckPp(checkPp);
//                        moveShiftParamEntity.setImgPath(systemService.wxImageDownLoad(moveShiftParamEntity.getImgPath()));
//                        moveShiftMapper.insertMoveShift(moveShiftParamEntity);
//                        if (copyUser != null && !copyUser.equals("")) {
//                            managementService.insertCopyUser(xh,copyUser);
//                        }
//                        // 自定义审批人
//                        managementService.approvalUser(approver,userSerial,processId);
//                        managementService.pushMessage(userSerial,checkProgress,xh,"0","4",null,null,sdf.format(tbrq),"调班");
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
     * 撤销调班记录
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult deleteMoverShift(String userSerial,String xh,String reason) throws Exception{
        JsonResult responEntity = workFlowService.deleteProcessInstanceByBussinessKey(xh, reason);
        if (CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){
            MoveShiftEntity moveShiftEntity = moveShiftMapper.selectMoveShiftByXh(xh);
            moveShiftMapper.insertPaiBanRevoke(xh);
            moveShiftMapper.deleteTiaoMore(xh);
            moveShiftMapper.updateKtQingjMore(xh,"",4,"","","","","",0,reason);
            managementService.pushMessage(userSerial,moveShiftEntity.getCheckProgress(),xh,"4","4",null,null,DateUtils.formatDate(moveShiftEntity.getTbrq(),"yyyy-MM-dd"),"调班");
        }
        return responEntity;
    }

    /**
     * 审核调班记录
     * @param approvalParamEntity
     * @return
     * @throws Exception
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public JsonResult approvalMoveShift(ApprovalParamEntity approvalParamEntity) throws Exception{
        String xh = approvalParamEntity.getXh();
        String result = approvalParamEntity.getResult();
        String userSerial = approvalParamEntity.getUserSerial();
        String checkId = approvalParamEntity.getCheckId();
        String userName = managementService.findUserName(userSerial);
        int shjb = moveShiftMapper.selectMoveShiftShjb(xh) + 1;
        String shsj = DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        JsonResult responEntity = workFlowService.completeTask(approvalParamEntity);
        MoveShiftEntity moveShiftEntity = moveShiftMapper.selectMoveShiftByXh(xh);
        if(WorkFlowConstants.PROCESS_FINISHED.equals(responEntity.getCode())){  // 审批完成 请假生效
            int flag = Integer.parseInt(result) == 1?2:3;
            moveShiftMapper.updateKtTiaoMore(userName,xh);
            moveShiftMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,"","",userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            if(flag == 2) {
                moveShiftMapper.insertKtTiao(checkId, SHConstants.SHENHE);
                moveShiftMapper.insertKtTiaoB(checkId, SHConstants.SHENHE);
                moveShiftMapper.updatePaiba(xh);
                managementService.pushMessage("","",xh,"2","4",null,null,DateUtils.formatDate(moveShiftEntity.getTbrq(),"yyyy-MM-dd"),"调班");
            } else {
                managementService.pushMessage("","",xh,"3","4",null,null,DateUtils.formatDate(moveShiftEntity.getTbrq(),"yyyy-MM-dd"),"调班");
            }
        }
        if(CoreConstants.SUCCESSED_FLAG.equals(responEntity.getCode())){  // 审批成功
            int flag = 1;
            String checkProgress = responEntity.getData().toString();
            String checkPp = "$" + checkProgress.replace(",","$,$") + "$";;
            moveShiftMapper.updateKtQingjMore(xh,Integer.toString(shjb),flag,checkProgress,checkPp,userSerial,shsj,result,shjb,approvalParamEntity.getReason());
            managementService.pushMessage("",checkProgress,xh,"1","4",null,null,DateUtils.formatDate(moveShiftEntity.getTbrq(),"yyyy-MM-dd"),"调班");

        }

        return responEntity;
    }

    public Map<String,Object> getBanci(MoveShiftParamEntity moveShiftParamEntity){
        Map<String,Object> map = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(moveShiftParamEntity.getTbrq());
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String paiba = "D"+Integer.toString(day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String rq = sdf.format(moveShiftParamEntity.getTbrq());
        String banci = moveShiftMapper.getPaiba(moveShiftParamEntity.getUserSerial(),paiba,rq);
        if (banci != null && !banci.equals("")) {
            // 休息
            if (banci.equals("[X]")){
                MoveShiftEntity moveShiftEntity = new MoveShiftEntity();
                moveShiftEntity.setBh("[X]");
                moveShiftEntity.setMc("休息");
                map.put("banci",moveShiftEntity);
            } else {
                banci = banci.substring(3);
                MoveShiftEntity moveShiftEntity = moveShiftMapper.getBanci(banci);
                map.put("banci",moveShiftEntity);
            }
        }
        List<MoveShiftEntity> list = moveShiftMapper.getBanciAll();
        if (list != null ){
            MoveShiftEntity moveShiftEntity = new MoveShiftEntity();
            moveShiftEntity.setBh("[X]");
            moveShiftEntity.setMc("休息");
            list.add(moveShiftEntity);
            map.put("BanciAll",list);
        }
        return map;
    }

}
