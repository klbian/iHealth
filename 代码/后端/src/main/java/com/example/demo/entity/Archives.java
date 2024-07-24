package com.example.demo.entity;

public class Archives {
    private String archivesID;
    private String BID;
    private String chattime;
    private String chartresult;
    private int recover;

    public String getArchivesID() {
        return archivesID;
    }

    public void setArchivesID(String archivesID) {
        this.archivesID = archivesID;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getChattime() {
        return chattime;
    }

    public void setChattime(String chattime) {
        this.chattime = chattime;
    }

    public String getChartresult() {
        return chartresult;
    }

    public void setChartresult(String chartresult) {
        this.chartresult = chartresult;
    }

    public int getRecover() {
        return recover;
    }

    public void setRecover(int recover) {
        this.recover = recover;
    }
}
