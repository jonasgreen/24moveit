package com.moveit.client.gui;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.Hyperlink;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LSignIn;
import com.moveit.client.validator.ValidateManager;

/**
 *
 */
public class SignInPage extends Page<SignInPageController> {

    private VerticalComponent content;
    private SignInPanel signInPanel;
    private VerticalComponent signInWrapper;
    private Hyperlink createAnAccount;
    private SimplePanelComponent problemHolder;
    private ValidationComponent valComponent;


    public SignInPage() {
        super();
        this.content = new VerticalComponent();
        initWidget(content);
    }

    public void init() {

        Layout17 ll = new TextLayout(0, 0, 12, 0).sizeH1().bold();
        Layout17 lsiguPanel = new Layout17(0, 0, 0, 0);

        content.add(new LabelComponent(Language.get(LSignIn.TITLE)), ll);
        content.add(getProblemHolder(), new Layout17(0, 0, 10, 0, null, "300px"));
        content.add(getSignInWrapper(), lsiguPanel);

        ColorButton sButton = getSaveButton();
        content.add(sButton, new Layout17(20, 20, 20, 0, sButton.getHeight(), sButton.getWidth(), Horizontal.RIGHT, null));
        content.add(getCreateAnAccount());
    }

    private ColorButton getSaveButton() {
        ColorButton b = ColorButtonFactory.getBlue90x60(Language.get(LSignIn.SIGNIN_BUTTON));
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getController().signIn();
            }
        });
        return b;
    }

    public Hyperlink getCreateAnAccount() {
        if (createAnAccount == null) {
            createAnAccount = new Hyperlink(Language.get(LSignIn.CREATE_FREE_ACCOUNT), false, SignUpPageController.HISTORY_NAME);
            StyleIt.add(createAnAccount, new TextLayout().sizeH3().bold().add(P.COLOR_BLUE_DARK));
            createAnAccount.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    InfoManager.hideInfo();
                    ApplicationController.getInstance().loadPage(SignUpPageController.getInstance());
                }
            });
        }
        return createAnAccount;
    }


    public VerticalComponent getSignInWrapper() {
        if (signInWrapper == null) {
            signInWrapper = new VerticalComponent();
            signInWrapper.add(getSignInPanel(), new Layout17(1, 1, 1, 1, null, "520px").add(P.BACKGROUND_E1));
        }
        return signInWrapper;
    }



    public SignInPanel getSignInPanel() {
        if (signInPanel == null) {
            signInPanel = new SignInPanel();
            signInPanel.PASSWORD.addKeyDownHandler(new KeyDownHandler() {
                public void onKeyDown(KeyDownEvent event) {
                    if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                        getController().signIn();
                    }
                }
            });
            signInPanel.EMAIL.addKeyDownHandler(new KeyDownHandler() {
                public void onKeyDown(KeyDownEvent event) {
                    if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                        getController().signIn();
                    }
                }
            });

            signInPanel.FORGOT_PASSWORD.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    getController().forgotPassword();
                }
            });


        }
        return signInPanel;
    }

    public void removeErrors() {
        if (valComponent != null) {
            valComponent.removeFromParent();
            for (DataContainer dc : getSignInPanel().getDataContainerChildren()) {
                dc.setDataIsIllegal(false);
            }

        }
    }

    public void showErrors(ValidateManager vm) {
        if (valComponent != null) {
            valComponent.removeFromParent();
        }

        InfoManager.hideInfo();
        valComponent = new ValidationComponent(vm);
        getProblemHolder().add(valComponent, new Layout17(0, 0, 15, 0, null, "100%"));

        vm.getErrorDCs().get(0).setFocus(true);
    }


    public SimplePanelComponent getProblemHolder() {
        if (problemHolder == null) {
            problemHolder = new SimplePanelComponent();
        }
        return problemHolder;
    }

    public VerticalComponent getContent() {
        return content;
    }
}

