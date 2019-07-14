package com.friend.modules;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.friend.modules")
//@MapperScan("com.friend.modules")
public class SuperFriendApplication {
    private static final Logger logger = LoggerFactory.getLogger(SuperFriendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run( SuperFriendApplication.class, args );
    }
}
