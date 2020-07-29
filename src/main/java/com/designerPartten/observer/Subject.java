/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.observer;

/**
 * @Author: jiangtingfeng
 * @Description: 观察者的主题
 * @Date :Create in 9:42 2020/7/24
 */
public interface Subject {
    /** 注册*/
    void registerObserver(Observer observer);

    /** 移除*/
    void removeObserver(Observer observer);

    /** 监听*/
    void notifyObserver();

}
