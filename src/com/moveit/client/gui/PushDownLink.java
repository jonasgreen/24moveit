package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.moveit.client.guicomponents.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PushDownLink extends LabelComponent {

    private List<PushDownHandler> handlers = new ArrayList<PushDownHandler>();

    private P colorSelected = P.COLOR_BLACK;
    private P colorNotSelected = P.COLOR_BLUE_DARK;

    private boolean selected = false;


    public PushDownLink(String text) {
        super(text);
        StyleIt.add(label, new TextLayout().sizeSmall());
        StyleIt.add(label, colorNotSelected);

        addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (!isSelected()) {
                    for (PushDownHandler handler : handlers) {
                        handler.pushedDown(PushDownLink.this);
                    }
                    setSelected(true);
                }
            }
        });

        addMouseOver(new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
                if (!isSelected()) {
                    label.getElement().getStyle().setProperty("cursor", "pointer");
                }
                else{
                    label.getElement().getStyle().setProperty("cursor", "auto");

                }
            }
        });
    }


    public void addPushDownHandler(PushDownHandler handler) {
        handlers.add(handler);
    }


    public P getColorSelected() {
        return colorSelected;
    }

    public P getColorNotSelected() {
        return colorNotSelected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean setAsSelected) {
        selected = setAsSelected;
        if (selected) {
            StyleIt.add(label, colorSelected);
        }
        else {
            StyleIt.add(label, colorNotSelected);
        }
    }

}
