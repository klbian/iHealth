package com.example.demo.entity;

import java.math.BigDecimal;

public class Orderdetail {

    private String OdID;
    private String OID;
    private String DID;
    private String SID;
    private BigDecimal price;
    private int num;

    public String getOdID() {
        return OdID;
    }

    public void setOdID(String odID) {
        OdID = odID;
    }

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
