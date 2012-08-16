package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LLogo;
import com.moveit.client.model.User;
import com.moveit.client.util.MouseOver;

/**
 *
 */
public class LogoPanel {

    private HorizontalComponent content;

    private static LogoPanel instance;
    private LogoMenues logoMenues;

    private LogoPanel() {
    }

    public static LogoPanel getInstance() {
        if (instance == null) {
            instance = new LogoPanel();
        }
        return instance;
    }

    private ImageComponent getWorldImage() {
        return new ImageComponent("world.png");
    }

    private ImageComponent getLogoImage() {
        ImageComponent logoImage = new ImageComponent("newLogo.png");
        logoImage.getImage().addMouseOverHandler(MouseOver.POINTER);
        logoImage.getImage().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
            }
        });
        return logoImage;
    }

    public LogoMenues getLogoMenues() {
        if (logoMenues == null) {
            logoMenues = new LogoMenues();
            logoMenues.setBackgroundColor(P.BACKGROUND_WHITE);
        }
        return logoMenues;
    }

    public HorizontalComponent getPanel() {
        if (content == null) {
            content = new HorizontalComponent();
            //VerticalComponent vc = new VerticalComponent();

            HorizontalComponent iHc = new HorizontalComponent();

            iHc.add(getLogoImage(), new Layout17(0, 0, 0, 0, null, "133px", null, Vertical.MIDDLE));
            iHc.add(LanguageSelector.getInstance(), new Layout17(0,0,0,10, AppFrame.LOGO_HEIGHT + "px", null, Horizontal.LEFT, Vertical.BOTTOM).add(P.BACKGROUND_BACK_PANEL));

            //iHc.add(getWorldImage(), new Layout17(0, 0, 0, 0, AppFrame.LOGO_HEIGHT + "px", "400px"));
            //vc.add(new SimplePanelComponent(), new TextLayout("100%", null));
            //vc.add(iHc);
            //vc.add(new LabelComponent("Powered by Green Cargo Systems"), new TextLayout().sizeEkstraEkstraSmall().colorC1());

            content.add(iHc, new Layout17(0,0,0,0, AppFrame.LOGO_HEIGHT + "px", "633px", Horizontal.LEFT, null).add(P.BACKGROUND_BACK_PANEL));
            content.add(getLogoMenues(), new Layout17(0, 0, 0, 0, AppFrame.LOGO_HEIGHT + "px", "100%", Horizontal.RIGHT, Vertical.MIDDLE).add(P.BACKGROUND_BACK_PANEL));

            content.setBackgroundColor(P.BACKGROUND_WHITE);
        }
        return content;
    }


    public void loggedOn(User user) {
        LogoMenues page = getLogoMenues();
        page.getSignIn().setVisible(false);
        page.getSignUp().setVisible(false);
        page.getUserName().getLabel().setText(user.getEmail());
        page.getUserName().setVisible(true);
        page.getLogOff().setVisible(true);
    }

    public void SignOff() {
        LogoMenues page = getLogoMenues();
        page.getSignIn().setVisible(true);
        page.getSignUp().setVisible(true);
        page.getLogOff().setVisible(false);
        page.getUserName().setVisible(false);
    }

    public void changeLanguage(){
        LogoMenues page = getLogoMenues();
        page.getSignIn().setText(Language.get(LLogo.SIGN_IN));
        page.getSignUp().setText(Language.get(LLogo.SIGN_UP));
        page.getLogOff().setText(Language.get(LLogo.LOG_OFF));

    }
}
