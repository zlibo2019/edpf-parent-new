package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.CustomizedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomizedService extends BaseService {

    @Autowired
    private CustomizedMapper customizedMapperl;

    public void sendMessage(int personLx,int num){
        customizedMapperl.sendMessage(personLx,num);
    }
}
