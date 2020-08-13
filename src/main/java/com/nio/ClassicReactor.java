/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 15:57 2020/8/11
 */
public class ClassicReactor {

    private final Integer MAXIN = 4096;
    private final Integer MAXOUT = 4096;
    class Reactor implements Runnable {

        final Selector selector;
        final ServerSocketChannel serverSocketChannel;

        Reactor(int port) throws IOException {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            register.attach(new Acceptor());
        }

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                try {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        dispatch(next);
                    }
                    selectionKeys.clear();
                } catch (IOException e) {
                }
            }
        }

        private void dispatch(SelectionKey next) {
            Runnable r = (Runnable) next.attachment();
            if (r != null) {
                r.run();
            }
        }
        /** class Reactor continued*/
        class Acceptor implements Runnable {  // inner
            @Override
            public void run() {
                SocketChannel accept = null;
                try {
                    accept = serverSocketChannel.accept();
                    if (accept != null) {
                        new Handler(accept,selector);
                    }
                } catch (IOException e) {

                }
            }
        }
    }
    final class Handler implements Runnable {
        final SocketChannel socketChannel;
        final SelectionKey key;
        ByteBuffer input = ByteBuffer.allocate(MAXIN);
        ByteBuffer output = ByteBuffer.allocate(MAXOUT);
        static final int READING = 0, SENDING = 1;
        int state = READING;

        public Handler(SocketChannel socketChannel, Selector selector) throws IOException {
            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            //Optionally try first read now
            key = socketChannel.register(selector, 0);
            key.attach(this);
            key.interestOps(SelectionKey.OP_READ);
            selector.wakeup();
        }
        /** 是否完成读*/
        boolean inputIsComplete() {
            return false;
        }
        /** 是否完成写*/
        boolean outputIsComplete() {
            return false;
        }
        /** 业务操作*/
        void process() {

        }
        /** class Handler continued*/
        @Override
        public void run() {
            /*try {
                if (state == READING) {
                    read();
                } else if (state == SENDING) {
                    send();
                }
            } catch (Exception e) {
            }*/
            try {
                socketChannel.read(input);
                if (inputIsComplete()) {
                    process();
                    key.attach(new Sender());
                    key.interestOps(SelectionKey.OP_WRITE);
                    key.selector().wakeup();
                }
            } catch (IOException e) {
            }

        }

        private void send() throws IOException {
            socketChannel.write(output);
            if (outputIsComplete()) {
                key.cancel();
            }
        }

        private void read() throws IOException {
            socketChannel.read(input);
            if (inputIsComplete()) {
                process();
                state = SENDING;
                //Normally also do first write now
                key.interestOps(SelectionKey.OP_WRITE);
            }
        }

        /** 发送方法处理*/
        class Sender implements Runnable {
            @Override
            public void run() {
                try {
                    socketChannel.write(output);
                    if (outputIsComplete()) {
                        key.cancel();
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}
