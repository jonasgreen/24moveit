package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.event.dom.client.ClickHandler;

/**
 *
 */
public class HyperlinkComponentOld extends GuiComponent{
    private Hyperlink hyperlink;

    public HyperlinkComponentOld(String text, boolean asHtml, String targetHistory) {
        super();
        hyperlink = new Hyperlink(text, asHtml, targetHistory);
        initWidget(hyperlink);
    }


    public Hyperlink getHyperlink() {
        return hyperlink;
    }

    public void addClickHandler(ClickHandler clickHandler) {
        hyperlink.addClickHandler(clickHandler);
    }
}
