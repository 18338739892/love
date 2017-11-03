package com.pkk.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.pkk.base.PkkBaseModel;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.model
 * @Description: <>
 * @date 11/2 0002 17:08
 */
@Embeddable
public class SysRoleDetailId extends PkkBaseModel {

    private Integer roleid;
    private Integer menuid;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public void setInputdate(Timestamp inputdate) {

    }

    @Override
    public Timestamp getInputdate() {
        return null;
    }
// Constructors

    /**
     * default constructor
     */
    public SysRoleDetailId() {
    }

    /**
     * full constructor
     */
    public SysRoleDetailId(Integer roleid, Integer menuid) {
        this.roleid = roleid;
        this.menuid = menuid;
    }

    // Property accessors

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


    @Override
    public String toString() {
        return "SysRoleDetailId{" +
                "roleid=" + roleid +
                ", menuid=" + menuid +
                '}';
    }
}
