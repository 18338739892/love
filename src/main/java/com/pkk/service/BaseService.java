package com.pkk.service;

import javax.annotation.Resource;

import com.pkk.dao.impl.UserDao;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.action.base
 * @Description: <>
 * @date 11/2 0002 13:27
 */
public class BaseService<T> {

    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
