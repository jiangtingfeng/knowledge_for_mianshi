/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.template;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:31 2020/7/24
 */
public class Client {

    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
        System.out.println("---------------");
        caffeineBeverage = new Tea();
        caffeineBeverage.prepareRecipe();
    }
}
