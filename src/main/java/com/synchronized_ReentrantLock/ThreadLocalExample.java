/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.synchronized_ReentrantLock;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:55 2020/7/28
 */
public class ThreadLocalExample {


    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(()->{
           threadLocal.set(1);
           try {
               Thread.sleep(1000L);
           }catch (Exception e) {
               e.printStackTrace();
           }
            System.out.println(threadLocal.get());
           threadLocal.remove();
        });

        Thread thread = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread.start();
        thread1.start();

    }


}
