package com.moveit.client.guicomponents;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.ControlAnchor;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.event.MapDoubleClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.Window;
import com.moveit.client.gui.GmapController;
import com.moveit.client.gui.MapRoute;

/**
 *
 */
public class GMap extends GuiComponent {

    private MapWidget mapWidget;
    private GmapController controller;
    private MapSearchControl searchControl;

    //better fit window with search panel

    public static LatLng WORLD = LatLng.newInstance(15, -5);

    public GMap(GmapController ctrl) {
        controller = ctrl;
        MapWidget w = getMapWidget();
        initWidget(w);
    }

    public GmapController getController() {
        return controller;
    }

    public MapWidget getMapWidget() {
        if (mapWidget == null) {
            mapWidget = new MapWidget();

            // Open a mapWidget centered on cph
            mapWidget.setCenter(WORLD);
            mapWidget.setGoogleBarEnabled(false);
            mapWidget.setDoubleClickZoom(true);
            mapWidget.setPinchToZoom(true);

            mapWidget.setHeight("500px");
            int clientWidth = Window.getClientWidth();
            mapWidget.setWidth("100%");
            mapWidget.setZoomLevel(2);
            mapWidget.addControl(new SmallMapControl());

            ControlPosition cp = new ControlPosition(ControlAnchor.TOP_LEFT, 56, 12);
            searchControl = new MapSearchControl(cp, false, true);
            mapWidget.addControl(searchControl);

            cp = new ControlPosition(ControlAnchor.TOP_RIGHT, 12, 12);
            mapWidget.addControl(new MapCargoTypeControl(cp, false, true));

            cp = new ControlPosition(ControlAnchor.BOTTOM_LEFT, 12, 0);
            mapWidget.addControl(new MapPanelControl(cp, false, true));
        }
        return mapWidget;
    }

    public void setHeight(String height) {
        getMapWidget().setHeight(height);
    }

    public void repaint() {
        getMapWidget().checkResizeAndCenter();

    }

    public void addMapDoubleClickHandler(MapDoubleClickHandler handler) {
        getMapWidget().addMapDoubleClickHandler(handler);
    }


    public void removeOverlay(MapRoute mr) {
        mapWidget.removeOverlay(mr.getFromMarker());
        mapWidget.removeOverlay(mr.getToMarker());
        mapWidget.removeOverlay(mr.getLine());
    }


    public MapRoute addOverlay(MapRoute mr) {
        mapWidget.addOverlay(mr.getFromMarker());
        mapWidget.addOverlay(mr.getToMarker());
        mapWidget.addOverlay(mr.getLine());
        return mr;
    }

    public void clear() {

        mapWidget.clearOverlays();
    }

    public MapSearchControl getSearchControl() {
        return searchControl;
    }
}
