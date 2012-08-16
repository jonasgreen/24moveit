package com.moveit.client.about;

import com.moveit.client.gui.Page;
import com.moveit.client.guicomponents.HtmlComponent;
import com.moveit.client.html.HtmlContent;

/**
 *
 */
public class SearchHelpPage extends Page <SearchHelpController>{
    private HtmlComponent content;
    private String html;

    public SearchHelpPage() {
        super();
        content = new HtmlComponent();
        initWidget(content);
    }

    public void init() {
        content.setHtml(getHtml());
    }


    public String getHtml() {
        if (html == null) {
            HtmlContent html = new HtmlContent();
            html.addSection("helpH1", "Søgning efter flyttejobs");
            html.addSection("helpText", "Du foretager en søgning ved at indtaste en by i søgefeltet og trykke på den blå søgeknap. Hvis " +
                    "systemet finder nogen flyttejobs, som opfylder søgekriterierne, vises de på kortet og i en tabel nederst på siden.");
            html.addLinkAndSection("helpIndex", "helpH3", "helpText", "Søgekriterier", "Som udgangspunkt søger systemet efter...");
            html.addLinkAndSection("helpIndex", "helpH3", "helpText", "Ændring af søgekriterierne", "Du ændrer");
            html.addLinkAndSection("helpIndex", "helpH3", "helpText", "Forstå kortet", "Kortet er bla bla");
            html.addLinkAndSection("helpIndex", "helpH3", "helpText", "Forstå resultatlisten", "Resultatlisten bruges...");


            this.html = html.getHtml();
        }
        return html;

    }


}