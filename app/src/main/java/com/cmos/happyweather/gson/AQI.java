package com.cmos.happyweather.gson;

/**
 * Created by Administrator on 2017/3/15 0015.
 * 空气质量
 */
public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
