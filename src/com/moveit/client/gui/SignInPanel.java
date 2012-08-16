package com.moveit.client.gui;

import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LSignIn;
import com.moveit.client.model.SignInData;

/**
 *
 */
public class SignInPanel extends FlexTableComponent {

    public StringContainer EMAIL = new StringContainer(Language.get(LSignIn.EMAIL), true);
    public PasswordContainer PASSWORD = new PasswordContainer(Language.get(LSignIn.PASSWORD), true);
    public CheckBoxComponent REMEMBER_ME = new CheckBoxComponent(Language.get(LSignIn.REMEMBER_ME));
    public HyperlinkComponentOld FORGOT_PASSWORD = new HyperlinkComponentOld(Language.get(LSignIn.FORGOT_PASSWORD), false, SignInPageController.HISTORY_NAME);

    public SignInPanel() {
        super();
        init();
    }

    private void init() {



        Layout17 ll = new TextLayout(Horizontal.RIGHT).sizeSmall().bold();

        Layout17 tbl = new TextLayout("32px", "300px", Vertical.MIDDLE).sizeInput().add(P.VERTICAL_ALIGN_MIDDLE);

        setLabel(0, 0, EMAIL, ll);
        setWidget(0, 1, EMAIL, tbl);

        setLabel(1, 0, PASSWORD, ll);
        setWidget(1, 1, PASSWORD, tbl);

        setWidget(1, 2, REMEMBER_ME, new TextLayout(Horizontal.RIGHT).sizeSmall().paddingRight(10));


        setWidget(2, 0, FORGOT_PASSWORD, new TextLayout(2, 0, 2, 0).sizeSmall());
        getFlexCellFormatter().setColSpan(2, 0, 2);
        FORGOT_PASSWORD.setVisible(true);


        getPanel().setCellSpacing(6);

    }


    public SignInData getValue() {
        SignInData s = new SignInData();
        s.setEmail(EMAIL.getValue());
        s.setPassword(PASSWORD.getValue());
        return s;
    }

    public void setValue(SignInData s) {
        EMAIL.setValue(s.getEmail());
        PASSWORD.setValue(s.getPassword());
    }

    public void clear() {
        clearDataContainerChildren();
    }
}
