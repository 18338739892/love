package com.pkk.utils.condition;

import java.util.List;


/**
 * @author peikunkun<br>
 * @version V1.0<br>
 * @Title: <br>
 * @Description: <><br>
 * @date 2017年11/16 0016 17:49<br>
 */
public interface Page extends SoftUtils {


    int getPageNo();

    void setPageNo(int pageno);

    int getRowSize();

    void setRowSize(int rowsize);

    List getRecored();

    void setRecored(List list);
}
