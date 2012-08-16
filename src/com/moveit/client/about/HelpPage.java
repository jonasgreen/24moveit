package com.moveit.client.about;

import com.moveit.client.gui.Page;
import com.moveit.client.guicomponents.HtmlComponent;
import com.moveit.client.guicomponents.StyleIt;
import com.moveit.client.guicomponents.TextLayout;
import com.moveit.client.language.LHelp;

/**
 *
 */
public class HelpPage extends Page<HelpController> {

    private HtmlComponent content;
    private String text;

    public HelpPage() {
        super();
        this.content = new HtmlComponent();
        initWidget(content);        
    }

    public void init() {
        content.setHtml(getText());
        StyleIt.add(content, new TextLayout().sizeNormal());
    }

    public String getText() {
        if (text == null) {
            text = LHelp.HELP.text();
        }
        return text;
    }

    public HtmlComponent getContent() {
        return content;
    }
}
