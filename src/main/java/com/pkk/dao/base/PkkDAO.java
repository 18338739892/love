package com.pkk.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.pkk.model.base.IPkkBaseModel;
import com.pkk.utils.condition.Page;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.action.base
 * @Description: <(对DAO层的简单封装，不做更为复杂的封装，只求达到某些方法的共用即可) >
 * @date 11/16 0016 17:45
 */
public interface PkkDAO extends Serializable {


    String setParamString(List<String> params, List<Object> values);

    String setParamString(String[] params, Object[] values);

    void setParamString(SQLQuery sqlQuery, String[] params, Object[] values);

    String setParamString(Query query);

    Integer save(Object entity);

    void saves(List entityList);

    void update(Object entity);

    void update(Object entity, Object get);

    void updates(List entityList);

    void delete(Object entity);

    <T extends IPkkBaseModel> void delete(Class<T> clazz, Integer id);

    <T extends IPkkBaseModel> T get(Class<T> clazz, Integer id);

    <T extends IPkkBaseModel> List<T> gets(Class<T> clazz, String ids);

    Page queryHqls(String hql, String[] params, Object[] values, int pageNo, int rowsize);

    Page queryHql(String hql, String params, Object values, int pageNo, int rowsize);

    Page querySqls(String sql, String[] params, Object[] values, int pageNo, int rowsize);

    Page querySql(String sql, String params, Object values, int pageNo, int rowsize);

    Page querySql(String sql, String params, Object values, int pageNo, int rowsize, Class clazz);

    List findByHqls(String hql, String[] params, Object[] values);

    List findByHql(String hql, String params, Object values);

    <T extends IPkkBaseModel> List<T> findByProperty(Class<T> clazz, String[] params, Object[] values, int pageNo, int rowsize);

    <T extends IPkkBaseModel> List<T> findAll(Class<T> clazz, int pageNo, int rowsize);

    <T extends IPkkBaseModel> List<T> findAll(Class<T> clazz);

    int executeSql(String sql);

    boolean isExistHql(String hql, List<String> params, List<Object> values);

    List getByPropertySql(String sql, String params, Object values);

    List getByPropertySqls(String sql, String[] params, Object[] values);

    <T extends IPkkBaseModel> List getByPropertySql(String sql, String params, Object values, Class<T> clazz);

    <T extends IPkkBaseModel> List getByPropertySqls(String sql, String[] params, Object[] values, Class<T> clazz);


}
