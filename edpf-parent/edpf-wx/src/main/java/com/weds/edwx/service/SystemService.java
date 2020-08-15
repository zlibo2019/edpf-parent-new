package com.weds.edwx.service;

import com.weds.core.base.BaseService;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description System管理
 * @Date 2018-11-14
 */
@Service
public class SystemService extends BaseService {

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private RestTemplate restTemplate;

    public String wxImageDownLoad(String mediaIds, String fileName, String imageType, String imagePath, int size, String root) throws Exception {
        if (StringUtils.isBlank(mediaIds)) {
            return null;
        }
        List<String> paths = new ArrayList<>();
        String[] arrMediaId = mediaIds.split(",");
        for (String mediaId : arrMediaId) {
            byte[] image;
            if (mediaId.startsWith("http")) {
                image = restTemplate.getForObject(mediaId, byte[].class);
            } else {
                image = restTemplate.getForObject(weiXinParams.getImageUrl(), byte[].class, SystemPool.getToken(), mediaId);
                String rtn = new String(image);
                if (rtn.contains("errcode")) {
                    throw new RuntimeException();
                }
            }
            String path = ImageUtils.byteToImageScale(image, fileName, imageType, imagePath, root, size);
            // String path = ImageUtils.byteToFile(image, imgType, wxImgPath);
            paths.add(path);
        }
        return StringUtils.join(paths.toArray(), ",");
    }

    public String wxImageDownLoad(String mediaIds) throws Exception {
        return this.wxImageDownLoad(mediaIds, null, "jpeg", weiXinParams.getImagePath(), 1024, null);
    }
}