package com.moveit.client.guicomponents;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.Control;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.user.client.ui.*;

/**
 *
 */
public class CloseAreaControl extends Control.CustomControl {

    public CloseAreaControl(ControlPosition defaultPosition, boolean printable, boolean selectable) {
        super(defaultPosition, printable, selectable);
    }


    public boolean isSelectable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected Widget initialize(MapWidget map) {
        return new SimplePanel();
    }


}
