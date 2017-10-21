package com.pkk.action;

import com.pkk.base.BaseAction;
import com.pkk.model.UserLoginModel;
import com.pkk.service.impl.QueryUserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.action
 * @Description: <>
 * @date 10/9 0009 15:58
 */
@Controller(value = "userLoginAction")
public class UserLoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static Logger UserLoginActionlogger = Logger.getLogger(UserLoginAction.class);

	private UserLoginModel userLoginModel;

	@Resource(name = "queryUserService")
	private QueryUserService queryUserService;

	public QueryUserService getQueryUserService() {
		return queryUserService;
	}

	public void setQueryUserService(QueryUserService queryUserService) {
		this.queryUserService = queryUserService;
	}

	public UserLoginModel getUserLoginModel() {
		return userLoginModel;
	}

	public void setUserLoginModel(UserLoginModel userLoginModel) {
		this.userLoginModel = userLoginModel;
	}

	public String userLogin() {
		System.out.println("Service为:" + queryUserService);
		
		System.out.print("测试");

		UserLoginAction userLoginAction = new UserLoginAction();

		QueryUserService queryUserService = userLoginAction.getObject("queryUserService");
		System.out.println("Service2为:" + queryUserService);
		queryUserService.findUserInfo();

		System.out.println("用户的登录:" + userLoginModel.toString());
		return "success";
	}

	public static <T> T getObject(T t) {
		String[] locations = { "applicationContext.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
		System.out.println(t.getClass().getName());
		String string = t.getClass().getSimpleName().substring(0, 1).toLowerCase()
				+ t.getClass().getSimpleName().substring(1);
		System.out.println(string);
		return (T) ctx.getBean(string);

	}

	public static QueryUserService getObject(String name) {
		String[] locations = { "applicationContext.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);

		return (QueryUserService) ctx.getBean(name);

	}

	public static void main(String[] args) {
		getObject(QueryUserService.class);
	}

}
