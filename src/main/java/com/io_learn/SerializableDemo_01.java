/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.io_learn;

import java.io.*;

/**
 * @Author: jiangtingfeng
 * @Description:
 *  transient
 *      transient 关键字可以使一些属性不会被序列化。
 *
 * ArrayList 中存储数据的数组 elementData 是用 transient 修饰的，因为这个数组是动态扩展的，
 * 并不是所有的空间都被使用，因此就不需要所有的内容都被序列化。
 * 通过重写序列化和反序列化方法，使得可以只序列化数组中有内容的那部分数据。
 *
 * @Date :Create in 14:37 2020/8/6
 */
public class SerializableDemo_01 {

    private static String filePath = "C:\\Users\\111\\Desktop\\近期任务.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        T t = new T(1,"job");
        System.out.println(t);
        /**
         * 进行对象的序列化
         * */
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(t);
        T.z = 100;
        t.x = 100;
        /**
        * 进行对象的反序列化
        * */
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T t1 = (T)objectInputStream.readObject();
        System.out.println(t1);


        /**
         * 关闭资源
         * */
        fileOutputStream.close();
        fileInputStream.close();
        objectInputStream.close();
        objectOutputStream.close();

    }


    private static class T implements Serializable{
        private static int z = 1;
        private transient int x;
        private String y;
        T(int x,String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString()  {
            return "x = " + x + " "  + "y = " + y + " " +"z = " + z;
        }
    }
}

