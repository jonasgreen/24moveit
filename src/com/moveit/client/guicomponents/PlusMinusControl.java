package com.moveit.client.guicomponents;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.Control;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.moveit.client.guicomponents.Name;
import com.moveit.client.guicomponents.StyleIt;

/**
 *
 */
public class PlusMinusControl extends Control.CustomControl {

    private final MapWidget map;

    protected PlusMinusControl(MapWidget mw, ControlPosition defaultPosition, boolean printable, boolean selectable) {
        super(defaultPosition, printable, selectable);
        this.map = mw;
    }



    public boolean isSelectable() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public MapWidget getMap(){
        return map;
    }

    protected Widget initialize(MapWidget map) {

        VerticalPanel p = new VerticalPanel();

        Image plus = new Image("plus.png");
        plus.setPixelSize(25, 25);
        p.add(plus);
        plus.addMouseOverHandler(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
            }
        });

        plus.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getMap().setZoomLevel(getMap().getZoomLevel()+1);
            }
        });

        StyleIt.add(plus, Name.MARGIN, "0 0 7 0");

        Image minus = new Image("minus.png");
        minus.setPixelSize(25, 25);
        p.add(minus);
        minus.addMouseOverHandler(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
            }
        });

        minus.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getMap().setZoomLevel(getMap().getZoomLevel()-1);
            }
        });



        return p;//To change body of implemented methods use File | Settings | File Templates.
    }
}
