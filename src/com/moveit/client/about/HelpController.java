package com.moveit.client.about;

import com.moveit.client.guicomponents.MenuComponent;
import com.moveit.client.guicomponents.PageController;

/**
 *
 */
public class HelpController extends PageController<HelpPage> {


    private static String HISTORY_NAME = "help";
    private static HelpController instance;

    private HelpController() {
        super(HISTORY_NAME);
    }

    public static HelpController getInstance() {
        if (instance == null) {
            instance = new HelpController();
        }
        return instance;
    }
    public HelpPage newInstance() {
        return new HelpPage();
    }

    public void load() {
        page.setWidth("100%");
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.setAsPresent(allAboutPage.getHelp());

    }

    public void unload() {
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.removeAsPresent(allAboutPage.getHelp());
    }

    public MenuComponent getMenu() {
       return null;
    }

}
