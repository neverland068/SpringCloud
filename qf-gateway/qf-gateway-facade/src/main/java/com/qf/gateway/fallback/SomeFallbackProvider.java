package com.qf.gateway.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.qf.gateway.fallback.response.ClientHttpResponseImpl;


@Component
public class SomeFallbackProvider implements ZuulFallbackProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(SomeFallbackProvider.class);
    private final static String serviceName = "some";

    @Override
    public String getRoute() {
        // 表明是为哪个微服务提供回退
        return serviceName;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponseImpl(serviceName);
    }
}
