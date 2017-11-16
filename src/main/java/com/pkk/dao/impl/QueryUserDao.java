package com.pkk.dao.impl;

import com.pkk.base.BaseDAO;
import com.pkk.model.UserModel;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.dao
 * @Description: <>
 * @date 10/9 0009 20:50
 */
@Repository
public class QueryUserDao extends BaseDAO<UserModel> {

    /**
     * *************************************************************************
     *
     * @param
     * @return com.pkk.model.UserModel
     * @Description: <查询用户信息>
     * @author peikunkun
     * @date 2017年11/16 0016 19:50
     * @version V1.0
     * *************************************************************************
     */
    public UserModel findUserInFo(UserModel userModel) {

        String hql = "from UserModel where uname=? and password=? and level=?";
        return (UserModel) super.getSession().createQuery(hql).setParameter(0, userModel.getUname()).setParameter(1, userModel.getPassword()).setParameter(2, userModel.getLevel()).list().get(0);
    }

}
