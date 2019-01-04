package com.hss.boot6.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Table (name = "user")
@Entity
public class UserEntity {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    /**
     * 用户名称
     */
    @Column(name = "username")
    private String userName;


    @Column(name = "age")
    private int age;


}
