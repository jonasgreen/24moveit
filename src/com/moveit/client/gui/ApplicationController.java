package com.moveit.client.gui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.maps.client.geocode.Placemark;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.moveit.client.guicomponents.*;
import com.moveit.client.history.HistorySupport;
import com.moveit.client.language.LEmailPassword;
import com.moveit.client.language.Language;
import com.moveit.client.model.User;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.Service;
import com.moveit.client.service.SilentCallBack;
import com.moveit.client.service.UserResult;
import com.moveit.client.util.GoogleAnalytics;

import java.util.Date;

/**
 * Global controller. Handle and control reusable gui items.
 */
public class ApplicationController {
    public final static String COOKIE_USER_ID = "userid";
    public final static String COOKIE_LANGUAGE = "language";
    public final static String APP_WIDTH = "815px";
    public final static int APP_WIDTH_INT = 815;
    public final static int PAGE_MARGIN_INT = 40;
    public final static String PAGE_MARGIN = "40px";



    public static String nationality = null;

    private static ApplicationController instance = null;
    private PageController activeController = null;
    //before active controller
    private PageController previousController = null;
    private TextArea loggerPanel = null;
    private HistorySupport history = HistorySupport.getInstance();
    public User user;
    public Timer pingTimer;


    private ApplicationController() {
    }


    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }


    public void loadApplication() {

/*
        SEO - optimizing

        ColorButton b = ColorButtonFactory.getBlue180x60("Gå til flytteportal");
        HorizontalComponent hc = new HorizontalComponent();
        hc.add(b, new TextLayout(Horizontal.CENTER));

        RootPanel rootPanel = RootPanel.get("panel");
        rootPanel.setWidth("100%");
        rootPanel.add(hc);
        b.setWidth(b.getWidth());
        b.setHeight(b.getHeight());

        StyleIt.add(hc, new TextLayout(200, 0,0,0,null, "100%").alignCenter());
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Window.Location.assign("http://www.24moveit.appspot.com");
            }
        });
*/

       
        GoogleAnalytics.runGoogleAnalytics();
        startPinging();
        RootPanel.get("panel").add(AppFrame.getInstance());
        setLanguage();

        //Window.enableScrolling(false);
        //Window.setMargin("0px");

        //setting up application frames
        //sp.add();

        AppFrame.getInstance().setWidth("100%");
        AppFrame.getInstance().setHeight("100%");

        //setting top and bottom panels
        //AppFrame.getInstance().addLogoContent(LogoPanel.getInstance().getPanel(), false);


        HistorySupport.getInstance().loadFirstPage();
        silentLogIn();
        FloatingMenu.getInstance().load();

    }







    private void startPinging() {
        pingServer();//varm server up

        pingTimer = new Timer() {
            @Override
            public void run() {
                pingServer();
            }
        };
        pingTimer.scheduleRepeating(1000 * 60);//ping every minute
    }

    private void pingServer() {
        String domain = Document.get().getDomain();
        if (domain.equals("localhost")) {
            return;
        }
        Service.getUser("dummy", new SilentCallBack<UserResult>() {
            @Override
            public void success(UserResult result) {
                //ignore
            }

            @Override
            public void fail(Throwable t) {
                //ignore
            }
        });
    }


    private void setLanguage() {
        Integer language = getLanguageFromCookie();
        if (language == null) {
            //set from browsers language
            String bl = getBrowserLanguage();
            if (bl == null) {
                Language.changeLanguage(Language.ENGLISH);
                return;
            }
            //danish, swedish and norwegian
            if (bl.equalsIgnoreCase("da") || bl.equalsIgnoreCase("sv") || bl.equalsIgnoreCase("sv-sv") || bl.equalsIgnoreCase("no") || bl.equalsIgnoreCase("nb") || bl.equalsIgnoreCase("nn")) {
                Language.changeLanguage(Language.DANISH);
            }

            else {
                Language.changeLanguage(Language.ENGLISH);
            }
        }
        else {
            Language.changeLanguage(language);
        }
    }


    public void silentLogIn() {
        Long userId = getUserIdFromCookie();
        if (userId != null) {
            Service.getUser(userId, new CallBack<UserResult>() {
                public void fail(Throwable caught) {
                    //ignore
                }

                public void success(UserResult result) {
                    if (result != null && result.getUser() != null) {
                        loggedOn(result.getUser(), true);
                    }

                }
            });
        }
    }

    private Long getUserIdFromCookie() {
        Long userId = null;
        try {
            userId = Long.valueOf(Cookies.getCookie(COOKIE_USER_ID));
        }
        catch (Exception e) {
            //ignore
        }
        return userId;
    }

    private Integer getLanguageFromCookie() {
        Integer language = null;
        try {
            language = Integer.valueOf(Cookies.getCookie(COOKIE_LANGUAGE));
        }
        catch (Exception e) {
            //ignore
        }
        return language;
    }


    private void setCookieUserId(Long userId) {
        try {
            Date expire = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 14));//14 days
            Cookies.setCookie(COOKIE_USER_ID, String.valueOf(userId), expire);
        }
        catch (Exception e) {
            //ignore
        }
    }

    public void setCookieLanguage(Language language) {
        try {
            Date expire = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 14));//14 days
            Cookies.setCookie(COOKIE_LANGUAGE, String.valueOf(language.getValue()), expire);
        }
        catch (Exception e) {
            //ignore
        }
    }

    private void loadDebugLogger() {
        String domain = Document.get().getDomain();
        if (!domain.equals("www.24moveittest.appspot.com")) {
            loggerPanel = new TextArea();
            AppFrame.getInstance().getCenterFrame().add(loggerPanel);
            loggerPanel.setHeight("150px");
            loggerPanel.setWidth("700px");
//            cp.setCellVerticalAlignment(loggerPanel, HasVerticalAlignment.ALIGN_BOTTOM);
        }
    }

    public void debug(String msg) {
        if (loggerPanel != null) {
            loggerPanel.setText(loggerPanel.getText() + msg + "\n");
        }
    }

    public void loadPageFromHistory(PageController toLoad) {
        GoogleAnalytics.logPage(toLoad.getHistoryName());
        MapPopupManager.hideAll();
        if (toLoad instanceof PopupPageController) {
            PopupManager.showComponentFromHistory(toLoad);
            return;
        }
        PopupManager.hide();
        unloadActiveController();
        setActiveController(toLoad);
        AppFrame.getInstance().addCenterContent(toLoad.getPage(), toLoad.getLayout());
        toLoad.loadFromHistory();
        handleMenuLoad(toLoad);
    }

    private void unloadActiveController() {
        InfoManager.hideInfo();
        //getInfoPanel().setVisible(false);
        if (activeController != null) {
            //activeController.getPage().removeFromParent();
            activeController.unload();
        }
    }

    public void loadPage(PageController toLoad) {
        GoogleAnalytics.logPage(toLoad.getHistoryName());
        history.addHistory(toLoad);
        MapPopupManager.hideAll();
        if (toLoad instanceof PopupPageController) {
            PopupManager.showComponent(toLoad);
            return;
        }
        PopupManager.hide();
        unloadActiveController();
        setActiveController(toLoad);
        AppFrame.getInstance().addCenterContent(toLoad.getPage(), toLoad.getLayout());
        toLoad.load();
        handleMenuLoad(toLoad);
        ApplicationController.scrollUp();
    }

    private void setActiveController(PageController p) {
        previousController = activeController;
        activeController = p;
    }

    private void handleMenuLoad(PageController pc) {
        if (pc instanceof PopupPageController) {
            return;
        }
        MenuPanel.getInstance().setSelected(pc.getMenu());
    }


    public void debug(Placemark pm) {
        debug(pm.getAddress());
        try {
            debug("CITY:" + pm.getCity());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("ACCURACY: " + pm.getAccuracy());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("ADMINISTRATIVEAREA: " + pm.getAdministrativeArea());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("COUNTRY: " + pm.getCountry());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("COUNTY: " + pm.getCounty());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("LOCALITY: " + pm.getLocality());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("POSTALCODE: " + pm.getPostalCode());

        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("STATE: " + pm.getState());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("STREET: " + pm.getStreet());
        }
        catch (Exception e) {
            //ignore
        }
        try {
            debug("SUADMINISTRATIVEAREA: " + pm.getSubAdministrativeArea());
        }
        catch (Exception e) {
            //ignore
        }
    }

    public void error(Throwable e) {
        error(e.getClass().getName() + " " + e.getMessage());
    }

    public void error(String s) {
        DialogBox db = new DialogBox(false, false);
        db.setText("SYSTEM ERROR");
        SimplePanelComponent sp = new SimplePanelComponent();
        LabelComponent l = new LabelComponent(s);
        l.getLabel().setWordWrap(true);
        sp.add(l, new TextLayout(4, 4, 4, 4).sizeSmall());
        db.add(sp);
        db.show();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = u;
    }


    public void loggedOn(User user, boolean rememberUser) {
        this.user = user;
        if (rememberUser) {
            setCookieUserId(user.getId());
        }
        MenuPanel.getInstance().getAccount().setActive(true);
        MenuPanel.getInstance().getAccount().setVisible(true);
        LogoPanel.getInstance().loggedOn(user);
        SearchPageController.getInstance().normalSearch();
    }

    public void loggedOut() {
        this.user = null;
        try {
            MenuPanel.getInstance().getAccount().setActive(false);
            MenuPanel.getInstance().getAccount().setVisible(false);
            Cookies.removeCookie(COOKIE_USER_ID);
            LogoPanel.getInstance().SignOff();
            ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
            InfoManager.showSucces(LEmailPassword.YOU_ARE_LOGGED_OUT.text());
        }
        catch (Exception e) {
            //ignore
        }
    }

    public PageController getActiveController() {
        return activeController;
    }


    public void addActiveControllerToHistory() {
        if (activeController != null) {
            history.addHistory(activeController);
        }
    }

    public PageController getPreviousController() {
        return previousController;
    }

    @SuppressWarnings({"AppEngineForbiddenCode"})
    public static native void resizeTo(final int width, final int height) /*-{
        $wnd.resizeTo(width, height);
    }-*/;
    @SuppressWarnings({"AppEngineForbiddenCode"})
    public native String getBrowserLanguage() /*-{
        return navigator.language;
    }-*/;




    @SuppressWarnings({"AppEngineForbiddenCode"})
    public static native void scrollUp() /*-{
        $wnd.scroll(0, 0);
    }-*/;
   
    
    @SuppressWarnings({"AppEngineForbiddenCode"})
    public static native String getUserAgent() /*-{
        return navigator.userAgent.toLowerCase();
    }-*/;


}
