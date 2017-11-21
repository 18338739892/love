package com.pkk.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pkk.dao.base.BaseDAO;
import com.pkk.model.SysMenu;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.dao
 * @Description: <>
 * @date 11/2 0002 14:52
 */
@SuppressWarnings("unchecked")
@Repository
public class SysMenuDAO extends BaseDAO<SysMenu> {

    private Logger logger = Logger.getLogger(SysMenuDAO.class);


    /**
     * 获取父节点
     *
     * @param roleid
     * @return
     */
    public List<SysMenu> getParentMenuList(int roleid) throws RuntimeException {

        try {
            String sql = "from SysMenu a where a.id in(select s.menuid from SysRoleDetail s where s.roleid= :roleid ) and a.parentid=0 and a.plevel=1 and a.status=1 order by a.id";
            return (List<SysMenu>) super.getSession().createQuery(sql).setParameter("roleid", roleid).list();
        } catch (RuntimeException re) {
            logger.error("获取父节点菜单出错：", re);
            throw new RuntimeException();
        }
    }

    public List<SysMenu> getChildMenuList(int roleid, int parentid) throws RuntimeException {
        try {
            String sql = "from SysMenu where id in(select s.menuid  from SysRoleDetail s where s.roleid= :roleid) and parentid= :parentid and status=1 order by id ";
            return (List<SysMenu>) super.getSession().createQuery(sql).setParameter("roleid", roleid).setParameter("parentid", parentid).list();
        } catch (RuntimeException re) {
            logger.error("获取子节点菜单出错：", re);
            throw new RuntimeException();
        }
    }

    /**
     * *************************************************************************
     *
     * @param
     * @return com.pkk.model.SysMenu
     * @Description: <创建菜单>
     * @author peikunkun
     * @date 2017年11/21 0021 16:01
     * @version V1.0
     * *************************************************************************
     */
    public SysMenu saveMenu(SysMenu sysMenu) {

        SysMenu sysMenu1 = (SysMenu) super.getSession().merge(sysMenu);
        return sysMenu1;
    }

    public String getPropertiesByCondition(String menuName, Integer userId) {
        String hql = "select  s.menuname from SysMenu s where s.menuname=:menuname and s.inputuserid=:id";
        List list = super.findByHqls(hql, new String[]{"menuname", "id"}, new Object[]{menuName, userId});
        String result = list == null || list.size() <= 0 ? null : (String) list.get(0);
        return result;
    }

    public List<SysMenu> getSysMenuByUserId(Integer userId) {
        String hql = "from SysMenu s where s.plevel='1' and s.status='1' and s.inputuserid=:id";
        List list = super.findByHqls(hql, new String[]{"id"}, new Object[]{userId});
        List<SysMenu> result = list == null || list.size() <= 0 ? null : list;
        return result;
    }


}
