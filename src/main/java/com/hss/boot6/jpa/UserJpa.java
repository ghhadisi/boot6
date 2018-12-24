package com.hss.boot6.jpa;

import com.hss.boot6.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, Integer> {
}
