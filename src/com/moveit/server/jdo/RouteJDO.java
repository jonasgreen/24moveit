package com.moveit.server.jdo;

import com.moveit.server.dao.JDO;

import javax.jdo.annotations.*;
import java.util.Date;

/**
 *
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class RouteJDO extends JDO {      
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String encodedKey;

    @Persistent()
    @Extension(vendorName = "datanucleus", key = "gae.pk-id", value = "true")
    private Long keyId;


    @Persistent
    private Long userId;

    //TO

    @Persistent
    private Double toLatitude;


    @Persistent
    private Double toLongitude;


    @Persistent
    private String toCountryCode;

    @Persistent
    private String toCountry;

    @Persistent
    private String toStreet;


    @Persistent
    private String toCity;

    @Persistent
    private String toCityCode;

    //FROM

    @Persistent
    private Double fromLatitude;


    
    @Persistent
    private Double fromLongitude;


    @Persistent
    private String fromCountryCode;

    @Persistent
    private String fromCountry;

    @Persistent
    private String fromStreet;


    @Persistent
    private String fromCity;

    @Persistent
    private String fromCityCode;

    //DESCRIPTIVE
    @Persistent
    private Date fromDate;

    @Persistent
    private Date toDate;

    @Persistent
    private Integer cargoType;

    @Persistent
    private String cargoDescription;

    @Persistent
    private Boolean deleted;

    @Persistent
    private Date createdDate;

    @Persistent
    private Date lastChangeDate;

    @Persistent
    private Integer offerType;

    @Persistent
    private Integer contactWish;

    @Persistent
    private String infoShowedTo;

    @Persistent
    private Long counter;



    public RouteJDO() {

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getToLatitude() {
        return toLatitude;
    }

    public void setToLatitude(Double toLatitude) {
        this.toLatitude = toLatitude;
    }

    public Double getToLongitude() {
        return toLongitude;
    }

    public void setToLongitude(Double toLongitude) {
        this.toLongitude = toLongitude;
    }

    public String getToCountryCode() {
        return toCountryCode;
    }

    public void setToCountryCode(String toCountryCode) {
        this.toCountryCode = toCountryCode;
    }

    public String getToStreet() {
        return toStreet;
    }

    public void setToStreet(String toStreet) {
        this.toStreet = toStreet;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToCityCode() {
        return toCityCode;
    }

    public void setToCityCode(String toCityCode) {
        this.toCityCode = toCityCode;
    }

    public Double getFromLatitude() {
        return fromLatitude;
    }

    public void setFromLatitude(Double fromLatitude) {
        this.fromLatitude = fromLatitude;
    }

    public Double getFromLongitude() {
        return fromLongitude;
    }

    public void setFromLongitude(Double fromLongitude) {
        this.fromLongitude = fromLongitude;
    }

    public String getFromCountryCode() {
        return fromCountryCode;
    }

    public void setFromCountryCode(String fromCountryCode) {
        this.fromCountryCode = fromCountryCode;
    }

    public String getFromStreet() {
        return fromStreet;
    }

    public void setFromStreet(String fromStreet) {
        this.fromStreet = fromStreet;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromCityCode() {
        return fromCityCode;
    }

    public void setFromCityCode(String fromCityCode) {
        this.fromCityCode = fromCityCode;
    }

    public Integer getCargoType() {
        return cargoType;
    }

    public void setCargoType(Integer cargoType) {
        this.cargoType = cargoType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }


    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Integer getOfferType() {
        return offerType;
    }

    public void setOfferType(Integer offerType) {
        this.offerType = offerType;
    }

    public Integer getContactWish() {
        return contactWish;
    }

    public void setContactWish(Integer contactWish) {
        this.contactWish = contactWish;
    }

    public String getInfoShowedTo() {
        return infoShowedTo;
    }

    public void setInfoShowedTo(String infoShowedTo) {
        this.infoShowedTo = infoShowedTo;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
}
