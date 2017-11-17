package com.pkk.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pkk.model.base.PkkBaseModel;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.model
 * @Description: <>
 * @date 11/2 0002 17:05
 */
@Entity
@Table(name = "sys_role_detail")
public class SysRoleDetail extends PkkBaseModel {

    private Integer id;
    private Integer roleid;
    private Integer menuid;
    private String  orgcode;

    @Column(name = "roleid")
    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Column(name = "menuid")
    public Integer getMenuid() {
        return this.menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }


    @Column(name = "orgcode", length = 32)
    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setInputdate(Timestamp inputdate) {

    }

    @Override
    @Transient
    public Timestamp getInputdate() {
        return null;
    }

    @Override
    public String toString() {
        return "SysRoleDetail{" +
                "roleid=" + roleid +
                ", menuid=" + menuid +
                ", orgcode='" + orgcode + '\'' +
                '}';
    }
}
