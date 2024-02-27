package com.hxt.controlbackend.repository;

import com.hxt.controlbackend.pojo.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PowerRepository extends JpaRepository<Power,Integer> {
    List<Power> findPowersByDateBetween(Date start,Date end);
}
