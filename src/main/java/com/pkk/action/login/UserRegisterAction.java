package com.pkk.action.login;

import com.opensymphony.xwork2.ActionContext;
import com.pkk.interceptor.UserThreadLocal;
import com.pkk.action.base.BaseAction;
import com.pkk.model.UserModel;
import com.pkk.service.UserLoginService;
import com.pkk.utils.CookieUtil;
import com.pkk.utils.constant.SysConstant;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;

import org.apache.struts2.ServletActionContext;

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
        HashMap<String, String> map = new HashMap<>();
        HttpServletRequest request = ServletActionContext.getRequest();
        String validateCode = CookieUtil.getCookieValue(request, "scaptcha");
        if (!validateCode.equalsIgnoreCase(userModel.getVerifykey())) {
            map.put(SysConstant.RETURN_CODE, "verifykeyerror");
            map.put(SysConstant.RETURN_MSG, "验证码错误");
            writeJson(map);
            return;
        }

        boolean result = userLoginService.userRegister(userModel);
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
