package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.moveit.client.constants.ContactWishConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LAdd;
import com.moveit.client.language.Language;


/**
 *
 */
public class AddPage extends Page<AddPageController> {

    

    private HorizontalComponent content;
    private AddressPanel fromAddr;
    private AddressPanel toAddr;
    private WhenToMovePanel whenToMove;
    private WhatToMovePanel whatToMovePanel;
    private ByWhoPanel byWho;
    public ListContainer<Integer> contactWishes = new ListContainer<Integer>(Language.get(LAdd.I_WISH_OFFERS), ContactWishConstant.getList(), 0, false, true);
    private LabelComponent remeberToSave1;
    private LabelComponent remeberToSave;

    public AddPage() {
        super();
        content = new HorizontalComponent();
        initWidget(content);
    }


    public void init() {
        VerticalComponent vc = new VerticalComponent();

        Layout17 ll = new TextLayout(30, 0, 6, 0).sizeH2().bold();

        Layout17 lAdr = new Layout17(0, 0, 0, 0, null, "512px");
        lAdr.add(P.BACKGROUND_C1);

        vc.add(getRemeberToSave1(), new TextLayout(10, 0, 0, 10).colorRed().bold().sizeH3());


        //who to recieve offers from is only visible in danish
        if (Language.language == Language.DANISH) {
            vc.add(new LabelComponent(Language.get(LAdd.TITLE_1_WHO)), ll);
            vc.add(buildRounded(getByWho()), lAdr);
        }

        vc.add(new LabelComponent(Language.get(LAdd.TITLE_2_FROM)), ll);
        vc.add(buildRounded(getFromAddr()), lAdr);

        vc.add(new LabelComponent(Language.get(LAdd.TITLE_3_TO)), ll);
        vc.add(buildRounded(getToAddr()), lAdr);

        vc.add(new LabelComponent(Language.get(LAdd.TITLE_4_WHO)), ll);
        vc.add(buildRounded(getWhenToMovePanel()), lAdr);

        vc.add(new LabelComponent(Language.get(LAdd.TITLE_5_WHO)), ll);
        vc.add(buildRounded(getWhatToMovePanel()), lAdr);
        //vc.setMargin(0, 0, 0, 30);

        HorizontalComponent hc = new HorizontalComponent();
        hc.addLabel(contactWishes, new TextLayout(10, 10, 0, 0).sizeSmall().bold());
        hc.add(contactWishes, new TextLayout(10, 0, 0, 0).sizeSmall());
        vc.add(hc, new TextLayout());

        vc.add(getRemeberToSave(), new TextLayout(10, 0, 0, 0).colorRed().bold().sizeH3());

        ColorButton sb = getSaveButton();
        vc.add(sb, new Layout17(20, 20, 20, 0, sb.getHeight(), sb.getWidth(), Horizontal.RIGHT, null));

        HorizontalPanel hp = new HorizontalPanel();
        HorizontalComponent content2 = WidgetUtil.createHPanel(vc, hp);
        hp.setWidth("175px");

        content.add(content2, new Layout17(0, 0, 0, 0));
        content2.setWidth(ApplicationController.APP_WIDTH);
        showRememberToSave(false);

        //content.setCellHorizontalAlignment(content2, HasHorizontalAlignment.ALIGN_CENTER);
    }

    public LabelComponent getRemeberToSave1() {
        if (remeberToSave1 == null) {
            remeberToSave1 = new LabelComponent(LAdd.REMEMBER_TO_SAVE.text());
        }
        return remeberToSave1;
    }


    public LabelComponent getRemeberToSave() {
        if (remeberToSave == null) {
            remeberToSave = new LabelComponent(LAdd.REMEMBER_TO_SAVE.text());
        }
        return remeberToSave;
    }


    public void showRememberToSave(boolean visible) {
        getRemeberToSave().setVisible(visible);
        getRemeberToSave1().setVisible(visible);
    }





    public ColorButton getSaveButton() {
        ColorButton b = ColorButtonFactory.getBlue90x60(Language.get(LAdd.SAVE_BUTTON));
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getController().save();
            }
        });
        return b;
    }

    public ByWhoPanel getByWho() {
        if (byWho == null) {
            byWho = new ByWhoPanel();
        }
        return byWho;
    }


    public WhenToMovePanel getWhenToMovePanel() {
        if (whenToMove == null) {
            whenToMove = new WhenToMovePanel();
        }
        return whenToMove;
    }

    public WhatToMovePanel getWhatToMovePanel() {
        if (whatToMovePanel == null) {
            whatToMovePanel = new WhatToMovePanel();
        }
        return whatToMovePanel;
    }


    public AddressPanel getFromAddr() {
        if (fromAddr == null) {
            fromAddr = new AddressPanel();
        }
        return fromAddr;
    }

    public AddressPanel getToAddr() {
        if (toAddr == null) {
            toAddr = new AddressPanel();
        }
        return toAddr;
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
}
