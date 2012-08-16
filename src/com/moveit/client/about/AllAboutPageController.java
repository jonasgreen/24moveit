package com.moveit.client.about;

import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.MenuComponent;
import com.moveit.client.gui.MenuPanel;

/**
 *
 */
public class AllAboutPageController extends PageController<AllAboutPage> {

    public static String HISTORY_NAME = "allabout";
    private static AllAboutPageController instance;
    private PageController activeController;


    private AllAboutPageController() {
        super(HISTORY_NAME);
    }

    public static AllAboutPageController getInstance() {
        if (instance == null) {
            instance = new AllAboutPageController();
        }
        return instance;
    }

    public AllAboutPage newInstance() {
        return new AllAboutPage();


    }

    public void loadFromHistory(){

    }

    public void load(){
        loadPage(HelpController.getInstance());
    }

    public MenuComponent getMenu() {
         return MenuPanel.getInstance().getHelp();
    }

    public void loadPage(PageController toLoad) {
        //sub-all-about-sites are not added to history
        unloadActiveController();
        activeController = toLoad;
        page.getInsideContent().add(toLoad.getPage());
        toLoad.load();
    }

    private void unloadActiveController() {
        if (activeController != null) {
            activeController.getPage().removeFromParent();
            activeController.unload();
        }
    }


}
