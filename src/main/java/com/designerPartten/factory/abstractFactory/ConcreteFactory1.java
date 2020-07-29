/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.factory.abstractFactory;

import com.designerPartten.factory.item.ConcreteProduct;
import com.designerPartten.factory.item.ConcreteProduct1;
import com.designerPartten.factory.item.Product;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:27 2020/7/23
 */
public class ConcreteFactory1 extends  Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
