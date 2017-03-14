package com.cmos.happyweather.util;

import android.text.TextUtils;

import com.cmos.happyweather.model.City;
import com.cmos.happyweather.model.County;
import com.cmos.happyweather.model.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class Utility {
    /**
    * 解析和处理服务器返回的省级数据
    * */
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces=new JSONArray(response);
                for (int i = 0; i <allProvinces.length(); i++) {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities=new JSONArray(response);
                for (int i = 0; i <allCities.length() ; i++) {
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public  static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response))
        try{
            JSONArray allCounties=new JSONArray(response);
            for (int i = 0; i <allCounties.length() ; i++) {
                JSONObject countyObject=allCounties.getJSONObject(i);
                County country=new County();
                country.setCountyName(countyObject.getString("name"));
                country.setWeatherId(countyObject.getString("weather_id"));
                country.setCityId(cityId);
                country.save();
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return false;
    }
}
