/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.build;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:49 2020/7/23
 */
public class StringBuilder extends AbstractStringBuilder {
    /**
     * 构造方法
     *
     *
     */
    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(value,0,count);
    }

}
