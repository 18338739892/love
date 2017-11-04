package com.pkk.action.menu;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pkk.base.BaseAction;
import com.pkk.model.SysMenu;
import com.pkk.model.SysUser;
import com.pkk.service.SysMenuServcie;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.action.menu
 * @Description: <>
 * @date 11/2 0002 13:51
 */
@Controller
public class SysMenuAction extends BaseAction {


    @Resource
    private SysMenuServcie sysMenuService;
    private List<SysMenu>  sysMenus;

    public List<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public void setSysMenus(List<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }

    public static void main(String[] args) {
        new SysMenuAction().queryMenu();
    }


    public String queryMenu() {

        SysUser sysUserTest = new SysUser();
        sysUserTest.setId(1);
        sysUserTest.setRoleid(1);

        super.session.put("sysUserInfo", sysUserTest);

        // 从session中获得用户信息，取出角色id
        SysUser sysUser = (SysUser) super.session.get("sysUserInfo");
        if (sysUser != null) {
            Integer roleId = sysUser.getRoleid();
            // 根据角色id获得菜单
            try {
                sysMenus = this.sysMenuService.getMenuList(roleId);
                System.out.println(sysMenus);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "makeMenu";
    }

    public String openNorth() {
        return "openNorth";
    }
}
