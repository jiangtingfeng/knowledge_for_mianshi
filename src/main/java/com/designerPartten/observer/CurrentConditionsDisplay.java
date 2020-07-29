/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.observer;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:47 2020/7/24
 */
public class CurrentConditionsDisplay implements Observer {
    /** 注册到主题中去*/
    public CurrentConditionsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }
    /** 更新主题内容*/
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("CurrentConditionsDisplay.update: " + temp + " " + humidity + " " + pressure);
    }
}
