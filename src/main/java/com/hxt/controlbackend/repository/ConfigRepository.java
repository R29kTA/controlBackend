package com.hxt.controlbackend.repository;

import com.hxt.controlbackend.pojo.Config;
import com.hxt.controlbackend.pojo.Power;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config,Integer> {
}
