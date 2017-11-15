package com.pkk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	public UserModel findUserInfo() {

		System.out.println("dao信息为" + queryUserDao);

		queryUserDao.findUserInFo();

		return null;

	}

}
