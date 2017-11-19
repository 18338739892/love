package com.pkk.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.pkk.action.login.UserLoginAction;
import com.pkk.action.login.UserRegisterAction;
import com.pkk.model.SysUser;
import com.pkk.model.UserModel;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by peikunkun on 2017/11/19 0019.
 *
 * @author peikunkun
 * @desc 用户登录拦截器
 */
public class AuthorityInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        //ActionContext context = actionInvocation.getInvocationContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        Map session = actionInvocation.getInvocationContext().getSession();
        //后缀是.do的为所有前台操作    .action 为所有后台操作

        Object action = actionInvocation.getAction();
        String actionName = actionInvocation.getInvocationContext().getName();//action名称
        //actionName Example   :userLoginAction
        //对UserLoginAction不做该项拦截
        if (action instanceof UserLoginAction || action instanceof UserRegisterAction) {
            return actionInvocation.invoke();
        }
        //验证 session
        UserModel user = (UserModel) session.get("user");
        if (user != null) {//存在的情况下进行后续操作
            UserThreadLocal.put(UserModel.getUsersBySessionUser(user));
            String o = actionInvocation.invoke();
            //拦截器的o Example:makeMenu
            UserThreadLocal.clear();
            return o;
        } else {//否则终止后续操作，返回LOGIN
            // easyui 通过iframe布局，如果session超时，有问题，所有通过返回js来跳出iframe
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>");
            out.println("window.parent.location.href = '" + request.getScheme() + "://" + request.getServerName() + "';");
            out.println("</script>");
            out.flush();
            out.close();
            return null;
        }
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
