/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.singleton;

/**
 * @Author: jiangtingfeng
 * @Description: 恶汉式
 */
public class Singlonton01 {
    private static Singlonton01 singlonton01 = new Singlonton01();
    private Singlonton01(){}
    public static Singlonton01 getInstance() {
        return singlonton01;
    }
}

/**
 * @Description: TODO
 * 懒汉式 线程不安全
 */
class Singleton02 {
    private static Singleton02 instance;

    private Singleton02(){

    }

    public static  Singleton02 getInstance(){
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}

/**
 * @Description: TODO
 * 线程安全  但是性能会变差
 */
class Singleton03 {
    private static Singleton03 instance;
    private Singleton03(){
    }

    public static synchronized Singleton03 getInstance(){
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}


/**
 * @Description: TODO
 * 线程安全  双重校验锁-线程安全
 */
class Singleton04 {
    private static Singleton04 instance;
    private Singleton04(){
    }

    public static  Singleton04 getInstance(){
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}
/**
 * @Description: TODO
 * 线程安全  静态内部类实现
 */
class Singleton05 {
    private Singleton05(){
    }

    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}

/**
 * @Description: TODO
 * 线程安全  枚举实现
 */
enum Singleton06 {
    INSTANCE;
}










