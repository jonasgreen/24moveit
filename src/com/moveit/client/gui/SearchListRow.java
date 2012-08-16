package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.guicomponents.*;
import com.moveit.client.model.Route;
import com.moveit.client.model.User;
import com.moveit.client.service.Service;
import com.moveit.client.service.VoidResult;
import com.moveit.client.service.SilentCallBack;
import com.moveit.client.language.LSearchPage;
import com.moveit.client.util.GoogleAnalytics;

/**
 *
 */
public class SearchListRow extends VerticalComponent {

    private Route route;
    private SearchListRowContent content;
    private ButtonComponent contactInfoButton;
    private SearchListController controller;


    public SearchListRow(SearchListController ctrl, Route r, P color) {
        super();
        this.controller = ctrl;
        this.route = r;
        content = new SearchListRowContent(ctrl, r, this, color);
        add(content);
        add(getContactInfoButton(), new TextLayout(4, 4, 4, 4, Horizontal.LEFT).sizeEkstraSmall());
        getContactInfoButton().setVisible(false);
        setBackgroundColor(P.BACKGROUND_YELLOW);


    }

    public Route getRoute() {
        return route;
    }

    public ButtonComponent getContactInfoButton() {
        if (contactInfoButton == null) {
            contactInfoButton = new ButtonComponent(LSearchPage.SHOW_CONTACT_INFO_1.text()+route.countInfoShownTo() + LSearchPage.SHOW_CONTACT_INFO_2.text());
            contactInfoButton.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    User u = ApplicationController.getInstance().getUser();
                    content.getContactInfo().setVisible(true);
                    content.getContactInfo().setValue(route);
                    contactInfoButton.setVisible(false);
                    if (u.isDriver()) {
                        Service.contactInfoShownTo(u.getId(), route.getId(), new SilentCallBack<VoidResult>() {
                            @Override
                            public void success(VoidResult result) {
                                //Ignore
                            }

                            @Override
                            public void fail(Throwable t) {
                                //Ignore
                            }
                        });
                        GoogleAnalytics.logAction(GoogleAnalytics.SHOW_CONTACTINFO_DRIVER, u.getName(), u.getId().toString());
                    }
                }
            });
        }
        return contactInfoButton;
    }


    public void selected(boolean b) {
        content.selected(b);
    }

    public void setColor(P next) {
        content.setColor(next);
    }

    public void setupColor(P next) {
        content.setupColor(next);
    }

    public void clicked() {
        content.clicked();
    }
}
