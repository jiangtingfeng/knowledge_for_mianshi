/**
 * app315.net Inc.
 * Copyright (c) 2005-2020 All Rights Reserved.
 */
package com.safeThread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 11:25 2020/7/28
 */
public class ImmutableExample {

    public static void main(String[] args) {
        Map<String,Integer> map =  new HashMap<>();
        Map<String, Integer> stringIntegerMap = Collections.unmodifiableMap(map);
        map.put("a",1);
        System.out.println(map.get("a"));
    }
}
