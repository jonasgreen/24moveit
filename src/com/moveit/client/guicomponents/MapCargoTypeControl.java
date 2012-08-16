package com.moveit.client.guicomponents;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.Control;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.gui.CargoTypePanel;
import com.moveit.client.util.Border;

/**
 *
 */
public class MapCargoTypeControl extends Control.CustomControl {


    public MapCargoTypeControl(ControlPosition defaultPosition, boolean printable, boolean selectable) {
        super(defaultPosition, printable, selectable);

    }


    public boolean isSelectable() {
        return true;
    }

    protected Widget initialize(MapWidget map) {
        CargoTypePanel panel = new CargoTypePanel();
        StyleIt.add(panel, Name.OPACITY, "0.93");
        StyleIt.add(panel, Name.FILTER, "alpha(opacity=93)");
        Border.addBorder(panel, P.BACKGROUND_MENU_TOP.getValue());
        return panel;
    }




   
}