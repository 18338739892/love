package com.pkk.dao;

import com.pkk.model.UserLoginModel;
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
@Repository(value = "queryUserDao")
public class QueryUserDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserLoginModel findUserInFo() {

		System.out.println("获取的结果为[sessionFactory]:" + sessionFactory);
		return null;
	}

}
