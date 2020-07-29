/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.memento;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:25 2020/7/24
 */
public class PreviousCalculationImp implements PreviousCalculationToCareTaker,PreviousCalculationToOriginator {

    private int firstNumber;
    private int secondNumber;

    @Override
    public int getFirstNumber() {
        return this.firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return this.secondNumber;
    }


    public PreviousCalculationImp(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}
