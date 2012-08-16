package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 */
public class FlowComponent extends GuiComponent{




    private FlowPanel panel;

    public FlowComponent() {
        super();
        this.panel = new FlowPanel();
        initWidget(panel);
    }


    public void add(GuiComponent gc, Layout17 l){
        panel.add(gc);
        gc.layout(l);
    }



}