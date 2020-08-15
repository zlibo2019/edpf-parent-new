package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.core.utils.DateUtils;
import com.weds.edwx.constant.VisitorParams;
import com.weds.edwx.entity.ParkCarDepEntity;
import com.weds.edwx.entity.ParkCarInfoEntity;
import com.weds.edwx.entity.VisCardUserEntity;
import com.weds.edwx.entity.VisRegisterEntity;
import com.weds.edwx.mapper.VisCardUserMapper;
import com.weds.web.comm.entity.CommProcEntity;
import com.weds.web.comm.service.CommProcService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author sxm
 * @Description VisCardUser管理
 * @Date 2019-03-20
 */
@Service
public class VisCardUserService extends BaseService {

    @Autowired
    private VisCardUserMapper visCardUserMapper;

    @Autowired
    private VisRegisterService visRegisterService;

    @Autowired
    private UserService userService;

    @Autowired
    private ParkCarDepService parkCarDepService;

    @Autowired
    private CommProcService commProcService;

    @Autowired
    private ParkCarInfoService parkCarInfoService;

    @Autowired
    private VisitorParams visitorParams;

    private Logger log = LogManager.getLogger();

    /**
     * 给访客发卡，并且下发增量
     *
     * @param visSerial 访客序号
     * @param xh        访问记录序号
     * @param areas     区域编号，以逗号分割
     * @param visKssj   访问开始时间
     * @param visJssj   访问结束时间
     * @return
     */

    public String insertCardIncrement(Long visSerial, Integer xh, String areas, Date visKssj, Date visJssj) {
        return this.insertCardIncrement(visSerial, visSerial.toString(), xh, areas, visKssj, visJssj);
    }

    public String insertCardIncrement(Long visSerial, String cardNo, Integer xh, String areas, Date visKssj, Date visJssj) {
        VisRegisterEntity visRegisterEntity = new VisRegisterEntity();
        visRegisterEntity.setVisSerial(visSerial);
        visRegisterEntity.setVisCard(cardNo);
        visRegisterEntity.setVisKssj(visKssj);
        visRegisterEntity.setVisJssj(visJssj);
        visRegisterEntity.setXh(xh);
        // if (visCardUserMapper.selectCardCount(visRegisterEntity) > 0) { //如果人员已经发过卡，不能再次预约
        //     return "601";
        // }
        VisCardUserEntity visCardUserEntity = new VisCardUserEntity();
        visCardUserEntity.setCardHao(cardNo);

        //查出该卡是否是正式员工的使用卡，避免误发
        if (visCardUserMapper.selectCardNormalCount(visCardUserEntity) > 0) {
            return "602";
        }
        visCardUserEntity.setBh(visRegisterEntity.getXh());
        visCardUserEntity.setAcType("0");
        visCardUserEntity.setVisSerial(visRegisterEntity.getVisSerial());

        visCardUserEntity.setVisFlg(0);
        visCardUserEntity.setKssj(new Date());
        visCardUserEntity.setSj(new Date());
        //插入临时卡表
        visCardUserMapper.insertSelective(visCardUserEntity);
        //更新在访记录表
        VisRegisterEntity newEntity = new VisRegisterEntity();
        newEntity.setVisCard(cardNo);
        newEntity.setVisState(1);
        // newEntity.setVisKssjReal(new Date());
        newEntity.setXh(xh);
        visRegisterService.updateByPrimaryKeySelective(newEntity);
        //下发增量
        // String visArea = areas.replaceAll(",","','");
        visRegisterEntity.setVisArea(areas);
        visCardUserMapper.insertUpdate1Mj(visRegisterEntity);
        visCardUserMapper.insertUpdate4Kq(visRegisterEntity);
        if ("1".equals(visitorParams.getTkAppFlag())) {
            visCardUserMapper.insertUpdate1Tk(visRegisterEntity);
        }
        return "600";
    }

