package com.moveit.client.gui;

import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.MenuComponent;


/**
 *
 */
public class TermsOfServiceController extends PageController <TermsOfServicePage> {

    private static TermsOfServiceController instance = null;
    public static String HISTORY_NAME = "terms";


    private TermsOfServiceController() {
        super(HISTORY_NAME);
    }

    public static TermsOfServiceController getInstance() {
        if (instance == null) {
            instance = new TermsOfServiceController();
        }
        return instance;
    }



    public TermsOfServicePage newInstance() {
        return new TermsOfServicePage();
    }

    public void loadFromHistory() {
        getPage();
        page.setWidth("100%");
        page.setVisible(true);
    }

    public MenuComponent getMenu() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void load() {
        getPage();
        //AppFrame.getInstance().addMenuContent(MenuPanel.getInstance().getMenuPanelAdd(), false);
        page.setWidth("100%");
        page.setVisible(true);
    }



}