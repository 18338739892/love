package com.pkk.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pkk.service.BaseService;
import com.pkk.dao.impl.QueryUserDao;
import com.pkk.model.UserModel;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.service
 * @Description: <>
 * @date 10/9 0009 20:34
 */

@Service(value = "queryUserService")
public class QueryUserService extends BaseService<UserModel> {

    @Resource(name = "queryUserDao")
    private QueryUserDao queryUserDao;

    @Override
    public QueryUserDao getQueryUserDao() {
        return queryUserDao;
    }

    @Override
    public void setQueryUserDao(QueryUserDao queryUserDao) {
        this.queryUserDao = queryUserDao;
    }


}
