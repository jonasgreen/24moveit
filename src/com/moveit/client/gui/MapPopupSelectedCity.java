package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.moveit.client.guicomponents.*;

/**
 *
 */
public class MapPopupSelectedCity extends PopupPanel implements ClickHandler {
    private HorizontalComponent content;

    public MapPopupSelectedCity(boolean autoHide, boolean modal) {
        super(autoHide, modal);

        StyleIt.add(this, Name.BORDER_BOTTOM, "NONE");

        StyleIt.add(this, Name.BORDER_COLOR, P.COLOR_GREY_LIGHT.getValue());
        StyleIt.add(this, P.BACKGROUND_YELLOW);

        addDomHandler(this, ClickEvent.getType());

    }


    public void cancelIt() {
        this.hide();
    }

    public void show(MapRoute mr) {
        if (content != null) {
            content.removeFromParent();
        }

        content = new HorizontalComponent();

        add(content);
        this.setWidth((SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getClientWidth()-12)+"px");

        Layout17 lCity = new TextLayout().sizeSmall();

        LabelComponent from = new LabelComponent(mr.getRoute().getFromPoint().getAddress().getCity());
        LabelComponent to = new LabelComponent(mr.getRoute().getToPoint().getAddress().getCity());
        LabelComponent sep = new LabelComponent(" - ");
        content.add(from, lCity);
        content.add(sep, lCity);
        content.add(to, lCity);
        showItAll();
    }


    private void showItAll() {
        setPopupPositionAndShow(new PositionCallback() {
            public void setPosition(int offsetWidth, int offsetHeight) {
                int offsetLeft = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetLeft();
                int offsetTop = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetTop();


                setPopupPosition(offsetLeft, offsetTop - Window.getScrollTop()+ 470);
            }
        });
    }


    public void onClick(ClickEvent event) {
        cancelIt();
    }
}