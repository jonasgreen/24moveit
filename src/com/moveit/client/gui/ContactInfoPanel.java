package com.moveit.client.gui;

import com.moveit.client.constants.OfferTypeConstant;
import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.constants.ContactWishConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.model.Route;
import com.moveit.client.model.User;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.Service;
import com.moveit.client.service.UserResult;
import com.moveit.client.language.LContactInfoPanel;

/**
 *
 */
public class ContactInfoPanel extends FlexTableComponent {

    public LabelComponent name = new LabelComponent(LContactInfoPanel.NAME.text());
    public LabelComponent phone = new LabelComponent(LContactInfoPanel.PHONE.text());
    public LabelComponent email = new LabelComponent(LContactInfoPanel.EMAIL.text());

    public LabelComponent nameValue = new LabelComponent("");
    public LabelComponent phoneValue = new LabelComponent("");
    public HtmlComponent emailValue = new HtmlComponent();
    public HorizontalComponent infoValue;


    private User contactInfoUser = null;
    private LabelComponent infoValueText;
    private HyperlinkComponent signInLink;

    private SearchListRow parent;

    public ContactInfoPanel(SearchListRow slr) {
        super();
        parent = slr;
        init();
    }

    private void init() {
        Layout17 ll = new TextLayout(null, "45px", Horizontal.LEFT).sizeSmall();

        Layout17 lv = new TextLayout(null, "200px", Horizontal.LEFT).sizeSmall();

        int i = 0;

        setWidget(i, 0, name, ll);
        setWidget(i++, 1, nameValue, lv);

        if (shouldPhoneBeShown()) {
            setWidget(i, 0, phone, ll);
            setWidget(i++, 1, phoneValue, lv);
        }

        if (shouldMailBeShown()) {
            setWidget(i, 0, email, ll);
            setWidget(i++, 1, emailValue, lv);
        }

        setWidget(i, 0, getInfoValue(), new Layout17(Horizontal.LEFT));
        getFlexCellFormatter().setColSpan(i, 0, 2);

    }

    private boolean shouldMailBeShown() {
        Integer wish = parent.getRoute().getContactWish();
        return wish == null || wish != ContactWishConstant.PHONE.getValue();
    }

    private boolean shouldPhoneBeShown() {
        Integer wish = parent.getRoute().getContactWish();
        return wish == null || wish != ContactWishConstant.MAIL.getValue();
    }


    public HorizontalComponent getInfoValue() {
        if (infoValue == null) {
            infoValue = new HorizontalComponent();
            Layout17 l = new TextLayout(0, 8, 0, 0, null, Vertical.MIDDLE).sizeSmall();
            infoValue.add(getInfoValueText(), l);
            infoValue.add(getSignInLink(), l);
        }
        return infoValue;
    }


    public LabelComponent getInfoValueText() {
        if (infoValueText == null) {
            infoValueText = new LabelComponent("");
            infoValueText.setBackgroundColor(P.BACKGROUND_RED);

            StyleIt.add(infoValueText, Name.PADDING, "4px");
            StyleIt.add(infoValueText, P.COLOR_WHITE);

        }
        return infoValueText;
    }


    public HyperlinkComponent getSignInLink() {
        if (signInLink == null) {
            signInLink = new HyperlinkComponent();
            signInLink.getHyperlink().setText(LContactInfoPanel.LOGIN.text());
            signInLink.getHyperlink().setTargetHistoryToken(SignInPageController.HISTORY_NAME);
        }
        return signInLink;
    }

    public void setValue(final Route r) {
        if (contactInfoUser == null) {
            Service.getUser(r.getUserId(), new CallBack<UserResult>() {
                public void fail(Throwable caught) {
                    setContactInfo(LContactInfoPanel.CONTACTINFO_NOT_FOUND.text(), false);
                }

                public void success(UserResult u) {
                    contactInfoUser = u.getUser();
                    addInfo(r);
                }
            });
        }
        else {
            addInfo(r);
        }

    }

    private void addInfo(Route r) {
        User user = ApplicationController.getInstance().getUser();
        String info = null;
        boolean logOnPossible = true;

        if (user != null && user.getId().longValue() == contactInfoUser.getId()) {
            setContactInfo(info, logOnPossible);
            return;
        }

        if (r.getOfferType().getValue() == OfferTypeConstant.BASIS.getValue()) {
            if (user == null) {
                info = LContactInfoPanel.CONTACTINFO_LOGIN_NEEDED.text();
            }
        }
        else if (r.getOfferType().getValue() == OfferTypeConstant.PRO.getValue()) {
            if (user == null) {
                info = LContactInfoPanel.CONTACTINFO_LOGIN_AS_HAULIER_NEEDED.text();
            }
            else if (user.getUserType() == UserTypeConstant.CUSTOMER.getValue()) {
                info = LContactInfoPanel.CONTACTINFO_LOGIN_AS_HAULIER_NEEDED_BY_OWNER.text();
                logOnPossible = false;
            }
        }
        else {
            if (user == null) {
                info = LContactInfoPanel.CONTACTINFO_LOGIN_AS_HAULIER_AND_DMF_NEEDED.text();
            }
            else if (user.getUserType() == UserTypeConstant.CUSTOMER.getValue() || user.getUserType() == UserTypeConstant.DRIVER.getValue()) {
                info = LContactInfoPanel.CONTACTINFO_LOGIN_AS_HAULIER_AND_DMF_NEEDED_BY_OWNER.text();
                logOnPossible = false;
            }
        }
        setContactInfo(info, logOnPossible);
    }

    private void setContactInfo(String info, boolean logOnPossible) {
        nameValue.setText("xxxxxx xxxxxxxx");
        if (shouldPhoneBeShown()) {
            phoneValue.setText("xx xx xx xx");
        }
        if (shouldMailBeShown()) {
            emailValue.setHtml("xxxxx@xxxx.xxx");
        }
        if (info == null) {
            getInfoValue().setVisible(false);
            setContactInfo();
            return;
        }
        parent.getContactInfoButton().setVisible(false);
        getInfoValue().setVisible(true);
        getInfoValueText().setText(info);
        getSignInLink().setVisible(logOnPossible);
    }

    private void setContactInfo() {
        nameValue.setText(contactInfoUser.getName());
        if (shouldPhoneBeShown()) {
            phoneValue.setText(contactInfoUser.getPhone());
        }
        if (shouldMailBeShown()) {
            emailValue.setHtml("<a href=\"mailto:" + contactInfoUser.getEmail() + "\">" + contactInfoUser.getEmail() + "</a>");

        }
    }


}
