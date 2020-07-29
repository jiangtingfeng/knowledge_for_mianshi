/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.observer;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:56 2020/7/24
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasureMents(0,0,0);
        weatherData.setMeasureMents(1,1,1);
    }

}
