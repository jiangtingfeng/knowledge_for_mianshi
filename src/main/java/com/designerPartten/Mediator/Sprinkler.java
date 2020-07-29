/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.Mediator;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:05 2020/7/24
 */
public class Sprinkler extends Colleague{
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("sprinkler");
    }

    public void doSprinkler() {
        System.out.println("doSprinkler()");
    }
}
