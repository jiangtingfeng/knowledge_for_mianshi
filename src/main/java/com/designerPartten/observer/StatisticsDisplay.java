/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.observer;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:45 2020/7/24
 */
public class StatisticsDisplay implements Observer {

    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("StatisticsDisplay.update:" + temp + "   " + humidity + "    " + pressure);
    }

}
