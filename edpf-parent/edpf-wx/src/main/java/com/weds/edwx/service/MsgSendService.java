package com.weds.edwx.service;

import com.alibaba.fastjson.JSONObject;
import com.weds.core.base.BaseService;
import com.weds.core.utils.DateUtils;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.MsgSendEntity;
import com.weds.edwx.mapper.MsgSendMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author sxm
 * @Description MsgSend管理
 * @Date 2018-12-19
 */
@Service
public class MsgSendService extends BaseService {

    @Autowired
    private MsgSendMapper msgSendMapper;

    private Logger log = LogManager.getLogger();

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private WeiXinParams weiXinParams;

    public String sendMessage(String content) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map param = JSONObject.parseObject(content);
        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(param, httpHeaders);
        String token = SystemPool.getToken();
        JSONObject httpResponEntity = restTemplate.postForObject(weiXinParams.getSendmsgUrl() + "?access_token=" + token, request, JSONObject.class);
        System.out.println("获取的值" + httpResponEntity.getString("errcode"));
        log.info("time:" + DateUtils.getCurrentDateTime() + ";send message url:" + weiXinParams.getSendmsgUrl());
        return httpResponEntity.getString("errcode");
    }

    public int addMessage(Long userSerial, String templetId, Map map, String msgXh) {
        MsgSendEntity entity = new MsgSendEntity();
        String strDate = DateUtils.getCurrentDateTime();
        entity.setUserSerial(userSerial);
        entity.setMsgState(0);
        entity.setRecordDate(strDate);
        entity.setInsertDate(strDate);
        entity.setTempletId(templetId);
        entity.setMesContent(toJson(map));
        entity.setMsgXh(msgXh);
        return msgSendMapper.insertSelective(entity);
    }

    public int deleteByPrimaryKey(Long id) {
        return msgSendMapper.deleteByPrimaryKey(id);
    }

    public int insert(MsgSendEntity record) {
        return msgSendMapper.insert(record);
    }

    public int insertSelective(MsgSendEntity record) {
        return msgSendMapper.insertSelective(record);
    }

    public MsgSendEntity selectByPrimaryKey(Long id) {
        return msgSendMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(MsgSendEntity record) {
        return msgSendMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MsgSendEntity record) {
        return msgSendMapper.updateByPrimaryKey(record);
    }

    public List<MsgSendEntity> selectListByEntity(MsgSendEntity record) {
        return msgSendMapper.selectListByEntity(record);
    }

    public List<MsgSendEntity> selectListByKeys(String keys) {
        return msgSendMapper.selectListByKeys(keys);
    }

    public int deleteBatchByKeys(List<MsgSendEntity> list) {
        return msgSendMapper.deleteBatchByKeys(list);
    }

    public List<MsgSendEntity> selectMsgList() {
        return msgSendMapper.selectMsgList();
    }

    public List<MsgSendEntity> selectMsgListYun() {
        return msgSendMapper.selectMsgListYun();
    }
}
