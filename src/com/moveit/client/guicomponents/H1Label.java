package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

/**
 *
 */
public class H1Label extends Composite {
    Label label;


    public H1Label() {
        label = new Label();
        initWidget(label);
    }

    public void setHtml(String s){
        label.setText("<h1>"+s+"</h1>");
    }

    public void setStyleName(String styleName) {
        super.setStyleName(styleName);
    }


}
