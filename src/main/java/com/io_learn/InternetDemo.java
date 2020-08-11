/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.io_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: jiangtingfeng
 * @Description:  网络编程    ------ 网络操作
 * 可以直接从URL中读取字节流数据
 * @Date :Create in 15:01 2020/8/6
 */
public class InternetDemo {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        /** 字节流*/
        InputStream is = url.openStream();

        /** 字符流*/
        InputStreamReader isr = new InputStreamReader(is,"utf-8");

        /** 提供缓存功能*/
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

}
