package com.pkk.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.*;
import org.apache.log4j.Logger;


/**
 * <p>Title: CookieUtil.java</p>
 * <p>Description: 对Cookie的操作类</p>
 * <p>Copyright: Copyright (c) 新开普电子股份有限公司 2016</p>
 *
 * @author keeps
 * @date 创建日期：2016年8月11日
 * 修改日期：
 * 修改人：
 * 复审人：
 */
public class CookieUtil {

    private static final Logger log = Logger.getLogger(CookieUtil.class);

    public static final int maxAge = 1800;

    /**
     * @Title: getCookie
     * @Description: 从cookie中获取值Cookie
     * @param:
     * @return:
     * @author: keeps
     * @data: 2016年8月11日
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(cookieName)) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * @Title: getCookieValue
     * @Description: 从cookie中获取值
     * @param:
     * @return:
     * @author: keeps
     * @data: 2016年8月11日
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie cookie = getCookie(request, cookieName);
        if (null != cookie) {
            return cookie.getValue();
        }
        return null;
    }


    /**
     * @Title: setCookie
     * @Description: 添加Cookie
     * @param:
     * @return:
     * @author: keeps
     * @data: 2016年8月11日
     */
    public static void setCookie(HttpServletResponse response, String name, String value, String path, String domain, int maxAge) {
        Cookie cookie = new Cookie(name, "");
        cookie.setValue(value);
        cookie.setPath(path);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }


    /**
     * @Title: setCookie
     * @Description: 添加Cookie
     * @param:
     * @return:
     * @author: keeps
     * @data: 2016年8月11日
     */
    public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
        try {
            value = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }


    /**
     * @Title: setCookie
     * @Description: 添加Cookie(path：默认/, maxAge:可自行修改)
     * @param:
     * @return:
     * @author: keeps
     * @data: 2016年8月11日
     */
    public static void setCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, "");
        cookie.setValue(value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void createCookie(HttpServletResponse res, String name, String value, Integer maxage) {
        Cookie cookie;
        try {
            cookie = new Cookie(name, "");
            cookie.setValue(value);
            cookie.setMaxAge(maxage);
            cookie.setPath("/");
            //cookie.setHttpOnly(true);
            res.addCookie(cookie);
        } catch (Exception e) {
            log.error(e);
            throw new LoveException("创建Cookie错误");
        }
    }


    /**
     * @Title: clearCookie
     * @Description: 清除Cookie
     * @param:
     * @return:
     * @author: keeps
     * @data: 2016年8月11日
     */
    public static void clearCookie(HttpServletResponse response, String name, String path) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath(path);
        cookie.setMaxAge(0);
//		cookie.setDomain(Property.REALM_NAME);
        response.addCookie(cookie);
    }

}
