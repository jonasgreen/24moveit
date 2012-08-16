package com.moveit.client.gui;

import com.moveit.client.guicomponents.DataContainer;
import com.moveit.client.guicomponents.MenuComponent;
import com.moveit.client.guicomponents.PageController;
import com.moveit.client.guicomponents.PopupPageController;
import com.moveit.client.language.Language;
import com.moveit.client.language.LSignIn;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.Service;
import com.moveit.client.service.UserResult;
import com.moveit.client.service.VoidResult;
import com.moveit.client.validator.ValidateManager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SignInPageController extends PageController <SignInPage> implements PopupPageController {

    private static SignInPageController instance = null;
    public static String HISTORY_NAME = "signin";


    private SignInPageController() {
        super(HISTORY_NAME);
    }

    public static SignInPageController getInstance() {
        if (instance == null) {
            instance = new SignInPageController();
        }
        return instance;
    }

    public SignInPage newInstance() {
        return new SignInPage();
    }

    public void load() {
        getPage();
        page.setVisible(true);
        page.getSignInPanel().PASSWORD.clear();
        page.removeErrors();
        page.getSignInPanel().EMAIL.setFocus(true);
        page.getSignInPanel().REMEMBER_ME.getCheckBox().setValue(false);
    }

    public MenuComponent getMenu() {
        return null;  
    }

    public void signIn() {
        ValidateManager vm = new ValidateManager();
        boolean succes = vm.validate(page.getSignInPanel().getDataContainerChildren());
        if (succes) {
            page.removeErrors();
            Service.signIn(page.getSignInPanel().getValue(), new CallBack<UserResult>() {
                public void fail(Throwable caught) {
                    page.getSignInPanel().FORGOT_PASSWORD.setVisible(true);
                }

                public void success(UserResult result) {
                    PopupManager.hideAndShowNormalPage();
                    ApplicationController.getInstance().loggedOn(result.getUser(), page.getSignInPanel().REMEMBER_ME.getCheckBox().getValue());
                    InfoManager.showSucces(Language.get(LSignIn.SIGNIN_SUCCES));
                }
            });
        }
        else {
            page.showErrors(vm);
        }
    }

    public void forgotPassword() {
        page.getSignInPanel().PASSWORD.setDataIsIllegal(false);
        ValidateManager vm = new ValidateManager();
        List<DataContainer> containers = new ArrayList<DataContainer>();
        containers.add(page.getSignInPanel().EMAIL);
        boolean succes = vm.validate(containers);

        if (succes) {//succes
            page.removeErrors();
            Service.emailPasswordToUser(page.getSignInPanel().EMAIL.getValue(), new CallBack<VoidResult>() {
                @Override
                public void success(VoidResult result) {
                    InfoManager.showSucces(Language.get(LSignIn.PASSWORD_SEND_1), Language.get(LSignIn.PASSWORD_SEND_2));
                }

                @Override
                public void fail(Throwable t) {
                }
            });
        }
        else {
            page.showErrors(vm);
        }
    }
}
