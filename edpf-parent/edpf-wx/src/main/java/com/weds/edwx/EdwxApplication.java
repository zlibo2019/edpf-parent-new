package com.weds.edwx;

import com.weds.core.annotation.MyBatisDao;
import com.weds.dingtalk.service.DtCallBackService;
import com.weds.dingtalk.service.DtCallBackServiceImpl;
import com.weds.edpf.core.constant.GatewayParams;
import com.weds.edpf.core.constant.WeiXinParams;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.util.DefaultUriTemplateHandler;
import org.springframework.web.util.UriTemplateHandler;

import javax.annotation.Resource;
import java.net.URI;

@SpringBootApplication
@ComponentScan(basePackages = {"com.weds.edwx", "com.weds.web", "com.weds.workflow", "com.weds.scan",
        "com.weds.edpf", "com.weds.rpt", "com.weds.app", "com.weds.dingtalk"})
@MapperScan(basePackages = {"com.weds.**.mapper"}, annotationClass = MyBatisDao.class)
public class EdwxApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EdwxApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private GatewayParams gatewayParams;

    @Bean
    @ConditionalOnMissingBean(name = "dtCallBackService")
    public DtCallBackService dtCallBackService() {
        return new DtCallBackServiceImpl();
    }

    @Bean
    public UriTemplateHandler uriTemplateHandler() {
        return new DefaultUriTemplateHandler() {
            @Override
            public URI expand(String uriTemplate, Object... uriVariables) {
                if (weiXinParams.getMode().equals("1")) {
                    String[] strs = gatewayParams.getSourceUrl().split(",");
                    for (String str : strs) {
                        uriTemplate = uriTemplate.replace(str, gatewayParams.getTargetUrl());
                    }
                }
                return super.expand(uriTemplate, uriVariables);
            }
        };
    }
}
