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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
