/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.chainOfResponsibility;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:29 2020/7/23
 */
public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE2) {
            System.out.println(request.getName() + "is handle by ConcreteHandler2");
        } else {
            System.out.println(request.getName() + "is handle by ConcreteHandler1");
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
