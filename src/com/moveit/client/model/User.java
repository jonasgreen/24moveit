package com.moveit.client.model;


import com.moveit.client.constants.UserTypeConstant;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class User extends Model implements Serializable {
    private static final long serialVersionUID = 4834656240567205753L;

    private Long id;

    private String nationality;
    private String email;
    private String phone;
    private String password;
    private String name;
    private Integer userType;

    private Date createdDate;
    private Date lastChangeDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserType() {
        return userType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isDriver(){
        return userType != UserTypeConstant.CUSTOMER.getValue();
    }

    public boolean isDanish(){
        return nationality.equalsIgnoreCase("DK");
    }

}
