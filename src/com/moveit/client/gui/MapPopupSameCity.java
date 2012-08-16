package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.PopupPanel;
import com.moveit.client.guicomponents.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MapPopupSameCity extends PopupPanel implements ClickHandler {
    private FlexTableComponent ft = new FlexTableComponent();
    private int rowIndex = 0;
    private List<MapRoute> result = new ArrayList<MapRoute>();
    private Timer timer = null;
    private String city;

    public MapPopupSameCity(boolean autoHide, boolean modal) {
        super(autoHide, modal);
        add(ft);
        ft.getPanel().setCellPadding(2);
        ft.getPanel().setCellSpacing(0);
     //   Style.add(this, Name.BORDER_LEFT, "NONE");
       StyleIt.add(this, Name.BORDER_TOP, "NONE");

        StyleIt.add(this, Name.BORDER_COLOR, P.COLOR_GREY_LIGHT.getValue());
        StyleIt.add(this, P.BACKGROUND_LIGHT_BLUE);

        addDomHandler(this, ClickEvent.getType());

    }


    public void cancelIt() {
        if (timer != null) {
            timer.cancel();
        }
        this.hide();
    }

    public void show(MapRoute mr, String city) {
        this.city = city;
        List<MapRoute> routes = SearchPageController.getInstance().getMapController().getMapRoutes();

        result.addAll(getStarters(routes, city));
        result.addAll(getEnders(routes, city));
        showResult(result, mr);
    }

    private void showResult(final List<MapRoute> result, final MapRoute mr) {
        if (result.isEmpty()) {
            return;
        }

        timer = new Timer() {
            @Override
            public void run() {
                if (rowIndex == 0) {
                    showItAll();
                }

                addRow(rowIndex++, mr);
                if (rowIndex == result.size()) {
                    this.cancel();
                }
            }
        };

        timer.scheduleRepeating(25);
    }


    private void showItAll() {
        setPopupPositionAndShow(new PopupPanel.PositionCallback() {
            public void setPosition(int offsetWidth, int offsetHeight) {
                int offsetLeft = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetLeft();
                int offsetTop = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetTop();


                setPopupPosition(offsetLeft+ 500, offsetTop);
            }
        });
    }

    private void addRow(int row, MapRoute org) {
        MapRoute mapRoute = result.get(row);

        String cityTo = mapRoute.getRoute().getToPoint().getAddress().getCity();

        String cityFrom = mapRoute.getRoute().getFromPoint().getAddress().getCity();
        LabelComponent lFrom = new LabelComponent(cityFrom);
        LabelComponent lTo = new LabelComponent(cityTo);
        Layout17 from = new TextLayout().sizeSmall();
        Layout17 to = new TextLayout().sizeSmall();

        if (result.size() > 1) {
            if (cityFrom.equalsIgnoreCase(city)) {
                from.add(P.COLOR_PURPLE);
            }
            if(cityTo.equalsIgnoreCase(city)) {
                to.add(P.COLOR_PURPLE);
            }
        }

        ft.setWidget(row, 0, lFrom, from);
        ft.setWidget(row, 1, new LabelComponent(" - "), new TextLayout(null, "10px").alignCenter().sizeSmall());
        ft.setWidget(row, 2, lTo, to);

    }


    private List<MapRoute> getStarters(List<MapRoute> routes, String city) {
        List<MapRoute> list = new ArrayList<MapRoute>();
        for (MapRoute r : routes) {
            if (r.getRoute().getFromPoint().getAddress().getCity().equalsIgnoreCase(city)) {
                list.add(r);
            }
        }
        return list;
    }

    private List<MapRoute> getEnders(List<MapRoute> routes, String city) {
        List<MapRoute> list = new ArrayList<MapRoute>();
        for (MapRoute r : routes) {
            if (r.getRoute().getToPoint().getAddress().getCity().equalsIgnoreCase(city)) {
                //those are already added as starters 
                if (!r.getRoute().getFromPoint().getAddress().getCity().equalsIgnoreCase(city)) {
                    list.add(r);
                }
            }
        }
        return list;
    }


    public void onClick(ClickEvent event) {
        cancelIt();
    }
}
