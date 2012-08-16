package com.moveit.client.about;

import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.MenuComponent;

/**
 *
 */
public class SearchHelpController extends PageController <SearchHelpPage>{


    private static String HISTORY_NAME = "searchhelp";
    private static SearchHelpController instance;

    private SearchHelpController() {
        super(HISTORY_NAME);

    }

    public static SearchHelpController getInstance() {
        if (instance == null) {
            instance = new SearchHelpController();
        }
        return instance;
    }

    public SearchHelpPage newInstance() {
        return new SearchHelpPage();
    }

    public void load() {
        page.setWidth("100%");
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.setAsPresent(allAboutPage.getSearchHelp());
    }

    public void unload() {
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.removeAsPresent(allAboutPage.getSearchHelp());

    }

    public MenuComponent getMenu() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}