package com.example.demo.entity;

public class Drug {
    private String DrugID;
    private String Dname;
    private String Dmessage;
    private String Dtype;
    private int Dsales;

    public String getDrugID() {
        return DrugID;
    }

    public void setDrugID(String drugID) {
        DrugID = drugID;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDmessage() {
        return Dmessage;
    }

    public void setDmessage(String dmessage) {
        Dmessage = dmessage;
    }

    public String getDtype() {
        return Dtype;
    }

    public void setDtype(String dtype) {
        Dtype = dtype;
    }

    public int getDsales() {
        return Dsales;
    }

    public void setDsales(int dsales) {
        Dsales = dsales;
    }
}
