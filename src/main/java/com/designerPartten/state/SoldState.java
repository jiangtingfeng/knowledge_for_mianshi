/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.state;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:08 2020/7/24
 */
public class SoldState implements State {

    private GumballMachine machine;

    public SoldState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        
    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
