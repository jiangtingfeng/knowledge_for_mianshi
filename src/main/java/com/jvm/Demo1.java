package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:36 2020/4/28
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Integer _10mb = 1024 * 1024 * 10;
        System.out.println("1......");
        Thread.sleep(30000);
        byte[] bytes = new byte[_10mb];
        System.out.println("2.......");
        Thread.sleep(30000);
        bytes = null;
        System.gc();
        System.out.println("3...");
        Thread.sleep(100000L);
    }
}
