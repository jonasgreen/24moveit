package com.moveit.server.jdo;

import com.moveit.server.dao.JDO;

import javax.jdo.annotations.*;
import java.util.Date;

/**
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class SubscriptionJDO extends JDO {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String encodedKey;

    @Persistent
    @Extension(vendorName = "datanucleus", key = "gae.pk-id", value = "true")
    private Long keyId;

    @Persistent
    private Integer mailList;

    
    @Persistent
    private Long userId;

    @Persistent
    private Date createdDate;

    @Persistent
    private Date lastChangeDate;


    public SubscriptionJDO() {
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

    public Integer getMailList() {
        return mailList;
    }

    public void setMailList(Integer mailList) {
        this.mailList = mailList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


}