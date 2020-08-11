package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: jiangtingfeng
 * @Description: 模拟nio服务器端
 * @Date :Create in 17:27 2020/7/3
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //建立选择器
        Selector selector = Selector.open();
        //获取serverSocketChannel的通道/并对相关参数进行设置/以及将socket的channel的注册到选择器上进行绑定
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        //将选择器注册到ServerSocketChannel中/可以指定相应的操作参数
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //获取socket
        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8888);
        serverSocket.bind(inetSocketAddress);

        while (true) {
            /** 使用selector.select() 来监听到达的事件，他会一直阻塞直到有至少一个事件到达*/
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                keyIterator.remove();
                //分发事件
                SelectionKey key = keyIterator.next();
                dispatch(key,selector);
            }
        }
    }

    private static void dispatch(SelectionKey key,Selector selector) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();
            // 服务器会为每个新连接创建一个 SocketChannel
            SocketChannel sChannel = ssChannel1.accept();
            sChannel.configureBlocking(false);
            // 这个新连接主要用于从客户端读取数据
            sChannel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel sChannel = (SocketChannel) key.channel();
            System.out.println(readDataFromSocketChannel(sChannel));
            sChannel.close();
        } else if (key.isWritable()) {
            SocketChannel sChannel = (SocketChannel) key.channel();
            System.out.println(writeDataFromSocketChannel(sChannel));
            sChannel.close();
        }
    }

    private static String writeDataFromSocketChannel(SocketChannel sChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        byte[] bytes = str.getBytes();
        byteBuffer.put(bytes);
        sChannel.write(byteBuffer);
        return str;
    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        StringBuffer dataStr = new StringBuffer();
        int len = 0;
        while ((len = sChannel.read(byteBuffer)) != -1) {
            int limit = byteBuffer.limit();
            char[] chars = new char[limit];
            for (int i=0; i<limit; i++) {
                chars[i] = (char) byteBuffer.get(i);
            }
            dataStr.append(chars);
            byteBuffer.clear();
        }
        return dataStr.toString();
    }
}
