package com.moveit.client.gui;

/**
 *
 */
public class BottomPageController{

    private static BottomPageController instance = null;

    private BottomPage page;


    private BottomPageController(){
        this.page = new BottomPage(this);
    }

    public static BottomPageController getInstance() {
        if (instance == null) {
            instance = new BottomPageController();
        }
        return instance;
    }


    public BottomPage getPage() {
        return page;
    }

}
