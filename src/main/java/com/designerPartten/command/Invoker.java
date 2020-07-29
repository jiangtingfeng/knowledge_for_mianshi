/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.command;

/**
 * @Author: jiangtingfeng
 * @Description:  遥控进行调用
 * @Date :Create in 12:21 2020/7/23
 */
public class Invoker {
    /**
     * 初始化操作队列
     * */
    private Command[] onCommands;
    private Command[] offCommands;
    private final int slotNum = 7;

    public Invoker() {
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }
    public void setOnCommand(Command command, int slot) {
        onCommands[slot] = command;
    }

    public void setOffCommand(Command command, int slot) {
        offCommands[slot] = command;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].excute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].excute();
    }

}
