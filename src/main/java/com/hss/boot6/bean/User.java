package com.hss.boot6.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable
{
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    /**
     * 昵称
     */
    @Column(name = "username")
    private String name;
    /**
     * 登录名
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 登录密码
     */
    @Column(name = "age")
    private int age;



}
