package com.pkk.base;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.base
 * @Description: <>
 * @date 10/9 0009 15:59
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

    
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}
