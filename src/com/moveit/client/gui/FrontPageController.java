package com.moveit.client.gui;

import com.moveit.client.about.AllAboutPageController;
import com.moveit.client.about.HowController;
import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.MenuComponent;

/**
 *
 */
public class FrontPageController extends PageController <FrontPage> {

    private static FrontPageController instance;
    public static String HISTORY_NAME = "front";


    private FrontPageController() {
        super(HISTORY_NAME);
    }


    public static FrontPageController getInstance() {
        if (instance == null) {
            instance = new FrontPageController();
        }
        return instance;
    }


    public void unload() {
    }

    public MenuComponent getMenu() {
        return MenuPanel.getInstance().getHome();
    }

    public void load(){
        MenuPanel.getInstance().setSelected(null);
    }

    public void addRouteClicked() {
        ApplicationController.getInstance().loadPage(AddPageController.getInstance());
    }

    public void searchClicked() {
        ApplicationController.getInstance().loadPage(SearchPageController.getInstance());

    }

    public void howDoesItWorkClicked() {
        ApplicationController.getInstance().loadPage(AllAboutPageController.getInstance());
        AllAboutPageController.getInstance().loadPage(HowController.getInstance());
    }

    public FrontPage newInstance() {
        return new FrontPage();
    }
}
