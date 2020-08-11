/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: jiangtingfeng
 * @Description:
 *    大多数异常处理都来自代码示例
 *     对client和server 进行的连接  进行分阶段处理   分而自治
 *
 * @Date :Create in 15:14 2020/8/11
 */
public class ClassicServerSocker {

    private static final Integer MAX_INPUT = 4096;
    private final Integer PORT = 8888;

    class Server implements Runnable{
        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
            } catch (IOException e) {
            }
        }
    }

    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            byte[] bytes = new byte[MAX_INPUT];
            try {
                /** 将client的信息读取到字节数组中*/
                socket.getInputStream().read(bytes);
                /** 1.传入字节数组
                 *  2.收到client的信息  进行处理
                 *  3.服务器将处理后的结果信息已字节数组的信息返回
                 *  4.将server服务器端的返回信息返还给client端
                 *  5.使用sockert.getOutputStream.write(byte[] b)进行返回;
                 *  */
                byte[] output = process(bytes);

                socket.getOutputStream().write(output);
            } catch (IOException e) {
            }
        }
        /**
         * 1.业务处理方法
         * */
        private byte[] process(byte[] bytes) {
            return new byte[0];
        }
    }
}

