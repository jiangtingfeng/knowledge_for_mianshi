package com.jvm;

import java.io.IOException;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 15:39 2020/4/28
 */
public class StringLazy {

    public static void main(String[] args) throws IOException {
        String s1 = "a";
        System.in.read();
        System.out.println(s1);
        //java.lang.string.count = 2361
        String s2 = "b";
        System.out.println(s2);
        System.in.read();
        //java.lang.string.count = 2362
        String s3 = "ab";
        System.out.println(s3);
        //java.lang.string.count = 2363
        System.in.read();
    }

}
