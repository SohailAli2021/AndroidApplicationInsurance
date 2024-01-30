package com.example.insurenceapp;

public class AddPolicyHolder {
 public String policyname,term,policynumber,policyemail,contactnumber,policy ;

 public AddPolicyHolder(String policyname, String term, String policynumber, String policyemail, String contactnumber,String policy) {
  this.policyname = policyname;
  this.term = term;
  this.policynumber = policynumber;
  this.policyemail = policyemail;
  this.contactnumber = contactnumber;
  this.policy=policy;
 }

 public String getPolicyname() {
  return policyname;
 }

 public void setPolicyname(String policyname) {
  this.policyname = policyname;
 }

 public String getTerm() {
  return term;
 }

 public void setTerm(String term) {
  this.term = term;
 }

 public String getPolicynumber() {
  return policynumber;
 }

 public void setPolicynumber(String policynumber) {
  this.policynumber = policynumber;
 }

 public String getPolicyemail() {
  return policyemail;
 }

 public void setPolicyemail(String policyemail) {
  this.policyemail = policyemail;
 }

 public String getContactnumber() {
  return contactnumber;
 }

 public void setContactnumber(String contactnumber) {
  this.contactnumber = contactnumber;
 }

 public String getPolicy() {
  return policy;
 }

 public void setPolicy(String policy) {
  this.policy = policy;
 }
}
