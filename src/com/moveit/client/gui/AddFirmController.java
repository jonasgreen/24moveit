package com.moveit.client.gui;

import com.moveit.client.constants.MailListConstant;
import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LAddFirmPage;
import com.moveit.client.model.CreateUser;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.Service;
import com.moveit.client.service.UserResult;
import com.moveit.client.validator.ValidateManager;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class AddFirmController extends PageController<AddFirmPage> {

    private static AddFirmController instance = null;
    public static String HISTORY_NAME = "addfirm";


    private AddFirmController() {
        super(HISTORY_NAME);
    }

    public static AddFirmController getInstance() {
        if (instance == null) {
            instance = new AddFirmController();
        }
        return instance;
    }


    public AddFirmPage newInstance() {
        return new AddFirmPage();
    }


    public MenuComponent getMenu() {
        return MenuPanel.getInstance().getAddFirm();
    }

    public void load() {
        getPage();
        TipsManagerAddPage.getInstance().setRelativePlacementLeft(page.getAddr());
        page.FIRM_NAME.setFocus(true);
        page.setWidth("100%");
        page.setVisible(true);
        clearFields();
    }

    public void unload() {
        TipsManagerAddPage.getInstance().clear();

    }

    private void clearFields() {
        getPage().getAcceptTermsBox().setValue(false);
    }

    public void save() {
        ValidateManager vm = new ValidateManager();
        List<DataContainer> dcs = new ArrayList<DataContainer>();

        dcs.add(getPage().FIRM_NAME);
        if (Language.isDanish()) {
            dcs.add(getPage().CVR);
        }
        dcs.add(getPage().getAddr().getCountry());
        dcs.add(getPage().getAddr().getCity());
        dcs.add(getPage().getAddr().getCityCode());
        dcs.add(getPage().getAddr().getStreet());
        dcs.add(getPage().NAME);
        dcs.add(getPage().PHONE);
        dcs.add(getPage().EMAIL);
        dcs.add(getPage().PASSWORD);
        dcs.add(getPage().REPEAT_PASSWORD);
        dcs.add(getPage().getAcceptTermsBox());

        if (!vm.validate(dcs)) {
            vm.showErrors();
        }
        else {
            Service.createUser(getCreateUser(), new CallBack<UserResult>() {
                public void fail(Throwable caught) {
                }

                PageController previous = ApplicationController.getInstance().getPreviousController();

                public void success(UserResult result) {
                    if (previous == null) {
                        DialogComponent.showSimpleOk(LAddFirmPage.FIRM_ADDED_WITH_SUCCES_1.text(), FrontPageController.getInstance(),
                                LAddFirmPage.FIRM_ADDED_WITH_SUCCES_2.text() + result.getUser().getEmail() + ".", LAddFirmPage.FIRM_ADDED_WITH_SUCCES_3.text(),
                                "",
                                LAddFirmPage.FIRM_ADDED_WITH_SUCCES_4.text()
                        );

                    }
                    else {
                        DialogComponent.showSimpleOk(LAddFirmPage.FIRM_ADDED_WITH_SUCCES_1.text(), previous,
                                LAddFirmPage.FIRM_ADDED_WITH_SUCCES_2.text() + result.getUser().getEmail() + ".",
                                "",
                                LAddFirmPage.FIRM_ADDED_WITH_SUCCES_3.text()
                        );

                    }


                    ApplicationController.getInstance().loggedOn(result.getUser(), false);
                    InfoManager.showSucces(LAddFirmPage.FIRM_ADDED_WITH_SUCCES_1.text());
                    getPage().getAcceptTermsBox().setValue(false);
                }
            });


        }
    }

    private CreateUser getCreateUser() {
        CreateUser cu = new CreateUser();
        AddFirmPage p = getPage();

        cu.setFirmName(p.FIRM_NAME.getValue());
        //only in dansih DMF and CVR number is supported.
        if (Language.isDanish()) {
            cu.setCvrnr(Long.valueOf(p.CVR.getValue()));
            cu.setUserType(p.DMF_MEMBER.getValue() ? UserTypeConstant.DRIVER_DMF.getValue() : UserTypeConstant.DRIVER.getValue());
        }
        else{
            cu.setUserType(UserTypeConstant.DRIVER.getValue());
        }
        cu.setAddress(p.getAddr().getValue());
        cu.setName(p.NAME.getValue());
        cu.setPhone(p.PHONE.getValue());
        cu.setEmail(p.EMAIL.getValue());
        cu.setPassword(p.PASSWORD.getValue());

        //subscriptions
        List<MailListConstant> list = new ArrayList<MailListConstant>();
        if (p.getNewsMail().getCheckBox().getValue()) {
            list.add(MailListConstant.NEWS_24MOVEIT);
        }
        if (p.getRouteMail().getCheckBox().getValue()) {
            list.add(MailListConstant.NEW_ROUTE_ONCE_A_DAY);
        }
        cu.setMailLists(list);

        return cu;
    }

}