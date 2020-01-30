package com.entity.dto;

import com.entity.po.Commodity;
import com.entity.po.FUser;

import java.io.Serializable;

/**
 * order
 * @author 
 */
public class OrderDetail implements Serializable {
    private Integer orderid;

    private String ono;

    private Commodity commodity;

    private String cnum;

    private String pay;

    private UserDetail userDetail;

    private String createtime;

    private String reciveadre;

    private String revicename;

    private String recivetel;

    private static final long serialVersionUID = 1L;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderid, String ono, Commodity commodity, String cnum, String pay, UserDetail userDetail, String createtime, String reciveadre, String revicename, String recivetel) {
        this.orderid = orderid;
        this.ono = ono;
        this.commodity = commodity;
        this.cnum = cnum;
        this.pay = pay;
        this.userDetail = userDetail;
        this.createtime = createtime;
        this.reciveadre = reciveadre;
        this.revicename = revicename;
        this.recivetel = recivetel;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public UserDetail getfUser() {
        return userDetail;
    }

    public void setfUser(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}