package com.moveit.client.model;

import com.moveit.client.util.EqualsUtil;

import java.io.Serializable;

/**
 *
 */
public class SearchCriteria implements Comparable<SearchCriteria>, Serializable {
    private static final long serialVersionUID = -1671777033212813515L;

    private String countryCode;
    private Double latitude = null;
    private Double longitude = null;
    private Integer radius = null;
    private Boolean toArea = true;
    private Boolean fromArea = true;

    public SearchCriteria() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public boolean equals(Object obj) {
        return obj instanceof SearchCriteria && compareTo((SearchCriteria) obj) == 0;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }


    public boolean hasAreaRestrictions(){
        return radius != 0;
    }

    public int compareTo(SearchCriteria searchRutes) {
        if (searchRutes == null) {
            return 1;
        }

        int ret = EqualsUtil.compareTo(latitude, searchRutes.getLatitude());
        if (ret != 0) {
            return ret;
        }
        return EqualsUtil.compareTo(longitude, searchRutes.getLongitude());
    }

    public Boolean getToArea() {
        return toArea;
    }

    public void setToArea(Boolean toArea) {
        this.toArea = toArea;
    }

    public Boolean getFromArea() {
        return fromArea;
    }

    public void setFromArea(Boolean fromArea) {
        this.fromArea = fromArea;
    }

    /*
    if (a < b) {
        return -1;
    }
    if (a > b) {
        return 1;
    }
    return 0;
    */


    public boolean isEmpty() {
        return this.equals(new SearchCriteria());
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                ", toArea=" + toArea +
                ", fromArea=" + fromArea +
                '}';
    }
}
