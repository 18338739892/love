package com.pkk.service;

import javax.annotation.Resource;

import com.pkk.dao.impl.UserDao;
import com.pkk.utils.LoveException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pkk.model.UserModel;
import com.pkk.utils.StringUtils;
import com.pkk.utils.common.LoggerUtil;
import com.pkk.utils.common.LoggerUtilMDC;
import com.pkk.utils.encryption.MD5Util;

import java.sql.Timestamp;
import java.util.Date;

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
    private static Logger logger = LoggerUtil.getLogger(logInfo, "userlogin");
    private static Logger email = LoggerUtil.getEmail(logInfo);
    private static Logger dblog = LoggerUtil.getDataBaseLog(logInfo);


    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
    @SuppressWarnings(value = "all")
    public boolean UserLogin(UserModel userModel) {
        if (userModel == null) {
            return false;
        }
        //Md5加密
        userModel.setPassword(MD5Util.md5(userModel.getPassword()));
        UserModel userModel1 = userDao.findUserInFo(userModel);
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

        String result = userDao.verifyUser(userModel);
        if (result == null || result.length() <= 0) {
            return false;
        } else {
            return true;
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
    public boolean userRegister(UserModel userModel) {
        if (userModel == null) {
            return false;
        }
        userModel.setPassword(MD5Util.md5(userModel.getPassword()));
        Integer result = userDao.userRegister(userModel);
        if (result == null || result <= 0) {
            return false;
        } else {
            LoggerUtilMDC.putName(userModel.getUname());//记录用户名[日志]
            dblog.info("用户进行注册操作| 操作用户 -：" + userModel.getUname());
            email.error("用户名:" + userModel.getUname() + "-于" + StringUtils.getDateStr() + "进行注册操作");//发送邮件
            return true;
        }
    }


}
