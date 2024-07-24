package com.example.demo.entity;

public class Addressee {
    private String AddressID;
    private String BID;
    private String address;
    private String name;
    private String phone;

    public String getAddressID() {
        return AddressID;
    }

    public void setAddressID(String AddressID) {
        this.AddressID = AddressID;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
