package com.pkk.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.model
 * @Description: <>
 * @date 11/2 0002 15:46
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sys_user")
public class SysUser {

    private Integer   id;
    private String    usercode;
    private String    idserial;
    private String    username;
    private String    email;
    private String    mobilephone;
    private String    telephone;
    private String    passwd;
    private Integer   roleid;
    private String    sex;
    private String    orgcode;
    private String    status;
    private Integer   inputuserid;
    private Timestamp inputdate;
    private String    reservestr1;
    private String    reservestr2;


    //与数据库无关
    private String orgstr;
    private String orgname;

    // Constructors

    @Transient
    public String getOrgstr() {
        return orgstr;
    }

    public void setOrgstr(String orgstr) {
        this.orgstr = orgstr;
    }

    /**
     * default constructor
     */
    public SysUser() {
    }

    /**
     * full constructor
     */
    public SysUser(String usercode, String idserial, String username,
                   String email, String mobilephone, String telephone, String passwd,
                   Integer roleid, String sex, String orgcode, String status,
                   Integer inputuserid, Timestamp inputdate, String reservestr1,
                   String reservestr2) {
        this.usercode = usercode;
        this.idserial = idserial;
        this.username = username;
        this.email = email;
        this.mobilephone = mobilephone;
        this.telephone = telephone;
        this.passwd = passwd;
        this.roleid = roleid;
        this.sex = sex;
        this.orgcode = orgcode;
        this.status = status;
        this.inputuserid = inputuserid;
        this.inputdate = inputdate;
        this.reservestr1 = reservestr1;
        this.reservestr2 = reservestr2;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "usercode", length = 20)
    public String getUsercode() {
        return this.usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    @Column(name = "idserial", length = 20)
    public String getIdserial() {
        return this.idserial;
    }

    public void setIdserial(String idserial) {
        this.idserial = idserial;
    }

    @Column(name = "username", length = 20)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email", length = 60)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "mobilephone", length = 16)
    public String getMobilephone() {
        return this.mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Column(name = "telephone", length = 16)
    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "passwd", length = 60)
    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Column(name = "roleid")
    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Column(name = "sex", length = 2)
    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "orgcode", length = 20)
    public String getOrgcode() {
        return this.orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    @Column(name = "status", length = 2)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "inputuserid")
    public Integer getInputuserid() {
        return this.inputuserid;
    }

    public void setInputuserid(Integer inputuserid) {
        this.inputuserid = inputuserid;
    }

    @Column(name = "inputdate", length = 19)
    public Timestamp getInputdate() {
        return this.inputdate;
    }

    public void setInputdate(Timestamp inputdate) {
        this.inputdate = inputdate;
    }

    @Column(name = "reservestr1", length = 200)
    public String getReservestr1() {
        return this.reservestr1;
    }

    public void setReservestr1(String reservestr1) {
        this.reservestr1 = reservestr1;
    }

    @Column(name = "reservestr2", length = 200)
    public String getReservestr2() {
        return this.reservestr2;
    }

    public void setReservestr2(String reservestr2) {
        this.reservestr2 = reservestr2;
    }

    @Transient
    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }


}
