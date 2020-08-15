package com.weds.edwx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.DeviceEntity;
import com.weds.scan.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.KtJlMapper;
import com.weds.edwx.entity.KtJlEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @Author sxm
 * @Description KtJl管理
 * @Date 2018-12-27
 */
@Service
public class KtJlService extends BaseService {

    @Autowired
    private KtJlMapper ktJlMapper;

    @Autowired
    private ScanService scanService;

    @Autowired
    private RestTemplate restTemplate;
    private Logger log = LogManager.getLogger();

    /**
     * 解密二维码字符串
     *
     * @param codeStr
     * @return
     */
    public Map<String, Object> decodingStr(Object codeStr) {
        Map<String, Object> json;
        int lx = 0;
        JsonResult jsonResult;
        try {
            json = (Map) JSONObject.parse(codeStr.toString());//先强转json，转化成功即可走考勤解密
            //requestUrl = codeUrl + "/v1/scan/jsonCheck/1000001";
            lx = 0;
            jsonResult = scanService.jsonCheck(json,"1000001");
        } catch (Exception e) { //转化失败，走门禁解密
            e.printStackTrace();
            json = new HashMap<>();
            json.put("ScanId", "1000002");
            json.put("SignStr", codeStr);
            jsonResult = scanService.strCheckPack(json,"1000002");
            lx = 1;
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("codeType",lx);
        param.put("jsonResult",jsonResult);
        return param;
    }

    /**
     * 查询该设备是否有场所白名单
     * @param record
     * @return
     */
    public int selectDepUser(DeviceEntity record){
        return ktJlMapper.selectDepUser(record);
    }

    /**
     * 查询该设备是否有部门白名单
     * @param record
     * @return
     */
    public int selectDepPlace(DeviceEntity record){
        return ktJlMapper.selectDepPlace(record);
    }

    /**
     * 查询该人在该设备上是否有场所白名单
     * @param record
     * @return
     */
    public int selectDepUserByUserSerial(DeviceEntity record){
        return ktJlMapper.selectDepUserByUserSerial(record);
    }

    /**
     * 查询该人在该设备上是否有部门白名单
     * @param record
     * @return
     */
    public int selectDepPlaceByUserSerial(DeviceEntity record){
        return ktJlMapper.selectDepPlaceByUserSerial(record);
    }

    /**
     * 插入考勤记录
     * @param record
     * @return
     */
    public int insert(KtJlEntity record){
        return ktJlMapper.insert(record);
    }
}
