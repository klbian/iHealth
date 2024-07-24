package com.example.demo.entity;

public class Diseaseinfo {
    private String DisInfoID;
    private String city;
    private String starttime;
    private String endtime;
    private String diseasename;
    private String diseasemessage;
    private String duration;
    private String mostsearch;
    private String mostDrugID;

    public String getDisInfoID() {
        return DisInfoID;
    }

    public void setDisInfoID(String disInfoID) {
        DisInfoID = disInfoID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    public String getDiseasemessage() {
        return diseasemessage;
    }

    public void setDiseasemessage(String diseasemessage) {
        this.diseasemessage = diseasemessage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMostsearch() {
        return mostsearch;
    }

    public void setMostsearch(String mostsearch) {
        this.mostsearch = mostsearch;
    }

    public String getMostDrugID() {
        return mostDrugID;
    }

    public void setMostDrugID(String mostDrugID) {
        this.mostDrugID = mostDrugID;
    }
}
