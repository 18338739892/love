package com.pkk.utils.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.net.SMTPAppender;

import com.pkk.utils.constant.SysConstant;

import static com.pkk.utils.constant.SysConstant.DB_DRIVER;
import static org.apache.struts2.interceptor.DateTextFieldInterceptor.DateWord.m;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.utils.common
 * @Description: <>
 * @date 11/15 0015 16:01
 */
public class LoggerUtil {

    public static Logger getLogger(String baseMsg, String fileName) {
        String outCharSet = "UTF-8";//日志输出编码
        //[JVM在启动的时候，会将环境变量，转换到 系统属性 里面。可以通过System.getProperty(""); 来获取。catalina.home属性，就是运行tomcat的JVM的系统属性之一。一般是由操作系统的环境变量CATALINA_HOME转换而来。如果操作系统没有设置，tomcat会采用默认设置来填充该内容。]
        String tomcatPath = System.getProperty("catalina.home");//Tomcat的路径[需要运行时有效]

        if (tomcatPath == null || "".equals(tomcatPath)) {
            tomcatPath = "D:\\Program Files\\apache-tomcat-8.0.39";//[服务器非启动的时候才用默认的地址]
        }


        String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String finalPath = tomcatPath + File.separator + "log" + File.separator + "lovelog" + File.separator + nowDate;//日志绝对路径
        fileName = fileName + ".love";//设置日志后缀名

        //设置布局
        String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss:SSS}-%p，%F，%L行: " + baseMsg + "-%m%n";//布局格式
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern(conversionPattern);

        //设置输出到文件，并按指定大小滚动
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setEncoding(outCharSet);//输出编码
        rollingFileAppender.setFile(finalPath + File.separator + fileName);/////设置输出文件
        rollingFileAppender.setLayout(patternLayout);//设置布局方式
        rollingFileAppender.setBufferSize(1 * 1024 * 1024);        //文件流缓存1M
        rollingFileAppender.setMaximumFileSize(5 * 1024 * 1024);    //达到5M滚动一个新文件
        rollingFileAppender.setMaxBackupIndex(50);                    //设置文件最大数量
        rollingFileAppender.activateOptions();                        //激活配置

        //输出到控制台
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(patternLayout);
        consoleAppender.setEncoding(outCharSet);
        consoleAppender.activateOptions();
        consoleAppender.setEncoding(outCharSet);


