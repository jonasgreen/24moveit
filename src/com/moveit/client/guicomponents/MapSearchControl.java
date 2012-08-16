package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.Control;
import com.google.gwt.maps.client.control.ControlPosition;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.gui.*;
import com.moveit.client.util.Border;

/**
 *
 */
public class MapSearchControl extends Control.CustomControl {

    private SearchCriteriaPanel searchPanel = new SearchCriteriaPanel();
    private RouteOptimizingPanel optimizePanel = new RouteOptimizingPanel();

    private VerticalComponent content = new VerticalComponent();
    private P color = P.BACKGROUND_CARGO_ONE;

    public MapSearchControl(ControlPosition defaultPosition, boolean printable, boolean selectable) {
        super(defaultPosition, printable, selectable);
        searchPanel.getSearchButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                MapPopupManager.hideHelpPopup();
                SearchPageController.getInstance().search(NormalSearchState.getInstance());
            }
        });

        searchPanel.getSearchBox().addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    SearchPageController.getInstance().search(NormalSearchState.getInstance());
                }
            }
        });
        searchPanel.setBackgroundColor(color);

        optimizePanel.getSearchButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                MapPopupManager.hideHelpPopup();
                SearchPageController.getInstance().search(OptimizedSearchState.getInstance());
            }
        });

        optimizePanel.getSearchBoxTo().addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    SearchPageController.getInstance().search(OptimizedSearchState.getInstance());
                }
            }
        });

        optimizePanel.getSearchBoxFrom().addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {

                    SearchPageController.getInstance().search(OptimizedSearchState.getInstance());
                }
            }
        });


        optimizePanel.setBackgroundColor(color);

    }


    public boolean isSelectable() {
        return true;
    }

    protected Widget initialize(MapWidget map) {
        searchPanel.setBackgroundColor(color);
        StyleIt.add(searchPanel, Name.OPACITY, "0.93");
        StyleIt.add(searchPanel, Name.FILTER, "alpha(opacity=93)");
        //panel.setWidth("345px");
        Border.addBorder(searchPanel, P.BACKGROUND_MENU_TOP.getValue());
        content.add(searchPanel);

        optimizePanel.setBackgroundColor(color);
        StyleIt.add(optimizePanel, Name.OPACITY, "0.93");
        StyleIt.add(optimizePanel, Name.FILTER, "alpha(opacity=93)");
        //panel.setWidth("345px");
        Border.addBorder(optimizePanel, P.BACKGROUND_MENU_TOP.getValue());
        content.add(optimizePanel, new TextLayout(12, 0, 0, 0));


        return content;
    }

    public RouteOptimizingPanel getRouteOptimizingPanel(){
        return optimizePanel;
    }

    public SearchCriteriaPanel getSearchPanel() {
        return searchPanel;
    }
}