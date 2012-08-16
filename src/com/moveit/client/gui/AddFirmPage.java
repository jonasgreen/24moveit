package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.moveit.client.guicomponents.*;
import com.moveit.client.html.HtmlContent;
import com.moveit.client.language.Language;
import com.moveit.client.language.LAddFirmPage;
import com.moveit.client.validator.*;


/**
 *
 */
public class AddFirmPage extends Page<AddFirmController> {


    public StringContainer FIRM_NAME = new StringContainer(LAddFirmPage.FIRM_NAME.text(), true);
    public StringContainer CVR = new StringContainer(LAddFirmPage.VAT.text(), true);
    public StringContainer WEBSITE = new StringContainer(LAddFirmPage.WEB_SITE.text(), false);

    public StringContainer NAME = new StringContainer(LAddFirmPage.NAME.text(), true);
    public StringContainer PHONE = new StringContainer(LAddFirmPage.PHONE.text(), true);
    public StringContainer EMAIL = new StringContainer(LAddFirmPage.EMAIL.text(), true);
    public PasswordContainer PASSWORD = new PasswordContainer(LAddFirmPage.PASS.text(), true);
    public PasswordContainer REPEAT_PASSWORD = new PasswordContainer(LAddFirmPage.REPEAT_PASS.text(), true);
    public CheckBoxContainer DMF_MEMBER = new CheckBoxContainer("Medlem af Dansk Møbeltransport Forening", false);

    public CheckBoxComponent newsMail;
    public CheckBoxComponent routeMail;

    private AcceptTermsOfUseContainer acceptTermsBox;
    private HorizontalComponent termsOfUse;
    private HtmlComponent info;


    private HorizontalComponent content;
    private AddressPanel addr;
    private FlexTableComponent table;
    private FlexTableComponent personTable;

    public AddFirmPage() {
        super();
        content = new HorizontalComponent();
        initWidget(content);
    }


    public void init() {
        //setting up validation rules - besides mandatory rules.
        CVR.add(new CvrValidator());
        getAcceptTermsBox().add(new AcceptTermsOfUserValidator());

        PASSWORD.add(new StringMinValidator(6));
        REPEAT_PASSWORD.add(new PassNotTheSameValidator(PASSWORD));


        VerticalComponent vc = new VerticalComponent();


        Layout17 ll = new TextLayout(30, 0, 6, 0).sizeH2().bold();
        ll.add(Name.BORDER_COLOR, P.BACKGROUND_D1.getValue());


        Layout17 lAdr = new Layout17(0, 0, 0, 0, null, "512px");
        lAdr.add(P.BACKGROUND_C1);


        vc.add(getInfo(), new TextLayout(30, 0, 0, 0, null, "512px").sizeSmall().border(1).borderColor(P.BACKGROUND_BLUE));
        getInfo().setBackgroundColor(P.BACKGROUND_BLUE_TIPS);

        vc.add(new LabelComponent(LAddFirmPage.TITLE_1_BASIS.text()), ll);
        vc.add(buildRounded(getFirmData()), lAdr);

        vc.add(new LabelComponent(LAddFirmPage.TITLE_2_ADDRESS.text()), ll);
        vc.add(buildRounded(getAddr()), lAdr);

        vc.add(new LabelComponent(LAddFirmPage.TITLE_3_PERSON.text()), ll);
        vc.add(buildRounded(getPerson()), lAdr);

        vc.add(getNewsMail());
        vc.add(getRouteMail());

        vc.add(getTermsOfUseAndButton(), new Layout17(20, 0, 20, 0, null, "100%"));

        HorizontalPanel hp = new HorizontalPanel();
        HorizontalComponent content2 = WidgetUtil.createHPanel(vc, hp);
        hp.setWidth("175px");

        content.add(content2, new Layout17(0, 0, 0, 0));
        content2.setWidth(ApplicationController.APP_WIDTH);
    }


    public HtmlComponent getInfo() {
        if (info == null) {
            HtmlContent hc = new HtmlContent();
            hc.addSection("tipsText", LAddFirmPage.TIPS_START.text());
            hc.addSection("tipsText", LAddFirmPage.TIPS_1.text());
            hc.addSection("tipsText", LAddFirmPage.TIPS_2.text());
            hc.addSection("tipsText", LAddFirmPage.TIPS_3.text());
            info = new HtmlComponent(hc.getHtml());

        }
        return info;
    }


    public CheckBoxComponent getNewsMail() {
        if (newsMail == null) {
            newsMail = new CheckBoxComponent(LAddFirmPage.I_WISH_NEWS.text());
            newsMail.getCheckBox().setValue(true);
        }
        return newsMail;
    }


    public CheckBoxComponent getRouteMail() {
        if (routeMail == null) {
            routeMail = new CheckBoxComponent(LAddFirmPage.I_WISH_OFFERS.text());
            routeMail.getCheckBox().setValue(true);
        }
        return routeMail;
    }