        Logger logger = Logger.getLogger(fileName);
        logger.removeAllAppenders();
        logger.setLevel(Level.INFO);//设定Logger级別
        //[它是 子Logger 是否继承 父Logger 的 输出源（appender） 的标志位。具体说，默认情况下子Logger会继承父Logger的appender，也就是说子Logger会在父Logger的appender里输出。若是additivity设为false，则子Logger只会在自己的appender里输出，而不会在父Logger的appender里输出。]
        logger.setAdditivity(false);//当某个logger的logging request(即printing method(error(),info()..))的级别高于或者等于该logger的级别(即在log4j.properties或者log4j.xml中定义)的时候，该logging request就为enable.一旦该logger的logging request为enable，那么该logging request将总会打印到该logger所有的appender中包括它的所有父logger的appender。（而不会管父logger的级别如何）。除非该logger的父logger的additivity设置为false，默认的情况下为true。某个logger的additivity设置为false，表示log只打印到本log的appender中，而不再打印到其父logger的appender。
        logger.addAppender(rollingFileAppender);
        logger.addAppender(consoleAppender);    //生产环境不向控制台输出
        return logger;
    }


    public static Logger getEmail(String baseMsg) {
        String outCharSet = "UTF-8";//日志输出编码
        String fileName = "";
        //[JVM在启动的时候，会将环境变量，转换到 系统属性 里面。可以通过System.getProperty(""); 来获取。catalina.home属性，就是运行tomcat的JVM的系统属性之一。一般是由操作系统的环境变量CATALINA_HOME转换而来。如果操作系统没有设置，tomcat会采用默认设置来填充该内容。]
        String tomcatPath = System.getProperty("catalina.home");//Tomcat的路径[需要运行时有效]
        if (tomcatPath == null || "".equals(tomcatPath)) {
            tomcatPath = "D:\\Program Files\\apache-tomcat-8.0.39";//[服务器非启动的时候才用默认的地址]
        }
        String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String finalPath = tomcatPath + File.separator + "log" + File.separator + "lovelog" + File.separator + nowDate;//日志绝对路径
        fileName = "info" + ".love";//设置日志后缀名

        //设置布局
        String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss:SSS}-%p，%F，%L行:" + baseMsg + " -%m%n";//布局格式
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern(conversionPattern);


        //设置输出到文件，并按指定大小滚动
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setEncoding(outCharSet);//输出编码
        rollingFileAppender.setFile(finalPath + File.separator + fileName);/////设置输出文件
        rollingFileAppender.setLayout(patternLayout);//设置布局方式
        rollingFileAppender.setBufferSize(1 * 1024 * 1024);        //文件流缓存1M
        rollingFileAppender.setMaximumFileSize(5 * 1024 * 1024);    //达到5M滚动一个新文件
        rollingFileAppender.setMaxBackupIndex(50);                    //设置文件最大数量
        rollingFileAppender.activateOptions();                        //激活配置


        //发送日志到指定邮箱中
        SMTPAppender smtpAppender = new SMTPAppender();
        smtpAppender.setThreshold(Priority.INFO);//发送邮件的门槛，仅当等于或高于ERROR（比如FATAL）时，邮件才被发送
        smtpAppender.setBufferSize(1 * 1204 * 1024);//缓存文件大小，日志达到1兆时发送Email
        smtpAppender.setFrom("kunzaikx@aliyun.com");//发送邮件的邮箱帐号
        smtpAppender.setSMTPUsername("kunzaikx@aliyun.com");//SMTP发送认证的帐号名
        smtpAppender.setSMTPPassword("kunzaikxadmin1");//SMTP发送认证帐号搜索的密码
        smtpAppender.setSMTPHost("smtp.aliyun.com");//SMTP邮件发送服务器地址
