package com.moveit.client.model;

import com.moveit.client.util.EqualsUtil;

import java.io.Serializable;


/**
 * Imutable - must be because its part of a Route and the Route has a listener pattern.
 */
public class GeoPoint implements Serializable{
private static final long serialVersionUID = -6062497095605689701L;

    private Double latitude;
    private Double longitude;
    private Address address;

    public GeoPoint(){

    }

    public GeoPoint(Double latitude, Double longitude, Address address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }


    //---------


    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Address getAddress() {
        return address;
    }

   public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint gp = (GeoPoint) obj;
        return EqualsUtil.equals(latitude, gp.getLatitude())
                && EqualsUtil.equals(longitude, gp.getLongitude());
    }



    public boolean isInside(double lat, double lng, double latDis, double lonDist){
        double latMax = lat + latDis;
        double latMin = lat - latDis;

        double lngMax = lng + lonDist;
        double lngMin = lng - lonDist;        

        return latMin < latitude && latMax > latitude &&
                lngMin < longitude && lngMax > longitude;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "latitude=" + latitude +
                "longitude=" + longitude +
                ", address=" + address +
                '}';
    }
}
