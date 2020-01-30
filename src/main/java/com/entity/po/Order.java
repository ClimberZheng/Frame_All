package com.entity.po;

import java.io.Serializable;

/**
 * order
 * @author 
 */
public class Order implements Serializable {
    private Integer orderid;

    private String ono;

    private Integer comid;

    private String cnum;

    private String pay;

    private Integer userid;

    private String createtime;

    private String reciveadre;

    private String revicename;

    private String recivetel;

    private static final long serialVersionUID = 1L;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getReciveadre() {
        return reciveadre;
    }

    public void setReciveadre(String reciveadre) {
        this.reciveadre = reciveadre;
    }

    public String getRevicename() {
        return revicename;
    }

    public void setRevicename(String revicename) {
        this.revicename = revicename;
    }

    public String getRecivetel() {
        return recivetel;
    }

    public void setRecivetel(String recivetel) {
        this.recivetel = recivetel;
    }
}