//        smtpAppender.setSMTPPort(587);//服务器地址，qq为587
        smtpAppender.setSMTPDebug(true);//是否打印调试信息，如果选true，则会输出和SMTP之间的握手等详细信息
        smtpAppender.setSubject("love日志文件");//邮件主题
        //smtpAppender.setBcc("")//  #如果需要发副本给某人，则加入下列行
        smtpAppender.setTo("656678879@qq.com");//送到什么邮箱，如果要发送给多个邮箱，则用逗号分隔
        smtpAppender.setLayout(patternLayout);//设置布局
        smtpAppender.activateOptions();


        Logger logger = Logger.getLogger(fileName);
        logger.removeAllAppenders();
        logger.setLevel(Level.INFO);//设定Logger级別
        //[它是 子Logger 是否继承 父Logger 的 输出源（appender） 的标志位。具体说，默认情况下子Logger会继承父Logger的appender，也就是说子Logger会在父Logger的appender里输出。若是additivity设为false，则子Logger只会在自己的appender里输出，而不会在父Logger的appender里输出。]
        logger.setAdditivity(false);//当某个logger的logging request(即printing method(error(),info()..))的级别高于或者等于该logger的级别(即在log4j.properties或者log4j.xml中定义)的时候，该logging request就为enable.一旦该logger的logging request为enable，那么该logging request将总会打印到该logger所有的appender中包括它的所有父logger的appender。（而不会管父logger的级别如何）。除非该logger的父logger的additivity设置为false，默认的情况下为true。某个logger的additivity设置为false，表示log只打印到本log的appender中，而不再打印到其父logger的appender。
        logger.addAppender(smtpAppender);
        return logger;
    }


    public static Logger getDataBaseLog(String baseMsg) {
        String outCharSet = "UTF-8";//日志输出编码
        String fileName = "";
        //[JVM在启动的时候，会将环境变量，转换到 系统属性 里面。可以通过System.getProperty(""); 来获取。catalina.home属性，就是运行tomcat的JVM的系统属性之一。一般是由操作系统的环境变量CATALINA_HOME转换而来。如果操作系统没有设置，tomcat会采用默认设置来填充该内容。]
        String tomcatPath = System.getProperty("catalina.home");//Tomcat的路径[需要运行时有效]
        if (tomcatPath == null || "".equals(tomcatPath)) {
            tomcatPath = "D:\\Program Files\\apache-tomcat-8.0.39";//[服务器非启动的时候才用默认的地址]
        }
        String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String finalPath = tomcatPath + File.separator + "log" + File.separator + "lovelog" + File.separator + nowDate;//日志绝对路径
        fileName = "database" + ".love";//设置日志后缀名

        //设置布局[文件布局]
        String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss:SSS}-%p，%F，%L行:" + baseMsg + " -%m%n";//布局格式
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern(conversionPattern);


        //设置输出到文件，并按指定大小滚动
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setEncoding(outCharSet);//输出编码
        rollingFileAppender.setFile(finalPath + File.separator + fileName);/////设置输出文件
        rollingFileAppender.setLayout(patternLayout);//设置布局方式
        rollingFileAppender.setBufferSize(1 * 1024 * 1024);        //文件流缓存1M
        rollingFileAppender.setMaximumFileSize(5 * 1024 * 1024);    //达到5M滚动一个新文件
        rollingFileAppender.setMaxBackupIndex(50);                    //设置文件最大数量
        rollingFileAppender.activateOptions();                        //激活配置

        //发送日志到指定邮箱中
        JDBCAppender jdbcAppender = new JDBCAppender();
        jdbcAppender.setURL(SysConstant.DB_URL == null ? "jdbc:mysql:///love" : SysConstant.DB_URL);
        jdbcAppender.setDriver(SysConstant.DB_DRIVER == null ? "com.mysql.jdbc.Driver" : SysConstant.DB_DRIVER);
        jdbcAppender.setUser(SysConstant.DB_USER == null ? "root" : SysConstant.DB_USER);
        jdbcAppender.setPassword(SysConstant.DB_PWD == null ? "admin" : SysConstant.DB_PWD);
//        jdbcAppender.setBufferSize(1 * 1024 * 1024);//缓存到一兆的时候进行存储到数据库
        jdbcAppender.setBufferSize(1);//【测试数据】
        jdbcAppender.setThreshold(Priority.INFO);//执行info级别的信息
        jdbcAppender.setSql("INSERT INTO log(name,operatedate,level,logger,message)VALUES('%X{name}','%d{yyyy-MM-dd HH:mm:ss}','%p','%C','%m')");
        //jdbcAppender.setLayout(patternLayout);//加上报错
        jdbcAppender.activateOptions();


        Logger logger = Logger.getLogger(fileName);
        logger.removeAllAppenders();
        logger.setLevel(Level.INFO);//设定Logger级別
        //[它是 子Logger 是否继承 父Logger 的 输出源（appender） 的标志位。具体说，默认情况下子Logger会继承父Logger的appender，也就是说子Logger会在父Logger的appender里输出。若是additivity设为false，则子Logger只会在自己的appender里输出，而不会在父Logger的appender里输出。]
        logger.setAdditivity(false);//当某个logger的logging request(即printing method(error(),info()..))的级别高于或者等于该logger的级别(即在log4j.properties或者log4j.xml中定义)的时候，该logging request就为enable.一旦该logger的logging request为enable，那么该logging request将总会打印到该logger所有的appender中包括它的所有父logger的appender。（而不会管父logger的级别如何）。除非该logger的父logger的additivity设置为false，默认的情况下为true。某个logger的additivity设置为false，表示log只打印到本log的appender中，而不再打印到其父logger的appender。
        logger.addAppender(jdbcAppender);

        return logger;
    }


}
