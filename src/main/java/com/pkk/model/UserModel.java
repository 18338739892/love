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
public class UserModel extends BaseModel {
    private Integer id;
    private String  uname;
    private String  password;
    private String  level;
    private String  verifykey;

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
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getVerifykey() {
        return verifykey;
    }

    public void setVerifykey(String verifykey) {
        this.verifykey = verifykey;
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
