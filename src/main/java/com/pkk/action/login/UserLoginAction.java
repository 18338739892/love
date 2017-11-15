package com.pkk.action.login;

import java.util.Map;

import com.pkk.base.BaseAction;
import com.pkk.model.SysUser;
import com.pkk.model.UserModel;
import com.pkk.service.impl.QueryUserService;
import com.pkk.utils.common.LoggerUtil;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.action
 * @Description: <>
 * @date 10/9 0009 15:58
 */
public class UserLoginAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private static Logger logger = LoggerUtil.getLogger("这是个基本的输出配置信息", "userlogin");

    private UserModel userModel;

    @Resource(name = "queryUserService")
    private QueryUserService queryUserService;

    public QueryUserService getQueryUserService() {
        return queryUserService;
    }

    public void setQueryUserService(QueryUserService queryUserService) {
        this.queryUserService = queryUserService;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String userLogin() {

        String tomcatPath = System.getProperty("catalina.home");//Tomcat的路径

        System.out.println(tomcatPath);

        for (int i = 0; i < 100; i++) {
            logger.info("测试邮件数据------------------------第" + i + "次");

            try {
                int i1 = 1 / 0;
            } catch (Exception e) {
                logger.error("测试邮件数据------------------------第" + i + "次");
            }
        }
        System.out.println("Service为:" + queryUserService);

        System.out.print("测试");

        System.out.print("测试1");

        UserLoginAction userLoginAction = new UserLoginAction();

        QueryUserService queryUserService = userLoginAction.getObject("queryUserService");
        System.out.println("Service2为:" + queryUserService);
        queryUserService.findUserInfo();

        System.out.println("用户的登录:" + userModel.toString());
        return "success";
    }

    public static <T> T getObject(T t) {
        String[] locations = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
        System.out.println(t.getClass().getName());
        String string = t.getClass().getSimpleName().substring(0, 1).toLowerCase()
                + t.getClass().getSimpleName().substring(1);
        System.out.println(string);
        return (T) ctx.getBean(string);

    }

    public static QueryUserService getObject(String name) {
        String[] locations = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);

        return (QueryUserService) ctx.getBean(name);

    }

    public String testSuccess() {

        SysUser sysUserTest = new SysUser();
        sysUserTest.setId(1);
        sysUserTest.setRoleid(1);
        Map session1 = super.getSession();


        return "success";
    }


    public void TestLog4jSendMail() {

        Logger logger = Logger.getLogger(UserLoginAction.class);
        SMTPAppender appender = new SMTPAppender();
        try {
            appender.setSMTPUsername("peikunkun@newcapec.net");
            appender.setSMTPPassword("As15938320850");
            appender.setTo("656678879@qq.com");
            appender.setFrom("peikunkun@newcapec.net");
            // SMTP服务器 smtp.163.com
            appender.setSMTPHost("smtp.newcapec.net");
            appender.setLocationInfo(true);
            appender.setSubject("Error Mail From Log4J");
            appender.setLayout(new PatternLayout());
            appender.activateOptions();
            logger.addAppender(appender);
            logger.error("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Printing ERROR Statements", e);
        }
    }

    public void TestLog4jSendMail1() {

        Logger logger = Logger.getLogger(UserLoginAction.class);
        SMTPAppender appender = new SMTPAppender();
        try {
            appender.setSMTPUsername("peikunkun@newcapec.net");
            appender.setSMTPPassword("As15938320850");
            appender.setTo("656678879@qq.com");
            appender.setFrom("peikunkun@newcapec.net");
            // SMTP服务器 smtp.163.com
            appender.setSMTPHost("smtp.newcapec.net");
            appender.setLocationInfo(true);
            appender.setSubject("Error Mail From Log4J");
            appender.setLayout(new PatternLayout());
            appender.activateOptions();
            logger.addAppender(appender);
            logger.error("Hello World");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Printing ERROR Statements", e);
        }
    }


    public static void main(String args[]) {
        new UserLoginAction().TestLog4jSendMail1();
    }

}
