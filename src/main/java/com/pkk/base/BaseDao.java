package com.pkk.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by peikunkun on 2017/10/22 0022.
 */
@Repository
public class BaseDao<T> implements IBaseDao<T> {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*protected Session session = sessionFactory.openSession();

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }*/

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public <T extends IPkkBaseModel> List getByPropertySql(String sql, String params, Object values, Class<T> clazz) {
        return this.getByPropertySqls(sql, new String[]{params}, new Object[]{values}, clazz);
    }

    public <T extends IPkkBaseModel> List getByPropertySqls(String sql, String[] params, Object[] values,
                                                            Class<T> clazz) {
        Session session = sessionFactory.openSession();


        List l = new ArrayList();
        return l;
    }


}
