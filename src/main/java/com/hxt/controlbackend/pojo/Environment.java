package com.hxt.controlbackend.pojo;

import java.util.Date;
import java.util.List;

public class Environment {
    private String sunrise;
    private String sunset;
    private Long dayTime;
    private Temperature temperatureN;
    private List<Temperature> temperatureF;

    public Environment() {
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Environment(String sunrise, String sunset, Long dayTime, Temperature temperatureN, List<Temperature> temperatureF, Float temperatureO, Float temperatureI, Float windSpeed, Float humidity) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.dayTime = dayTime;
        this.temperatureN = temperatureN;
        this.temperatureF = temperatureF;
        this.temperatureO = temperatureO;
        this.temperatureI = temperatureI;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
    }

    public Long getDayTime() {
        return dayTime;
    }

    public void setDayTime(Long dayTime) {
        this.dayTime = dayTime;
    }

    public Temperature getTemperatureN() {
        return temperatureN;
    }

    public void setTemperatureN(Temperature temperatureN) {
        this.temperatureN = temperatureN;
    }

    public List<Temperature> getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(List<Temperature> temperatureF) {
        this.temperatureF = temperatureF;
    }

    public Float getTemperatureO() {
        return temperatureO;
    }

    public void setTemperatureO(Float temperatureO) {
        this.temperatureO = temperatureO;
    }

    public Float getTemperatureI() {
        return temperatureI;
    }

    public void setTemperatureI(Float temperatureI) {
        this.temperatureI = temperatureI;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public static class Temperature {
        public Temperature() {
        }

        public Temperature(Date date, Float max, Float min, String icon) {
            this.date = date;
            this.max = max;
            this.min = min;
            this.icon = icon;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Float getMax() {
            return max;
        }

        public void setMax(Float max) {
            this.max = max;
        }

        public Float getMin() {
            return min;
        }

        public void setMin(Float min) {
            this.min = min;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        private Date date;
        private Float max;
        private Float min;
        private String icon;
    }

    private Float temperatureO;
    private Float temperatureI;
    private Float windSpeed;
    private Float humidity;
}
