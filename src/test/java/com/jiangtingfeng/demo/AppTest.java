package com.jiangtingfeng.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private Queue<String> data = new LinkedList<String>();

    //文章页面 https://www.psy525.cn/art/18290.html
    String PAGE = "/art/[0-9]+.html";

    Pattern p = Pattern.compile(PAGE);

    @Test
    public void catchTest() {
        /*try {
            action("https://www.psy525.cn/art/18290.html");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //文章的起始页
        String startPage = "https://www.psy525.cn/art/index.html";
        data.add(startPage);
        //列表页面，文章的第N页
        String page = "https://www.psy525.cn/art/index_";
        //总页数
        int total =440;
        for (int i = 2; i <= total+1; i++) {
            data.add(page+(i-1)*10+".html");
        }
        while (!data.isEmpty()) {
            try {
                action(data.poll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void action(String target) throws Exception {
        Matcher m = p.matcher(target);
        //校验是否是文章页面
        if (m.find()) {
            URL url = new URL(target);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream in = connection.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            //分割url,把文章的编号作为文件的名称
            String[] bufen = target.split("/");
            String name = bufen[bufen.length - 1];
            name = name.replaceAll("html", "txt");
            File file = new File("D:\\article", name);
            FileOutputStream fp = new FileOutputStream(file);
            while ((len = in.read(buf)) != -1) {
                fp.write(buf, 0, len);
            }
            fp.close();
        }
        //如果是列表页面
        //抽取里面的文章页面连接
        else {
            URL url = new URL(target);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream in = conn.getInputStream();
            byte[] buf = new byte[1024];
            //把列表页的内容放到ByteArrayOutputStream中
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                //System.out.println(len);
                outStream.write(buf, 0, len);
            }
            in.close();
            outStream.close();
            String content = new String(outStream.toByteArray());
            //System.out.println(content);
            Matcher matcher = p.matcher(content);
            //System.out.println(matcher.find());
            //抽取文章的url
            while (matcher.find()) {
                //将抽取的文章url进队
                String group = matcher.group();
                String urlString = "https://www.psy525.cn"+group;
                //System.out.println(group);
                data.add(urlString);
            }
        }
    }

    @Test
    public void test() {
        int i = 20;
        System.out.println(i%20 == 0 ? i%20 : i/20 + 1);
    }

    @Test
    public void test1() {
        Set<String> set =new HashSet<>();
        for (int i=1; i< 10; i++) {
            boolean add = set.add(1 + "");
            System.out.println(add);
        }
    }
}
