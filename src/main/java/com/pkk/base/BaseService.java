package com.pkk.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pkk.dao.impl.QueryUserDao;
import com.pkk.model.UserModel;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.base
 * @Description: <>
 * @date 11/2 0002 13:27
 */
@Service
public class BaseService<T> {

    @Resource
    private QueryUserDao queryUserDao;

    public QueryUserDao getQueryUserDao() {
        return queryUserDao;
    }

    public void setQueryUserDao(QueryUserDao queryUserDao) {
        this.queryUserDao = queryUserDao;
    }


}
