/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.proxy;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:50 2020/8/18
 */
public class Woker implements Work {
    @Override
    public String doSomething(String name) {
        System.out.println(name+"test  .........");
        return "test";
    }
}
