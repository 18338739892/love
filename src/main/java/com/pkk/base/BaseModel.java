package com.pkk.base;

import java.util.Date;

/**
 * Created by peikunkun on 2017/10/22 0022.
 */
public class BaseModel {

    /**
     * 创建时间【yyyyMMddHHmmss】
     */
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "createTime=" + createTime +
                '}';
    }
}
