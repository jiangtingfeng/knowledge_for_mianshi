package com.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:36 2020/4/28
 */
public class Demo3 extends ClassLoader {

    public static  void main(String[] args) throws InterruptedException {
        int j = 0;
        try {
            Demo3 test = new Demo3();
            for (int i = 0; i < 10000; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                //版本号 public ；类名  包名 父类 接口
                classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                byte[] code = classWriter.toByteArray();
                //执行类的加载
                test.defineClass("Class" + i, code, 0, code.length);
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(j);
        }
    }
}