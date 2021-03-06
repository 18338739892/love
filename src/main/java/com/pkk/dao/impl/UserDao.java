package com.pkk.dao.impl;

import java.util.List;

import com.pkk.dao.base.BaseDAO;
import com.pkk.model.FeedBack;
import com.pkk.model.UserModel;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.dao
 * @Description: <>
 * @date 10/9 0009 20:50
 */
@Repository
public class UserDao extends BaseDAO<UserModel> {

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

        List<UserModel> list = super.getSession().createQuery(hql).setParameter(0, userModel.getUname()).setParameter(1, userModel.getPassword()).setParameter(2, userModel.getLevel()).list();

        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }


    /**
     * *************************************************************************
     *
     * @param
     * @return java.lang.String
     * @Description: <验证用户是否存在>
     * @author peikunkun
     * @date 2017年11/17 0017 17:55
     * @version V1.0
     * *************************************************************************
     */
    public String verifyUser(UserModel userModel) {

        String sql = "select uname from userinfo where uname =?";
        Object object = super.getByPropertySql(sql, userModel.getUname());
        if (object == null || object.toString().length() <= 0) {
            return null;
        } else {
            return (String) object;
        }
    }


    /**
     * <p>Title: userRegister<／p>
     * <p>Description: 用户注册<／p>
     * <p>Copyright: Copyright (c) 2017<／p>
     *
     * @author pkk
     * @date 2017/11/19 0019
     * @version 1.0
     */
    public Integer saveUser(UserModel userModel) {
        return super.save(userModel);
    }

    /**
     * *************************************************************************
     *
     * @param feedBack
     * @return a
     * @Description: <保存用户的反馈信息>
     * @author peikunkun
     * @date 11/21 0021 10:4210:42
     * @version V1.0
     * *************************************************************************
     */
    public Integer saveUserFeedBack(FeedBack feedBack) {
        return super.save(feedBack);
    }


    /**
     * *************************************************************************
     *
     * @param
     * @return com.pkk.model.UserModel
     * @Description: <获取用户的信息根据账户和密码>
     * @author peikunkun
     * @date 2017年11/21 0021 11:46
     * @version V1.0
     * *************************************************************************
     */
    public UserModel getUserModel(String name, String password) {
        String hql = "from UserModel where uname=:name and password=:password";
        List list = super.findByHqls(hql, new String[]{"name", "password"}, new Object[]{name, password});
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (UserModel) list.get(0);
    }


}
