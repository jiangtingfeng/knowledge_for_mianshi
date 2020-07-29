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
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //获取socket
        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8888);
        serverSocket.bind(inetSocketAddress);

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
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
                }
                keyIterator.remove();
            }
        }
    }
    /*private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();
        while (true) {
            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == -1) {
                break;
            }
            //切换模式
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }
*/
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
