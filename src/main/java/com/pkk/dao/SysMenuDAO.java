package com.pkk.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pkk.base.BaseDao;
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
public class SysMenuDAO extends BaseDao<SysMenu> {

    private Logger logger = Logger.getLogger(SysMenuDAO.class);


    /**
     * 获取父节点
     *
     * @param roleid
     * @return
     */
    public List<SysMenu> getParentMenuList(int roleid) {

        try {
//            String sql = "from SysMenu where id in(select menuid from SysRoleDetail where roleid= :roleid ) and parentid=0 and plevel=1 and status=1 order by id";
            String sql = "from SysMenu where id in(1,2,3,20) and parentid=0 and plevel=1 and status=1 order by id";

            return (List<SysMenu>) super.sessionFactory.getCurrentSession().createQuery(sql).list();
        } catch (RuntimeException re) {
            logger.error("获取父节点菜单出错：", re);
            return null;
        }
    }

    public List<SysMenu> getChildMenuList(int roleid, int parentid) {
        try {
//            String sql = "from SysMenu where id in(select menuid from SysRoleDetail where roleid= :roleid ) and parentid= :parentid and status=1 order by id ";
            String sql = "from SysMenu where id in(1,2,3,20) and parentid= :parentid and status=1 order by id ";
            return (List<SysMenu>) super.sessionFactory.getCurrentSession().createQuery(sql).setParameter("parentid", parentid).list();

        } catch (RuntimeException re) {
            logger.error("获取子节点菜单出错：", re);
            return null;
        }
    }


}
