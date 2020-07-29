/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.Stategy;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:23 2020/7/24
 */
public class Client {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehaviour(new Squeak());
        duck.performQuack();
        duck.setQuackBehaviour(new DefaultQuack());
        duck.performQuack();
    }
}
