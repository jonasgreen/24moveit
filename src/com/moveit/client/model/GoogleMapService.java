package com.moveit.client.model;

import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LocationCallback;
import com.moveit.client.gui.ApplicationController;

/**
 *
 */
public class GoogleMapService {

    private static Geocoder geocoder = new Geocoder();
    private static ApplicationController appCcontroller = ApplicationController.getInstance();

    //---------  this is factory methods with callback functionality ----

    public static void newInstance(Address addr, boolean withCity, LocationCallback lcb) {
        ApplicationController.getInstance().debug("GOOGLE ADRESSE:" + addr);
        geocoder.setBaseCountryCode(addr.getNationalCode().toLowerCase());
        geocoder.getLocations(getGoogleMapAdress(addr, withCity), lcb);
    }

    public static void newInstance(String addr, final LocationCallback lcb) {
        geocoder.getLocations(addr, lcb);
    }


    private static String getGoogleMapAdress(Address adr, boolean withCity) {
        StringBuffer sb = new StringBuffer();
        addToGoogleMapAddress(sb, adr.getStreet());
        if (withCity) {
            addToGoogleMapAddress(sb, adr.getCity());
        }
        addToGoogleMapAddress(sb, adr.getCityCode());
        addToGoogleMapAddress(sb, adr.getNationalCode());

        return sb.toString();
    }

    private static void addToGoogleMapAddress(StringBuffer sb, String s) {
        if (s == null || s.equals("")) {
            return;
        }
        if (sb.length() != 0) {
            sb.append(", ").append(s);
        }
        else {
            sb.append(s);
        }
    }

}
