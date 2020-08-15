package com.weds.edwx.service;

import com.weds.bean.jwt.JwtHandlerService;
import com.weds.core.constants.CoreConstants;
import com.weds.core.resp.JsonResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("jwtHandlerService")
public class JwtHandlerServiceImpl implements JwtHandlerService {
    private Logger log = LogManager.getLogger();

    @Override
    public JsonResult dataHandler(String data) {
        log.info("JWT Data:" + data);
        return JsonResult.get(CoreConstants.SUCCESSED_FLAG, null);
    }
}
