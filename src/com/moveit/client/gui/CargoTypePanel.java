package com.moveit.client.gui;

import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LSearchPage;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class CargoTypePanel extends VerticalComponent {

    private List<CargoTypeRow> rows = new ArrayList<CargoTypeRow>();
    private HyperlinkLabelComponent selectAll;
    private HyperlinkLabelComponent selectNone;
    private boolean inProgress = false;

    public CargoTypePanel() {
        super();
        init();
    }

    private void init() {
        CenterComponent cc = new CenterComponent();
        HorizontalComponent hc = new HorizontalComponent();
        hc.add(getSelectAll(), new TextLayout(3, 0, 3, 0).sizeEkstraSmall().colorBlue());
        hc.add(new LabelComponent("|"), new TextLayout(3, 3, 3, 3).sizeEkstraSmall());
        hc.add(getSelectNone(), new TextLayout(3, 0, 3, 0).sizeEkstraSmall().colorBlue());
        hc.setBackgroundColor(P.BACKGROUND_BACK_PANEL);
        cc.add(hc, new Layout17(Horizontal.CENTER, Vertical.MIDDLE));

        add(cc, new Layout17(null, "100%"));
        cc.setBackgroundColor(P.BACKGROUND_BACK_PANEL);
        ColorWheel cw = new ColorWheel(P.BACKGROUND_CARGO_TWO, P.BACKGROUND_CARGO_ONE);
        int i = 0;
        while (i < CargoTypeConstant.getList().getKeys().size()) {
            CargoTypeRow r = new CargoTypeRow(this, cw.getNext(), CargoTypeConstant.itemMap.get(CargoTypeConstant.getList().getValue(i)));
            rows.add(r);
            add(r, new Layout17(null, "100%"));
            i++;
        }
    }

    public HyperlinkLabelComponent getSelectAll() {
        if (selectAll == null) {
            selectAll = new HyperlinkLabelComponent(LSearchPage.SELECT_ALL.text());
            selectAll.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    selectAllCargoTypes(true);
                }
            });
            StyleIt.add(selectAll, Name.COLOR, P.BACKGROUND_CARGO_TWO.getValue());
        }
        return selectAll;
    }

    public HyperlinkLabelComponent getSelectNone() {
        if (selectNone == null) {
            selectNone = new HyperlinkLabelComponent(LSearchPage.SELECT_NONE.text());
            selectNone.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    selectAllCargoTypes(false);
                }
            });
            StyleIt.add(selectNone, Name.COLOR, P.BACKGROUND_CARGO_TWO.getValue());
        }
        return selectNone;
    }

    private void selectAllCargoTypes(boolean select) {
        inProgress = true;
        for (CargoTypeRow r : rows) {
            r.getCheckBox().getCheckBox().setValue(select);
        }
        inProgress = false;
        updateMap();
    }


    public void updateMap() {
        if (inProgress) {
            return;
        }
        List<CargoTypeConstant> selected = new ArrayList<CargoTypeConstant>();
        for (CargoTypeRow r : rows) {
            if (r.getCheckBox().getCheckBox().getValue()) {
                selected.add(r.getCargoTypeConstant());
            }
        }

        SearchPageController.getInstance().cargoTypesChanged(selected);
    }


}
