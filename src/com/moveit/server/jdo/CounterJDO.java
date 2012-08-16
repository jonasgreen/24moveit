package com.moveit.server.jdo;

import com.moveit.server.dao.JDO;

import javax.jdo.annotations.*;
import java.util.Date;

/**
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class CounterJDO extends JDO {


    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String encodedKey;

    @Persistent()
    @Extension(vendorName = "datanucleus", key = "gae.pk-id", value = "true")
    private Long keyId;


    @Persistent
    private Integer key;

    @Persistent
    private String name;

    @Persistent
    private Long counter;

    @Persistent
    private Date createdDate;

    @Persistent
    private Date lastChangeDate;


    public CounterJDO() {

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

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}