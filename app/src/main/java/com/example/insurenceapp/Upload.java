package com.example.insurenceapp;

public class Upload {
    public String uploadname;
    public  String url;

    public Upload() {
    }

    public Upload(String uploadname, String url) {
        this.uploadname = uploadname;
        this.url = url;
    }

    public String getUploadname() {
        return uploadname;
    }

    public void setUploadname(String uploadname) {
        this.uploadname = uploadname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
