package com.pkk.dao.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.pkk.utils.LoveException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pkk.model.base.IPkkBaseModel;
import com.pkk.model.UserModel;
import com.pkk.utils.condition.Page;

/**
 * Created by peikunkun on 2017/10/22 0022.
 */
/*基于jdk的事务代理，只可以放在类上有效，放在接口上需使用CGLiB代理方式*/
public class BaseDAO<T> implements IBaseDAO<T> {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public <T extends IPkkBaseModel> List getByPropertySql(String sql, String params, Object values, Class<T> clazz) {
        return this.getByPropertySqls(sql, new String[]{params}, new Object[]{values}, clazz);
    }

    @Override
    public <T extends IPkkBaseModel> List getByPropertySqls(String sql, String[] params, Object[] values,
                                                            Class<T> clazz) {

        List l = new ArrayList();
        return l;
    }


    /**
     * *************************************************************************
     *
     * @param
     * @return java.lang.String
     * @Description: <根据参数进行拼装参数语句>
     * @author peikunkun
     * @date 2017年11/17 0017 18:33
     * @version V1.0
     * *************************************************************************
     */
    @Override
    public String setParamString(List<String> params, List<Object> values) {


        return null;
    }

    @Override
    public String setParamString(String[] params, Object[] values) {
        return null;
    }

    @Override
    public void setParamString(SQLQuery sqlQuery, String[] params, Object[] values) {
    }

    @Override
    public String setParamString(Query query) {
        return null;
    }

    @Override
    public Integer save(Object entity) {
        if (entity == null) {
            throw new LoveException("保存用户信息时-空指针异常");
        }
        Integer ressult = (Integer) getSession().save(entity);
        return ressult;
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
        Object object = getSession().createSQLQuery(sql).setParameter(0, values).uniqueResult();
        return null;
    }

    public Object getByPropertySql(String sql, Object values) {
        Object object = getSession().createSQLQuery(sql).setParameter(0, values).uniqueResult();
        return object;
    }

    @Override
    public List getByPropertySqls(String sql, String[] params, Object[] values) {
        return null;
    }

}