    /**
     * 根据访客卡号生成访问二维码
     *
     * @param visSerial 访客人员序号
     * @param visKssj   访问开始时间
     * @param visJssj   访问结束时间
     * @return
     */
    public String getVisCodeStr(String visSerial, Date visKssj, Date visJssj) {

        //返回二维码密钥
        String startTime = DateUtils.formatDate(DateUtils.addSeconds(visKssj, -180), "yyMMddHHmmss");
        Long keepTime = (visJssj.getTime() - visKssj.getTime()) / 1000 + (5 * 60);//  1 * 60 + 360;
        //拼接密钥字符串
        String codeStr = (new Random().nextInt(90000) + 10000) + ":1" + ":" + startTime + ":" + keepTime + ":"
                + visSerial + "," + visSerial;
        String codeData = userService.genaratorCode(codeStr);
        return codeData;
    }

    /**
     * 给访客车牌下发访客车道权限
     *
     * @param visName     访客姓名
     * @param visCompName 访客公司姓名
     * @param idCard      访客身份证号
     * @param visCars     访客车牌号，以逗号分割
     * @param visKssj     来访开始时间
     * @param visJssj     来访结束时间
     * @return
     */
    public boolean insertCardPermission(String visName, String visCompName, String idCard, String visCars, Date visKssj, Date visJssj) {
        //获取所有车道
        ParkCarDepEntity parkCarDepEntity = new ParkCarDepEntity();
        parkCarDepEntity.setIsVis(1);
        List<ParkCarDepEntity> parkList = parkCarDepService.selectListByEntity(parkCarDepEntity);
        CommProcEntity commProcEntity = new CommProcEntity();
        commProcEntity.setProcName("park_updatecarinfo_tmp");
        if (parkList.size() > 0) {
            String parks = parkList.stream().map(ParkCarDepEntity::getParkName).collect(Collectors.joining(","));
            //StringUtils.join(parkList.toArray(), ",");
            //循环授权
            String cars[] = visCars.split(",");
            for (int i = 0; i < cars.length; i++) {
                List<Object> list = new ArrayList<>();
                list.add("0");
                list.add("");
                list.add(visName);
                list.add(visCompName);
                list.add(idCard);
                list.add(cars[0]);
                list.add(DateUtils.formatDate(visKssj, DateUtils.DATE_TIME_FORMAT));
                list.add(DateUtils.formatDate(visJssj, DateUtils.DATE_TIME_FORMAT));
                list.add(parks);
                list.add("");
                list.add("");
                commProcEntity.setParams(list);
                //执行临时车牌
                commProcService.loadProcData(commProcEntity);
            }
            //下发授权
            CommProcEntity commProcEntity2 = new CommProcEntity();
            commProcEntity2.setProcName("Park_stp_lr");
            List<Object> list2 = new ArrayList<>();
            list2.add("1");
            list2.add("'" + visCars + "'");
            commProcEntity2.setParams(list2);
            commProcService.loadProcData(commProcEntity2);
            return true;
        }
        return false;
    }

    /**
     * 注销访客卡，并下发增量
     *
     * @param
     * @return
     */
    public boolean cancelCardIncrement(Integer visXh, Long visSerial, String visAreas) {
        cancelCardIncrement(visXh, visSerial, visSerial.toString(), visAreas);
        return true;
    }

    public boolean cancelCardIncrement(Integer visXh, Long visSerial, String cardNo, String visAreas) {
        VisCardUserEntity visCardUserEntity = new VisCardUserEntity();
        visCardUserEntity.setBh(visXh);
        visCardUserEntity.setVisSerial(visSerial);
        visCardUserEntity.setVisFlg(1);
        visCardUserEntity.setJssj(new Date());
        visCardUserEntity.setSj(new Date());
        //撤销访客临时卡
        visCardUserMapper.updateCancelCard(visCardUserEntity);
        VisRegisterEntity visRegisterEntity1 = new VisRegisterEntity();
        visRegisterEntity1.setVisSerial(visSerial);
        visRegisterEntity1.setVisCard(cardNo);
        //下发增量
        // String visArea = visAreas.replaceAll(",","','");
        visRegisterEntity1.setVisArea(visAreas);
        visCardUserMapper.cancelUpdate1Mj(visRegisterEntity1); //门控板增量
        visCardUserMapper.cancelUpdate4Kq(visRegisterEntity1); //考勤机增量
        if ("1".equals(visitorParams.getTkAppFlag())) {
            visCardUserMapper.cancelUpdate1Tk(visRegisterEntity1);
        }
        return true;
    }

