package com.moveit.client.model;


import com.moveit.client.constants.OfferTypeConstant;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class CreateRoute extends Creater implements Serializable {
    private static final long serialVersionUID = 7036747186961740195L;

    private Long userId;

    //TO
    private Double toLatitude;
    private Double toLongitude;
    private String toCountryCode;
    private String toCountry;
    private String toStreet;
    private String toCity;
    private String toCityCode;

    //FROM
    private Double fromLatitude;
    private Double fromLongitude;
    private String fromCountryCode;
    private String fromCountry;
    private String fromStreet;
    private String fromCity;
    private String fromCityCode;

    //DESCRIPTIVE
    private Integer cargoType = 0;
    private Date fromDate;
    private Date toDate;
    private String cargoDescription;
    private OfferTypeConstant offerType;

    private Integer contactWish;

    public CreateRoute(){

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OfferTypeConstant getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferTypeConstant offerType) {
        this.offerType = offerType;
    }

    public Integer getContactWish() {
        return contactWish;
    }

    public void setContactWish(Integer contactWish) {
        this.contactWish = contactWish;
    }
}
