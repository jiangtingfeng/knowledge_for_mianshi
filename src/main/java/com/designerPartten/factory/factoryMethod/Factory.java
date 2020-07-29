/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.factory.factoryMethod;

import com.designerPartten.factory.item.Product;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:24 2020/7/23
 */
public abstract class Factory {

    abstract public Product factoryMethod();
    public void doSomething() {
        Product product = factoryMethod();
        // do something with the product
    }

}
