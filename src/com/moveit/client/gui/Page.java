package com.moveit.client.gui;

import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.GuiComponent;

/**
 *
 */
public abstract class Page <C extends PageController> extends GuiComponent{

    private C controller;

    public void setController(C controller){
        this.controller = controller;
    }

    public C getController() {
        return controller;
    }

    public abstract void init();

}
