package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LLogo;
import com.moveit.client.language.Language;

/**
 *
 */
public class LogoMenues extends GuiComponent{

    private HorizontalComponent content;
    private HyperlinkLabelComponent signUp;
    private HyperlinkLabelComponent signIn;
    private HyperlinkLabelComponent logOff;
    private LabelComponent userMail;
    private HorizontalComponent fBRecommend;

    public LogoMenues() {
        super();
        this.content = new HorizontalComponent();
        initWidget(content);
        init();
    }

    public void init() {
        VerticalComponent vc = new VerticalComponent();

        content.add(vc);

        content.setCellHorizontalAlignment(vc, HasHorizontalAlignment.ALIGN_LEFT);

        Layout17 l = new TextLayout(0, 0, 0, 10).sizeEkstraSmall();
        Layout17 lMail = new TextLayout(0, 0, 10, 10).sizeNormal().bold().alignRight();

        vc.add(getUserName(), lMail);
        getUserName().setVisible(false);

        HorizontalComponent hc = new HorizontalComponent();

        //hc.add(getFBRecommend(), new TextLayout().alignCenter());
        hc.add(getSignUp(), l);
        hc.add(getSignIn(), l);
        hc.add(getLogOff(), l);
        getLogOff().setVisible(false);

        vc.add(hc);
        vc.setCellHorizontalAlignment(hc, HasHorizontalAlignment.ALIGN_RIGHT);        
        content.add(vc, new Layout17(0, 18, 15, 0, null, Vertical.BOTTOM));
        content.setCellHorizontalAlignment(vc, HasHorizontalAlignment.ALIGN_RIGHT);
    }



    public HorizontalComponent getContent() {
        return content;
    }

    public LabelComponent getUserMail() {
        return userMail;
    }


    public HyperlinkLabelComponent getSignIn() {
        if (signIn == null) {
            signIn = new HyperlinkLabelComponent(Language.get(LLogo.SIGN_IN));
            signIn.getLabel().setWordWrap(false);

            signIn.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    ApplicationController.getInstance().loadPage(SignInPageController.getInstance());
                }
            });

        }
        return signIn;
    }

    public HyperlinkLabelComponent getSignUp() {
        if (signUp == null) {
            signUp = new HyperlinkLabelComponent(Language.get(LLogo.SIGN_UP));
            signUp.getLabel().setWordWrap(false);
            signUp.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    ApplicationController.getInstance().loadPage(SignUpPageController.getInstance());
                }
            });

        }
        return signUp;
    }

    public HyperlinkLabelComponent getLogOff() {
        if (logOff == null) {
            logOff = new HyperlinkLabelComponent(Language.get(LLogo.LOG_OFF));
            logOff.getLabel().setWordWrap(false);

            logOff.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
                    ApplicationController.getInstance().loggedOut();
                }
            });

        }
        return logOff;
    }


    public LabelComponent getUserName() {
        if (userMail == null) {
            userMail = new LabelComponent("Not logged in");
        }
        return userMail;
    }


}
