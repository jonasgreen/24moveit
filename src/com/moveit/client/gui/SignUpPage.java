package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Hyperlink;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LSignUp;
import com.moveit.client.validator.ValidateManager;
import com.moveit.client.validator.Validator;

/**
 *
 */
public class SignUpPage extends Page<SignUpPageController> {

    private VerticalComponent content;
    private SignUpPanel signupPanel;
    private Hyperlink alreadyAMember;
    private VerticalComponent signUpWrapper;
    private SimplePanelComponent problemHolder;
    private ValidationComponent valComponent;
    private HorizontalComponent termsOfUse;
    private AcceptTermsOfUseContainer acceptTermsBox;

    public SignUpPage() {
        super();
        content = new VerticalComponent();
        initWidget(content);
    }

    public void init() {
        getAcceptTermsBox().add(Validator.ACCEPT_TERMS_OF_USE);

        Layout17 ll = new TextLayout(0, 0, 12, 0).sizeH1().bold();

        Layout17 lsiguPanel = new Layout17().add(P.BACKGROUND_GREY_YELLOW_DARK);

        content.add(new LabelComponent(Language.get(LSignUp.TITLE)), ll);
        content.add(getProblemHolder(), new Layout17(0, 0, 10, 0, null, "300px"));

         //driver link
        HyperlinkLabelComponent driver = new HyperlinkLabelComponent(Language.get(LSignUp.HAULIER_LINK));
        Layout17 hl = new TextLayout(Horizontal.RIGHT).sizeNormal().underline().colorOrange().alignRight().paddingBottom(4);
        driver.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ApplicationController.getInstance().loadPage(AddFirmController.getInstance());
            }
        });

        content.add(driver, hl);
        content.add(getSignUpWrapper(), lsiguPanel);

        content.add(getTermsOfUseAndButton(), new Layout17(20,0,20,0, null, "100%"));
        content.add(getAlreadyAMember());
    }

    public AcceptTermsOfUseContainer getAcceptTermsBox() {
        if (acceptTermsBox == null) {
            acceptTermsBox = new AcceptTermsOfUseContainer(Language.get(LSignUp.USING_CONDITIONS_1), true);
            StyleIt.add(acceptTermsBox.getGui(), P.NO_WRAP);
        }
        return acceptTermsBox;
    }

    public HorizontalComponent getTermsOfUseAndButton() {
        if (termsOfUse == null) {
            termsOfUse = new HorizontalComponent();

            HorizontalComponent hcLeft = new HorizontalComponent();
            TextLayout l = new TextLayout(0,3,0,0, null, Vertical.MIDDLE).sizeSmall();
            hcLeft.add(getAcceptTermsBox().getGui(), l);

            HyperlinkLabelComponent ref = new HyperlinkLabelComponent(Language.get(LSignUp.USING_CONDITIONS_2));
            ref.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    Window.open(Language.get(LSignUp.USING_CONDITIONS_LINK), "_blank", null);
                }
            });
            hcLeft.add(ref, l.underline().colorBlueLink());
            termsOfUse.add(hcLeft, new Layout17(0,0,5,0, Horizontal.LEFT, Vertical.BOTTOM));

            HorizontalComponent hcRight = new HorizontalComponent();
            ColorButton sButton = getSaveButton();
            hcRight.add(sButton, new Layout17(0, 20, 0, 0, sButton.getHeight(), sButton.getWidth(), Horizontal.RIGHT, Vertical.MIDDLE));
            termsOfUse.add(hcRight, new Layout17(Horizontal.RIGHT, Vertical.MIDDLE));
        }
        return termsOfUse;
    }

    public SimplePanelComponent getProblemHolder() {
        if (problemHolder == null) {
            problemHolder = new SimplePanelComponent();
        }
        return problemHolder;
    }

    private ColorButton getSaveButton() {
        ColorButton b = ColorButtonFactory.getBlue90x60(Language.get(LSignUp.CREATE_BUTTON));
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getController().save();
            }
        });
        return b;
    }

    public Hyperlink getAlreadyAMember() {
        if (alreadyAMember == null) {
            alreadyAMember = new Hyperlink(Language.get(LSignUp.ALREADY_HAVE_ACCOUNT), false, SignInPageController.HISTORY_NAME);
            StyleIt.add(alreadyAMember, new TextLayout().sizeH3().bold());
            alreadyAMember.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    InfoManager.hideInfo();
                    ApplicationController.getInstance().loadPage(SignInPageController.getInstance());
                }
            });
        }
        return alreadyAMember;
    }


    public SignUpPanel getSignupPanel() {
        if (signupPanel == null) {
            signupPanel = new SignUpPanel();
        }
        return signupPanel;
    }

    public VerticalComponent getSignUpWrapper() {
        if (signUpWrapper == null) {
            signUpWrapper = new VerticalComponent();
            signUpWrapper.add(getSignupPanel(), new Layout17(1, 1, 1, 1, null, "520px").add(P.BACKGROUND_E1));
        }
        return signUpWrapper;
    }

    public void removeErrors() {
        if (valComponent != null) {
            valComponent.removeFromParent();
            for (DataContainer dc : getSignupPanel().getTable().getDataContainerChildren()) {
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
}
