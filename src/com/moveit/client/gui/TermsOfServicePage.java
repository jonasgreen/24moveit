package com.moveit.client.gui;

import com.moveit.client.guicomponents.HtmlComponent;
import com.moveit.client.html.HtmlContent;


/**
 *
 */
public class TermsOfServicePage extends Page<TermsOfServiceController> {

    private HtmlComponent content;
    private String html;

    public TermsOfServicePage() {
        super();
        content = new HtmlComponent();
        initWidget(content);
    }


    public void init() {

    }

    public String getHtml() {
        if (html == null) {

            HtmlContent hc = new HtmlContent();
            hc.addSection("termsH1", "Betingelser for brug af 24moveit");
            hc.addSection("termText", "Ved brug websiderne 24moveit.com, 24moveit.dk og 24moveit.appspot.com accepterer du følgende betingelser.");
            hc.addSection("termText", "24moveit har ret til at updatere og ændre betingelserne for brug af 24moveit uden varsel.");
            html = hc.getHtml();
        }
        return html;
    }


    public HtmlComponent getContent() {
        if (content == null) {
            content = new HtmlComponent();
        }
        return content;
    }
}