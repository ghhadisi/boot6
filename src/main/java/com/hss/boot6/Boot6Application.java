package com.hss.boot6;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Boot6Application {
    static Logger logger = LoggerFactory.getLogger(Boot6Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Boot6Application.class, args);
        logger.info("【【【【【消息队列-消息提供者启动成功.】】】】】");
    }

}

