package com.personal.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务消费端
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceConsumerApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServiceConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run( ServiceConsumerApplication.class, args );
    }
}
