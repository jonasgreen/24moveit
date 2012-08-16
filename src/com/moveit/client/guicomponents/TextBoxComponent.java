package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 */
public class TextBoxComponent extends GuiComponent{

    private TextBox textBox = new TextBox();

    public TextBoxComponent() {
        super();
        initWidget(textBox);
    }

    public TextBox getTextBox(){
        return textBox;
    }

    public void setText(String s) {
        this.textBox.setText(s);
    }

    public String getText() {
        return textBox.getText();
    }

    public void setFocus(boolean focus) {
        this.textBox.setFocus(focus);
    }

    public void addKeyDownHandler(KeyDownHandler keyDownHandler) {
        textBox.addKeyDownHandler(keyDownHandler);
    }

    public boolean isEmpty(){
        return textBox.getText() == null || textBox.getText().trim().equals("");
    }

    public void setValue(Object obj) {
        textBox.setText((String)obj);
    }

    public String getValue(){
        return textBox.getText();
    }


}
