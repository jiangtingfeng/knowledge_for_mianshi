package com;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Stack;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 15:20 2020/7/1
 *
 * BitSet 实际是由“ 二进制位”构成的一个 Vector。如果希望高效率地保存大量“开－关”信息，就应使用BitSet。它只有从尺寸的角度看才有意义；如果希望的高效率的访问，那么它的速度会比使用一些固有类型的数组慢一些。
 * BitSet 的最小长度是一个长整数（ Long）的长度： 64 位。这意味着假如我们准备保存比这更小的数据，如 8 位数据，那么 BitSet 就显得浪费了。所以最好创建自己的类，用它容纳自己的标志位。
 */
public class CollectionLearn extends Dictionary{
    /*public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        for (int i= 2; i< 10;i++) {
            bitSet.set(i);
        }
        int i = bitSet.nextSetBit(1);
        System.out.println(i);
        boolean b = bitSet.get(12);
        System.out.println(b);
        System.out.println(bitSet);
    }*/

    static String[] months = { "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November",
            "December" };

    public static void main(String[] args) {
        Stack stk = new Stack();
        for (int i = 0; i < months.length; i++){
            stk.push(months[i] + " ");
        }
        System.out.println("stk = " + stk);
        // Treating a stack as a Vector:
        stk.addElement("The last line");
        System.out.println("element 5 = " + stk.elementAt(5));
        System.out.println("popping elements:");
        while (!stk.empty())
            System.out.println(stk.pop());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Enumeration keys() {

        return null;
    }

    @Override
    public Enumeration elements() {

        return null;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }
}
