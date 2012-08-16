package com.moveit.client.util;

import com.google.gwt.maps.client.geom.LatLng;
import com.moveit.client.model.GeoPoint;
import com.moveit.client.gui.ApplicationController;

/**
 *
 */
public class GeoPointUtil {

    private static GeoPointUtil instance = new GeoPointUtil();

    private class LatitudeKm {
        double lat;
        double km;

        private LatitudeKm(double lat, double km) {
            this.lat = lat;
            this.km = km;
        }

        public double getLat() {
            return lat;
        }

        public double getKm() {
            return km;
        }
    }

    private LatitudeKm[] latKms = new LatitudeKm[]{
            new LatitudeKm(0, 111),
            new LatitudeKm(15, 107),
            new LatitudeKm(30, 96),
            new LatitudeKm(45, 79),
            new LatitudeKm(50, 71),
            new LatitudeKm(55, 63),
            new LatitudeKm(60, 56),
            new LatitudeKm(65, 47),
            new LatitudeKm(70, 38),
            new LatitudeKm(75, 29),
            new LatitudeKm(80, 18),
            new LatitudeKm(85, 8),
            new LatitudeKm(90, 1)};


    private GeoPointUtil() {
    }

    public static GeoPointUtil getInstance() {
        return instance;
    }

    public LatLng getLatLng(GeoPoint gp) {
        return gp == null ? null : LatLng.newInstance(gp.getLatitude(), gp.getLongitude());
    }

    public double getLatitudeDistance(double km) {
        ApplicationController.getInstance().debug("getLatDis in");
        return km / 111; //1 latitude = 111 km

    }

    public double getLongitudeDistance(double latitude, double km) {
        ApplicationController.getInstance().debug("getLonDist in");

        if(latitude < 0){
            latitude = latitude*(-1);
        }
        int index = 0;

        for (LatitudeKm latKm : latKms) {
            if(latitude == latKm.getLat()){
                return km/ latKm.getKm();
            }
            if(latitude < latKm.getLat()){
                double kmDiff = (latKms[index-1].getLat() - latKm.getLat())/2;
                double newKm = kmDiff + latKm.getKm();
                return km/newKm;
            }
            index++;

        }
        throw new RuntimeException("Invalid argument latitude="+latitude + ". 90 is max");
    }

}
