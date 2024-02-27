package com.hxt.controlbackend.pojo;

import java.util.Date;
import java.util.List;

public class WeatherRaw {
    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private Integer tzshift;
    private String timezone;
    private Long server_time;
    private List<Float> location;
    private Result result;

    public WeatherRaw() {
    }

    public WeatherRaw(String status, String api_version, String api_status, String lang, String unit, Integer tzshift, String timezone, Long server_time, List<Float> location, Result result) {
        this.status = status;
        this.api_version = api_version;
        this.api_status = api_status;
        this.lang = lang;
        this.unit = unit;
        this.tzshift = tzshift;
        this.timezone = timezone;
        this.server_time = server_time;
        this.location = location;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getTzshift() {
        return tzshift;
    }

    public void setTzshift(Integer tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getServer_time() {
        return server_time;
    }

    public void setServer_time(Long server_time) {
        this.server_time = server_time;
    }

    public List<Float> getLocation() {
        return location;
    }

    public void setLocation(List<Float> location) {
        this.location = location;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private Daily daily;

        public Result() {
        }

        public Result(Daily daily, Integer primary) {
            this.daily = daily;
            this.primary = primary;
        }

        public Daily getDaily() {
            return daily;
        }

        public void setDaily(Daily daily) {
            this.daily = daily;
        }

        public Integer getPrimary() {
            return primary;
        }

        public void setPrimary(Integer primary) {
            this.primary = primary;
        }

        public static class Daily{
            private String status;
            private List<Astro> astro;

            public Daily() {
            }

            public Daily(String status, List<Astro> astro, List<Precipitation> precipitation_08h_20h, List<Precipitation> precipitation_20h_32h, List<Precipitation> precipitation, List<Meta> temperature, List<Meta> temperature_08h_20h, List<Meta> temperature_20h_32h, List<Wind> wind, List<Wind> wind_08h_20h, List<Wind> wind_20h_32h, List<Meta> humidity, List<Meta> cloudrate, List<Meta> pressure, List<Meta> visibility, List<Meta> dswrf, AirQuality air_quality, List<SkyCon> skycon, List<SkyCon> skycon_08h_20h, List<SkyCon> skycon_20h_32h, LifeIndex life_index) {
                this.status = status;
                this.astro = astro;
                this.precipitation_08h_20h = precipitation_08h_20h;
                this.precipitation_20h_32h = precipitation_20h_32h;
                this.precipitation = precipitation;
                this.temperature = temperature;
                this.temperature_08h_20h = temperature_08h_20h;
                this.temperature_20h_32h = temperature_20h_32h;
                this.wind = wind;
                this.wind_08h_20h = wind_08h_20h;
                this.wind_20h_32h = wind_20h_32h;
                this.humidity = humidity;
                this.cloudrate = cloudrate;
                this.pressure = pressure;
                this.visibility = visibility;
                this.dswrf = dswrf;
                this.air_quality = air_quality;
                this.skycon = skycon;
                this.skycon_08h_20h = skycon_08h_20h;
                this.skycon_20h_32h = skycon_20h_32h;
                this.life_index = life_index;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<Astro> getAstro() {
                return astro;
            }

            public void setAstro(List<Astro> astro) {
                this.astro = astro;
            }

            public List<Precipitation> getPrecipitation_08h_20h() {
                return precipitation_08h_20h;
            }

            public void setPrecipitation_08h_20h(List<Precipitation> precipitation_08h_20h) {
                this.precipitation_08h_20h = precipitation_08h_20h;
            }

            public List<Precipitation> getPrecipitation_20h_32h() {
                return precipitation_20h_32h;
            }

            public void setPrecipitation_20h_32h(List<Precipitation> precipitation_20h_32h) {
                this.precipitation_20h_32h = precipitation_20h_32h;
            }

            public List<Precipitation> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<Precipitation> precipitation) {
                this.precipitation = precipitation;
            }

            public List<Meta> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<Meta> temperature) {
                this.temperature = temperature;
            }

            public List<Meta> getTemperature_08h_20h() {
                return temperature_08h_20h;
            }

            public void setTemperature_08h_20h(List<Meta> temperature_08h_20h) {
                this.temperature_08h_20h = temperature_08h_20h;
            }

            public List<Meta> getTemperature_20h_32h() {
                return temperature_20h_32h;
            }

            public void setTemperature_20h_32h(List<Meta> temperature_20h_32h) {
                this.temperature_20h_32h = temperature_20h_32h;
            }

            public List<Wind> getWind() {
                return wind;
            }

            public void setWind(List<Wind> wind) {
                this.wind = wind;
            }

            public List<Wind> getWind_08h_20h() {
                return wind_08h_20h;
            }

            public void setWind_08h_20h(List<Wind> wind_08h_20h) {
                this.wind_08h_20h = wind_08h_20h;
            }

            public List<Wind> getWind_20h_32h() {
                return wind_20h_32h;
            }

            public void setWind_20h_32h(List<Wind> wind_20h_32h) {
                this.wind_20h_32h = wind_20h_32h;
            }

            public List<Meta> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<Meta> humidity) {
                this.humidity = humidity;
            }

            public List<Meta> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<Meta> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<Meta> getPressure() {
                return pressure;
            }

            public void setPressure(List<Meta> pressure) {
                this.pressure = pressure;
            }

            public List<Meta> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<Meta> visibility) {
                this.visibility = visibility;
            }

            public List<Meta> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<Meta> dswrf) {
                this.dswrf = dswrf;
            }

