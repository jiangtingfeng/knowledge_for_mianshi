package com.alicom.dyvms.api;

import sun.misc.Unsafe;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:58 2020/4/26
 */
public class ArrayTest {


    public static void main(String[] args) {
        String s = "hello world!";
        System.out.println(s);
    }



    public static void test() {
        Unsafe unsafe = Unsafe.getUnsafe();
        long l = unsafe.allocateMemory(1024 * 1024L);
        unsafe.freeMemory(l);
    }
}
