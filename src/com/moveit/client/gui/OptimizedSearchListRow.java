package com.moveit.client.gui;

import com.moveit.client.guicomponents.*;
import com.moveit.client.model.Route;
import com.moveit.client.util.MouseOver;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import java.util.List;

/**
 *
 */
public class OptimizedSearchListRow extends VerticalComponent {
    private List<Route> routes;

    private OptimizedSearchList optimizedSearchList;
    private SearchList searchList = null;
    private SearchListController slc = null;

    private ClickHandler clickHander = new ClickHandler() {
        public void onClick(ClickEvent event) {
            showHideContent();
        }
    };
    private ButtonComponent button;


    public OptimizedSearchListRow(OptimizedSearchList optimizedSearchList, List<Route> routes) {
        super();
        this.routes = routes;
        this.optimizedSearchList = optimizedSearchList;
        init();
    }

    private void init() {
        add(createHeader());
    }

    private HorizontalComponent createHeader() {
        HorizontalComponent hc = new HorizontalComponent();
        int i = 0;
        hc.add(getButton(), new TextLayout());
        for (Route r : routes) {
            if (i++ > 0) {
                hc.add(new LabelComponent(","), new TextLayout().sizeH2().bold().colorBlueLink().paddingRight(10));
            }
            hc.add(createLabel(r.getFromPoint().getAddress().getCity()), new TextLayout().sizeH2().bold().colorBlueLink().paddingLeft(10));
            hc.add(createLabel(" - "), new TextLayout().sizeH2().bold().colorBlueLink().paddingLeft(2).paddingRight(2));
            hc.add(createLabel(r.getToPoint().getAddress().getCity()), new TextLayout().sizeH2().bold().colorBlueLink());
        }

        return hc;

    }

    public ButtonComponent getButton() {
        if (button == null) {
            button = new ButtonComponent();
            button = new ButtonComponent("+");
            button.addClickHandler(clickHander);

        }
        return button;
    }

    private LabelComponent createLabel(String s) {
        LabelComponent l = new LabelComponent(s);
        l.addClickHandler(clickHander);
        l.addMouseOver(MouseOver.POINTER);
        return l;
    }

    private void showHideContent() {
        if (searchList == null || !searchList.isVisible()) {
            optimizedSearchList.unselectAll();
        }
        SearchPageController.getInstance().getMapController().clear();
        if (searchList == null) {
            slc = new SearchListController();
            searchList = slc.createSearchList(routes);
            add(searchList, new TextLayout(0, 0, 0, 38));
        }
        else {
            searchList.setVisible(!searchList.isVisible());

        }
        getButton().setText(searchList.isVisible() ? "-" : "+");
        if (searchList.isVisible()) {
            SearchPageController.getInstance().getMapController().load(routes);
            optimizedSearchList.setActive(this);
        }
        else {
            SearchPageController.getInstance().getMapController().clear();
            optimizedSearchList.unselectAll();

        }


    }

    public SearchListController getSlc() {
        return slc;
    }

    public void setSlc(SearchListController slc) {
        this.slc = slc;
    }

    public void unselct() {
        if (searchList != null && isVisible()) {
            searchList.setVisible(false);
            getButton().setText(searchList.isVisible() ? "-" : "+");

        }
    }
}