    public HorizontalComponent getTermsOfUseAndButton() {
        if (termsOfUse == null) {
            termsOfUse = new HorizontalComponent();

            HorizontalComponent hcLeft = new HorizontalComponent();
            TextLayout l = new TextLayout(0, 3, 0, 0, null, Vertical.MIDDLE).sizeSmall();
            hcLeft.add(getAcceptTermsBox().getGui(), l);

            HyperlinkLabelComponent ref = new HyperlinkLabelComponent(LAddFirmPage.USING_CONDITIONS_2.text());
            ref.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    Window.open(LAddFirmPage.USING_CONDITIONS_LINK.text(), "_blank", null);
                }
            });
            hcLeft.add(ref, l.underline().colorBlueLink());
            termsOfUse.add(hcLeft, new Layout17(0, 0, 5, 0, Horizontal.LEFT, Vertical.BOTTOM));

            HorizontalComponent hcRight = new HorizontalComponent();
            ColorButton sButton = getSaveButton();
            hcRight.add(sButton, new Layout17(0, 20, 0, 0, sButton.getHeight(), sButton.getWidth(), Horizontal.RIGHT, Vertical.MIDDLE));
            termsOfUse.add(hcRight, new Layout17(Horizontal.RIGHT, Vertical.MIDDLE));
        }
        return termsOfUse;
    }


    public AcceptTermsOfUseContainer getAcceptTermsBox() {
        if (acceptTermsBox == null) {
            acceptTermsBox = new AcceptTermsOfUseContainer(LAddFirmPage.USING_CONDITIONS_1.text(), true);
            StyleIt.add(acceptTermsBox.getGui(), P.NO_WRAP);
        }
        return acceptTermsBox;
    }


    private ColorButton getSaveButton() {
        ColorButton b = ColorButtonFactory.getBlue90x60(LAddFirmPage.SAVE_BUTTON.text());
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getController().save();
            }
        });
        return b;
    }

    public FlexTableComponent getFirmData() {
        if (table == null) {
            table = new FlexTableComponent();


            TextLayout ll = new TextLayout(Horizontal.RIGHT).sizeSmall().bold();

            Layout17 tbl = new TextLayout(0, 0, 0, 10, "32px", "300px", Vertical.MIDDLE).sizeInput().add(P.VERTICAL_ALIGN_MIDDLE);

            int row = 0;

            //firm specific - start


            table.setLabel(row, 0, FIRM_NAME, ll);
            table.setWidget(row++, 1, FIRM_NAME, tbl);

            if (Language.isDanish()) {
                table.setLabel(row, 0, CVR, ll);
                table.setWidget(row++, 1, CVR, tbl);
            }

            table.setLabel(row, 0, WEBSITE, ll);
            table.setWidget(row++, 1, WEBSITE, tbl);


            if (Language.isDanish()) {
                table.setWidget(row, 0, DMF_MEMBER, ll);
                table.getFlexCellFormatter().setColSpan(row, 0, 2);
            }

            table.getPanel().setCellSpacing(4);


        }
        return table;
    }


    public AddressPanel getAddr() {
        if (addr == null) {
            addr = new AddressPanel();
        }
        return addr;
    }

    private SimplePanelComponent buildRounded(GuiComponent content) {
        SimplePanelComponent spGrey = new SimplePanelComponent();

        HorizontalComponent hc = new HorizontalComponent();
        hc.add(content);
        SimplePanelComponent sp = new SimplePanelComponent();
        sp.add(new LabelComponent(""));
        hc.add(sp, new Layout17(0, 0, 0, 0, null, "100%").add(P.BACKGROUND_WHITE));
        RoundedComponent rp = new RoundedComponent(2);
        rp.add(hc, new Layout17(0, 0, 0, 0, null, "500px"));
        rp.setColor(P.BACKGROUND_WHITE);

        //rp.setWidth(dialogSize);

        //content.setBackgroundColor(P.BACKGROUND_WHITE);
        StyleIt.add(rp, Name.PADDING, "6px");

        spGrey.add(rp);
        return spGrey;
    }

    public HorizontalComponent getContent() {
        return content;
    }

    public FlexTableComponent getPerson() {
        if (personTable == null) {
            personTable = new FlexTableComponent();


            Layout17 ll = new TextLayout(Horizontal.RIGHT).sizeSmall().bold();

            Layout17 tbl = new TextLayout(0, 0, 0, 10, "32px", "300px", Vertical.MIDDLE).sizeInput().add(P.VERTICAL_ALIGN_MIDDLE);

            int row = 0;

            SimplePanelComponent widget1 = new SimplePanelComponent();
            widget1.add(new LabelComponent(""));


            personTable.setLabel(row, 0, NAME, ll);
            personTable.setWidget(row++, 1, NAME, tbl);


            personTable.setLabel(row, 0, PHONE, ll);
            personTable.setWidget(row++, 1, PHONE, tbl);

            personTable.setLabel(row, 0, EMAIL, ll);
            personTable.setWidget(row++, 1, EMAIL, tbl);

            personTable.setLabel(row, 0, PASSWORD, ll);
            personTable.setWidget(row++, 1, PASSWORD, tbl);

            personTable.setLabel(row, 0, REPEAT_PASSWORD, ll);
            personTable.setWidget(row, 1, REPEAT_PASSWORD, tbl);


            //personTable.setWidget(4, 2, REMEMBER_ME, new TextLayout(Horizontal.RIGHT).sizeSmall().paddingRight(10));
            personTable.getPanel().setCellSpacing(4);

        }
        return personTable;
    }
}