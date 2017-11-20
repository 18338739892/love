package com.pkk.action.login;

import com.opensymphony.xwork2.ActionContext;
import com.pkk.Interceptor.UserThreadLocal;
import com.pkk.action.base.BaseAction;
import com.pkk.model.UserModel;
import com.pkk.service.UserLoginService;
import com.pkk.utils.constant.SysConstant;

import javax.annotation.Resource;

import java.util.HashMap;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.action.login
 * @Description: <>
 * @date 11/15 0015 15:46
 */
public class UserRegisterAction extends BaseAction {

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

    @SuppressWarnings(value = "all")
    public void userRegister() {
        boolean result = userLoginService.userRegister(userModel);
        HashMap<String, String> map = new HashMap<>();
        if (result) {
            ActionContext.getContext().getSession().put("user", userModel);
            session.put("user", userModel);//sessionMap操作对象
            UserThreadLocal.put(userModel);
            UserThreadLocal.clear();
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_SUCCESS);
            map.put(SysConstant.RETURN_MSG, "注册成功");
            writeJson(map);
        } else {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_ERROR);
            map.put(SysConstant.RETURN_MSG, "注册失败");
            writeJson(map);
        }
    }


}
