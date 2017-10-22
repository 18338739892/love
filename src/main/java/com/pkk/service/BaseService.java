package com.pkk.service;

import com.pkk.dao.impl.QueryUserDao;
import com.pkk.model.UserLoginModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.service
 * @Description: <>
 * @date 10/9 0009 20:34
 */

@Service(value = "baseService")
public class BaseService {

    @Resource(name = "queryUserDao")
    private QueryUserDao queryUserDao;

    public QueryUserDao getQueryUserDao() {
        return queryUserDao;
    }

    public void setQueryUserDao(QueryUserDao queryUserDao) {
        this.queryUserDao = queryUserDao;
    }

    @Transactional
    public UserLoginModel findUserInfo() {

        System.out.println("dao信息为" + queryUserDao);

        queryUserDao.findUserInFo();

        return null;

    }

}
