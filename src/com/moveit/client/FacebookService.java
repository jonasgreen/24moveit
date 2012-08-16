package com.moveit.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.moveit.client.facebook.FBFeed;
import com.moveit.client.facebook.FacebookConnect;
import com.moveit.client.facebook.LoginCallback;
import com.moveit.client.language.LFacebook;
import com.moveit.client.model.Address;
import com.moveit.client.model.Route;
import com.moveit.client.gui.InfoManager;

/**
 *
 */
public class FacebookService {

    //private String API_KEY = "1d81c942b38e2e6b3fc35a147d371ab3";//localhost port 8888
    //private static String API_KEY = "707cee0b003b01d52b2b6a707fa1202b";//localhost port 8080
    private static String API_KEY = "3f6729c94b43089441bd352cfc02033f"; //PROD

    private AsyncCallback<JavaScriptObject> callback;

    public void puplish(String title, AsyncCallback acb) {
        puplish(title, "", acb);
    }

    public void puplish(Route r, AsyncCallback acb) {
        puplish(LFacebook.FEED_TITLE.text(), generateFeedText(r), acb);
    }

    private void puplish(String feedTitle, String feedText, AsyncCallback acb) {
        this.callback = acb;
        String link = "http://www.24moveit.appspot.com";
        Image img = new Image("http://24moveit.com/newLogo2c.png");
        String attMessage = LFacebook.ATT_MESSAGE.text();
        String attTitle = LFacebook.ATT_TITLE.text();
        String attPart1 = LFacebook.ATT_PART1.text();
        String attPart2 = LFacebook.ATT_PART2.text();

        FBFeed fbf = new FBFeed(feedText, feedTitle, link, img, attMessage, attTitle, attPart1, attPart2);

        puplish(fbf);

    }


    private String generateFeedText(Route r) {
        StringBuffer sb = new StringBuffer(LFacebook.ATT_MESSEAGE_START.text());
        sb.append(r.getCargoDescription()).append("\n\n");

        Address adr = r.getFromPoint().getAddress();
        sb.append(adr.getStreet()).append(", ").append(adr.getCityCode()).append(" ").append(adr.getCity()).append(" - ");

        adr = r.getToPoint().getAddress();
        sb.append(adr.getStreet()).append(", ").append(adr.getCityCode()).append(" ").append(adr.getCity());

        return sb.toString();
    }


    private void puplish(final FBFeed f) {
        try {
            FacebookConnect.init(API_KEY, "/xd_receiver.htm", new LoginCallback() {
                public void onLogin() {
                }
            });


            Timer t = new Timer() {
                @Override
                public void run() {
                    FacebookConnect.requireSession(new AsyncCallback<Boolean>() {
                        public void onFailure(Throwable caught) {
                            callback.onFailure(caught);
                        }

                        public void onSuccess(Boolean isLoggedIn) {
                            if (isLoggedIn) {
                                publishing(f);
                                callback.onSuccess(null);
                            }
                            else {
                                callback.onSuccess(null);
                                //ignore - maybee a callback method activation
                            }
                        }
                    });
                }
            };
            t.schedule(1500);

        }
        finally {
            //if something goes native goes wrong - stop progrees bar
            Timer t1 = new Timer() {
                @Override
                public void run() {
                    InfoManager.stopProgressBar();
                }
            };
            t1.schedule(7000);
        }
    }

    private void publishing(final FBFeed f) {
        try {
            FacebookConnect.streamPublish(f.getFeedText(), f.getAttachment(), null, null, f.getFeedTitle(), false, null, callback);
        }
        catch (Throwable t) {
            System.out.println("ERROR: FACEBOOK");
        }

    }


}
