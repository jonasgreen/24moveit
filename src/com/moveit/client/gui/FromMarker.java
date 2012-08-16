package com.moveit.client.gui;

import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.moveit.client.guicomponents.MapOptions;
import com.moveit.client.util.GeoPointUtil;

public class FromMarker extends MapMarker {

    private static String imageHighlighted = "yellow_MarkerA_copy.png";


    public FromMarker(MapRoute mr, LatLng point, MarkerOptions options) {
        super(mr, point, options);
    }

    public static FromMarker create(MapRoute mr, boolean highlighted) {
        String tooltip = mr.getRoute().getToolTip();
        MarkerOptions opt;
        if (highlighted) {
            opt = MapOptions.getOptions(tooltip, imageHighlighted, highlighted);

        }
        else {
            opt = MapOptions.getOptions(tooltip, MapMarker.fromMarkerPics.get(mr.getRoute().getCargoType()), highlighted);
        }

        FromMarker fromM = new FromMarker(mr, GeoPointUtil.getInstance().getLatLng(mr.getRoute().getFromPoint()), opt);
        fromM.setDraggingEnabled(false);
        fromM.addMarkerClickHandler(clickHandler);
        return fromM;
    }

}
