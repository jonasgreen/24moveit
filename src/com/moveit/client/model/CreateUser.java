package com.moveit.client.model;

import com.moveit.client.constants.MailListConstant;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


/**
 *
 */
public class CreateUser extends Creater implements Serializable {
    private static final long serialVersionUID = -6383134529154955454L;

    private Integer userType;

    private Address address;

    private String firmName;
    private Long cvrnr;
    private String website;

    private String name;
    private String Phone;
    private String email;
    private String password;
    private List<MailListConstant> mailLists = new ArrayList<MailListConstant>();

    public CreateUser() {
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
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

    public List<MailListConstant> getMailLists() {
        return mailLists;
    }

    public void setMailLists(List<MailListConstant> mailLists) {
        this.mailLists = mailLists;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public Long getCvrnr() {
        return cvrnr;
    }

    public void setCvrnr(Long cvrnr) {
        this.cvrnr = cvrnr;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
