package com.moveit.client.history;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.moveit.client.about.AllAboutPageController;
import com.moveit.client.gui.*;
import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.PopupPageController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HistorySupport {
    private static Map<String, PageController> controllers = new HashMap<String, PageController>();

    private static HistorySupport instance = null;

    private HistorySupport() {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            public void onValueChange(ValueChangeEvent<String> event) {
                updateState(event.getValue(), true);
            }
        });

    }


    public static HistorySupport getInstance() {
        if (instance == null) {
            instance = new HistorySupport();
            initMaps();
        }
        return instance;
    }


    private static void initMaps() {
        add(FrontPageController.HISTORY_NAME, FrontPageController.getInstance());
        add(AddPageController.HISTORY_NAME, AddPageController.getInstance());
        add(SearchPageController.HISTORY_NAME, SearchPageController.getInstance());
        add(SignUpPageController.HISTORY_NAME, SignUpPageController.getInstance());
        add(SignInPageController.HISTORY_NAME, SignInPageController.getInstance());
        add(AccountPageController.HISTORY_NAME, AccountPageController.getInstance());
        add(AllAboutPageController.HISTORY_NAME, AllAboutPageController.getInstance());
        add(AddFirmController.HISTORY_NAME, AddFirmController.getInstance());
    }


    private static void add(String name, PageController c) {
        controllers.put(name, c);
    }


    public void loadFirstPage() {
        // check to see if there are any tokens passed at startup via the browser's URI
        String token = History.getToken();
        if (token.length() == 0) {
            ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
        }
        else {
            PageController c = controllers.get(token);
            if(c instanceof PopupPageController){
                ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
                ApplicationController.getInstance().loadPageFromHistory(c);
                return;             
            }
            updateState(token, false);
        }
    }



    public void updateState(String historyToken, boolean fromHistory) {
        PageController c = controllers.get(historyToken);
        if (c != null) {
            if (c instanceof AccountPageController) {
                if (ApplicationController.getInstance().getUser() == null) {
                    doLoad(FrontPageController.getInstance(), fromHistory);
                    return;
                }
            }
            doLoad(c, fromHistory);
        }
    }

    private void doLoad(PageController toLoad, boolean fromHistory){
        if(fromHistory){
            ApplicationController.getInstance().loadPageFromHistory(toLoad);
        }
        else{
            ApplicationController.getInstance().loadPage(toLoad);
        }
    }

    public void addHistory(PageController controller) {
        History.newItem(controller.getHistoryName(), false);
    }


}
