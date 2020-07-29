/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.synchronized_ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 11:41 2020/7/28
 */
public class AtomicIntegerExample {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        atomicInteger.getAndAdd(12);
        System.out.println(i);
    }
}
