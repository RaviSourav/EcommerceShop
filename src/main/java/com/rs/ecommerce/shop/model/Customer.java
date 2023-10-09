package com.rs.ecommerce.shop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Entity
public class Customer {
    @Id
    private int cusId;
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime lastLoginTimeStamp;
    @JsonProperty //reason: https://stackoverflow.com/questions/21913955/json-post-request-for-boolean-field-sends-false-by-default
    private boolean isAdmin;

    public Customer() {

    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public LocalDateTime getLastLoginTimeStamp() {
        return lastLoginTimeStamp;
    }

    public void setLastLoginTimeStamp(LocalDateTime lastLoginTimeStamp) {
        this.lastLoginTimeStamp = lastLoginTimeStamp;
    }

//    public boolean isAdmin() {
//        return isAdmin;
//    }
//
//    public void setAdmin(boolean isAdmin) {
//        this.isAdmin = isAdmin;
//    }

    public Customer(int cusId, String fname, String lname, String phone, String email,
                    String password, LocalDateTime createdDate, LocalDateTime modifiedDate,
                    LocalDateTime lastLoginTimeStamp, boolean isAdmin) {
        this.cusId = cusId;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.lastLoginTimeStamp = lastLoginTimeStamp;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", lastLoginTimeStamp=" + lastLoginTimeStamp +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
