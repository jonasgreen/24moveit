package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

/**
 *
 */
public class ButtonComponent extends GuiComponent{
    private Button button = new Button();

    public ButtonComponent() {
        super();
        initWidget(button);
    }

    public ButtonComponent(String s){
        super();
        initWidget(button);
        button.setText(s);
    }

    public Button getButton() {
        return button;
    }

    public void setText(String s) {
        button.setText(s);
    }

    public void addClickHandler(ClickHandler clickHandler) {
        button.addClickHandler(clickHandler);
    }
}
