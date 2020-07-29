/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.build;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:51 2020/7/23
 */
public class Client {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            stringBuilder.append((char) ('a' + i));
        }
        System.out.println(stringBuilder.toString());
    }
}
