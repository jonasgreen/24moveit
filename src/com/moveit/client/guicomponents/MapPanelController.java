package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.language.LSearchPage;

/**
 *
 */
public class MapPanelController {
    private static MapPanelController instance;




    private MapPanelController() {
        
    }

    public static MapPanelController getInstance() {
        if (instance == null) {
            instance = new MapPanelController();
        }
        return instance;
    }




}
