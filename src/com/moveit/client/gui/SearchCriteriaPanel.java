package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LSearchCriteriaPanel;

import java.util.HashMap;


/**
 *
 */
public class SearchCriteriaPanel extends VerticalComponent {

    private ColorButton searchButton;
    private TextBoxComponent searchBox;
    private ListBoxComponent radiusListBox = null;
    private CheckBoxComponent routeFrom;
    private CheckBoxComponent routeTo;
    private String stringFrom = LSearchCriteriaPanel.FROM.text();
    private String stringTo = LSearchCriteriaPanel.TO.text();

    public DateContainer FROM_DATE = new DateContainer(LSearchCriteriaPanel.FROM_DATE.text(), false);
    public DateContainer TO_DATE = new DateContainer(LSearchCriteriaPanel.TO_DATE.text(), false);
    private HyperlinkComponentOld advAjustment;
    private VerticalComponent ajustments;
    private boolean hasBeenAjustet = false;
    private HyperlinkComponentOld helpLink;

    private class StringKm {
        private String key;
        private Integer km;

        private StringKm(String key, Integer km) {
            this.key = key;
            this.km = km;
        }

        public String getKey() {
            return key;
        }

        public Integer getKm() {
            return km;
        }
    }

    private StringKm[] kms = new StringKm[]{
            new StringKm(LSearchCriteriaPanel.RADIUS_0.text(), 0),
            new StringKm("10 km", 10),
            new StringKm("25 km", 25),
            new StringKm("50 km", 50),
            new StringKm("100 km", 100),
            new StringKm("150 km", 150),
            new StringKm("200 km", 200),
            new StringKm("300 km", 300),
            new StringKm("500 km", 500),
            new StringKm("1000 km", 1000),
            new StringKm("2000 km", 2000),
            new StringKm("5000 km", 5000)

    };

    private java.util.Map<String, StringKm> kmsMap = new HashMap<String, StringKm>();

    public SearchCriteriaPanel() {
        super();
        for (StringKm km : kms) {
            kmsMap.put(km.getKey(), km);
        }

        init();
    }

    private void init() {


        HorizontalComponent hp = new HorizontalComponent();

        Layout17 l = new TextLayout(0, 0, 0, 6, "36px", "260px", Horizontal.LEFT, Vertical.MIDDLE).sizeSearchInput().padding(7, 0, 0, 4).add(P.VERTICAL_ALIGN_MIDDLE).add(P.COLOR_ORANGE);
        hp.add(getSearchBox(), l);

        ColorButton sButton = getSearchButton();
        hp.add(sButton, new Layout17(sButton.getHeight(), sButton.getWidth(), Horizontal.RIGHT, Vertical.MIDDLE));

        VerticalComponent vc = new VerticalComponent();
        vc.add(hp);
        hp.setWidth("100%");

        vc.add(getAjustments(), new Layout17(0, 0, 0, 6));
        add(vc);

        HorizontalComponent bottom = new HorizontalComponent();
        Layout17 lh = new TextLayout(0, 0, 3, 6).sizeEkstraSmall();
        bottom.add(getAdvAjustmentLink(), lh);
        bottom.add(getHelpLink(), new TextLayout(0, 10, 3, 0, Horizontal.RIGHT).sizeEkstraSmall());
        add(bottom, new Layout17(2, 0, 0, 0, null, "100%"));
        bottom.setCellHorizontalAlignment(getHelpLink(), HasHorizontalAlignment.ALIGN_RIGHT);
        //add(vc);
        setCellVerticalAlignment(vc, HasVerticalAlignment.ALIGN_TOP);
        setCellVerticalAlignment(bottom, HasVerticalAlignment.ALIGN_BOTTOM);

        getAjustments().setVisible(false);

    }

