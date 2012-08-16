package com.moveit.client.about;

import com.moveit.client.gui.Page;
import com.moveit.client.guicomponents.HtmlComponent;
import com.moveit.client.guicomponents.StyleIt;
import com.moveit.client.guicomponents.TextLayout;
import com.moveit.client.language.LHowDoesItWork;

/**
 *
 */
public class HowPage extends Page<HowController> {

    private HtmlComponent content;
    private String html;

    public HowPage() {
        super();
        this.content = new HtmlComponent();
        initWidget(content);
    }

    public void init() {
        content.setHtml(getHtml());
        StyleIt.add(content, new TextLayout().sizeNormal());
    }

    public String getHtml() {
        if (html == null) {
            html = LHowDoesItWork.HOW.text();

        }
        return html;

    }
}
