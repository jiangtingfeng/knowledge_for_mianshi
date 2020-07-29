/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.state;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:05 2020/7/24
 */
public interface State {

    /**
     * 投入25分钱
     * */
    void insertQuarter();

    /**
     * 退回25分钱
     * */
    void ejectQuarter();

    /**
     * 转动曲柄
     * */
    void turnCrank();

    /**
     * 发放糖果
     * */
    void dispense();

}
