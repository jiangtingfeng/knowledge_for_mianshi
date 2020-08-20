/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 18:19 2020/8/17
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Woker woker = new Woker();
        Work work = (Work)Proxy.newProxyInstance(woker.getClass().getClassLoader(), woker.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o = null;
                try {
                    long start = System.currentTimeMillis();
                    String name = method.getName();
                    System.out.println("执行的方法{"+name+"}"+"参数{" + Arrays.toString(args) + "}");
                    Thread.sleep(1000);
                    o = method.invoke(woker, args);
                    long end = System.currentTimeMillis();
                    System.out.println(end-start);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                return o;
            }
        });
        String jtf = work.doSomething("JTF");
        System.out.println(jtf);
    }
}
