package com.pkk.service.login;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pkk.base.BaseService;
import com.pkk.dao.impl.QueryUserDao;
import com.pkk.model.UserModel;
import com.pkk.service.impl.QueryUserService;
import com.pkk.utils.StringUtils;
import com.pkk.utils.common.LoggerUtil;
import com.pkk.utils.common.LoggerUtilMDC;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.service.login
 * @Description: <>
 * @date 11/16 0016 18:20
 */
@Service
public class UserLoginService extends BaseService<UserModel> {

    @SuppressWarnings("unused")
    private static String logInfo = "-[用户登录操作]-";
    private static Logger logger  = LoggerUtil.getLogger(logInfo, "userlogin");
    private static Logger email   = LoggerUtil.getEmail(logInfo);
    private static Logger dblog   = LoggerUtil.getDataBaseLog(logInfo);


    @Resource(name = "queryUserService")
    private QueryUserService queryUserService;
    @Resource
    private QueryUserDao     queryUserDao;

    public QueryUserService getQueryUserService() {
        return queryUserService;
    }

    public void setQueryUserService(QueryUserService queryUserService) {
        this.queryUserService = queryUserService;
    }


    public boolean UserLogin(UserModel userModel) {
        LoggerUtilMDC.putName(userModel.getUname());//记录用户名[日志]
        dblog.info("用户进行登录操作");
        email.error("用户名:" + userModel.getUname() + "-于" + StringUtils.getDateStr() + "进行登录操作");//发送邮件

        UserModel userModel1 = queryUserDao.findUserInFo(userModel);

        if (userModel1 == null) {
            return false;
        } else {
            return true;
        }

    }


}
