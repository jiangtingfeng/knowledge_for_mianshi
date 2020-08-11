/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.io_learn;

import java.io.*;

/**
 * @Author: jiangtingfeng
 * @Description:
 *  磁盘操作
 *  File 类可以用于表示文件和目录的信息，但是它不表示文件的内容。
 * @Date :Create in 13:43 2020/8/6
 */
public class FileUtils {

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
        }
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                listAllFiles(file);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //listAllFiles(new File("D:\\Program Files (x86)"));

        //copyFile("D:\\test\\4.png","D:\\test1\\40.png");
        readFileContent("C:\\Users\\111\\Desktop\\t_train_remember_system.sql");
    }


    /** 实现文件赋值功能*/
    public static void copyFile(String src,String dist) throws IOException {

        /**
         * 准备输入和输出流
         * */
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        /** 进行赋值*/
        int cnt = -1;
        byte[] buffer = new byte[20*1024];
        while ((cnt = in.read(buffer)) != -1) {
            out.write(buffer,0,cnt);
        }

        /**
         * 资源关闭
         * */
        in.close();
        out.close();
    }



    public static void readFileContent(String filePath) throws IOException {
        /**
         * 准备 字符读读取流
         * */
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        /**
         * 读取字符  输出字符
         * */
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        /** 关闭资源*/
        bufferedReader.close();
    }

}
