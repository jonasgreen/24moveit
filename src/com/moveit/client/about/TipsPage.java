package com.moveit.client.about;

import com.moveit.client.gui.Page;
import com.moveit.client.guicomponents.HtmlComponent;

/**
 *
 */
public class TipsPage extends Page<TipsController> {
    private HtmlComponent content;
    private String html;

    public TipsPage() {
        super();
        content = new HtmlComponent();
        initWidget(content);
    }

    public void init() {
        content.setHtml(getHtml());
    }

    public String getHtml() {
        if (html == null) {
            html = "<html>" +
                    "<div class=helpH1>Tips</div>" +
                    "<div class=helpText>Under udarbejdelse.</div>";
        }
        return html;
    }

    public HtmlComponent getContent() {
        return content;
    }
}
