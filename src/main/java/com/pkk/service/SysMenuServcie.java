package com.pkk.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pkk.dao.SysMenuDAO;
import com.pkk.model.SysMenu;
import com.pkk.model.SysRoleDetail;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.service
 * @Description: <>
 * @date 11/2 0002 14:59
 */
@Service
public class SysMenuServcie extends BaseService<SysMenu> {

    @Resource
    private SysMenuDAO sysMenuDAO;

    @SuppressWarnings(value = "all")
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
                @Override
                public int compare(SysMenu arg0, SysMenu arg1) {
                    return arg0.getId().compareTo(arg1.getId());
                }
            });
        }
        return parentMenu;
    }


    /**
     * *************************************************************************
     *
     * @param
     * @return boolean
     * @Description: <创建菜单>
     * @author peikunkun
     * @date 2017年11/21 0021 16:04
     * @version V1.0
     * *************************************************************************
     */
    public boolean createMenu(SysMenu sysMenu, String userid) {

        if (sysMenu == null || userid == null || userid.length() < 0) {
            return false;
        }

        /*初始化父菜单的值*/
        if (sysMenu.getParentid() == null || sysMenu.getParentid().toString().length() <= 0) {
            sysMenu.setParentid(0);
        }
        sysMenu = sysMenuDAO.saveMenu(sysMenu);

        SysRoleDetail sysRoleDetail = new SysRoleDetail();
        sysRoleDetail.setRoleid(Integer.parseInt(userid));
        sysRoleDetail.setMenuid(sysMenu.getId());
        sysRoleDetail.setInputdate(new Timestamp(System.currentTimeMillis()));
        Integer result = sysMenuDAO.save(sysRoleDetail);
        if (result <= 0) {
            return false;
        } else {
            return true;
        }
    }


    public boolean verifyMenuName(String menuName, String userId) {
        if (userId == null || menuName == null || userId.length() <= 0 || menuName.length() <= 0) {
            return false;
        }
        String menunameTemp = sysMenuDAO.getPropertiesByCondition(menuName, Integer.parseInt(userId));

        if (menunameTemp == null || menunameTemp.length() <= 0) {
            return false;
        } else {
            return true;
        }
    }


    public List<SysMenu> getSysMenuByUsrtId(String userid) {
        if (userid == null || userid.length() <= 0) {
            return null;
        }
        List<SysMenu> result = sysMenuDAO.getSysMenuByUserId(Integer.parseInt(userid));
        return result;
    }

}
