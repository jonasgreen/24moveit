package com.moveit.client.gui;

import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LWhatToMove;

/**
 *
 */
public class WhatToMovePanel extends VerticalComponent {
    TipsManagerAddPage tipsManager = TipsManagerAddPage.getInstance();

    public ListContainer<Integer> CARGO_TYPE = new ListContainer<Integer>(LWhatToMove.CATEGORI.text(), CargoTypeConstant.getList(), 0, false, true);
    public TextAreaContainer CARGO_DESCRIPTION = new TextAreaContainer(LWhatToMove.DESCRIPTION.text(), true);


    public WhatToMovePanel() {
        super();
        init();
    }

    private void init() {
        tipsManager.add(CARGO_TYPE, LWhatToMove.TIP_CATEGORI.text());
        tipsManager.add(CARGO_DESCRIPTION, LWhatToMove.TIP_DESCRIPTION.text());
        Layout17 lLabel = new TextLayout(2, 0, 2, 0).sizeSmall().bold();
        Layout17 tlb = new TextLayout(0, 0, 0, 10).sizeSmall();

        FlexTableComponent table = new FlexTableComponent();
        table.setLabel(0,0, CARGO_TYPE, lLabel);
        table.setWidget(0, 1, CARGO_TYPE, tlb);

        add(table);

        lLabel.setLeftMargin(3);
        addLabel(CARGO_DESCRIPTION, lLabel);
        add(CARGO_DESCRIPTION, new Layout17(2, 0, 0, 3, "140px", "490px"));

    }
}