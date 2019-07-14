package com.personal.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author wangXK
 *
 */
@EnableDiscoveryClient  // 注册到eureka-server上，所以需要@EnableDiscoveryClient这个注解
@SpringBootApplication
@EnableZuulProxy
@RefreshScope
public class ZuulServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(ZuulServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApplication.class, args);
    }
}
