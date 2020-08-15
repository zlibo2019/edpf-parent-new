package com.weds.edwx.job;

import com.weds.core.utils.StringUtils;
import com.weds.edwx.constant.VisitorParams;
import com.weds.edwx.entity.VisRegisterEntity;
import com.weds.edwx.service.StFaceService;
import com.weds.edwx.service.VisCardUserService;
import com.weds.edwx.service.VisRegisterService;
import com.weds.etl.base.SchedulerJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class VisitorSchedulerJob extends SchedulerJob {

    private Logger log = LogManager.getLogger();

    @Autowired
    private VisCardUserService visCardUserService;

    @Autowired
    private VisRegisterService visRegisterService;

    @Resource
    private VisitorParams visitorParams;

    @Resource
    private StFaceService stFaceService;

    @Override
    @Transactional
    public void execute(JobExecutionContext context) throws JobExecutionException {
        VisRegisterEntity visRegisterEntity = new VisRegisterEntity();
        visRegisterEntity.setVisJssj(new Date());
        List<VisRegisterEntity> list = visRegisterService.selectLossRecord(visRegisterEntity);
        for (VisRegisterEntity entity : list) {
            if (entity.getVisState() == 1) {
                visCardUserService.cancelCardIncrement(entity.getXh(), entity.getVisSerial(), entity.getVisCard(), entity.getVisArea());
                if (visitorParams.getPtAppFlag().equals("1") && entity.getCarState() != null && entity.getCarState().equals("1")
                        && !StringUtils.isBlank(entity.getVisCars())) {
                    visCardUserService.cancelCardPermission(entity.getVisCars());
                }

                try {
                    if ("1".equals(visitorParams.getDeviceType())) {
                        stFaceService.deleteStFace(entity.getVisSerial().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            VisRegisterEntity visRegisterEntity1 = new VisRegisterEntity();
            visRegisterEntity1.setXh(entity.getXh());
            if (entity.getVisitorState() != null && entity.getVisitorState().equals("8")) {
                visRegisterEntity1.setVisitorState("9");
            } else {
                visRegisterEntity1.setVisitorState("10");
            }
            visRegisterEntity1.setVisState(2);
            visRegisterEntity1.setVisJssjReal(new Date());
            visRegisterService.updateByPrimaryKeySelective(visRegisterEntity1);
        }
    }
}
