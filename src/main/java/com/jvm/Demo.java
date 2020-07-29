package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:36 2020/4/28
 */
public class Demo {

    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        }catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
