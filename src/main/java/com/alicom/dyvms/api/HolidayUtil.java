package com.alicom.dyvms.api;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 18:17 2020/4/26
 */
public class HolidayUtil {


    public static int request( String httpArg) {
        String httpUrl = "http://timor.tech/api/holiday/info/";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + httpArg;
        //工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
        int d=0;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            JSONObject ob= JSONObject.parseObject(result);
            if(ob!=null){
                d=Integer.parseInt(ob.getString("data"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }







    /*public static void main(String[] args) {
        //判断今天是否是工作日 周末 还是节假日
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String httpArg="2019-05-03";
        //f.format(new Date());
        System.out.println(httpArg);
        int n = request(httpArg);
        System.out.println(n);
        //工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
    }*/


    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            map.put("a"+i,"b");
        }
        map.put("b","c");
    }



}
