/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.iterator;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:11 2020/7/23
 */
public interface Iterator<Item> {
    Item next();
    boolean hasNext();
}
