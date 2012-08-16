package com.moveit.client.gui;

import com.moveit.client.guicomponents.VerticalComponent;

/**
 *
 */
public class ByWhoPanel extends VerticalComponent{

    private ByWhoSelector byWhoSelector;


    public ByWhoPanel() {
        super();
        init();
    }

    private void init() {
        add(getByWhoSelector());
    }

    public ByWhoSelector getByWhoSelector() {
        if (byWhoSelector == null) {
            byWhoSelector = new ByWhoSelector();
        }
        return byWhoSelector;
    }


    public void setFocus() {
        byWhoSelector.setFocus();
    }
}