            public AirQuality getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQuality air_quality) {
                this.air_quality = air_quality;
            }

            public List<SkyCon> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyCon> skycon) {
                this.skycon = skycon;
            }

            public List<SkyCon> getSkycon_08h_20h() {
                return skycon_08h_20h;
            }

            public void setSkycon_08h_20h(List<SkyCon> skycon_08h_20h) {
                this.skycon_08h_20h = skycon_08h_20h;
            }

            public List<SkyCon> getSkycon_20h_32h() {
                return skycon_20h_32h;
            }

            public void setSkycon_20h_32h(List<SkyCon> skycon_20h_32h) {
                this.skycon_20h_32h = skycon_20h_32h;
            }

            public LifeIndex getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndex life_index) {
                this.life_index = life_index;
            }

            public static class Astro{
                private String date;
                private Sun sunrise;
                private Sun sunset;

                public Astro() {
                }

                public Astro(String date, Sun sunrise, Sun sunset) {
                    this.date = date;
                    this.sunrise = sunrise;
                    this.sunset = sunset;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public Sun getSunrise() {
                    return sunrise;
                }

                public void setSunrise(Sun sunrise) {
                    this.sunrise = sunrise;
                }

                public Sun getSunset() {
                    return sunset;
                }

                public void setSunset(Sun sunset) {
                    this.sunset = sunset;
                }

                public static class Sun{
                    public Sun(String time) {
                        this.time = time;
                    }

                    public Sun() {
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }

                    private String time;
                }
            }
            private List<Precipitation> precipitation_08h_20h;
            private List<Precipitation> precipitation_20h_32h;
            private List<Precipitation> precipitation;
            public static class Precipitation{
                public Precipitation() {
                }

                public Precipitation(String date, Float max, Float min, Float avg, Integer probability) {
                    this.date = date;
                    this.max = max;
                    this.min = min;
                    this.avg = avg;
                    this.probability = probability;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
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

                public Float getAvg() {
                    return avg;
                }

                public void setAvg(Float avg) {
                    this.avg = avg;
                }

                public Integer getProbability() {
                    return probability;
                }

                public void setProbability(Integer probability) {
                    this.probability = probability;
                }

                private String date;
                private Float max;
                private Float min;
                private Float avg;
                private Integer probability;
            }
            private List<Meta> temperature;
            private List<Meta> temperature_08h_20h;
            private List<Meta> temperature_20h_32h;
            public static class Meta{
                public Meta() {
                }

                public Meta(String date, Float max, Float min, Float avg) {
                    this.date = date;
                    this.max = max;
                    this.min = min;
                    this.avg = avg;
                }

                private String date;
                private Float max;
                private Float min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
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

                public Float getAvg() {
                    return avg;
                }

                public void setAvg(Float avg) {
                    this.avg = avg;
                }

                private Float avg;
            }
            private List<Wind> wind;
            private List<Wind> wind_08h_20h;
            private List<Wind> wind_20h_32h;

            public static class Wind{
                public Wind(String date, WindData max, WindData min, WindData avg) {
                    this.date = date;
                    this.max = max;
                    this.min = min;
                    this.avg = avg;
                }

                public Wind() {
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public WindData getMax() {
                    return max;
                }

                public void setMax(WindData max) {
                    this.max = max;
                }

                public WindData getMin() {
                    return min;
                }

                public void setMin(WindData min) {
                    this.min = min;
                }

                public WindData getAvg() {
                    return avg;
                }

                public void setAvg(WindData avg) {
                    this.avg = avg;
                }

                private String date;
                private WindData max;
                private WindData min;
                private WindData avg;
                public static class WindData{
                    public WindData() {
                    }

                    public WindData(Float speed, Float direction) {
                        this.speed = speed;
                        this.direction = direction;
                    }

                    public Float getSpeed() {
                        return speed;
                    }

                    public void setSpeed(Float speed) {
                        this.speed = speed;
                    }

                    public Float getDirection() {
                        return direction;
                    }

                    public void setDirection(Float direction) {
                        this.direction = direction;
                    }

                    private Float speed;
                    private Float direction;
                }
            }
            private List<Meta> humidity;
            private List<Meta> cloudrate;
            private List<Meta> pressure;
            private List<Meta> visibility;
            private List<Meta> dswrf;
            private AirQuality air_quality;
            public static class AirQuality{
                public AirQuality() {
                }

                public AirQuality(List<Aqi> aqi, List<Meta> pm25) {
                    this.aqi = aqi;
                    this.pm25 = pm25;
                }

                public List<Aqi> getAqi() {
                    return aqi;
                }

                public void setAqi(List<Aqi> aqi) {
                    this.aqi = aqi;
                }

                public List<Meta> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Meta> pm25) {
                    this.pm25 = pm25;
                }

                private List<Aqi> aqi;
                public static class Aqi{
                    public Aqi() {
                    }

                    public Aqi(String date, AqiData max, AqiData min, AqiData avg) {
                        this.date = date;
                        this.max = max;
                        this.min = min;
                        this.avg = avg;
                    }

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public AqiData getMax() {
                        return max;
                    }

                    public void setMax(AqiData max) {
                        this.max = max;
                    }

                    public AqiData getMin() {
                        return min;
                    }

                    public void setMin(AqiData min) {
                        this.min = min;
                    }

                    public AqiData getAvg() {
                        return avg;
                    }

                    public void setAvg(AqiData avg) {
                        this.avg = avg;
                    }

                    private String date;
                    private AqiData max;
                    private AqiData min;
                    private AqiData avg;
                    public static class AqiData{
                        public AqiData() {
                        }

                        public AqiData(Float chn, Float usa) {
                            this.chn = chn;
                            this.usa = usa;
                        }

                        public Float getChn() {
                            return chn;
                        }

                        public void setChn(Float chn) {
                            this.chn = chn;
                        }

                        public Float getUsa() {
                            return usa;
                        }

                        public void setUsa(Float usa) {
                            this.usa = usa;
                        }

                        private Float chn;
                        private Float usa;
                    }
                }
                private List<Meta> pm25;
            }
            private List<SkyCon> skycon;
            private List<SkyCon> skycon_08h_20h;
            private List<SkyCon> skycon_20h_32h;
            public static class SkyCon{
                public SkyCon() {
                }

                public SkyCon(String date, String value) {
                    this.date = date;
                    this.value = value;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                private String date;
                private String value;
            }
            private LifeIndex life_index;
            public static class LifeIndex{
                public LifeIndex() {
                }

                public LifeIndex(List<LifeIndexData> ultraviolet, List<LifeIndexData> carWashing, List<LifeIndexData> dressing, List<LifeIndexData> comfort, List<LifeIndexData> coldRisk) {
                    this.ultraviolet = ultraviolet;
                    this.carWashing = carWashing;
                    this.dressing = dressing;
                    this.comfort = comfort;
                    this.coldRisk = coldRisk;
                }

                public List<LifeIndexData> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<LifeIndexData> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<LifeIndexData> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<LifeIndexData> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<LifeIndexData> getDressing() {
                    return dressing;
                }

                public void setDressing(List<LifeIndexData> dressing) {
                    this.dressing = dressing;
                }

                public List<LifeIndexData> getComfort() {
                    return comfort;
                }

                public void setComfort(List<LifeIndexData> comfort) {
                    this.comfort = comfort;
                }

                public List<LifeIndexData> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<LifeIndexData> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                private List<LifeIndexData> ultraviolet;
                private List<LifeIndexData> carWashing;
                private List<LifeIndexData> dressing;
                private List<LifeIndexData> comfort;
                private List<LifeIndexData> coldRisk;
                public static class LifeIndexData{
                    public LifeIndexData() {
                    }

                    public LifeIndexData(String date, String index, String desc) {
                        this.date = date;
                        this.index = index;
                        this.desc = desc;
                    }

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    private String date;
                    private String index;
                    private String desc;
                }
            }
        }
        private Integer primary;
    }
}
