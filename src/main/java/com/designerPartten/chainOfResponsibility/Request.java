/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.designerPartten.chainOfResponsibility;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:28 2020/7/23
 */
public class Request {

    private RequestType type;
    private String name;


    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }


    public RequestType getType() {
        return type;
    }


    public String getName() {
        return name;
    }

}
