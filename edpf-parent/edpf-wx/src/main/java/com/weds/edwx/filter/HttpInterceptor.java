package com.weds.edwx.filter;

import com.weds.edpf.core.constant.WeiXinParams;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component("httpInterceptor")
public class HttpInterceptor implements ClientHttpRequestInterceptor {
    @Resource
    private WeiXinParams weiXinParams;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders httpHeaders = request.getHeaders();
        httpHeaders.add("CompanyId", weiXinParams.getCompanyId());
        return execution.execute(request, body);
    }
}

