package com.weds.edpf.core.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseController;
import com.weds.core.resp.JsonResult;
import com.weds.core.utils.MapCacheUtils;
import com.weds.core.utils.StringUtils;
import com.weds.core.utils.coder.RSACoder;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SettingParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author sxm
 * @Description 公共接口管理
 * @Date 2019-03-07
 */
@RestController
@RequestMapping(value = "/common")
@Api(value = "公共接口管理", description = "公共接口管理")
public class CommonController extends BaseController {

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private SettingParams settingParams;

    @Logs
    @ApiOperation(value = "获取登录二维码", notes = "获取登录二维码")
    @RequestMapping(value = "/getLoginQrcode", method = RequestMethod.GET)
    public JsonResult<String> getLoginQrcode() {
        String uuid = StringUtils.getUUID();
        MapCacheUtils.single().set(uuid, uuid, 300);
        return succMsgData(uuid);
    }

    @Logs
    @ApiOperation(value = "设置用户Token", notes = "设置用户Token")
    @RequestMapping(value = "/setUserToken", method = RequestMethod.GET)
    public JsonResult<String> setUserToken(@RequestParam String id, @RequestParam String token) {
        Object temp = MapCacheUtils.single().get(id);
        if (temp != null) {
            MapCacheUtils.single().set(id, token, 60);
        } else {
            return failMsg("二维码已失效");
        }
        return succMsg();
    }

    @Logs
    @ApiOperation(value = "生成密钥", notes = "生成密钥")
    @RequestMapping(value = "/getKeys", method = RequestMethod.GET)
    public JsonResult<Map> getKeys() {
        try {
            Map<String, Object> keys = RSACoder.initKey();
            Map<String, String> resp = new HashMap<>();
            resp.put("priKey", RSACoder.getPrivateKey(keys));
            resp.put("pubKey", RSACoder.getPublicKey(keys));
            return succMsgData(resp);
        } catch (Exception e) {
            e.printStackTrace();
            return failMsg();
        }
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

        String rootPath = System.getProperty("user.dir");
        if (!StringUtils.isBlank(settingParams.getSysRoot())) {
            rootPath = settingParams.getSysRoot();
        }

        String filePath = rootPath + File.separator + realPath;

        File file = new File(filePath);

        try {
            if (file.exists()) {
                String realName = filePath.substring(filePath.lastIndexOf("/") + 1);
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realName, "UTF-8"));
                FileInputStream fis = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
                IOUtils.copy(fis, out);
                out.close();
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter pw = response.getWriter();
                // |您要下载的资源已被删除
                pw.write("601");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
