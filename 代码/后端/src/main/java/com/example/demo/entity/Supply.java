package com.example.demo.entity;

import java.math.BigDecimal;

public class Supply {
    private String DrugID;
    private int Dinventory;
    private BigDecimal Dprice;
    private int Ssales;
    private String SID;
    private String Sname;

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getDrugID() {
        return DrugID;
    }

    public void setDrugID(String drugID) {
        DrugID = drugID;
    }

    public int getDinventory() {
        return Dinventory;
    }

    public void setDinventory(int dinventory) {
        Dinventory = dinventory;
    }

    public BigDecimal getDprice() {
        return Dprice;
    }

    public void setDprice(BigDecimal dprice) {
        Dprice = dprice;
    }

    public int getSsales() {
        return Ssales;
    }

    public void setSsales(int ssales) {
        Ssales = ssales;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
}
