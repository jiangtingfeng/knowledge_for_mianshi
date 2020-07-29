/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.template;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:25 2020/7/24
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    /** 流程中固定的操作 如  ------ 烧水*/
    void boilWater() {
        System.out.println("boilWater");
    }

    /** 流程中固定的操作 如  ------ 把水倒到杯子中*/
    void pourInCup() {
        System.out.println("pourInCup");
    }

}
