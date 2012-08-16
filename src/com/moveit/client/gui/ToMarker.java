package com.moveit.client.gui;

import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.moveit.client.guicomponents.MapOptions;
import com.moveit.client.util.GeoPointUtil;

public class ToMarker extends MapMarker{

    private static String imageHighlighted = "yellow_MarkerB_copy.png";

	public ToMarker(MapRoute mr, LatLng point, MarkerOptions options) {
		super(mr, point, options);
	}

    public static ToMarker create(MapRoute mr, boolean highlighted) {
           String tooltip = mr.getRoute().getToolTip();
           MarkerOptions opt;
           if (highlighted) {
               opt = MapOptions.getOptions(tooltip, imageHighlighted, highlighted);

           }
           else {
               opt = MapOptions.getOptions(tooltip, MapMarker.toMarkerPics.get(mr.getRoute().getCargoType()), highlighted);
           }

           ToMarker toMarker = new ToMarker(mr, GeoPointUtil.getInstance().getLatLng(mr.getRoute().getToPoint()), opt);
           toMarker.setDraggingEnabled(false);
           //toMarker.addMarkerDoubleClickHandler(doubleClickHandler);
           toMarker.addMarkerClickHandler(clickHandler);
           return toMarker;
       }

}
