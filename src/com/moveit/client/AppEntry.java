package com.moveit.client;

import com.google.gwt.core.client.EntryPoint;
import com.moveit.client.gui.ApplicationController;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AppEntry implements EntryPoint {

    


 
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        ApplicationController.getInstance().loadApplication();
    }




}





