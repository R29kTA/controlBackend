package com.hxt.controlbackend.repository;

import com.hxt.controlbackend.pojo.Device;
import com.hxt.controlbackend.pojo.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository  extends JpaRepository<Device,Integer> {
    Device getDeviceByType(String type);
    Device getDeviceByTypeAndId(String type,Integer id);
    List<Device> getDevicesByType(String type);

    @Modifying
    @Query("UPDATE Device dev SET dev.status = :status WHERE dev.id = :id")
    void updateDevice(Integer id, Boolean status);
}
