package com.qf.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class SleuthApplication {

	  public static void main(String[] args) {
	        SpringApplication.run(SleuthApplication.class, args);
	    }
	  
}
