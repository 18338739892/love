package com.pkk.action.login;

import java.io.IOException;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionContext;
import com.pkk.Interceptor.UserThreadLocal;
import com.pkk.model.UserModel;
import com.pkk.action.base.BaseAction;
import com.pkk.service.UserService;
import com.pkk.service.UserLoginService;
import com.pkk.utils.CookieUtil;
import com.pkk.utils.ValidateCode;
import com.pkk.utils.constant.SysConstant;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
            ActionContext.getContext().getSession().put("user", userModel);
            session.put("user", userModel);//sessionMap操作对象
            UserThreadLocal.put(userModel);
            UserThreadLocal.clear();
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_SUCCESS);
            map.put(SysConstant.RETURN_MSG, "密码正确");
            writeJson(map);
        } else {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_ERROR);
            map.put(SysConstant.RETURN_MSG, "密码错误");
            writeJson(map);
        }
    }


    public String userLoginSuccess() {

        return "success";
    }

    /**
     * *************************************************************************
     *
     * @param
     * @return void
     * @Description: <验证用户是否存在>
     * @author peikunkun
     * @date 2017年11/17 0017 18:52
     * @version V1.0
     * *************************************************************************
     */
    public void verifyUser() {
        boolean result = userLoginService.verifyUser(userModel);
        HashMap<String, String> returnMsg = new HashMap<>();
        if (result) {
            returnMsg.put("message", "SUCCESS");
        } else {
            returnMsg.put("message", "isNotExist");
        }
        writeJson(returnMsg);
    }


    /**
     * *************************************************************************
     *
     * @param
     * @return void
     * @Description: <验证码>
     * @author peikunkun
     * @date 2017年11/17 0017 16:53
     * @version V1.0
     * *************************************************************************
     */
    public void scaptcha() {

        HttpServletResponse response = ServletActionContext.getResponse();
        response.reset();
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ValidateCode instance = new ValidateCode();
        CookieUtil.setCookie(response, "scaptcha", instance.getCode().toUpperCase(), null, -1);
        try {
            instance.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
     * @return com.pkk.service.QueryUserService
     * @Description: <<获取注入的实体[废弃]>>
     * @author peikunkun
     * @date 2017年11/16 0016 15:03
     * @version V1.0
     * *************************************************************************
     */
    public static UserService getObject(String name) {

        String[] locations = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);

        return (UserService) ctx.getBean(name);

    }

}