    public VerticalComponent getAjustments() {
        if (ajustments == null) {
            ajustments = new VerticalComponent();


            HorizontalComponent hc = new HorizontalComponent();
            hc.add(getRadisListBox(), new TextLayout(3, 5, 0, 0,"12px", null, Vertical.MIDDLE).sizeEkstraSmall());
            hc.add(getRouteFrom(), new TextLayout(0,2,0,0,Vertical.MIDDLE));
            hc.add(getRouteTo(), new TextLayout(Vertical.MIDDLE));

            ajustments.add(hc);

            ajustments.add(new LabelComponent(LSearchCriteriaPanel.IN_THE_PERIOD.text()), new TextLayout(4,0,0,0).sizeEkstraSmall());

            HorizontalComponent hcTime = new HorizontalComponent();
            hcTime.add(TO_DATE, new TextLayout("10px", null).sizeEkstraSmall());
            hcTime.add(new LabelComponent(" - "), new TextLayout(0,4,0,2, Vertical.MIDDLE));
            hcTime.add(FROM_DATE, new TextLayout("10px", null).sizeEkstraSmall());
            ajustments.add(hcTime, new TextLayout(0,0,8,0));

        }
        return ajustments;
    }

    private HyperlinkComponentOld getAdvAjustmentLink() {
        if (advAjustment == null) {
            advAjustment = new HyperlinkComponentOld(LSearchCriteriaPanel.SHOW_ADJUSTMENTS.text(), false, SearchPageController.HISTORY_NAME);
            advAjustment.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    adjustSearch();
                }
            });
        }
        return advAjustment;
    }

    public HyperlinkComponentOld getHelpLink() {
        if (helpLink == null) {
            helpLink = new HyperlinkComponentOld(LSearchCriteriaPanel.SEARCH_HELP.text(), false, SearchPageController.HISTORY_NAME);
            helpLink.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    MapPopupManager.flipHelp();
                }
            });
        }
        return helpLink;
    }


    public void adjustSearch() {
        hasBeenAjustet = !hasBeenAjustet;
        getAjustments().setVisible(hasBeenAjustet);
        getAdvAjustmentLink().getHyperlink().setText(hasBeenAjustet ? LSearchCriteriaPanel.HIDE_ADJUSTMENTS.text() : LSearchCriteriaPanel.SHOW_ADJUSTMENTS.text());
    }

    public ListBoxComponent getRadisListBox() {
        if (radiusListBox == null) {
            radiusListBox = new ListBoxComponent();
            for (StringKm km : kms) {
                radiusListBox.addItem(km.getKey());
            }
            radiusListBox.setVisibleItemCount(1);
            radiusListBox.setSelectedIndex(0);

            StyleIt.add(radiusListBox, new TextLayout(0, 0, 10, 0).sizeSmall());
        }
        return radiusListBox;
    }

    public ColorButton getSearchButton() {
        if (searchButton == null) {
            searchButton = ColorButtonFactory.getOrange90x60(LSearchCriteriaPanel.SEARCH_BUTTON.text());
        }
        return searchButton;

    }

    public TextBoxComponent getSearchBox() {
        if (searchBox == null) {
            searchBox = new TextBoxComponent();
            //searchBox.setText(startCity);
            searchBox.getTextBox().addFocusHandler(new FocusHandler() {
                public void onFocus(FocusEvent event) {
                    MapPopupManager.hideHelpPopup();
                }
            });
            

        }
        return searchBox;
    }


    public Integer getRadius() {
        String key = getRadisListBox().getItemText(getRadisListBox().getSelectedIndex());
        return kmsMap.get(key).getKm();
    }

    public CheckBoxComponent getRouteFrom() {
        if (routeFrom == null) {
            routeFrom = new CheckBoxComponent(stringFrom);
            routeFrom.getCheckBox().setEnabled(true);
            routeFrom.getCheckBox().setValue(true);
            StyleIt.add(routeFrom, new TextLayout(12, 0, 0, 4).sizeEkstraSmall().alignCenter());
        }
        return routeFrom;
    }


    public CheckBoxComponent getRouteTo() {
        if (routeTo == null) {
            routeTo = new CheckBoxComponent(stringTo);
            routeTo.getCheckBox().setEnabled(true);
            routeTo.getCheckBox().setValue(true);

            StyleIt.add(routeTo, new TextLayout(12, 0, 0, 4).sizeEkstraSmall().alignCenter());
        }
        return routeTo;
    }

    public boolean isAdvancedSearchShowing() {
        return hasBeenAjustet;
    }
}
