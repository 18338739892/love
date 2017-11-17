package com.pkk.action.login;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.pkk.base.BaseAction;
import com.pkk.model.SysUser;
import com.pkk.model.UserModel;
import com.pkk.service.impl.QueryUserService;
import com.pkk.service.login.UserLoginService;
import com.pkk.utils.common.LoggerUtil;
import com.pkk.utils.common.LoggerUtilMDC;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
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
 * @Description: <用户登录接口>
 * @date 10/9 0009 15:58
 */
public class UserLoginAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private UserModel userModel;


    @Resource
    private UserLoginService userLoginService;

    public UserLoginService getUserLoginService() {
        return userLoginService;
    }

    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }


    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void userLogin() {

        boolean result = userLoginService.UserLogin(userModel);
        HashMap<String, String> map = new HashMap<>();
        if (result) {
            map.put("key", "成功");
            map.put("meg", "密码正确");
            writeJson(map);

        } else {
            map.put("key", "失败");
            map.put("meg", "密码错误");

            writeJson(map);
        }
//        return "success";
    }

    /**
     * *************************************************************************
     *
     * @param
     * @return T
     * @Description: <获取注入的实体[废弃]>
     * @author peikunkun
     * @date 2017年11/16 0016 15:02
     * @version V1.0
     * *************************************************************************
     */
    public static <T> T getObject(T t) {


        String[] locations = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
        System.out.println(t.getClass().getName());
        String string = t.getClass().getSimpleName().substring(0, 1).toLowerCase()
                + t.getClass().getSimpleName().substring(1);
        System.out.println(string);
        return (T) ctx.getBean(string);

    }

    /**
     * *************************************************************************
     *
     * @param
     * @return com.pkk.service.impl.QueryUserService
     * @Description: <<获取注入的实体[废弃]>>
     * @author peikunkun
     * @date 2017年11/16 0016 15:03
     * @version V1.0
     * *************************************************************************
     */
    public static QueryUserService getObject(String name) {

        String[] locations = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);

        return (QueryUserService) ctx.getBean(name);

    }

}
