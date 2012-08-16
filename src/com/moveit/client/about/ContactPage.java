package com.moveit.client.about;

import com.moveit.client.guicomponents.HtmlComponent;
import com.moveit.client.guicomponents.StyleIt;
import com.moveit.client.guicomponents.TextLayout;
import com.moveit.client.gui.Page;
import com.moveit.client.language.LContact;

/**
 *
 */
public class ContactPage extends Page<ContactController>{

    private String text;
    private HtmlComponent content;
    public ContactPage() {
        super();
        content = new HtmlComponent();
        initWidget(content);
    }

    public void init() {
        content.setHtml(getText());
        StyleIt.add(content, new TextLayout().sizeNormal());        
    }

    public String getText() {
        if (text == null) {
            text = LContact.CONTACT.text();
        }
        return text;
    }
}
