package com.hss.boot6.controller;

import com.hss.boot6.bean.User;
import com.hss.boot6.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserJpa userJpa;


    /**
     * 查询用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}")
    public User detail(@PathVariable("id") Integer id)

    {
        Optional<User>  value  =  userJpa.findById(id);

        return value.get();
    }
}
