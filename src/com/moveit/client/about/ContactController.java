package com.moveit.client.about;

import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.MenuComponent;

/**
 *
 */
public class ContactController extends PageController<ContactPage> {
    
    private static String HISTORY_NAME = "contact";
    private static ContactController instance;

    private ContactController() {
        super(HISTORY_NAME);
    }

    public static ContactController getInstance() {
        if (instance == null) {
            instance = new ContactController();
        }
        return instance;
    }

    public ContactPage newInstance() {
        return new ContactPage();
    }

    public void load() {
        page.setWidth("100%");
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.setAsPresent(allAboutPage.getContact());
    }

    public void unload() {
        AllAboutPage allAboutPage = AllAboutPageController.getInstance().getPage();
        allAboutPage.removeAsPresent(allAboutPage.getContact());

    }

    public MenuComponent getMenu() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
