package com.pkk.model.base;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.action.base
 * @Description: <love项目基类>
 * @date 11/2 0002 15:06
 */
public interface IPkkBaseModel extends Serializable {

    Integer getId();

    void setId(Integer id);

    void setInputdate(Timestamp inputdate);

    Timestamp getInputdate();

}
