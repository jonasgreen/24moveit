package com.moveit.client.about;

import com.moveit.client.guicomponents.MenuComponent;
import com.moveit.client.guicomponents.PageController;

/**
 *
 */
public class TipsController extends PageController<TipsPage>{

    private static String HISTORY_NAME = "help";
    private static TipsController instance;

    private TipsController() {
        super(HISTORY_NAME);
    }

    public static TipsController getInstance() {
        if (instance == null) {
            instance = new TipsController();
        }
        return instance;
    }

    public TipsPage newInstance() {
        return new TipsPage();
    }

    public void load() {
        page.setWidth("100%");
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.setAsPresent(allAboutPage.getTips());
    }

    public void unload() {
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.removeAsPresent(allAboutPage.getTips());
    }

    public MenuComponent getMenu() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
