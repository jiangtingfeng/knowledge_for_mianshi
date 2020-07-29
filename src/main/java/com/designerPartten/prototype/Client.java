/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.prototype;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:03 2020/7/23
 */
public class Client {

    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}
