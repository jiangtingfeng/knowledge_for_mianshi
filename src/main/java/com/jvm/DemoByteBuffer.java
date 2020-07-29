package com.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 16:00 2020/4/28
 */
public class DemoByteBuffer {

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while(true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100*1024*1024);
                list.add(byteBuffer);
                i++;
            }
        }finally {
            System.out.println(i);
        }
    }

}