    public boolean cancelCardIncrementAll(Integer visXh, Long visSerial, String visAreas) {
        VisCardUserEntity visCardUserEntity = new VisCardUserEntity();
        visCardUserEntity = new VisCardUserEntity();
        visCardUserEntity.setBh(visXh);
        visCardUserEntity.setVisSerial(visSerial);
        visCardUserEntity.setVisFlg(0);
        List<VisCardUserEntity> list = visCardUserMapper.selectListByEntity(visCardUserEntity);
        for (VisCardUserEntity entity : list) {
            VisRegisterEntity visRegisterEntity = new VisRegisterEntity();
            visRegisterEntity.setVisCard(entity.getCardHao());
            visRegisterEntity.setVisArea(visAreas);
            visCardUserMapper.cancelUpdate1Mj(visRegisterEntity); //门控板增量
            if ("1".equals(visitorParams.getTkAppFlag())) {
                visCardUserMapper.cancelUpdate1Tk(visRegisterEntity);
            }
        }

        visCardUserEntity.setBh(visXh);
        visCardUserEntity.setVisSerial(visSerial);
        visCardUserEntity.setVisFlg(1);
        visCardUserEntity.setJssj(new Date());
        visCardUserEntity.setSj(new Date());
        //撤销访客临时卡
        visCardUserMapper.updateCancelCard(visCardUserEntity);

        VisRegisterEntity visRegisterEntity = new VisRegisterEntity();
        visRegisterEntity.setVisArea(visAreas);
        visCardUserMapper.cancelUpdate4Kq(visRegisterEntity); //考勤机增量

        //下发增量
        // String visArea = visAreas.replaceAll(",","','");

        return true;
    }

    /**
     * 注销访客车牌授权
     *
     * @param visCar 访客车牌号，以逗号分割
     * @return
     */
    public boolean cancelCardPermission(String visCar) {
        // String visCars = visCar.replaceAll(",","','");
        ParkCarInfoEntity parkCarInfoEntity = new ParkCarInfoEntity();
        parkCarInfoEntity.setCancelSj(new Date());
        parkCarInfoEntity.setCancelGlyNo("微信端");
        parkCarInfoEntity.setCarNo(visCar);
        parkCarInfoService.updateByCar(parkCarInfoEntity); //更新临时授权状态
        parkCarInfoService.deleteCarsRules(parkCarInfoEntity); //删除临时授权
        CommProcEntity commProcEntity = new CommProcEntity();
        commProcEntity.setProcName("Park_stp_zx");
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("'" + visCar + "'");
        commProcEntity.setParams(list);
        commProcService.loadProcData(commProcEntity); //执行下发规则
        return true;
    }

    public boolean haveCards(Long visSerial) {
        return visCardUserMapper.haveCards(visSerial) > 0;
    }

    public boolean haveCardsOrQrcode(String cardHao, Long visSerial) {
        return visCardUserMapper.haveCardsOrQrcode(cardHao, visSerial) > 0;
    }

    public int deleteByPrimaryKey(Integer xh) {
        return visCardUserMapper.deleteByPrimaryKey(xh);
    }

    public int insert(VisCardUserEntity record) {
        return visCardUserMapper.insert(record);
    }

    public int insertSelective(VisCardUserEntity record) {
        return visCardUserMapper.insertSelective(record);
    }

    public VisCardUserEntity selectByPrimaryKey(Integer xh) {
        return visCardUserMapper.selectByPrimaryKey(xh);
    }

    public int updateByPrimaryKeySelective(VisCardUserEntity record) {
        return visCardUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VisCardUserEntity record) {
        return visCardUserMapper.updateByPrimaryKey(record);
    }

    public List<VisCardUserEntity> selectListByEntity(VisCardUserEntity record) {
        return visCardUserMapper.selectListByEntity(record);
    }


    public List<VisCardUserEntity> selectListByKeys(String keys) {
        return visCardUserMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<VisCardUserEntity> list) {
        return visCardUserMapper.deleteBatchByKeys(list);
    }
}
