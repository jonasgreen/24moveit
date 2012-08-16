package com.moveit.client.gui;

import com.moveit.client.constants.MailListConstant;
import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LSignUp;
import com.moveit.client.language.Language;
import com.moveit.client.model.Address;
import com.moveit.client.model.CreateUser;
import com.moveit.client.validator.PassNotTheSameValidator;
import com.moveit.client.validator.StringMinValidator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SignUpPanel extends VerticalComponent {

    public StringContainer NAME = new StringContainer(Language.get(LSignUp.NAME), true);
    public StringContainer PHONE = new StringContainer(Language.get(LSignUp.PHONE), true);
    public StringContainer EMAIL = new StringContainer(Language.get(LSignUp.EMAIL), true);
    public PasswordContainer PASSWORD = new PasswordContainer(Language.get(LSignUp.PASSWORD), true);
    public PasswordContainer REPEAT_PASSWORD = new PasswordContainer(Language.get(LSignUp.PASSWORD_AGAIN), true);
    public CheckBoxComponent REMEMBER_ME = new CheckBoxComponent(Language.get(LSignUp.REMEMBER_ME));


    private FlexTableComponent table;
    private CheckBoxComponent newsMail;


    public SignUpPanel() {
        super();
        init();
    }

    private void init() {
        PASSWORD.add(new StringMinValidator(6));
        REPEAT_PASSWORD.add(new PassNotTheSameValidator(PASSWORD));

        this.add(getTable(), new Layout17(0, 0, 10, 0, null, "100%"));


        Layout17 l = new TextLayout(10, 0, 10, 4).sizeSmall();
        this.add(getNewsMail(), l);
    }

    public CheckBoxComponent getNewsMail() {
        if (newsMail == null) {
            newsMail = new CheckBoxComponent(Language.get(LSignUp.ACCEPT_NEWS));
            newsMail.getCheckBox().setValue(true);
        }
        return newsMail;
    }

    public FlexTableComponent getTable() {
        if (table == null) {
            table = new FlexTableComponent();


            Layout17 ll = new TextLayout(Horizontal.RIGHT).sizeSmall().bold();

            Layout17 tbl = new TextLayout("32px", "300px", Vertical.MIDDLE).sizeInput().add(P.VERTICAL_ALIGN_MIDDLE);

            table.setLabel(1, 0, NAME, ll);
            table.setWidget(1, 1, NAME, tbl);


            table.setLabel(2, 0, PHONE, ll);
            table.setWidget(2, 1, PHONE, tbl);

            table.setLabel(3, 0, EMAIL, ll);
            table.setWidget(3, 1, EMAIL, tbl);

            table.setLabel(4, 0, PASSWORD, ll);
            table.setWidget(4, 1, PASSWORD, tbl);

            table.setLabel(5, 0, REPEAT_PASSWORD, ll);
            table.setWidget(5, 1, REPEAT_PASSWORD, tbl);


            table.setWidget(5, 2, REMEMBER_ME, new TextLayout(Horizontal.RIGHT).sizeSmall().paddingRight(10));
            table.getPanel().setCellSpacing(4);

        }
        return table;
    }


    public CreateUser getValue() {
        CreateUser s = new CreateUser();
        Address a = new Address();
        a.setNationalCode(Language.getNationCode());

        s.setAddress(a);
        s.setEmail(EMAIL.getValue());
        s.setName(NAME.getValue());
        s.setPhone(PHONE.getValue());
        s.setUserType(UserTypeConstant.CUSTOMER.getValue());
        s.setPassword(PASSWORD.getValue());

        //what subscriptions
        List<MailListConstant> list = new ArrayList<MailListConstant>();
        if (getNewsMail().getCheckBox().getValue()) {
            list.add(MailListConstant.NEWS_24MOVEIT);
        }
        s.setMailLists(list);

        return s;
    }

    public void setValue(CreateUser s) {
        EMAIL.setValue(s.getEmail());
        NAME.setValue(s.getName());
        PHONE.setValue(s.getPhone());
        PASSWORD.setValue(s.getPassword());
    }

    public void clear() {
        clearDataContainerChildren();
    }


}
