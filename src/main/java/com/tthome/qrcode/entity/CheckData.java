package com.tthome.qrcode.entity;



public class CheckData {
    private int id;
    private String hashcode;
    private int isCheck;

    public CheckData(int id, String hashcode, int isCheck) {
        this.id = id;
        this.hashcode = hashcode;
        this.isCheck = isCheck;
    }

    public CheckData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "CheckData{" +
                "id=" + id +
                ", hashcode='" + hashcode + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}
