package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:36 2020/4/28
 */
public class Demo2 {

    public static  void main(String[] args) throws InterruptedException {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 200;i++){
            list.add(new Student());
        }
        Thread.sleep(10000000000L);
    }
}

class Student{
    private byte[] big = new byte[1024 * 1024];
}