package com.weds.edwx.web;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.base.BaseController;
import com.weds.bean.jwt.JwtEntity;
import com.weds.bean.jwt.JwtParams;
import com.weds.bean.jwt.JwtUtils;
import com.weds.core.annotation.Logs;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.DateUtils;
import com.weds.core.utils.WeiXinUtils;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edwx.entity.WxConfigEntity;
import com.weds.edwx.util.WxSignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author sxm
 * @Description System管理
 * @Date 2018-11-14
 */
@RestController
@RequestMapping(value = "/system")
@Api(value = "System管理", description = "System管理")
public class SystemController extends BaseController {
    @Autowired
    private JwtParams jwtParams;

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private RestTemplate restTemplate;

    @Logs
    @ApiOperation(value = "获取系统日期", notes = "获取系统日期")
    @RequestMapping(value = "/getSystemDate", method = RequestMethod.GET)
    public JsonResult<Map> getSystemDate() {
        Map map = new HashMap<>();
        map.put("sysDate", DateUtils.getCurrentDateTime());
        return succMsgData(map);
    }

    @Logs
    @ApiOperation(value = "获取测试Token", notes = "获取测试Token")
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    @ApiImplicitParam(name = "Authorization", required = false)
    public JsonResult<String> getToken(@RequestBody Map<String, Object> map) {
        JwtEntity jwtEntity = new JwtEntity();
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(map);
        jwtEntity.setJwtParams(jwtParams);
        jwtEntity.setPdata(jsonObject);
        String token = "";
        synchronized (this) {
            try {
                token = JwtUtils.createJWT(jwtEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return succMsgData(token);
    }

    @Logs
    @ApiOperation(value = "获取微信上传图片路径", notes = "获取微信上传图片路径")
    @RequestMapping(value = "/getWxImageUrl", method = RequestMethod.GET)
    public JsonResult<String> getWxImageUrl(@RequestParam String mediaId) {
        String url = MessageFormat.format(weiXinParams.getImageUrl(), "", SystemPool.getToken(), mediaId);
        return succMsgData(url);
    }

    @Logs
    @ApiOperation(value = "获取微信jssdk配置参数", notes = "获取微信jssdk配置参数")
    @RequestMapping(value = "/getConfig", method = RequestMethod.GET)
    public JsonResult<Map> getConfig(@RequestParam String url) {
        if ("0".equals(SystemPool.getTicket("errcode").toString())) {
            Map<String, String> map = WeiXinUtils.sign(SystemPool.getTicket(), url);
            map.put("appId", weiXinParams.getAppId());
            return succMsgData(map);
        }
        return succMsg("配置失败");
    }

    @Logs
    @ApiOperation(value = "获取微信token", notes = "获取微信token")
    @ApiImplicitParam(name = "Authorization", required = false)
    @RequestMapping(value = "/getAccessToken", method = RequestMethod.GET)
    public Map<String, Object> getAccessToken(@RequestParam String appid, @RequestParam String grant_type) {
        Map<String, Object> map = new HashMap<>();
        if (weiXinParams.getAppId().equals(appid) && "client_credential".equals(grant_type)) {
            map.put("access_token", SystemPool.getToken());
            map.put("expires_in", SystemPool.getToken("expires_in"));
            map.put("errcode", SystemPool.getToken("errcode"));
        } else {
            map.put("errcode", 601);
        }
        return map;
    }

    @Logs
    @ApiOperation(value = "获取微信ticket", notes = "获取微信ticket")
    @ApiImplicitParam(name = "Authorization", required = false)
    @RequestMapping(value = "/getJsapiTicket", method = RequestMethod.GET)
    public Map<String, Object> getJsapiTicket(@RequestParam String type) {
        Map<String, Object> map = new HashMap<>();
        if ("jsapi".equals(type)) {
            map.put("ticket", SystemPool.getTicket());
            map.put("expires_in", SystemPool.getTicket("expires_in"));
            map.put("errcode", SystemPool.getTicket("errcode"));
        } else {
            map.put("errcode", 601);
        }
        return map;
    }

    @Logs
    @RequestMapping(value = "/file/{param}/**", method = RequestMethod.GET)
    public void getFileByPath(@PathVariable("param") String param) {
        String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        String bestMatchPattern = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String arguments = new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
        String realPath;
        if (null != arguments && !arguments.isEmpty()) {
            realPath = param + '/' + arguments;
        } else {
            realPath = param;
        }
        String filePath = System.getProperty("user.dir") + File.separator + realPath;
        File file = new File(filePath);

        try {
            if (file.exists()) {
                String realName = filePath.substring(filePath.indexOf("/") + 1);
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realName, "UTF-8"));
                FileInputStream fis = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
                IOUtils.copy(fis, out);
                out.close();
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter pw = response.getWriter();
                pw.write("601|您要下载的资源已被删除");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // @RequestMapping(value = "/test1", method = RequestMethod.GET)
    // public void test1(HttpServletResponse httpServletResponse) {
    //     String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5bbd89441280f062&redirect_uri=http://10.11.0.6:6929/system/test2&response_type=code&scope=snsapi_userinfo#wechat_redirect";
    //     httpServletResponse.setHeader("Location", url);
    //     httpServletResponse.setStatus(302);
    // }
    //
    // @RequestMapping(value = "/test2", method = RequestMethod.GET)
    // public void test2(HttpServletResponse httpServletResponse) {
    //     httpServletResponse.setHeader("Location", "http://10.11.0.6:8081/");
    //     httpServletResponse.setStatus(302);
    // }

    @Logs
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public JsonResult<Object> test(MultipartFile file, String abc) {
        File temp = new File("./" + file.getOriginalFilename());
        try {
            file.transferTo(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return succMsg();
    }
}