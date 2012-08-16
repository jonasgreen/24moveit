package com.moveit.server.jdo;

import com.moveit.server.dao.JDO;

import javax.jdo.annotations.*;
import java.util.Date;


/**
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class InvitationJDO extends JDO {

	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String encodedKey;


    @Persistent
    @Extension(vendorName = "datanucleus", key = "gae.pk-id", value = "true")
    private Long keyId;


    @Persistent
    private String email;

    @Persistent
    private Integer language;


    @Persistent
    private Boolean sent;


    @Persistent
    private Date createdDate;

    @Persistent
    private Date lastChangeDate;


    public InvitationJDO() {
    }


    public String getEncodedKey() {
        return encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }
}