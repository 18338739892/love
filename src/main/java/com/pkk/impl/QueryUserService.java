package com.pkk.impl;

import com.pkk.dao.QueryUserDao;
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

@Service(value = "queryUserService")
public class QueryUserService {

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
