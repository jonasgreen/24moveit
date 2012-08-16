package com.moveit.client.gui;

import com.google.gwt.maps.client.event.PolylineClickHandler;
import com.google.gwt.maps.client.event.PolylineMouseOutHandler;
import com.google.gwt.maps.client.event.PolylineMouseOverHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Polyline;
import com.google.gwt.maps.client.overlay.PolylineOptions;
import com.moveit.client.guicomponents.GMap;
import com.moveit.client.model.Route;
import com.moveit.client.util.GeoPointUtil;

import java.util.*;

/**
 *
 */
public class GmapController {

    private GMap mapPanel;
    private List<MapRoute> mapRoutes = new ArrayList<MapRoute>();
    private final GeoPointUtil gpConv = GeoPointUtil.getInstance();


    public GmapController() {
        mapPanel = new GMap(this);
    }

    public GMap getMapPanel() {
        return mapPanel;
    }

    public void load(List<Route> routes) {
        List<Route> cloneList = new ArrayList<Route>();
        for (Route r : routes) {
            cloneList.add(r);
        }
        update(cloneList);
        
    }

    //use this only to update thoose MapMarkers that has to be updated.
    private void update(List<Route> updateList){
        List<MapRoute> alive = new ArrayList<MapRoute>();
        for (MapRoute mapRoute : mapRoutes) {
            if(existInUpdate(mapRoute, updateList)){
                //it stays alive
                alive.add(mapRoute);
            }
            else{
                getMapPanel().removeOverlay(mapRoute);
            }
        }

        for (MapRoute mr : alive) {
            if(existInUpdate(mr, updateList)){
                updateList.remove(mr.getRoute());
            }
        }

        for (Route r : updateList) {
            MapRoute mr = create(r, mapPanel);
            alive.add(mr);
            mapPanel.addOverlay(mr);
        }

        mapRoutes = alive;
    }




    private boolean existInUpdate(MapRoute mr, List<Route> updateList){
        for (Route r : updateList) {
            if(mr.getRoute().getId().longValue() == r.getId()){
                return true;
            }
        }
        return false;
    }



    public void routeClicked(Route route) {
        for (MapRoute mapRoute : mapRoutes) {
            if (mapRoute.getRoute().equals(route)) {
                mapRoute.clicked();
            }
        }
    }

    public MapRoute create(final Route r, final GMap mapPanel) {
        LatLng from = gpConv.getLatLng(r.getFromPoint());
        LatLng to = gpConv.getLatLng(r.getToPoint());
        MapRoute mr = new MapRoute(r, mapPanel);

        Polyline pl = new Polyline(new LatLng[]{
                from, to}, "#FF0000", 1, .75,
                PolylineOptions.newInstance(true, true));


        pl.addPolylineClickHandler(new PolylineClickHandler() {
            public void onClick(PolylineClickEvent event) {
                SearchPageController.getInstance().routeClicked(r);
            }
        });
        pl.addPolylineMouseOverHandler(new PolylineMouseOverHandler() {
            public void onMouseOver(PolylineMouseOverEvent event) {
                mapPanel.getMapWidget().getElement().getStyle().setProperty("cursor", "pointer");
            }
        });

        pl.addPolylineMouseOutHandler(new PolylineMouseOutHandler() {
            public void onMouseOut(PolylineMouseOutEvent event) {
                mapPanel.getMapWidget().getElement().getStyle().setProperty("cursor", "auto");
            }
        });

        mr.setFromMarker(FromMarker.create(mr, false));
        mr.setToMarker(ToMarker.create(mr, false));
        mr.setLine(pl);
        return mr;
    }

    public void repaint() {
        getMapPanel().repaint();
    }

    

    public void setCenter(LatLng center){
        getMapPanel().getMapWidget().setCenter(center);
    }

    public void setCenter(Double latitude, Double longitude) {
        //to better fit window with search panel
        getMapPanel().getMapWidget().setCenter(LatLng.newInstance(latitude, longitude));
    }

    public List<MapRoute> getMapRoutes() {
        return mapRoutes;
    }

    public void clear() {
        mapRoutes = new ArrayList<MapRoute>();
        mapPanel.clear();
    }
}
