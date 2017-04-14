package com.qf.gateway.fallback.response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import com.alibaba.fastjson.JSON;
import com.qf.gateway.fallback.SomeFallbackProvider;

/**
 * @author liuchaogang
 * @date 2017年4月14日
 */
public class ClientHttpResponseImpl implements ClientHttpResponse {
    private final static Logger LOGGER = LoggerFactory.getLogger(SomeFallbackProvider.class);

    private String serviceName;

    public ClientHttpResponseImpl() {
        super();
    }

    public ClientHttpResponseImpl(String serviceName) {
        super();
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        // fallback时的状态码
        return HttpStatus.OK;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        // 数字类型的状态码，本例返回的其实就是200，详见HttpStatus
        return this.getStatusCode().value();
    }

    @Override
    public String getStatusText() throws IOException {
        // 状态文本，本例返回的其实就是OK，详见HttpStatus
        return this.getStatusCode().getReasonPhrase();
    }

    @Override
    public void close() {}

    @Override
    public InputStream getBody() throws IOException {
        LOGGER.error("Call "+serviceName+" Service failed>>>>>>>>>>>>>>>>>");
        CommonResponse response = new CommonResponse();
        response.setResponseCode(ResponseCode.RC_CALL_ERROR.getResponseCode());
        response.setResponseMessage(ResponseCode.RC_CALL_ERROR.getResponseMessage());
        return new ByteArrayInputStream(JSON.toJSONString(response).getBytes());
    }

    @Override
    public HttpHeaders getHeaders() {
        // headers设定
        HttpHeaders headers = new HttpHeaders();
        MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
        headers.setContentType(mt);

        return headers;
    }
}
