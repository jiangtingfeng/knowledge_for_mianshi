/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.io_learn;

import java.io.UnsupportedEncodingException;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:17 2020/8/6
 */
public class StringUtils {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "中文";

        /*byte[] bytes = str1.getBytes("UTF-8");
        String str2 = new String(bytes, "UTF-8");*/
        byte[] bytes = str1.getBytes();
        String str2 = new String(bytes);
        System.out.println(str2);
    }



}
