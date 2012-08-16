package com.moveit.client.gui;

import com.google.gwt.maps.client.event.MarkerClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.google.gwt.user.client.Timer;
import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.guicomponents.P;

import java.util.HashMap;
import java.util.Map;

public abstract class MapMarker extends Marker {

    static long lastClick = 0;
    static long doubleClickTime = 300;
    static Timer timer = null;

    public static Map<Integer, String> fromMarkerPics = new HashMap<Integer, String>();
    static{
        fromMarkerPics.put(CargoTypeConstant.FURNITURE.getValue(), "green_markerA.png");
        fromMarkerPics.put(CargoTypeConstant.ANIMALS.getValue(), "pink_markerA.png");
        fromMarkerPics.put(CargoTypeConstant.FREEZE.getValue(), "blue_markerA.png");
        fromMarkerPics.put(CargoTypeConstant.STONE_SAND.getValue(), "brown_markerA.png");
        fromMarkerPics.put(CargoTypeConstant.DANGER.getValue(), "red_markerA.png");
        fromMarkerPics.put(CargoTypeConstant.OTHER.getValue(), "orange_markerA.png");
    }

    public static Map<Integer, String> toMarkerPics = new HashMap<Integer, String>();
    static{
        toMarkerPics.put(CargoTypeConstant.FURNITURE.getValue(), "green_markerB.png");
        toMarkerPics.put(CargoTypeConstant.ANIMALS.getValue(), "pink_markerB.png");
        toMarkerPics.put(CargoTypeConstant.FREEZE.getValue(), "blue_markerB.png");
        toMarkerPics.put(CargoTypeConstant.STONE_SAND.getValue(), "brown_markerB.png");
        toMarkerPics.put(CargoTypeConstant.DANGER.getValue(), "red_markerB.png");
        toMarkerPics.put(CargoTypeConstant.OTHER.getValue(), "orange_markerB.png");
    }

    public static Map<Integer, String> markerPics = new HashMap<Integer, String>();
    static{
        markerPics.put(CargoTypeConstant.FURNITURE.getValue(), "green_marker.png");
        markerPics.put(CargoTypeConstant.ANIMALS.getValue(), "pink_marker.png");
        markerPics.put(CargoTypeConstant.FREEZE.getValue(), "blue_marker.png");
        markerPics.put(CargoTypeConstant.STONE_SAND.getValue(), "brown_marker.png");
        markerPics.put(CargoTypeConstant.DANGER.getValue(), "red_marker.png");
        markerPics.put(CargoTypeConstant.OTHER.getValue(), "orange_marker.png");
    }

    public static Map<Integer, P> markerColors = new HashMap<Integer, P>();
    static{
        markerColors.put(CargoTypeConstant.FURNITURE.getValue(), P.BACKGROUND_MARKER_GREEN);
        markerColors.put(CargoTypeConstant.ANIMALS.getValue(), P.BACKGROUND_MARKER_PINK);
        markerColors.put(CargoTypeConstant.FREEZE.getValue(), P.BACKGROUND_MARKER_BLUE);
        markerColors.put(CargoTypeConstant.STONE_SAND.getValue(), P.BACKGROUND_MARKER_BROWN);
        markerColors.put(CargoTypeConstant.DANGER.getValue(), P.BACKGROUND_MARKER_RED);
        markerColors.put(CargoTypeConstant.OTHER.getValue(), P.BACKGROUND_MARKER_ORANGE);
    }



    protected static MarkerClickHandler clickHandler = new MarkerClickHandler() {

        public void onClick(final MarkerClickEvent event) {
                if (((MapMarker) event.getSender()).getMapRoute().isHighligted()) {
                    cancelPopup();
                }
                else {
                    timer = new Timer() {
                        @Override
                        public void run() {

                            MapRoute mr = ((MapMarker) event.getSender()).getMapRoute();
                            if (event.getSender() instanceof FromMarker) {
                                MapPopupManager.showRoutePopup(mr, mr.getRoute().getFromPoint().getAddress().getCity());
                            }
                            else {
                                MapPopupManager.showRoutePopup(mr, mr.getRoute().getToPoint().getAddress().getCity());

                            }

                        }
                    };
                    timer.schedule(100);
                }            
            SearchPageController.getInstance().markerClicked((MapMarker) event.getSender());
        }
    };

    private static void cancelPopup() {
        if (timer != null) {
            timer.cancel();
        }
        MapPopupManager.hideRoute();
    }

    private MapRoute mapRoute;

    public MapMarker(MapRoute mr, LatLng point, MarkerOptions options) {
        super(point, options);
        this.mapRoute = mr;
    }

    public MapRoute getMapRoute() {
        return mapRoute;
    }
}
