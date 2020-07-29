/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.Stategy;

/**
 * @Author: jiangtingfeng
 * @Description: 鸭子
 * @Date :Create in 10:21 2020/7/24
 */
public class Duck {
    private QuackBehaviour quackBehaviour;

    public Duck() {
    }

    public void performQuack() {
        if (quackBehaviour != null) {
            quackBehaviour.quack();
        }
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

}
