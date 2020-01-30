package com.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * user_info
 * @author 
 */
@Data
public class UserInfo implements Serializable {
    private Integer userinfoid;

    private Integer userid;

    private String realname;

    private String sex;

    private String age;

    private String address;

    private String telno;

    private String idcardno;

    private static final long serialVersionUID = 1L;

    public UserInfo() {
    }

    public UserInfo(Integer userinfoid, Integer userid, String realname, String sex, String age, String address, String telno, String idcardno) {
        this.userinfoid = userinfoid;
        this.userid = userid;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.telno = telno;
        this.idcardno = idcardno;
    }

    public Integer getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(Integer userinfoid) {
        this.userinfoid = userinfoid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}