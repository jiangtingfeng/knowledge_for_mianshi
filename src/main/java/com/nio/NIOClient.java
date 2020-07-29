package com.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 17:43 2020/7/3
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes("utf-8"));
        out.close();
    }
}
