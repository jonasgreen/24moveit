package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.CheckBox;

/**
 *
 */
public class CheckBoxComponent extends GuiComponent{

    private CheckBox checkBox;

    public CheckBoxComponent(String text) {
        this.checkBox = new CheckBox(text);
        initWidget(checkBox);
    }

    public CheckBox getCheckBox() {
        
        return checkBox;
    }
}
