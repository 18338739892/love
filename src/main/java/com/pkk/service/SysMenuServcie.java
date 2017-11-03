package com.pkk.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pkk.dao.SysMenuDAO;
import com.pkk.model.SysMenu;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.service
 * @Description: <>
 * @date 11/2 0002 14:59
 */
@Service
public class SysMenuServcie {

    @Resource
    private SysMenuDAO sysMenuDAO;

    public SysMenuDAO getSysMenuDAO() {
        return sysMenuDAO;
    }

    public void setSysMenuDAO(SysMenuDAO sysMenuDAO) {
        this.sysMenuDAO = sysMenuDAO;
    }

    public List<SysMenu> getMenuList(int roleid) throws Exception {
        List<SysMenu> sysMenu = new ArrayList<SysMenu>();//返回菜单列表
        List<SysMenu> parentMenu = this.sysMenuDAO.getParentMenuList(roleid);//父节点菜单列表
        //System.out.println(parentMenu);
        if (parentMenu != null && parentMenu.size() > 0) {
            for (int i = 0; i < parentMenu.size(); i++) {
                SysMenu menu = (SysMenu) parentMenu.get(i);
                List<SysMenu> childMenu = this.sysMenuDAO.getChildMenuList(roleid, menu.getId());//子节点单列表
                parentMenu.addAll(childMenu);
            }

            Collections.sort(parentMenu, new Comparator<SysMenu>() {
                public int compare(SysMenu arg0, SysMenu arg1) {
                    return arg0.getId().compareTo(arg1.getId());
                }
            });
        }
        //System.out.println("后来的"+parentMenu);
        return parentMenu;
    }


}
