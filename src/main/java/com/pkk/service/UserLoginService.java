package com.pkk.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pkk.service.BaseService;
import com.pkk.dao.impl.QueryUserDao;
import com.pkk.model.UserModel;
import com.pkk.service.QueryUserService;
import com.pkk.utils.StringUtils;
import com.pkk.utils.common.LoggerUtil;
import com.pkk.utils.common.LoggerUtilMDC;
import com.pkk.utils.encryption.MD5Util;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.service.login
 * @Description: <>
 * @date 11/16 0016 18:20
 */
@Service(value = "userLoginService")
public class UserLoginService extends BaseService<UserModel> {

    @SuppressWarnings("unused")
    private static String logInfo = "-[用户登录操作]-";
    private static Logger logger  = LoggerUtil.getLogger(logInfo, "userlogin");
    private static Logger email   = LoggerUtil.getEmail(logInfo);
    private static Logger dblog   = LoggerUtil.getDataBaseLog(logInfo);


    @Resource(name = "queryUserService")
    private QueryUserService queryUserService;
    @Resource(name = "queryUserDao")
    private QueryUserDao     queryUserDao;

    public QueryUserService getQueryUserService() {
        return queryUserService;
    }

    public void setQueryUserService(QueryUserService queryUserService) {
        this.queryUserService = queryUserService;
    }

    /**
     * *************************************************************************
     *
     * @param
     * @return boolean
     * @Description: <用户登录>
     * @author peikunkun
     * @date 2017年11/17 0017 16:57
     * @version V1.0
     * *************************************************************************
     */
    public boolean UserLogin(UserModel userModel) {


        if (userModel == null) {
            return false;
        }
        //Md5加密
        userModel.setPassword(MD5Util.md5(userModel.getPassword()));
        UserModel userModel1 = queryUserDao.findUserInFo(userModel);
        if (userModel1 == null) {
            return false;
        } else {
            LoggerUtilMDC.putName(userModel.getUname());//记录用户名[日志]
            dblog.info("用户进行登录操作");
            email.error("用户名:" + userModel.getUname() + "-于" + StringUtils.getDateStr() + "进行登录操作");//发送邮件
            return true;
        }

    }


    public boolean verifyUser(UserModel userModel) {

        String result = queryUserDao.verifyUser(userModel);
        if (result == null || result.length() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}