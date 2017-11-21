package com.pkk.service;

import javax.annotation.Resource;

import com.pkk.dao.impl.UserDao;

import org.springframework.stereotype.Service;

import com.pkk.model.UserModel;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.service
 * @Description: <>
 * @date 10/9 0009 20:34
 */

@Service
public class UserService extends BaseService<UserModel> {

    @Resource
    private UserDao userDao;

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
