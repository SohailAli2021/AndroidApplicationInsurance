package com.example.insurenceapp;

public class BuyHolder {
    public  String purname1,purcnic2,puraddess3,puremail4,purcontat5, policytime;

    public BuyHolder(String purname1, String purcnic2, String puraddess3, String puremail4, String purcontat5, String policytime) {
        this.purname1 = purname1;
        this.purcnic2 = purcnic2;
        this.puraddess3 = puraddess3;
        this.puremail4 = puremail4;
        this.purcontat5 = purcontat5;
        this.policytime=policytime;

    }

    public BuyHolder() {
    }

    public String getPurname1() {
        return purname1;
    }

    public void setPurname1(String purname1) {
        this.purname1 = purname1;
    }

    public String getPurcnic2() {
        return purcnic2;
    }

    public void setPurcnic2(String purcnic2) {
        this.purcnic2 = purcnic2;
    }

    public String getPuraddess3() {
        return puraddess3;
    }

    public void setPuraddess3(String puraddess3) {
        this.puraddess3 = puraddess3;
    }

    public String getPuremail4() {
        return puremail4;
    }

    public void setPuremail4(String puremail4) {
        this.puremail4 = puremail4;
    }

    public String getPurcontat5() {
        return purcontat5;
    }

    public void setPurcontat5(String purcontat5) {
        this.purcontat5 = purcontat5;
    }

    public String getPolicytime() {
        return policytime;
    }

    public void setPolicytime(String policytime) {
        this.policytime = policytime;
    }
}
