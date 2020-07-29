package com.ints;

import java.util.LinkedList;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:15 2020/7/6
 */
public class findFriends {
    public static void main(String[] args) {
        int[] b= {17,4,1,8,12};
        getFriend(b);
    }
    //控制时间复杂度
    public static int[] getFriend(int[] b) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] a = new int[b.length];
        linkedList.addFirst(a[0]);
        for (int i=1; i<b.length; i++) {
            Integer first = linkedList.getFirst();
            if (a[i] > first.intValue()) {
                a[i-1] = 1;
                linkedList.removeFirst();
                linkedList.addFirst(a[i]);
            } else {
                linkedList.addFirst(a[i]);
                a[i-1]++;
            }
        }
        a[b.length-1] = 0;
        return a;
    }
}
