package com.hss.boot6.jpa;

import com.hss.boot6.bean.GoodInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodInfoRepository extends JpaRepository<GoodInfoEntity, Long> {
}
