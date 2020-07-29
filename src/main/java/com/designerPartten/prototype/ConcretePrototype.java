/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.prototype;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:01 2020/7/23
 */
public class ConcretePrototype extends Prototype {

    private String field;

    @Override
    Prototype myClone() {
        return new ConcretePrototype(field+"cde");
    }

    public ConcretePrototype(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "field='" + field + '\'' +
                '}';
    }

}
