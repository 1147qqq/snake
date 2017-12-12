package com.dyz.persist.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.ResolverUtil.Test;

public class TjUtil {

    /**
     * 获取唯一的32位字符串
     * 
     * @return
     */
    public static String getUUID() {
        String str = UUID.randomUUID().toString();
        // 去掉"-"符号
        String uuid = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return uuid;
    }

    /**
     * 获取当前日期，日期格式为yyyy-MM-dd
     * 
     * @return 日期格式为yyyy-MM-dd。例如：2016-08-17
     */
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间，时间格式为yyyy-MM-dd
     * 
     * @return 时间格式为yyyy-MM-dd HH:mm:ss。例如：2016-08-17 11:39:20
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间，时间格式为yyyy-MM-dd
     * 
     * @return 时间格式为yyyy-MM-dd HH:mm:。例如：2016-08-17 11:39
     */
    public static String getDataTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date());
    }

    /**
     * 读取配置文件
     * 
     * @param filePath
     *            配置文件路径
     * @param key
     *            键名
     * @return 键值
     */
    public static String readPropertiesValue(String filePath, String key) {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(TjUtil.class.getClassLoader()
                    .getResourceAsStream(filePath), "UTF-8"));
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 读取properties的全部信息
    public static List<String> readPropertiesKeys(String filePath) {
        Properties props = new Properties();
        List<String> propKeys = new ArrayList<String>();
        try {
            props.load(new InputStreamReader(TjUtil.class.getClassLoader()
                    .getResourceAsStream(filePath), "UTF-8"));
            Enumeration en = props.propertyNames();
            // 在这里遍历
            while (en.hasMoreElements()) {
                String key = en.nextElement().toString();// key值
                propKeys.add(key);
            }
            return propKeys;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 格式化数字(不四舍五入)
     * 
     * @param number
     *            要格式化的数字
     * @param decimalNumber
     *            需要保留的小数位数。1保留一位小数，2保留两位小数，0为没有小数，返回整数。
     * @return 格式化后的数字
     */
    public static String getFormatNumber(String number, int decimalNumber) {
        String formatNumber = "";
        // 格式化后小数位大于0
        if (decimalNumber > 0) {
            // 原数字有小数点
            if (number.indexOf(".") > -1) {
                String numberDec = number.substring(number.indexOf(".") + 1);
                // 小数位少
                if (numberDec.length() < decimalNumber) {
                    int zeroNum = decimalNumber - numberDec.length();
                    for (int i = 0; i < zeroNum; i++) {
                        numberDec += "0";
                    }
                    // 小数位多
                } else {
                    numberDec = numberDec.substring(0, decimalNumber);
                }
                formatNumber = number.substring(0, number.indexOf(".")) + "."
                        + numberDec;
                // 原数字没有小数点
            } else {
                formatNumber = number + ".";
                for (int i = 0; i < decimalNumber; i++) {
                    formatNumber += "0";
                }
            }
            // 格式化后小数位小于0
        } else {
            // 原数字有小数点
            if (number.indexOf(".") > -1) {
                formatNumber = number.substring(0, number.indexOf("."));
                // 原数字没有小数点
            } else {
                formatNumber = number;
            }
        }
        return formatNumber;
    }

    /**
     * 将xml字符串转换为JSON字符串
     * 
     * @param xml
     *            xml字符串
     * @return JSON字符串
     */
    public static String getJSONFromXml(String xmlString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xmlString);
        return json.toString();
    }

    /**
     * http请求POST方式
     * 
     * @param requestUrl
     *            请求URL
     * @param json
     *            数
     * @return String JSON格式请求参
     */
    public static String post(String requestUrl, String json) {
        URL url;
        try {
            url = new URL(requestUrl);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(json.getBytes("UTF-8"));// 传入参数
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String result = new String(jsonBytes, "UTF-8");
            os.flush();
            os.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 日期时间字符串转换为时间
     * 
     * @param dateTime
     *            yyyy-MM-dd HH:mm:ss
     * @return java.util.Date
     */
    public static Date getDateFromDateTime(String dateTimeStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期字符串转换为日期
     * 
     * @param dateTime
     *            yyyy-MM-dd
     * @return java.util.Date
     */
    public static Date getDateFromDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取日期天数差
     * 
     * @param dateBeforeStr
     *            yyyy-MM-dd
     * @param dateAfterStr
     *            yyyy-MM-dd
     * @return 相差天数
     */
    public static int getDateCha(String dateBeforeStr, String dateAfterStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int days = 0;
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(sdf.parse(dateBeforeStr));
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(sdf.parse(dateAfterStr));
            long l = cal2.getTimeInMillis() - cal1.getTimeInMillis();
            days = new Long(l / (1000 * 60 * 60 * 24)).intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获取日期分钟差
     * 
     * @param dateBeforeStr
     *            yyyy-MM-dd HH:mm 之前的时间
     * @param dateAfterStr
     *            yyyy-MM-dd HH:mm 之后的时间（当前时间）
     * @return 相差分钟数
     * @throws ParseException
     */
    public static int getMMFromDateTime(String dateBeforeStr,
            String dateAfterStr) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");// 如2016-08-10
                                                                                 // 20:40
        long from = simpleFormat.parse(dateBeforeStr).getTime();
        long to = simpleFormat.parse(dateAfterStr).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        return minutes;
    }

    /**
     * 获取订单ID
     * 
     * @return String
     */
    public static String getOrderId() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmm");
        String datetime = formatter.format(currentTime);
        StringBuffer sb = new StringBuffer(datetime);
        sb.append((int) (Math.random() * 900 + 100));
        SimpleDateFormat ft = new SimpleDateFormat("S");
        String mi = ft.format(currentTime);
        if (mi.length() == 1) {
            mi += "00";
        }
        if (mi.length() == 2) {
            mi += "0";
        }
        sb.append(mi);
        return sb.toString();
    }

    /**
     * 获取订单ID
     * 
     * @return String 含有大写字母的随机订单
     */
    public static String getOrderNum() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String datetime = formatter.format(currentTime);
        long aString = Calendar.getInstance().getTimeInMillis();
        String str = "";
        for (int i = 0; i < 3; i++) {// 你想生成几个字符的，就把3改成几，如果改成１,那就生成一个随机字母．
            str = str + (char) (Math.random() * 26 + 'A');
        }
        String sb = datetime + aString + str;
        return sb;
    }

    public static String randomString(int length) {
        String str = new BigInteger(130, new SecureRandom()).toString();
        return str.substring(0, length);
    }

    /**
     * 复制单个文件
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf.txt
     * @param newPath
     *            String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }

    /**
     * 复制整个文件夹内容
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf
     * @param newPath
     *            String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public static void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath
                            + "/" + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {// 如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }

    }

    /**
     * 获取访问者IP
     * 
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     * 
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     * 
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public static void main(String[] args) {

        String st = "50.21";
       Float float1= Float.valueOf(st);
       int a=(int)(float1*100);
       System.out.println(a);

    }

}
