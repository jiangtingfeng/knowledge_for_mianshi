package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:12 2020/6/30
 */
public class MultiThread {

    public static void main(String[] args) {
        List<Integer> integers = lexicalOrder(13);
        System.out.println(integers.toString());
    }

    public static List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i + "");
        }
        Collections.sort(list,(o1, o2)->{
            return o1.compareTo(o2);
        });
        List<Integer> iList = new ArrayList<>();
        list.stream().forEach((str)->{
            iList.add(Integer.parseInt(str));
        });
        return iList;
    }

    /*public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println(this);
                    System.out.println("qqqqq!");
                }
            }
        });
        System.out.println(thread);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
                System.out.println("wwwwww!");
            }
        });
        System.out.println(thread1);
        //thread.run();
        //thread1.run();
        thread.start();
        thread1.start();
    }*/
}
