package com.moveit.client.gui;

import com.moveit.client.guicomponents.DataContainer;
import com.moveit.client.guicomponents.MenuComponent;
import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.PopupPageController;
import com.moveit.client.language.LSignUp;
import com.moveit.client.language.Language;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.Service;
import com.moveit.client.service.UserResult;
import com.moveit.client.validator.ValidateManager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SignUpPageController extends PageController<SignUpPage> implements PopupPageController {

    private static SignUpPageController instance = null;
    public static String HISTORY_NAME = "signup";


    private SignUpPageController() {
        super(HISTORY_NAME);
    }

    public static SignUpPageController getInstance() {
        if (instance == null) {
            instance = new SignUpPageController();
        }
        return instance;
    }

    public SignUpPage newInstance() {
        return new SignUpPage();
    }

    public void load() {
        getPage();
        page.setVisible(true);
        page.getSignupPanel().PASSWORD.clear();
        page.removeErrors();
        page.getSignupPanel().NAME.setFocus(true);
    }

    public void unload() {
        page.getSignupPanel().REMEMBER_ME.getCheckBox().setValue(false);

    }

    public MenuComponent getMenu() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void save() {
        ValidateManager vm = new ValidateManager();
        List<DataContainer> dcs = new ArrayList<DataContainer>();
        SignUpPanel sp = page.getSignupPanel();
        dcs.add(sp.NAME);
        dcs.add(sp.PHONE);
        dcs.add(sp.EMAIL);
        dcs.add(sp.PASSWORD);
        dcs.add(sp.REPEAT_PASSWORD);
        dcs.add(page.getAcceptTermsBox());

        boolean succes = vm.validate(dcs);


        if (succes) {
            page.removeErrors();
            Service.createUser(page.getSignupPanel().getValue(), new CallBack<UserResult>() {
                public void fail(Throwable caught) {
                }

                public void success(UserResult result) {
                    PopupManager.hideAndShowNormalPage();
                    ApplicationController.getInstance().loggedOn(result.getUser(), page.getSignupPanel().REMEMBER_ME.getCheckBox().getValue());
                    InfoManager.showSucces(Language.get(LSignUp.ACCOUNT_CREATED));
                    getPage().getAcceptTermsBox().setValue(false);
                }
            });
        }
        else {
            page.showErrors(vm);
        }
    }


}
