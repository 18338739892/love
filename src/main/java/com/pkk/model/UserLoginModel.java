package com.pkk.model;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.model
 * @Description: <用户登录的表>
 * @date 10/9 0009 15:56
 */

import com.pkk.base.BaseModel;

import javax.persistence.*;

@Table(name = "userinfo")
@Entity
public class UserLoginModel extends BaseModel {
    private Integer id;
    private String uname;
    private String pwd;
    private char sex;
    private String dsc;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Column
    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Column
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column
    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    @Override
    public String toString() {
        return "UserLoginModel [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", sex=" + sex + ", dsc=" + dsc + "]";
    }

}
