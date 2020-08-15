package com.weds.edwx.service;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.FileUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.ManagementEntity;
import com.weds.edwx.mapper.ManagementMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManagementService {

    @Autowired
    private ManagementMapper managementMapper;

    @Resource
    private WeiXinParams weiXinParams;

    /**
     * 获取已存在的自定义审批人，根据字符串所存先后顺序排序
     *
     * @param userSerial 人员序号
     * @return
     */
    public List<ManagementEntity> selectApprovalUser(String userSerial) {
        String approvalSerial = managementMapper.selectApprovalSerial(userSerial);
        String[] array = approvalSerial.split(",");
        List<ManagementEntity> repList = new ArrayList<ManagementEntity>();
        for (int i = 0; i < array.length; i++) {
            String serial = array[i];
            ManagementEntity managementEntity = managementMapper.selectApprovalUser(serial);
            repList.add(managementEntity);
        }
        return repList;
    }

    /**
     * 查找用户是否已有自义定审批人
     *
     * @param userSerial
     * @return
     */
    public String findUserApproval(String userSerial) {
        return managementMapper.findUserApproval(userSerial);
    }

    /**
     * 查找是否有当前类型的默认抄送人
     *
     * @param lx
     * @return
     */
    public int findCopyUser(String lx, Long userSerial) {
        return managementMapper.findCopyUser(lx, userSerial);
    }


    public int existsCopyUser(int lx, Long userSerial) {
        return managementMapper.existsCopyUser(lx, userSerial);
    }
    /**
     * 查找默认抄送人
     *
     * @param lx
     * @return
     */
    public List<ManagementEntity> selectCopyUser(String lx, Long userSerial) {
        return managementMapper.seletCopyUser(lx, userSerial);
    }

    /**
     * 修改自定义审批人 以及 状态
     *
     * @param lx             1:请假 2:出差 3:外出 4:加班 5:调班
     * @param userSerial
     * @param approvalSerial 自定义审批人
     * @return
     */
    public int updateApprovalLx(int lx, String userSerial, String approvalSerial) {
        return managementMapper.updateApprovalLx(lx, userSerial, approvalSerial);
    }

    /**
     * 新增自定义审批人
     *
     * @param userSerial 人员序号
     * @param approval   自定义审批人字符串
     * @return
     */
    public int insertApproval(String userSerial, String approval) {
        return managementMapper.insertApproval(userSerial, approval);
    }


    /**
     * 获取同行人员
     *
     * @param userSerial
     * @return
     */
    public List<ManagementEntity> getTravelPeople(String userSerial) {
        return managementMapper.getTravelPeople(userSerial);
    }

    /**
     * 获取同行人员姓名
     *
     * @param userSerials
     * @return
     */
    public List<String> getTravelPeopleName(String userSerials) {
        return managementMapper.getTravelPeopleName(userSerials);
    }


    /**
     * @param userSerial    人员序号
     * @param checkProgress 审批状态为待审批时为审批人员序号,其余为空
     * @param xh            申请编号
     * @param spFlg         审批状态 0,1:待审批； 2:审批通过； 3:审批拒绝； 4:撤销；
     * @param spType        审批类型 0 请假；1 出差；2 外出；3 加班；4 调班；5 漏打卡, 99 移动考勤
     */
    public void pushMessage(String userSerial, String checkProgress, String xh, String spFlg, String spType, Date kssj, Date jssj, String approvalDate, String approvalName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        //请假 出差 外出
        if (spType.equals("0") || spType.equals("1") || spType.equals("2")) {
            //待审批,推送消息到审批人
            if (spFlg.equals("0") || spFlg.equals("1")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    String[] array = checkProgress.split(",");
                    if (userSerial == null || userSerial.equals("")) {
                        userSerial = managementMapper.selectQingJia(xh);
                    }
                    //获取人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "2");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100200", mesContent, xh);
                    }
                }
            }
            //审批通过 抄送模板
            if (spFlg.equals("2")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectQingJia(xh);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);

                String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100200", mesContent, xh);
                //向预设抄送人推送消息
                List<ManagementEntity> list = managementMapper.seletCopyUser(spType, Long.parseLong(userSerial));
                mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "3");
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100202", mesContent, xh);
                    }
                }
                //自定义抄送人
                list = managementMapper.selectCustomCopyUser(xh);
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100202", mesContent, xh);
                    }
                }
            }
            //审批拒绝,推送消息到申请人
            if (spFlg.equals("3")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectQingJia(xh);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);
                String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100200", mesContent, xh);
            }
            //申请撤销,推送消息到审批人
            if (spFlg.equals("4")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    //申请人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "2");
                    String[] array = checkProgress.split(",");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100200", mesContent, xh);
                    }
                }
            }
        }
        // 加班
        if (spType.equals("3")) {
            //待审批,推送消息到审批人
            if (spFlg.equals("0") || spFlg.equals("1")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    String[] array = checkProgress.split(",");
                    if (userSerial == null || userSerial.equals("")) {
                        userSerial = managementMapper.selectJiaBan(xh);
                    }
                    //获取人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "2");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100200", mesContent, xh);
                    }
                }
            }
            //审批通过 抄送模板
            if (spFlg.equals("2")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectJiaBan(xh);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);
                String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100200", mesContent, xh);
                //向预设抄送人推送消息
                List<ManagementEntity> list = managementMapper.seletCopyUser(spType, Long.parseLong(userSerial));
                mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "3");
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100202", mesContent, xh);
                    }
                }
                list = managementMapper.selectCustomCopyUser(xh);
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100202", mesContent, xh);
                    }
                }

            }
            //审批拒绝,推送消息到申请人
            if (spFlg.equals("3")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectJiaBan(xh);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);
                String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "3");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100200", mesContent, xh);
            }
            //申请撤销,推送消息到审批人
            if (spFlg.equals("4")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    //申请人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, kssj, jssj, "", approvalName, spType, spFlg, "3");
                    String[] array = checkProgress.split(",");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100200", mesContent, xh);
                    }
                }
            }
        }
        // 调班
        if (spType.equals("4")) {
            //待审批,推送消息到审批人
            if (spFlg.equals("0") || spFlg.equals("1")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    String[] array = checkProgress.split(",");
                    if (userSerial == null || userSerial.equals("")) {
                        userSerial = managementMapper.selectKtTiao(xh);
                    }
                    //获取人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, null, null, approvalDate, approvalName, spType, spFlg, "2");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100201", mesContent, xh);
                    }
                }
            }
            //审批通过 抄送模板
            if (spFlg.equals("2")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectKtTiao(xh);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);
                String mesContent = addJson(userName, null, null, approvalDate, approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100201", mesContent, xh);
                //向预设抄送人推送消息
                List<ManagementEntity> list = managementMapper.seletCopyUser(spType, Long.parseLong(userSerial));
                mesContent = addJson(userName, null, null, approvalDate, approvalName, spType, spFlg, "3");
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100203", mesContent, xh);
                    }
                }
                list = managementMapper.selectCustomCopyUser(xh);
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100203", mesContent, xh);
                    }
                }
            }
            //审批拒绝,推送消息到申请人
            if (spFlg.equals("3")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectKtTiao(xh);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);

                String mesContent = addJson(userName, null, null, approvalDate, approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100201", mesContent, xh);
            }
            //申请撤销,推送消息到审批人
            if (spFlg.equals("4")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    //申请人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, null, null, approvalDate, approvalName, spType, spFlg, "2");
                    String[] array = checkProgress.split(",");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100201", mesContent, xh);
                    }
                }
            }
        }

        // 补出勤
        if (spType.equals("5")) {
            //待审批,推送消息到审批人
            if (spFlg.equals("0") || spFlg.equals("1")) {
                // 待审批人员不为空或NUll 推送消息
                if (checkProgress != null && !checkProgress.equals("")) {
                    String[] array = checkProgress.split(",");
                    if (userSerial == null || userSerial.equals("")) {
                        userSerial = managementMapper.selectLrJl(xh);
                    }
                    if (kssj != null && !kssj.equals("")) {
                        approvalDate = DateUtils.formatDate(kssj, DateUtils.DATE_FORMAT);
                    } else {
                        approvalDate = DateUtils.formatDate(jssj, DateUtils.DATE_FORMAT);
                    }
                    //获取人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, kssj, jssj, approvalDate, approvalName, spType, spFlg, "2");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100201", mesContent, xh);
                    }
                }
            }

            //审批通过 抄送模板
            if (spFlg.equals("2")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectLrJl(xh);
                }
                if (kssj != null && !kssj.equals("")) {
                    approvalDate = DateUtils.formatDate(kssj, DateUtils.DATE_FORMAT);
                } else {
                    approvalDate = DateUtils.formatDate(jssj, DateUtils.DATE_FORMAT);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);
                String mesContent = addJson(userName, kssj, jssj, approvalDate, approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100201", mesContent, xh);
                //向预设抄送人推送消息
                List<ManagementEntity> list = managementMapper.seletCopyUser(spType, Long.parseLong(userSerial));
                mesContent = addJson(userName, kssj, jssj, approvalDate, approvalName, spType, spFlg, "3");
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100203", mesContent, xh);
                    }
                }
                list = managementMapper.selectCustomCopyUser(xh);
                if (list != null || list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        managementMapper.insertMsgSend(list.get(i).getUserSerial(), "0", date, date, "100203", mesContent, xh);
                    }
                }

            }
            //审批拒绝,推送消息到申请人
            if (spFlg.equals("3")) {
                //获取申请人员序号
                if (userSerial == null || userSerial.equals("")) {
                    userSerial = managementMapper.selectLrJl(xh);
                }
                if (kssj != null && !kssj.equals("")) {
                    approvalDate = DateUtils.formatDate(kssj, DateUtils.DATE_FORMAT);
                } else {
                    approvalDate = DateUtils.formatDate(jssj, DateUtils.DATE_FORMAT);
                }
                //申请人员姓名
                String userName = managementMapper.findUserName(userSerial);
                String mesContent = addJson(userName, kssj, jssj, approvalDate, approvalName, spType, spFlg, "1");
                //插入数据库
                managementMapper.insertMsgSend(userSerial, "0", date, date, "100201", mesContent, xh);

            }

            //申请撤销,推送消息到审批人
            if (spFlg.equals("4")) {
                if (checkProgress != null && !checkProgress.equals("")) {
                    if (kssj != null && !kssj.equals("")) {
                        approvalDate = DateUtils.formatDate(kssj, DateUtils.DATE_FORMAT);
                    } else {
                        approvalDate = DateUtils.formatDate(jssj, DateUtils.DATE_FORMAT);
                    }
                    //申请人员姓名
                    String userName = managementMapper.findUserName(userSerial);
                    String mesContent = addJson(userName, kssj, jssj, approvalDate, approvalName, spType, spFlg, "2");
                    String[] array = checkProgress.split(",");
                    for (int i = 0; i < array.length; i++) {
                        String serial = array[i];
                        //插入数据库
                        managementMapper.insertMsgSend(serial, "0", date, date, "100201", mesContent, xh);
                    }
                }
            }
        }
        if (spType.equals("99")) {
            String userName = managementMapper.findUserName(userSerial);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", userName);
            jsonObject.put("userplace", approvalName);
            jsonObject.put("jlsj", DateUtils.formatDate(kssj, DateUtils.DATE_TIME_FORMAT));
            String mesContent = jsonObject.toJSONString();
            managementMapper.insertMsgSend(userSerial, "0", date, date, "100100", mesContent, "");
        }
    }

    /**
     * 拼接Json字符串,并转为String
     *
     * @param userName
     * @param kssj
     * @param jssj
     * @param approvalDate
     * @param approvalName
     * @param spType
     * @param spFlg
     * @return
     */
    public String addJson(String userName, Date kssj, Date jssj, String approvalDate, String approvalName, String spType, String spFlg, String genre) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", userName);
        if (kssj != null) {
            String ksDate = DateUtils.formatDate(kssj, "yyyy-MM-dd HH:mm");
            jsonObject.put("kssj", ksDate);
        }
        if (jssj != null) {
            String jsDate = DateUtils.formatDate(jssj, "yyyy-MM-dd HH:mm");
            jsonObject.put("jssj", jsDate);
        }

        jsonObject.put("approvaldate", approvalDate);
        jsonObject.put("approvalname", approvalName);
        jsonObject.put("sptype", spType);
        jsonObject.put("spflg", spFlg);
        jsonObject.put("genre", genre);
        return jsonObject.toJSONString();
    }

    /**
     * @param xh
     * @param copyUser
     * @return
     * @throws Exception
     */
    public int insertCopyUser(String xh, String copyUser) {
        managementMapper.deleteCopyUser(xh);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sj = sdf.format(new Date());
        return managementMapper.insertCopyUser(xh, sj, copyUser);
    }


    public int deleteCopyUser(String xh) {
        return managementMapper.deleteCopyUser(xh);
    }

    /**
     * 新增图片接口
     *
     * @param img
     * @return
     * @throws Exception
     */
    public String[] insertPhoto(String[] img) throws Exception {
        int length = img.length;
        String[] imagePath = new String[length];
        for (int i = 0; i < img.length; i++) {
            imagePath[i] = ImageUtils.base64ToFile(img[i], "jpeg", weiXinParams.getImagePath(), "");
        }
        return imagePath;
    }

    /**
     * 删除图片接口
     *
     * @param imgPath
     * @return
     * @throws Exception
     */
    public boolean deletePhoto(String imgPath) {
        File file = new File(imgPath);
        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }

    /**
     * 自定人审批人修改
     *
     * @param approver
     * @param userSerial
     * @param processId
     */
    public void approvalUser(String approver, String userSerial, String processId) {
        if (processId == null || processId.equals("") || approver == null || approver.equals("")) {
            managementMapper.updateApprovalLx(1, userSerial, approver);
        } else {
            String countApp = managementMapper.findUserApproval(userSerial);
            if (countApp == null || countApp.equals("")) {
                managementMapper.insertApproval(userSerial, approver);
            } else {
                managementMapper.updateApprovalLx(0, userSerial, approver);
            }
        }
    }

    /**
     * 获取员工姓名
     *
     * @param userSerial
     * @return
     */
    public String findUserName(String userSerial) {
        return managementMapper.findUserName(userSerial);
    }


}
