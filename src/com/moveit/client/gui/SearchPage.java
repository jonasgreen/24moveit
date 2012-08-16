package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.event.MapDoubleClickHandler;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LSearchPage;
import com.moveit.client.model.Route;

import java.util.List;

/**
 *
 */
public class SearchPage extends Page<SearchPageController> {


    private VerticalComponent content;
    private GMap map;
    private SimplePanelComponent searchListPanel = null;
    private SimplePanelComponent searchListHolder = new SimplePanelComponent();
    private HorizontalComponent infoPanel;

    public SearchPage() {
        super();
        content = new VerticalComponent();
        initWidget(content);
    }


    public void init() {
        content.add(getMap(), new TextLayout(0, 10, 0, 0, "500px", "100%", Horizontal.LEFT).borderBottom(1));
        content.add(searchListHolder, new TextLayout(0,0,0, 15, Horizontal.LEFT, null));
        SimplePanelComponent sp = new SimplePanelComponent();
        sp.add(getInfoPanel(), new Layout17(0, 0, 0, 0, null, "888", Horizontal.CENTER, null).add(Name.PADDING_LEFT, "15px").add(Name.PADDING_RIGHT, "15px"));
        content.add(sp);

    }

    public HorizontalComponent getInfoPanel() {
        if (infoPanel == null) {
            infoPanel = new HorizontalComponent();

            Layout17 hl = new TextLayout().sizeSmall().underline().colorBlueLink();


            VerticalComponent vc = new VerticalComponent();
            HyperlinkLabelComponent header = new HyperlinkLabelComponent(LSearchPage.SEARCH_HELP.text());
            header.underline();
            header.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    MapPopupManager.flipHelp();
                }
            });

            vc.add(header, hl);
            infoPanel.add(vc, new Layout17(Horizontal.RIGHT));


        }
        return infoPanel;
    }


    public GMap getMap() {
        if (map == null) {
            map = getController().getMapController().getMapPanel();
            map.addMapDoubleClickHandler(new MapDoubleClickHandler() {
                public void onDoubleClick(MapDoubleClickHandler.MapDoubleClickEvent event) {
                    getController().mapDoubleClicked(event.getLatLng());
                }
            });

            map.getMapWidget().addMapClickHandler(new MapClickHandler() {
                public void onClick(MapClickEvent event) {
                    MapPopupManager.hideHelpPopup();
                }
            });
        }
        return map;
    }


    public void addSearchResults(GuiComponent searchListResult) {
        if (searchListPanel != null) {
            searchListPanel.removeFromParent();
        }
        searchListPanel = new SimplePanelComponent();
        //searchListPanel.setColor(P.BACKGROUND_D1);
        searchListPanel.add(searchListResult, new Layout17(0, 0, 0, 0));

        searchListHolder.add(searchListPanel, new TextLayout(10, 0, 10, 0, Horizontal.CENTER));
    }

    public void addOptimizedSearchResult(List<List<Route>> list) {

    }


    public VerticalComponent getContent() {
        return content;
    }

    public void clearSearchList() {
        if (searchListPanel != null) {
            searchListPanel.removeFromParent();
        }

    }
}
