/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.memento;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:30 2020/7/24
 */
public class Client {

    public static void main(String[] args) {
        //program starts
        Calculator calculator = new CalculatorImp();

        // assume user enters two numbers
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);

        //find Result
        System.out.println(calculator.getCalculationResult());

        //store result of this calculation in case of error
        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();

        //user enters a number
        calculator.setFirstNumber(17);

        //user enters a wrong second number and calculator result
        calculator.setSecondNumber(-290);

        //calculate result
        System.out.println(calculator.getCalculationResult());

        //user hits CTRL + Z to undo last operation and see last result
        calculator.restorePreviousCalculation(memento);

        //result restored
        System.out.println(calculator.getCalculationResult());
    }
}
