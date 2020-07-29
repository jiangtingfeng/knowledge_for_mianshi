/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.Stategy;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:20 2020/7/24
 */
public class DefaultQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
