package com.entity.dto;

public class UserDetail {
    private Integer userinfoid;

    private String uName;

    private String uPwd;

    private String statue;

    private Integer userid;

    private String realname;

    private String sex;

    private String age;

    private String address;

    private String telno;

    private String idcardno;

    public UserDetail() {
    }

    public UserDetail(Integer userinfoid, String uName, String uPwd, String statue, Integer userid, String realname, String sex, String age, String address, String telno, String idcardno) {
        this.userinfoid = userinfoid;
        this.uName = uName;
        this.uPwd = uPwd;
        this.statue = statue;
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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
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
}
