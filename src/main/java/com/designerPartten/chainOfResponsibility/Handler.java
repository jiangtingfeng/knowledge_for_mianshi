/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.chainOfResponsibility;



/**
 * @Author: jiangtingfeng
 * @Description: 行为型
 * 责任链
 * @Date :Create in 10:18 2020/7/23
 */
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);
}
