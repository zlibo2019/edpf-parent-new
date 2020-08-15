package com.weds.edwx.service;

import com.google.gson.reflect.TypeToken;
import com.weds.bean.http.HttpRequestService;
import com.weds.core.base.BaseService;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.VisUserNewEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Service
public class StFaceService extends BaseService {

    @Resource
    private HttpRequestService httpRequestService;

    public JsonResult<Object> insertStFace(VisUserNewEntity visUserNewEntity, String areaNo) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("img", visUserNewEntity.getFacePhoto());
        params.put("imgId", visUserNewEntity.getVisSerial().toString());
        params.put("personName", visUserNewEntity.getVisLname());
        params.put("personGender", visUserNewEntity.getVisSex());
        params.put("personIdCard", visUserNewEntity.getVisId());
        params.put("acdepSerial", areaNo);
        TypeToken<JsonResult<Object>> typeToken = new TypeToken<JsonResult<Object>>() {
        };
        return httpRequestService.sendPostRequest("/vis/insertVis", params, typeToken);
    }

    public JsonResult<Object> deleteStFace(String imgId) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("imgId", imgId);
        TypeToken<JsonResult<Object>> typeToken = new TypeToken<JsonResult<Object>>() {
        };
        return httpRequestService.sendPostRequest("/vis/deleteVis", params, typeToken);
    }
}
