package com.jvm;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 16:03 2020/4/28
 */
public class RootSearch {
    private final static Integer _4MB = 1024 * 1024 * 4;
    public static void main(String[] args) throws  InterruptedException , IOException {
        /*List<byte[]> list1 = new ArrayList<>();
        for (int i = 0;i < 5;i++){
            list1.add(new byte[_4MB]);
        }*/
//        soft();
//        weak();
        test();
    }


    /**
     * @Description: TODO  软引用
     */
    public static  void soft(){
        List<SoftReference<byte[]>> list = new ArrayList<>();
        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0;i < 5;i++){
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        Reference<? extends byte[]> poll = queue.poll();
        while(poll !=null){
            list.remove(poll);
            poll = queue.poll();
        }
        System.out.println("循环结束,"+ list.size());
        for (SoftReference<byte[]> ref:list){
            System.out.println(ref.get());
        }
    }


    public static  void weak(){
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> ref1:list){
                System.out.print(ref1.get()+" ");
            }
            System.out.println();
        }
    }


    public  static void test() {
        Long i = 2L;
        System.out.println(i.toString());
        System.out.println(String.valueOf(i));
    }

}
