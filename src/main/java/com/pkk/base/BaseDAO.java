package com.pkk.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pkk.model.UserModel;
import com.pkk.utils.condition.Page;

/**
 * Created by peikunkun on 2017/10/22 0022.
 */
@Repository
public class BaseDAO<T> implements IBaseDAO<T> {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public <T extends IPkkBaseModel> List getByPropertySql(String sql, String params, Object values, Class<T> clazz) {
        return this.getByPropertySqls(sql, new String[]{params}, new Object[]{values}, clazz);
    }

    @Override
    public <T extends IPkkBaseModel> List getByPropertySqls(String sql, String[] params, Object[] values,
                                                            Class<T> clazz) {
        Session session = sessionFactory.openSession();


        List l = new ArrayList();
        return l;
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Integer save(Object entity) {
        return null;
    }

    @Override
    public void saves(List entityList) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void update(Object entity, Object get) {

    }

    @Override
    public void updates(List entityList) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public <T extends IPkkBaseModel> void delete(Class<T> clazz, Integer id) {

    }

    @Override
    public <T extends IPkkBaseModel> T get(Class<T> clazz, Integer id) {
        return null;
    }

    @Override
    public <T extends IPkkBaseModel> List<T> gets(Class<T> clazz, String ids) {
        return null;
    }

    @Override
    public Page queryHqls(String hql, String[] params, Object[] values, int pageNo, int rowsize) {
        return null;
    }

    @Override
    public Page queryHql(String hql, String params, Object values, int pageNo, int rowsize) {
        return null;
    }

    @Override
    public Page querySqls(String sql, String[] params, Object[] values, int pageNo, int rowsize) {
        return null;
    }

    @Override
    public Page querySql(String sql, String params, Object values, int pageNo, int rowsize) {
        return null;
    }

    @Override
    public Page querySql(String sql, String params, Object values, int pageNo, int rowsize, Class clazz) {
        return null;
    }

    @Override
    public List findByHqls(String hql, String[] params, Object[] values) {
        return null;
    }

    @Override
    public List findByHql(String hql, String params, Object values) {


        UserModel userModel = getSession().get(UserModel.class, 1);
        System.out.println("Dao层的获取的数据:" + userModel.toString());


        return null;
    }

    @Override
    public <T extends IPkkBaseModel> List<T> findByProperty(Class<T> clazz, String[] params, Object[] values, int pageNo, int rowsize) {
        return null;
    }

    @Override
    public <T extends IPkkBaseModel> List<T> findAll(Class<T> clazz, int pageNo, int rowsize) {
        return null;
    }

    @Override
    public <T extends IPkkBaseModel> List<T> findAll(Class<T> clazz) {
        return null;
    }

    @Override
    public int executeSql(String sql) {
        return 0;
    }

    @Override
    public boolean isExistHql(String hql, List<String> params, List<Object> values) {
        return false;
    }

    @Override
    public List getByPropertySql(String sql, String params, Object values) {
        return null;
    }

    @Override
    public List getByPropertySqls(String sql, String[] params, Object[] values) {
        return null;
    }

}
