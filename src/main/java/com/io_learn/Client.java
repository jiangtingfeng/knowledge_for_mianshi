/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.io_learn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 15:40 2020/8/6
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("你好,service".getBytes());
        outputStream.flush();
        /**
         * 等待回复
         * */
        while (true) {
            int index = -1;
            byte[] bytes = new byte[4*1024];
            while ((index = inputStream.read(bytes)) != -1) {
                String str = new String(bytes);
                System.out.println(str);
            }
        }
    }
}
