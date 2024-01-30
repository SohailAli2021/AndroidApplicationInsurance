package com.example.insurenceapp;

public class AdminShowUserHolder {
    private String firstname, lastname, email, gender, role;
    private String policyName;
    private String policyNumber;
    private String policyAddress;
    private String policyCnic;
    private String policyTime;

    public AdminShowUserHolder() {
    }

    public AdminShowUserHolder(String firstname, String lastname, String email, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
    }

    public AdminShowUserHolder(String firstname, String lastname, String email, String gender, String role, String policyName, String policyNumber, String policyAddress, String policyCnic, String policyTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.role = role;
        this.policyName = policyName;
        this.policyNumber = policyNumber;
        this.policyAddress = policyAddress;
        this.policyCnic = policyCnic;
        this.policyTime = policyTime;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyAddress() {
        return policyAddress;
    }

    public void setPolicyAddress(String policyAddress) {
        this.policyAddress = policyAddress;
    }

    public String getPolicyCnic() {
        return policyCnic;
    }

    public void setPolicyCnic(String policyCnic) {
        this.policyCnic = policyCnic;
    }

    public String getPolicyTime() {
        return policyTime;
    }

    public void setPolicyTime(String policyTime) {
        this.policyTime = policyTime;
    }
}
