package com.pkk.utils.condition;

/**
 * Created by peikunkun on 2017/10/22 0022.
 *
 * @Description: <显示页数的工具类>
 */
public class PageCondition {
    /**
     * 当前页数
     */
    private int    page;
    /**
     * 每页显示的条数
     */
    private int    pagesize;
    /**
     * 排序字段
     */
    private String sortname;
    /**
     * 排序顺序
     */
    private String sortorder;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    @Override
    public String toString() {
        return "PageCondition{" +
                "page=" + page +
                ", pagesize=" + pagesize +
                ", sortname='" + sortname + '\'' +
                ", sortorder='" + sortorder + '\'' +
                '}';
    }
}
