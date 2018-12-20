package com.hss.boot6;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot6Application {

    public static void main(String[] args) {
//        SpringApplication.run(Boot6Application.class, args);
        SpringApplication application =  new SpringApplication(Boot6Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);

    }

}

