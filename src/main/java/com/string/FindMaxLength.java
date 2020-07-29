package com.string;

import java.util.Scanner;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:38 2020/7/1
 */
public class FindMaxLength {

    public static int lengthOfLongestSubstring(String s) {
        //判断字符串是否为空
        if (s.isEmpty()){
            return 0;
        }else{
            //不为空
            //从第一个字符开始，假设1就为最大值
            int max=1;
            int sum=1;
            //获取字符串中第一个字符，将其作为flag
            String s1=""+s.charAt(0);
            if(s.length()==1){
                //判断字符串长度是否为1，为1直接返回1
                return 1;
            }
            for (int i = 1; i < s.length(); i++) {
                //从第二个字符开始遍历
                //判断flag字符中是否还有下一个字符
                if(s1.indexOf(""+s.charAt(i))!=-1){
                    //找到flag字符中含有下一个字符的位置,并截取其后字符的长度
                    int n1=s1.length()-s1.indexOf(""+s.charAt(i))-1;
                    sum=n1+1;
                    //截取原flag其后字符并加上末端的重复字符形成新的flag字符
                    s1=s1.substring(s1.indexOf(""+s.charAt(i))+1,s1.length())+s.charAt(i);
                }else{
                    //flag字符中没有有下一个字符，sum+1并在flag字符中加上下一个字符
                    sum=sum+1;
                    s1=s1+s.charAt(i);
                }
                //当sum>max,替换max
                if(sum>max){
                    max=sum;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
