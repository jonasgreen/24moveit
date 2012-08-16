package com.moveit.client.model;

/**
 *
 */
public interface GeoPointCallBack {



    public void onFailure(int statusCode, String msg);


    public void onSuccess(GeoPoint geoPoint);
}
