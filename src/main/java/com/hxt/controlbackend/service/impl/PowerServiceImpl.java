package com.hxt.controlbackend.service.impl;

import com.hxt.controlbackend.pojo.*;
import com.hxt.controlbackend.repository.PowerRepository;
import com.hxt.controlbackend.service.ConfigService;
import com.hxt.controlbackend.service.DeviceService;
import com.hxt.controlbackend.service.PowerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class PowerServiceImpl implements PowerService {
    @Resource
    private PowerRepository powerRepository;
    @Resource
    private DeviceService deviceService;
    @Resource
    private ConfigService configService;
    @Override
    public List<Power> getPower() {
        return null;
    }

    @Override
    public List<DayPower> getDatePower(int month) {
        LocalDate now = LocalDate.now();
        LocalDate end = now.withMonth(month);
        System.out.println(end);
        LocalDate start = end.minusDays(7);
        List<Power> powerList = powerRepository.findPowersByDateBetween(
                Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
        List<DayPower> dayPowers = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        HashMap<Integer,Double> map = new HashMap<>();
        for (Power power : powerList) {
            Integer day = Integer.parseInt(sdf.format(power.getDate()));
            Double old = map.get(day)==null ? 0d : map.get(day);
            map.put(day,power.getPower()+old);
        }
        Set<Integer> keyset = map.keySet();
        Object[] array = keyset.toArray();
        Arrays.sort(array);
        for (Object day : array){
            DayPower dayPower = new DayPower((Integer) day,map.get(day));
            dayPowers.add(dayPower);
        }
        return dayPowers;
    }

    @Override
    public List<DeviceConsume> getDevicePower(int month) {
        LocalDate now = LocalDate.now();
        LocalDate dat = now.withMonth(month);
        // 获得当月第一天
        LocalDate start = dat.with(TemporalAdjusters.firstDayOfMonth());
        // 获取下个月的第一天
        LocalDate end = dat.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        List<Power> powerList = powerRepository.findPowersByDateBetween(
                Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant())
        );
        TreeMap<Integer,Double> deviceMap = new TreeMap<>();
        for (Power power : powerList) {
            Integer deviceId = power.getDeviceId();
            Double oldPower = deviceMap.get(deviceId)==null ? 0d : deviceMap.get(deviceId);
            deviceMap.put(deviceId,power.getPower()+oldPower);
        }
        // 创建比较器
        Comparator<Map.Entry<Integer, Double>> valueComparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
        List<Map.Entry<Integer, Double>> mapList = new ArrayList<>(deviceMap.entrySet());
        mapList.sort(valueComparator);
        List<DeviceConsume>  deviceConsumes = new ArrayList<>();
        // 获得配置
        Config config = configService.getConfig();
        Double powerRate = config.getPowerRate();
        double total = 0d;
        for (int i = 0; i < 3 && i < mapList.size(); i++) {
            Map.Entry<Integer, Double> entry = mapList.get(i);
            Device device = deviceService.getDevice(entry.getKey());
            double consume = entry.getValue() * powerRate;
            total += consume;
            deviceConsumes.add(new DeviceConsume(device.getName(),consume,device.getPowerLimit() * powerRate));
        }
        Double others = 0d;
        for (int i = 3; i < mapList.size(); i++) {
            Map.Entry<Integer, Double> entry = mapList.get(i);
            others += entry.getValue();
        }
        if (others>0d) {
            Double limit = (config.getPowerLimit() * powerRate) - total;
            deviceConsumes.add(new DeviceConsume("其他", others, limit));
        }

        return deviceConsumes;
    }
}
