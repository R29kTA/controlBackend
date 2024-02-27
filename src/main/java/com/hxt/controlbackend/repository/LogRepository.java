package com.hxt.controlbackend.repository;

import com.hxt.controlbackend.pojo.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer> {
    Page<Log> findAllByUserId(Integer userid, Pageable pageable);
    Page<Log> findAllByOrderByDateDesc(Pageable pageable);
}
