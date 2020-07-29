/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.build;

import java.util.Arrays;

/**
 * @Author: jiangtingfeng
 * @Description:  参考JDK1.8  实现一个简易的StringBuilder
 * @Date :Create in 9:36 2020/7/23
 */
public class AbstractStringBuilder {

    protected char[] value;
    protected int count;

    /**
     *  构造方法
     * */
    public AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    /**
     * 尾加元素
     * */
    public AbstractStringBuilder append(char c) {
        ensureCapacityInternal(count + 1);
        value[count++] = c;
        return this;
    }

    /**
     * 判断是否需要进行扩容
     * */
    private void ensureCapacityInternal(int minimumCapacity) {
        if (minimumCapacity - value.length > 0) {
            expandCapacity(minimumCapacity);
        }
    }

    /**
     * 扩容
     * */
    private void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0) {
            newCapacity = minimumCapacity;
        }
        if (newCapacity < 0) {
            if (minimumCapacity < 0) {
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value,newCapacity);
    }

}
