/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.factory;

import com.designerPartten.factory.item.ConcreteProduct;
import com.designerPartten.factory.item.ConcreteProduct1;
import com.designerPartten.factory.item.ConcreteProduct2;
import com.designerPartten.factory.item.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: jiangtingfeng
 * @Description: 简单工厂
 * @Date :Create in 17:25 2020/7/22
 */
public class SimpleFactory {

    static Properties evn = new Properties();

    /**
     * 获取配置文件
     * */
    static {
        try {
            InputStream inputStream = SimpleFactory.class.getResourceAsStream("/application.properties");
            evn.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product createProduct(String name){
        Product product = null;
        try {
            product = (Product)Class.forName(evn.getProperty(name)).newInstance();
        } catch (Exception e) {
        }
        return product;
    }

}
