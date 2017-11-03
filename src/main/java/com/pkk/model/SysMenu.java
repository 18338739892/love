package com.pkk.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pkk.base.PkkBaseModel;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.model
 * @Description: <>
 * @date 11/2 0002 14:12
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sys_menu")
public class SysMenu extends PkkBaseModel {

    private Integer   id;
    private Integer   parentid;
    private String    menuname;
    private String    menuurl;
    private String    status;
    private String    plevel;
    private String    imgurl;
    private Integer   inputuserid;
    private Timestamp inputdate;


    private List<SysMenu> sysMenuList;

    /**
     * default constructor
     */
    public SysMenu() {
    }

    /**
     * full constructor
     */
    public SysMenu(Integer parentid, String menuname, String menuurl,
                   String status, String plevel, String imgurl, Integer inputuserid,
                   Timestamp inputdate) {
        this.parentid = parentid;
        this.menuname = menuname;
        this.menuurl = menuurl;
        this.status = status;
        this.plevel = plevel;
        this.imgurl = imgurl;
        this.inputuserid = inputuserid;
        this.inputdate = inputdate;
    }


    private String orgcode;


    @Column(name = "orgcode", length = 32)
    public String getOrgcode() {
        return this.orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }


    // Constructors

    @Transient
    public List<SysMenu> getSysMenuList() {
        return sysMenuList;
    }

    public void setSysMenuList(List<SysMenu> sysMenuList) {
        this.sysMenuList = sysMenuList;
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

    @Column(name = "parentid")
    public Integer getParentid() {
        return this.parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Column(name = "menuname", length = 30)
    public String getMenuname() {
        return this.menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    @Column(name = "menuurl", length = 300)
    public String getMenuurl() {
        return this.menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    @Column(name = "status", length = 2)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "plevel", length = 2)
    public String getPlevel() {
        return this.plevel;
    }

    public void setPlevel(String plevel) {
        this.plevel = plevel;
    }

    @Column(name = "imgurl", length = 300)
    public String getImgurl() {
        return this.imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

    @Override
    public String toString() {
        return "SysMenu [id=" + id + ", parentid=" + parentid + ", menuname=" + menuname + ", menuurl=" + menuurl
                + ", status=" + status + ", plevel=" + plevel + ", imgurl=" + imgurl + ", inputuserid=" + inputuserid
                + ", inputdate=" + inputdate + ", sysMenuList=" + sysMenuList + ", orgcode=" + orgcode + "]";
    }
}
