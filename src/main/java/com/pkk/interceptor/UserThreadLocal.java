package com.pkk.interceptor;

import com.pkk.model.UserModel;

import java.io.Serializable;

/**
 * Created by peikunkun on 2017/11/19 0019.
 * 用户线程本地变量
 */
public class UserThreadLocal implements Serializable {

    private static ThreadLocal<UserModel> THREAD = new ThreadLocal<UserModel>();

    public static void put(UserModel users) {
        THREAD.set(users);
    }

    public static UserModel get() {
        return THREAD.get();
    }

    public static void clear() {
        THREAD.set(null);
        THREAD.remove();
    }
}
