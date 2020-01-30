package com.entity.po;

/**
 * @Author: StevenClise
 * @Date : 2019/12/20
 **/
public class FUser {

    private int userId;

    private String uName;

    private String uPwd;

    private String statue;

    public FUser() {
    }

    public FUser(int userId, String uName, String uPwd, String statue) {
        this.userId = userId;
        this.uName = uName;
        this.uPwd = uPwd;
        this.statue = statue;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
