package com.moveit.client.model;

import com.moveit.client.constants.OfferTypeConstant;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class Route extends Model implements Serializable {
    private static final long serialVersionUID = 7930835722959317232L;

    private Long id;
    private Long userId;


    private Date createdDate;
    private Date lastChangeDate;

    private GeoPoint fromPoint = null;
    private GeoPoint toPoint = null;

    private Date fromDate;
    private Date toDate;

    private Integer cargoType;
    private String cargoDescription;
    private OfferTypeConstant offerType;

    private Boolean deleted = false;
    private Integer contactWish;

    private String infoShownTo;
    private Long counter;

    public Route() {
    }


    public Route(GeoPoint fromPoint, GeoPoint toPoint) {

        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
    }

    public GeoPoint getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(GeoPoint newValue) {
        this.fromPoint = newValue;
    }

    public GeoPoint getToPoint() {
        return toPoint;
    }

    public void setToPoint(GeoPoint newValue) {
        this.toPoint = newValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OfferTypeConstant getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferTypeConstant offerType) {
        this.offerType = offerType;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getInfoShownTo() {
        return infoShownTo;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public int countInfoShownTo() {
        if (infoShownTo == null || infoShownTo.equals("")) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while (index < infoShownTo.length()) {
            if (infoShownTo.charAt(index) == ' ') {
                count++;
            }
            index++;
        }
        return count;
    }

    public boolean hasBeenShownTo(Long userId) {
        //noinspection SimplifiableIfStatement
        if (infoShownTo == null || infoShownTo.equals("")) {
            return false;
        }
        return infoShownTo.contains(String.valueOf(userId));
    }

    public void setInfoShownTo(String infoShownTo) {
        this.infoShownTo = infoShownTo;
    }

    @Override
    public String toString() {
        return "Route{" +
                "fromPoint=" + fromPoint +
                ", toPoint=" + toPoint +
                '}';
    }

    public static List<Route> extractNotDeleted(Collection<Route> routes) {
        List<Route> list = new ArrayList<Route>();
        for (Route r : routes) {
            if (!r.isDeleted()) {
                list.add(r);
            }
        }
        return list;
    }

    public static List<Route> extractByCountryCode(Collection<Route> routes, String countryCode) {
        List<Route> list = new ArrayList<Route>();
        for (Route r : routes) {
            if (r.containsCoutryCode(countryCode)) {
                list.add(r);
            }
        }
        return list;
    }

    public boolean containsCoutryCode(String countryCode) {
        return getFromPoint().getAddress().getNationalCode().equalsIgnoreCase(countryCode)
                    || getToPoint().getAddress().getNationalCode().equalsIgnoreCase(countryCode);
    }

    public String getToolTip() {
        return fromPoint.getAddress().getCityCityCodeAndNationCode() + " -> " + toPoint.getAddress().getCityCityCodeAndNationCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Route)) {
            return false;
        }
        Route r = (Route) obj;
        if (fromPoint == null && toPoint == null) {
            return r.getFromPoint() == null && r.getToPoint() == null;
        }
        if (fromPoint != null && toPoint != null) {
            return fromPoint.equals(r.getFromPoint()) && toPoint.equals(r.getToPoint());
        }
        if (fromPoint != null) {//toPoint must be null
            return fromPoint.equals(r.getFromPoint()) && r.getToPoint() == null;
        }
        //fromPoint must be null and toPoint cannot be
        return toPoint.equals(r.getToPoint()) && r.getFromPoint() == null;
    }

    public Integer getContactWish() {
        return contactWish;
    }

    public void setContactWish(Integer contactWish) {
        this.contactWish = contactWish;
    }
}
