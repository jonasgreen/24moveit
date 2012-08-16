package com.moveit.client.guicomponents;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.Control;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.language.LSearchPage;

/**
 *
 */
public class MapPanelControl extends Control.CustomControl {

    private HorizontalComponent content = new HorizontalComponent();

    private P color = P.BACKGROUND_WHITE;

    public MapPanelControl(ControlPosition defaultPosition, boolean printable, boolean selectable) {
        super(defaultPosition, printable, selectable);

    }


    public boolean isSelectable() {
        return true;
    }

    protected Widget initialize(MapWidget map) {
        HorizontalComponent comp = new HorizontalComponent();

        comp.setBackgroundColor(color);
        LabelComponent w = new LabelComponent(LSearchPage.SEARCH_PANE.text());
        comp.add(w, new TextLayout().padding(8));
        comp.setStyleName("mappanel");

        content.add(comp);
        content.add(new ImageComponent("mappanelshadow.png"), new TextLayout(3, 0,0,0));
        return content;
    }

}