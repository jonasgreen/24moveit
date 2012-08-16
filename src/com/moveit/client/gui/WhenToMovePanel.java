package com.moveit.client.gui;

import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LWhenToMove;
import com.moveit.client.validator.DateLargerOrEqualsOtherDateValidator;
import com.moveit.client.validator.DateLargerOrEqualsTodayValidator;

import java.util.Date;

/**
 *
 */
public class WhenToMovePanel extends FlexTableComponent {
    TipsManagerAddPage tipsManager = TipsManagerAddPage.getInstance();
    public DateContainer FROMDATE = new DateContainer(Language.get(LWhenToMove.FROM), true);
    public DateContainer TODATE = new DateContainer(Language.get(LWhenToMove.TO), true);

    private static long DAYS_14 = 1000*60*60*24*14;
    public WhenToMovePanel() {
        super();
        init();
    }

    private void init() {
        tipsManager.add(FROMDATE, Language.get(LWhenToMove.TIP));
        tipsManager.add(TODATE, Language.get(LWhenToMove.TIP));

        //validation
        FROMDATE.add(new DateLargerOrEqualsTodayValidator());
        TODATE.add(new DateLargerOrEqualsOtherDateValidator(FROMDATE));

        FROMDATE.setValue(new Date());
        TODATE.setValue(new Date(new Date().getTime() + DAYS_14));


        TextLayout lDate = new TextLayout(2, 0, 2, 0, Horizontal.LEFT);
        Layout17 lLabel = new TextLayout(0, 10, 0, 0).sizeSmall().bold();
        setLabel(0, 0, FROMDATE, lLabel);
        setWidget(0, 1, FROMDATE, lDate);
        setLabel(1, 0, TODATE, lLabel);
        setWidget(1, 1, TODATE, lDate);
    }
}