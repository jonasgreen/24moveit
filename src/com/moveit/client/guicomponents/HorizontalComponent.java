package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 *
 */
public class HorizontalComponent extends CellComponent {

    protected HorizontalPanel panel = new HorizontalPanel();

    public HorizontalComponent() {
        super();
        initWidget(panel);
    }

    public HorizontalPanel getPanel() {
        return panel;
    }

   


}
