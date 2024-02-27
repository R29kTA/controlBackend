package com.hxt.controlbackend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxt.controlbackend.pojo.Config;
import com.hxt.controlbackend.pojo.Environment;
import com.hxt.controlbackend.pojo.WeatherRaw;
import com.hxt.controlbackend.service.ConfigService;
import com.hxt.controlbackend.service.EnvironmentService;
import jakarta.annotation.Resource;
import okhttp3.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    private static final String API_KEY = "2zLsYNlGrLZGfIKM";
    @Resource
    private ConfigService configService;

    public WeatherRaw getWeatherRaw(float latitude,float longitude) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String url = "https://api.caiyunapp.com/v2.6/"+API_KEY+"/"+longitude+","+latitude+"/"+"daily?dailysteps=1";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("authority", "api.caiyunapp.com")
                .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .addHeader("cache-control", "no-cache")
                .addHeader("pragma", "no-cache")
                .addHeader("sec-ch-ua", "\"Not A(Brand\";v=\"99\", \"Microsoft Edge\";v=\"121\", \"Chromium\";v=\"121\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("sec-fetch-dest", "document")
                .addHeader("sec-fetch-mode", "navigate")
                .addHeader("sec-fetch-site", "none")
                .addHeader("sec-fetch-user", "?1")
                .addHeader("upgrade-insecure-requests", "1")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36 Edg/121.0.0.0")
                .build();
        WeatherRaw weatherRaw = null;
        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                String string = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                weatherRaw = objectMapper.readValue(string, WeatherRaw.class);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return weatherRaw;
    }

    @Override
    public Environment getEnvironmentInfo() {
        Config config = configService.getConfig();
        WeatherRaw weatherRaw = getWeatherRaw(config.getLatitude(),config.getLongitude());
        WeatherRaw.Result result = weatherRaw.getResult();
        WeatherRaw.Result.Daily daily = result.getDaily();
        WeatherRaw.Result.Daily.Astro astro = daily.getAstro().get(0);
        String riseTime = astro.getSunrise().getTime();
        String setTime = astro.getSunset().getTime();
        Environment environment = new Environment();

        // 设置日落时间
        environment.setSunrise(riseTime);
        environment.setSunset(setTime);
        long minutes = ChronoUnit.MINUTES.between(LocalTime.parse(riseTime), LocalTime.parse(setTime));
        environment.setDayTime(minutes);
        // 天气
        Date now = new Date();

        String iconRaw = daily.getSkycon().get(0).getValue();
        String icon8Raw = daily.getSkycon_08h_20h().get(0).getValue();
        String icon20Raw = daily.getSkycon_20h_32h().get(0).getValue();
        WeatherRaw.Result.Daily.Meta t = daily.getTemperature().get(0);
        WeatherRaw.Result.Daily.Meta t8 = daily.getTemperature_08h_20h().get(0);
        WeatherRaw.Result.Daily.Meta t20 = daily.getTemperature_20h_32h().get(0);
        environment.setTemperatureN(raw2Temperature(t,iconRaw,now));
        List<Environment.Temperature> tF = new ArrayList<>();
        // 加上8小时
        tF.add(raw2Temperature(t8,icon8Raw,new Date(now.getTime()+ 28800000L)));
        // 加上16小时
        tF.add(raw2Temperature(t20,icon20Raw,new Date(now.getTime() + 57600000L)));
        environment.setTemperatureF(tF);
        // 平均气温
        environment.setTemperatureO(t.getAvg());
        // 这里获取室内温度
        environment.setTemperatureI(26.3F);
        // 风速
        Float windSpeed = daily.getWind().get(0).getMax().getSpeed();
        environment.setWindSpeed(windSpeed);
        Float humidity = daily.getHumidity().get(0).getMax();
        environment.setHumidity(humidity);
        return environment;
    }
    private Environment.Temperature raw2Temperature(WeatherRaw.Result.Daily.Meta raw,String icon,Date date){
        return new Environment.Temperature(date,raw.getMax(), raw.getMin(),raw2Icon(icon));
    }
    private String raw2Icon(String raw){
        if (raw.contains("CLEAR")){
            return "Sunny";
            // 多云
        }else if (raw.contains("PARTLY_CLOUDY")){
            return "PartlyCloudy";
            // 阴
        }else if (raw.contains("CLOUDY")){
            return "Cloudy";
        }else if (raw.contains("RAIN")){
            return "Pouring";
        }
        return "Lightning";
    }
}
