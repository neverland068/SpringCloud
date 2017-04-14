package com.qf.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.qf.gateway.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {

	  public static void main(String[] args) {
	        SpringApplication.run(GatewayApplication.class, args);
	    }
	  
	  @Bean
	    public AccessFilter accessFilter() {
	        return new AccessFilter();
	    }
}
