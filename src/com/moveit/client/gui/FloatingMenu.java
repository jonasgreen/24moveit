package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.moveit.client.FacebookService;
import com.moveit.client.guicomponents.HtmlComponent;
import com.moveit.client.language.LFacebook;
import com.moveit.client.language.LFront;
import com.moveit.client.language.Language;
import com.moveit.client.util.GoogleAnalytics;

/**
 *
 */
public class FloatingMenu {


    HtmlComponent html;
    private static FloatingMenu instance;


    public static FloatingMenu getInstance() {
        if (instance == null) {
            instance = new FloatingMenu();
        }
        return instance;
    }

    private FloatingMenu() {
    }


    public void load() {
        if (html != null) {
            html.removeFromParent();
        }
        html = null;
        getFBRecommend();
    }

    public HtmlComponent getFBRecommend() {
        if (html == null) {

            html = new HtmlComponent();
            html.getHtmlContent().addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent clickEvent) {
                    InfoManager.startProgressBar(LFacebook.INFO_CONNECTING.text());
                    GoogleAnalytics.logAction(GoogleAnalytics.FACEBOOK_RECOOMEND);
                    FacebookService fb = new FacebookService();
                    fb.puplish(LFront.FB_RECOMMEND.text(), new AsyncCallback() {
                        public void onFailure(Throwable throwable) {
                            InfoManager.stopProgressBar();                    

                        }

                        public void onSuccess(Object o) {
                            InfoManager.stopProgressBar();
                        }
                    });
                }
            });

            String cssStyle = "fbrecommend";
            
            RootPanel.get("facebook").setStyleName(cssStyle);
            RootPanel.get("facebook").add(html);
            html.setStyleName(cssStyle);


            if (Language.isDanish()) {

                html.getElement().getStyle().setProperty("backgroundImage", "url(\"recommend_danish2.png\")");
                html.setHeight("185px");
                html.setWidth("32px");

            }
            else {
                html.getElement().getStyle().setProperty("backgroundImage", "url(\"recommend_english.png\")");
                html.setHeight("220px");
                html.setWidth("32px");
            }


        }
        return html;
    }

}
