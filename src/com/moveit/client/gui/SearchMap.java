package com.moveit.client.gui;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.ControlAnchor;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.event.MapDoubleClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.moveit.client.guicomponents.Name;
import com.moveit.client.guicomponents.P;
import com.moveit.client.guicomponents.CloseAreaControl;
import com.moveit.client.guicomponents.StyleIt;
import org.cobogw.gwt.user.client.ui.RoundedPanel;

/**
 *
 */
public class SearchMap extends Composite {

    private final SearchPageController controller;

    public SearchMap(SearchPageController ctrl) {
        controller = ctrl;

        RoundedPanel rp = new RoundedPanel(RoundedPanel.ALL, 7);
        StyleIt.add(rp, Name.MARGIN, "8px 25px 10px 0px");
        SimplePanel sp = new SimplePanel();
        StyleIt.add(sp, P.BACKGROUND_GREY);


        MapWidget map = new MapWidget();
        StyleIt.add(map, Name.MARGIN, "0px 7px 0px 7px");

        LatLng cph = LatLng.newInstance(55.652, 12.546);
        // Open a map centered on cph


        map.setHeight("500px");
        map.setCenter(cph);
        map.setZoomLevel(5);
        map.setGoogleBarEnabled(false);
        map.addControl(new SmallMapControl());
        map.setDoubleClickZoom(false);


        map.addMapDoubleClickHandler(new MapDoubleClickHandler() {
            public void onDoubleClick(MapDoubleClickEvent event) {
                controller.mapDoubleClicked(event.getLatLng());
            }
        });
        sp.setWidget(map);
        rp.setWidget(sp);
        rp.setCornerColor("#E7E7DE");


        //list panel
        // Make a new list box, adding a few items to it.

        ControlPosition cp = new ControlPosition(ControlAnchor.TOP_RIGHT, 7, 7);
        map.addControl(new CloseAreaControl(cp, false, true));


        initWidget(rp);

    }
}