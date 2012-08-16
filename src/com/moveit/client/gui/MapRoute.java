package com.moveit.client.gui;

import com.google.gwt.maps.client.overlay.Polyline;
import com.moveit.client.guicomponents.GMap;
import com.moveit.client.model.Route;

public class MapRoute {
    private boolean highligted = false;
    private ToMarker toMarker;
    private FromMarker fromMarker;
    private Polyline line;
    private Route route;
    private GMap mapPanel;


    public MapRoute(Route r, GMap map) {
        this.route = r;
        this.mapPanel = map;
    }

    public void clicked() {
        mapPanel.getMapWidget().removeOverlay(toMarker);
        mapPanel.getMapWidget().removeOverlay(fromMarker);

        toMarker = ToMarker.create(this, !highligted);
        fromMarker = FromMarker.create(this, !highligted);

        mapPanel.getMapWidget().addOverlay(toMarker);
        mapPanel.getMapWidget().addOverlay(fromMarker);

        highligted = !highligted;
    }


    public ToMarker getToMarker() {
        return toMarker;
    }


    public FromMarker getFromMarker() {
        return fromMarker;
    }


    public Polyline getLine() {
        return line;
    }


    public Route getRoute() {
        return route;
    }

    public void setToMarker(ToMarker toMarker) {
        this.toMarker = toMarker;
    }

    public void setFromMarker(FromMarker fromMarker) {
        this.fromMarker = fromMarker;
    }

    public void setLine(Polyline line) {
        this.line = line;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public boolean isHighligted() {
        return highligted;
    }

    public GMap getMapPanel() {
        return mapPanel;
    }
}
