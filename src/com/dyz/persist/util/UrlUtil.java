package com.dyz.persist.util;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 
 * 
 * UrlUtil
 * 创建人:tj
 * 时间：2017年3月14日-下午7:22:29 
 * @version 1.0.0
 *根据传来的链接地址去获取链接里的json数据
 *
 */

public class UrlUtil {
	  private String name;
	    private static HttpURLConnection connection = null;
     static String httpRequestPost(String path,String post){
    	URL url = null;
    try {
        url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");// 提交模式
        // conn.setConnectTimeout(10000);//连接超时 单位毫秒
        // conn.setReadTimeout(2000);//读取超时 单位毫秒
        // 发送POST请求必须设置如下两行
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
        // 发送请求参数
        printWriter.write(post);//post的参数 xx=xx&yy=yy
        // flush输出流的缓冲
        printWriter.flush();
        //开始获取数据
        BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len;
        byte[] arr = new byte[1024];
        while((len=bis.read(arr))!= -1){
            bos.write(arr,0,len);
            bos.flush();
        }
        bos.close();
        return bos.toString("utf-8");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }

    public static void main(String[] args){
    	String content = Post("http://api.map.baidu.com/geodata/v3/poi/create", ""+"&latitude=34.763150469433&longitude=113.7784727538&coord_type=1&nickname=网页那个叫&url=12321");
    		
    	System.out.println(content);
    }
    /**
     * 
     * @param url
     * @param msg post的参数 xx=xx&yy=yy
     * @return
     */
    public static String Post(String url,String msg){
    	return httpRequestPost(url,msg);
    }
    /**
     * 
     * @param url
     * @param msg GET的参数 xx=xx&yy=yy
     * @return
     */
    public static String GET(String url,String msg){
    	return httpRequest(url+"?"+msg);
    }
     static String httpRequest(String url){
    String content = "";
    try{
    URL u = new URL(url);
    connection = (HttpURLConnection)u.openConnection();
    connection.setRequestMethod("GET");
    int code = connection.getResponseCode();
    if(code == 200){
    InputStream in = connection.getInputStream();
    InputStreamReader isr = new InputStreamReader(in,"utf-8");
    BufferedReader reader = new BufferedReader(isr);
    String line = null;
    while((line = reader.readLine()) != null){
    content += line;
    }
    }
    }catch(MalformedURLException e){
    e.printStackTrace();
    }catch(IOException e){
    e.printStackTrace();
    }finally{
    if(connection != null){
    connection.disconnect();
    }
    }
    return content;
    }
    
}
