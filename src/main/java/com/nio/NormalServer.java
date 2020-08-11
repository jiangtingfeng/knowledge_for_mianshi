package com.nio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 16:40 2020/7/3
 */
public class NormalServer {
    //模拟普通的服务器端
    public static void main(String[] args) throws IOException {
        //监听10088端口
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 10088);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(address);
        //获取一个请求
        Socket accept = null;
        //使用多线程对客户端进行监听一直处于监听状态
        while (true) {
            accept = serverSocket.accept();
            if (accept != null) {
                InputStream inputStream = accept.getInputStream();
                Socket finalAccept = accept;
                new Thread(new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        try {
                            byte[] b = new byte[1024];
                            inputStream.read(b);
                            System.out.println(new String(b));
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            finalAccept.close();
                        }
                    }
                }).start();
            }
        }
    }
}
