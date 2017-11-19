package com.pkk.model;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: MyMavenProject
 * @Package com.pkk.model
 * @Description: <用户登录的表>
 * @date 10/9 0009 15:56
 */

import com.pkk.model.base.BaseModel;

import javax.persistence.*;

@Table(name = "userinfo")
@Entity
public class UserModel extends BaseModel {
    private Integer id;
    private String uname;
    private String password;
    private String level;
    private String verifykey;
    private String dsc;
    private String sex;
    private String age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Column
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "verifykey")
    public String getVerifykey() {
        return verifykey;
    }

    public void setVerifykey(String verifykey) {
        this.verifykey = verifykey;
    }


    @Column(name = "dsc")
    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public static UserModel getUsersBySessionUser(UserModel u) {
        UserModel u1 = new UserModel();
        u1.setId(u.getId());
        u1.setUname(u.getUname());
        u1.setLevel(u.getLevel());
        u1.setAge(u.getAge());
        u1.setDsc(u.getDsc());
        u1.setVerifykey(u.getVerifykey());
        return u1;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                ", verifykey='" + verifykey + '\'' +
                '}';
    }
}
