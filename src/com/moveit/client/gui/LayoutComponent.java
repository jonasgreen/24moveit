package com.moveit.client.gui;

import com.moveit.client.guicomponents.GuiComponent;
import com.google.gwt.user.client.ui.LayoutPanel;

/**
 *
 */
public class LayoutComponent extends GuiComponent{
    private LayoutPanel panel;

    public LayoutComponent() {
        super();
        panel = new LayoutPanel();
        initWidget(panel);
    }

    public LayoutPanel getPanel() {
        return panel;
    }
}
