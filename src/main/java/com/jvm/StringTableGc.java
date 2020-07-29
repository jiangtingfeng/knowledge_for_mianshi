package com.jvm;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 15:53 2020/4/28
 */
public class StringTableGc {

    public static void main(String[] args) throws  InterruptedException{
        int i = 0;
        try {
            for (int j = 0;j< 10000; j++){
                String.valueOf(j).intern();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println();
        }
    }

}
