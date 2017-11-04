package com.pkk.base;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author peikunkun
 * @version V1.0
 * @Title: love
 * @Package com.pkk.base
 * @Description: <>
 * @date 11/2 0002 15:06
 */
public interface IPkkBaseModel extends Serializable {

    Integer getId();

    void setId(Integer id);

    public void setInputdate(Timestamp inputdate);

    public Timestamp getInputdate();

}
