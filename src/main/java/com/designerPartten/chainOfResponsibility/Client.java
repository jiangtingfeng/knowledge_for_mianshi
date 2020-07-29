/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.chainOfResponsibility;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:34 2020/7/23
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Request request1 = new Request(RequestType.TYPE1,"request1");
        handler1.handleRequest(request1);
        Request request2 = new Request(RequestType.TYPE2,"request2");
        handler2.handleRequest(request2);
    }
}
