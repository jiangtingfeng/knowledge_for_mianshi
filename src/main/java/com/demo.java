package com;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:21 2020/7/3
 */
public class demo {

    public static void main(String[] args) {
        int add = Add(10, 11);
        System.out.println(add);
    }
    public static int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
}
