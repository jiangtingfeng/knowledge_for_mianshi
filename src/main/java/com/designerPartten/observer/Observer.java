/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.observer;

/**
 * @Author: jiangtingfeng
 * @Description: 观察者的基类
 * @Date :Create in 9:43 2020/7/24
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);

}
