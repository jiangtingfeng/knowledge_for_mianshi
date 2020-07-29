package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author: jiangtingfeng
 * @Description: 使用NIO快速複製文件
 * @Date :Create in 15:08  2020/7/3
 */
public class FastCopyFile {

    private static String source = "C:\\Users\\111\\Desktop\\copy\\";
    private static String target = "C:\\Users\\111\\Desktop\\copy1\\";

    public static void main(String[] args) throws IOException {
        File fileDir = new File(source);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File[] files = fileDir.listFiles();
        for (File file:files) {
            String name = file.getName();
            String prifux = name.substring(name.indexOf('.'));
            //生成一个随机的名称的文件
            String nameTarget = System.currentTimeMillis() + prifux;
            String sourcePath = source + name;
            String targetPath = target + nameTarget;
            fastCopyNIO(sourcePath,targetPath);
        }
    }


    //传统方式实现，使用流对象对文件进行copy操作
    public static void fastCopy(String src, String dist) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dist);
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = fis.read(b))!=-1) {
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();
    }


    //使用NIO进行实现
    public static void fastCopyNIO(String src, String dist) throws IOException {
        //使用装饰者模式
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dist);
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        //使用nio需要为缓冲区分配1024个字节
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        //使用channel对象进行文件的copy
        int len = 0;
        while((len = fisChannel.read(byteBuffer)) != -1) {
            //切换读写
            byteBuffer.flip();
            /*把缓冲区的内容写入输出文件中*/
            fosChannel.write(byteBuffer);
            /*清空缓冲区*/
            byteBuffer.clear();
        }
    }

    //创建选择器，将通道注册到选择器上
    public void test() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


}
