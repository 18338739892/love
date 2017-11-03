package com.pkk.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pkk.base.PkkBaseModel;

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

    private SysRoleDetailId sysRoleDetailId;

    private String orgcode;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "roleid", column = @Column(name = "roleid")),
            @AttributeOverride(name = "menuid", column = @Column(name = "menuid"))})
    public SysRoleDetailId getSysRoleDetailId() {
        return this.sysRoleDetailId;
    }


    public void setSysRoleDetailId(SysRoleDetailId sysRoleDetailId) {
        this.sysRoleDetailId = sysRoleDetailId;
    }

    @Column(name = "orgcode", length = 32)
    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    @Override
    @Transient
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
    @Transient
    public Timestamp getInputdate() {
        return null;
    }

    @Override
    public String toString() {
        return "SysRoleDetail{" +
                "sysRoleDetailId=" + sysRoleDetailId +
                ", orgcode='" + orgcode + '\'' +
                '}';
    }
}
