/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.io_learn;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 15:29 2020/8/6
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                60,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket accept = serverSocket.accept();
            if (accept != null) {
                /**
                 * 使用线程池
                 * */
                threadPoolExecutor.submit(new Handler(accept));
            }
        }

    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    static class Handler implements Runnable {
        Socket accept;

        public Handler(Socket socket) {
            this.accept = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = accept.getInputStream();
                int cnt = -1;
                byte[] buffer = new byte[4*1024];
                while ((cnt = inputStream.read(buffer)) != -1) {
                    String str = new String(buffer);
                    System.out.println(str);
                }
                //可以进行消息的回复
                String input = getInput();
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write(input.getBytes());
                outputStream.flush();
            } catch (Exception e ) {
                e.printStackTrace();
            } finally {
                if (accept != null) {
                    try {
                        accept.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
