package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.moveit.client.guicomponents.*;

/**
 *
 */
public class BottomPage extends VerticalComponent {
    private BottomPageController controller;
    private LabelComponent copyright;
    private HyperlinkLabelComponent termsOfUse;

    public BottomPage(BottomPageController ctrl) {
        super();
        this.controller = ctrl;
        init();
    }

    private void init() {
        //add(getLanguageSelector(), new Layout17(20,0,6,0, Horizontal.CENTER, null));


        RootPanel.get("seoindex").getElement().removeFromParent();
        HorizontalComponent hc = new HorizontalComponent();
        Layout17 l = new TextLayout(0, 4, 0, 4).sizeSmall().add(P.COLOR_GREY);
        hc.add(getCopyright(), l);
        //hc.add(getTermsOfUse(), l.add(P.COLOR_BLUE));
        add(hc, new Layout17(10, 0, 15, 0, Horizontal.CENTER, null));
    }

    public HyperlinkLabelComponent getTermsOfUse() {
        if (termsOfUse == null) {
            termsOfUse = new HyperlinkLabelComponent("Brugsbetingelser");
            termsOfUse.underline();
            termsOfUse.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    Window.open("http://www.24moveit.com/terms_da.html", "_blank", null);
                }
            });
        }
        return termsOfUse;
    }


    public LabelComponent getCopyright() {
        if (copyright == null) {
            copyright = new LabelComponent("Copyright © 2009 24moveit.com");
        }
        return copyright;
    }


    public BottomPageController getController() {
        return controller;
    }
}
