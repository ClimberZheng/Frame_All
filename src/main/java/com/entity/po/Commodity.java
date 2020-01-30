package com.entity.po;

import java.io.Serializable;

public class Commodity implements Serializable {

    private int comid;

    private String cName;

    private String description;

    private String price;

    private String pic;

    public Commodity(int comid, String cName, String description, String price, String pic) {
        this.comid = comid;
        this.cName = cName;
        this.description = description;
        this.price = price;
        this.pic = pic;
    }

    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "comid='" + comid + '\'' +
                ", cName='" + cName + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
