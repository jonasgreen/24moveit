package com.moveit.client.gui;

import com.google.gwt.maps.client.geom.LatLng;
import com.moveit.client.model.Route;

/**
 *
 */
public abstract class SearchState {
    private LatLng centerFromLastSearch = null;


    public abstract void markerDoubleClicked(MapMarker mMarker);

    public abstract void markerClicked(MapMarker mMarker);

    public abstract void listRowClicked(SearchListRow row);
    public abstract void routeClicked(Route r);

    public abstract void mapDoubleClicked(LatLng point);

    public abstract void search();

    public abstract void setFocus();

    //this method is only called when user changes categories - balloons are added and removed from map
    public abstract void cargoTypesChanged();    

    public LatLng getCenterFromLastSearch(){
        return centerFromLastSearch;
    }

    public void setCenterFromLastSearch(LatLng centerFromLastSearch) {
        this.centerFromLastSearch = centerFromLastSearch;
    }



}
