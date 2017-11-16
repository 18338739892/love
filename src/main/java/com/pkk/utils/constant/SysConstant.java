package com.pkk.utils.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.utils.constant
 * @Description: <系统常量级>
 * @date 11/2 0002 11:42
 */
public class SysConstant {

    /**
     * 字符集【UTF-8】
     */
    public static final String CHARSET_UTF8      = "UTF-8";
    /**
     * 24小时时间格式
     */
    public static final String DATEFORMAT_24HOUR = "yyyyMMddHHmmss";
    /**
     * 请求方式[get]
     */
    public static final String HTTP_GET          = "get";
    /**
     * 请求方式[post]
     */
    public static final String HTTP_POST         = "post";


    public static String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";


    public static String DB_URL    = "";
    public static String DB_DRIVER = "";
    public static String DB_USER   = "";
    public static String DB_PWD    = "";


    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("love.properties");

        if (inputStream != null) {
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                DB_URL = properties.getProperty("db.url");//数据库连接地址
                DB_DRIVER = properties.getProperty("db.driverClassName");//数据库驱动地址
                DB_USER = properties.getProperty("db.username");//数据库驱动地址
                DB_PWD = properties.getProperty("db.password");//数据库驱动地址


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }


}
