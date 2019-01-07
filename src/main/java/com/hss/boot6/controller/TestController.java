package com.hss.boot6.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /**
     * 测试拦截地址
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "Success";
    }
}
