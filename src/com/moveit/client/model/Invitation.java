package com.moveit.client.model;


import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Invitation extends Model implements Serializable {
    private static final long serialVersionUID = 2766148233166254520L;

    private Long id;

    private String email;
    private Boolean sent;
    private Date createdDate;
    private Date lastChangeDate;
    private String nationCode;
    private Integer Language;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Boolean isSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public Integer getLanguage() {
        return Language;
    }

    public void setLanguage(Integer language) {
        Language = language;
    }
}