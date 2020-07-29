/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.factory;

import com.designerPartten.factory.abstractFactory.ConcreteFactory;
import com.designerPartten.factory.abstractFactory.Factory;
import com.designerPartten.factory.item.Product;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 17:39 2020/7/22
 */
public class MainTest {

    public static void main(String[] args) {
        Product concreteProduct = SimpleFactory.createProduct("concreteProduct");
        System.out.println(concreteProduct);

       /* Factory factory = new ConcreteFactory();
        factory.doSomething();*/
    }

}
