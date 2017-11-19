package com.pkk.action.base;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.pkk.utils.condition.PageCondition;


import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.action.base
 * @Description: <>
 * @date 10/9 0009 15:59
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

    // request对象
    public HttpServletRequest  request;
    // response对象
    public HttpServletResponse response;
    //第几页
    public int                 page;
    //每页显示的总条数
    public int                 rows;
    //排序字段
    public String              sort;
    //排序顺序
    public String              order;
    //分页封装类
    public PageCondition       pageCondition;
    //session对象
    public Map                 session;




    public HttpServletRequest getServletRequest() {
        return request;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.request = servletRequest;
    }

    public HttpServletResponse getServletResponse() {
        return response;
    }

    @Override
    public void setServletResponse(HttpServletResponse servletResponse) {
        this.response = servletResponse;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setPageCondition(PageCondition pageCondition) {
        this.pageCondition = pageCondition;
    }

    public Map getSession() {
        return session;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }


    public PageCondition getPageCondition() {
        if (pageCondition == null) {
            pageCondition = new PageCondition();
        }
        pageCondition.setPage(page);
        pageCondition.setPagesize(rows);
        pageCondition.setSortname(sort);
        pageCondition.setSortorder(order);
        return pageCondition;
    }

    /**
     * 功能描述：将对象转换成JSON字符串，并响应回前台
     * 时间：2014年9月11日
     *
     * @param object
     * @author ：lirenbo
     */
    public void writeJson(Object object) {
        try {
            String json = JSONObject.toJSONString(object);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
