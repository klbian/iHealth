package com.example.demo.entity;

public class Images {

    private String DrugID;
    private String imgtype;
    private String imgorder;
    private byte[] img;
    private String ImgID;

    public String getImgID() {
        return ImgID;
    }

    public void setImgID(String imgID) {
        ImgID = imgID;
    }

    public String getDrugID() {
        return DrugID;
    }

    public void setDrugID(String drugID) {
        DrugID = drugID;
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

    public String getImgorder() {
        return imgorder;
    }

    public void setImgorder(String imgorder) {
        this.imgorder = imgorder;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
