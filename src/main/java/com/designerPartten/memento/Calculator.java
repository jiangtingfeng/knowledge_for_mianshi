/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.memento;

/**
 * @Author: jiangtingfeng
 * @Description: 备忘录模式  计算机类
 * @Date :Create in 9:15 2020/7/24
 */
public interface Calculator {

    /** create memento */
    PreviousCalculationToCareTaker backupLastCalculation();

    /** setMemento*/
    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);

}
