package com.moveit.client.about;

import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.MenuComponent;

/**
 *
 */
public class HowController extends PageController<HowPage>{

    private static String HISTORY_NAME = "how";
    private static HowController instance;

    private HowController() {
        super(HISTORY_NAME);
    }

    public static HowController getInstance() {
        if (instance == null) {
            instance = new HowController();
        }
        return instance;
    }

    public HowPage newInstance() {
        return new HowPage();
    }

    public void load() {
        page.setWidth("100%");
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.setAsPresent(allAboutPage.getHowDoesItWork());
    }

    public void unload() {
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.removeAsPresent(allAboutPage.getHowDoesItWork());

    }

    public MenuComponent getMenu() {
        return null;
    }
}
