package com.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 16:52 2020/7/3
 */
public class NormalClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10088);
        OutputStream outputStream = socket.getOutputStream();
        String message = "hello,server!";
        byte[] bytes = message.getBytes("utf-8");
        outputStream.write(bytes);
        outputStream.close();
    }
}
