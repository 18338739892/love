package com.pkk.action.menu;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.pkk.action.base.BaseAction;
import com.pkk.model.SysMenu;
import com.pkk.model.UserModel;
import com.pkk.service.SysMenuServcie;
import com.pkk.service.UserLoginService;
import com.pkk.utils.constant.SysConstant;

import static org.apache.struts2.interceptor.DateTextFieldInterceptor.DateWord.s;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.action.menu
 * @Description: <>
 * @date 11/2 0002 13:51
 */
public class SysMenuAction extends BaseAction {


    private SysMenu sysMenu;
    private String  userid;//用户编号
    private String  menuname;//菜单名称

    @Resource
    private SysMenuServcie sysMenuService;

    @Resource
    private UserLoginService userLoginService;

    private List<SysMenu> sysMenus;

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public SysMenu getSysMenu() {
        return sysMenu;
    }

    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }

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
        UserModel userModel = (UserModel) ActionContext.getContext().getSession().get("user");
        userModel = userLoginService.findUserByProperties(userModel.getUname(), userModel.getPassword());
        ActionContext.getContext().getSession().put("user", userModel);
        if (userModel != null) {
            /*根据用户的id来与菜单关联*/
            Integer roleId = userModel.getId();
            // 根据角色id获得菜单
            try {
                sysMenus = this.sysMenuService.getMenuList(roleId);
                /*没有菜单提醒开通功能*/

                /*新创建的 管理员具有初始化增加菜单的功能*/
                if (userModel.getLevel() != null && "0".equals(userModel.getLevel())) {
                    if (sysMenus == null || sysMenus.size() <= 0) {
                        SysMenu sysMenu = new SysMenu();
                        sysMenu.setId(1);//菜单id
                        sysMenu.setParentid(0);//父节点的id
                        sysMenu.setMenuname("菜单管理");
                        sysMenu.setStatus("1");//启用
                        sysMenu.setPlevel("1");//是否是父接口0否1是


                        SysMenu childSysMenu = new SysMenu();
                        childSysMenu.setId(2);//菜单id
                        childSysMenu.setParentid(1);//父节点的id
                        childSysMenu.setMenuname("初始化菜单");
                        childSysMenu.setStatus("1");//启用
                        childSysMenu.setPlevel("0");//是否是父接口0否1是
                        childSysMenu.setMenuurl(SysConstant.INIT_MENU_URL);

                        sysMenus.add(sysMenu);
                        sysMenus.add(childSysMenu);
                    }
                } else {
                    return "openmenuoperation";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("最终的菜单为" + sysMenus);
        return "makeMenu";
    }


    public String initMenu() {
        return "initmenu";
    }


    /**
     * 创建菜单
     */
    public void markMenu() {
        HashMap<String, String> map = new HashMap<>();//返回参数

        boolean result = sysMenuService.createMenu(sysMenu, userid);
        if (result) {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_SUCCESS);
            map.put(SysConstant.RETURN_MSG, "创建菜单成功");
            writeJson(map);
        } else {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_ERROR);
            map.put(SysConstant.RETURN_MSG, "创建菜单失败");
            writeJson(map);
        }
    }


    /**
     * 验证菜单是否存在在当前账户上
     */
    public void verifyMenuName() {
        HashMap<String, String> map = new HashMap<>();//返回参数

        boolean result = sysMenuService.verifyMenuName(menuname, userid);
        if (result) {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_SUCCESS);
            map.put(SysConstant.RETURN_MSG, menuname + "-在该账户下是已经存在的");
            writeJson(map);
        } else {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_ERROR);
            map.put(SysConstant.RETURN_MSG, menuname + "-菜单不存在，可以创建");
            writeJson(map);
        }
    }

    /**
     * 加载父菜单
     */
    public void loadMenu() {
        HashMap<String, Object> map = new HashMap<>();//返回参数
        List<SysMenu> result = sysMenuService.getSysMenuByUsrtId(userid);

        if (result == null || result.size() <= 0) {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_ERROR);
            map.put(SysConstant.RETURN_MSG, "没有查到父菜单");
        } else {
            map.put(SysConstant.RETURN_CODE, SysConstant.RETURN_CODE_SUCCESS);
            map.put(SysConstant.RETURN_MSG, result);
        }
        writeJson(map);
    }

    public String openNorth() {
        return "openNorth";
    }
}
