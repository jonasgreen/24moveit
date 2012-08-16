package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.TextArea;

/**
 *
 */
public class TextAreaComponent extends GuiComponent {
    private TextArea textArea = new TextArea();

    public TextAreaComponent() {
        super();
        initWidget(textArea);
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setText(String s) {
        this.textArea.setText(s);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setFocus(boolean focus) {
        this.textArea.setFocus(focus);
    }

    public void addKeyDownHandler(KeyDownHandler keyDownHandler) {
        textArea.addKeyDownHandler(keyDownHandler);
    }

    public boolean isEmpty() {
        return textArea.getText() == null || textArea.getText().trim().equals("");
    }

    public void setValue(Object obj) {
        textArea.setText((String) obj);
    }

    public String getValue() {
        return textArea.getText();
    }

}
