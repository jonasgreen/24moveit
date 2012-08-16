package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LRouteOptimizePanel;

import java.util.HashMap;
import java.util.Map;


/**
 *
 */
public class RouteOptimizingPanel extends VerticalComponent {

    private ColorButton searchButton;
    private TextBoxComponent searchBoxFrom;
    private TextBoxComponent searchBoxTo;
    private ListBoxComponent maxEmptyDistance = null;
    private ListBoxComponent maxJobs = null;

    private VerticalComponent content;
    private HyperlinkLabelComponent title;

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
            new StringKm(LRouteOptimizePanel.KM_1.text(), 1),
            new StringKm(LRouteOptimizePanel.KM_2.text(), 2),
            new StringKm(LRouteOptimizePanel.KM_5.text(), 5),
            new StringKm(LRouteOptimizePanel.KM_10.text(), 10),
            new StringKm(LRouteOptimizePanel.KM_20.text(), 20),
            new StringKm(LRouteOptimizePanel.KM_30.text(), 30),
            new StringKm(LRouteOptimizePanel.KM_50.text(), 50),
            new StringKm(LRouteOptimizePanel.KM_75.text(), 75),
            new StringKm(LRouteOptimizePanel.KM_100.text(), 100),
            new StringKm(LRouteOptimizePanel.KM_150.text(), 150),
            new StringKm(LRouteOptimizePanel.KM_200.text(), 200),
            new StringKm(LRouteOptimizePanel.KM_300.text(), 300)
    };


    private StringKm[] jobs = new StringKm[]{
            new StringKm(LRouteOptimizePanel.JOB_1.text(), 1),
            new StringKm(LRouteOptimizePanel.JOB_2.text(), 2),
            new StringKm(LRouteOptimizePanel.JOB_3.text(), 3),
            new StringKm(LRouteOptimizePanel.JOB_4.text(), 4)
    };


    private Map<String, StringKm> kmsMap = new HashMap<String, StringKm>();
    private Map<String, StringKm> jobsMap = new HashMap<String, StringKm>();

    public RouteOptimizingPanel() {
        super();
        for (StringKm km : kms) {
            kmsMap.put(km.getKey(), km);
        }
        for (StringKm job : jobs) {
            jobsMap.put(job.getKey(), job);
        }

        init();
    }

    private void init() {
        add(getHeaderTitle(), new TextLayout(4,6,4,6).sizeEkstraSmall().underline().colorBlueLink());
        add(getContent());
        getContent().setVisible(false);
    }



    public VerticalComponent getContent() {
        if (content == null) {
            content = new VerticalComponent();
            HorizontalComponent hp = new HorizontalComponent();

            TextLayout l = new TextLayout();
            hp.add(fromTo(LRouteOptimizePanel.FROM.text(), getSearchBoxFrom()), l);
            hp.add(new LabelComponent(" - "), new TextLayout(null, Vertical.MIDDLE).paddingTop(10));
            hp.add(fromTo(LRouteOptimizePanel.TO.text(), getSearchBoxTo()), l);

            content.add(hp);


            HorizontalComponent hp2 = new HorizontalComponent();
            VerticalComponent vLeft = new VerticalComponent();

            vLeft.add(new LabelComponent(LRouteOptimizePanel.MAX_JOBS.text()), new TextLayout(4, 6, 0, 6).sizeEkstraSmall());
            vLeft.add(getJobList(), new TextLayout(2, 6, 2, 6, "12px", null).sizeEkstraSmall());

            vLeft.add(new LabelComponent(LRouteOptimizePanel.MAX_KM_BETWEEN_JOBS.text()), new TextLayout(4, 6, 0, 6).sizeEkstraSmall());
            vLeft.add(getRadisListBox(), new TextLayout(2, 6, 6, 6, "12px", null).sizeEkstraSmall());

            hp2.add(vLeft);
            ColorButton sButton = getSearchButton();
            hp2.add(sButton, new Layout17(0, 0, 0, 0, sButton.getHeight(), sButton.getWidth()));
            content.add(hp2, new TextLayout(null, "100%"));

            hp2.setCellHorizontalAlignment(sButton, HasHorizontalAlignment.ALIGN_RIGHT);
            hp2.setCellVerticalAlignment(sButton, HasVerticalAlignment.ALIGN_BOTTOM);

        }
        return content;
    }

    public VerticalComponent fromTo(String label, TextBoxComponent tbc) {
        VerticalComponent vc = new VerticalComponent();
        vc.add(new LabelComponent(label), new TextLayout(6, 6, 2, 6).sizeEkstraSmall());
        vc.add(tbc, new TextLayout(0, 6, 6, 6, "25px", "163px", Horizontal.LEFT, Vertical.MIDDLE).sizeNormal().colorBlueLink().padding(0, 0, 0, 0).add(P.VERTICAL_ALIGN_MIDDLE));
        return vc;
    }


     public HyperlinkLabelComponent getHeaderTitle() {
        if (title == null) {
            title = new HyperlinkLabelComponent(LRouteOptimizePanel.FIND_JOBS_TITLE_SHOW.text());
            title.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    Widget content = getContent();
                    getContent().setVisible(!content.isVisible());

                    title.setText(content.isVisible() ? LRouteOptimizePanel.FIND_JOBS_TITLE_HIDE.text() : LRouteOptimizePanel.FIND_JOBS_TITLE_SHOW.text());
                    getSearchBoxFrom().setText(SearchPageController.getInstance().getSearchCriteriaPanel().getSearchBox().getText());
                }
            });
        }
        return title;
    }

    public ListBoxComponent getRadisListBox() {
        if (maxEmptyDistance == null) {
            maxEmptyDistance = new ListBoxComponent();
            for (StringKm km : kms) {
                maxEmptyDistance.addItem(km.getKey());
            }
            maxEmptyDistance.setVisibleItemCount(1);
            maxEmptyDistance.setSelectedIndex(5);

            StyleIt.add(maxEmptyDistance, new TextLayout(0, 0, 10, 0).sizeSmall());
        }
        return maxEmptyDistance;
    }

    public ColorButton getSearchButton() {
        if (searchButton == null) {
            searchButton = ColorButtonFactory.getBlue90x60(LRouteOptimizePanel.SEARCH_BUTTON.text());
        }
        return searchButton;

    }

    public TextBoxComponent getSearchBoxFrom() {
        if (searchBoxFrom == null) {
            searchBoxFrom = new TextBoxComponent();
            searchBoxFrom.getTextBox().addFocusHandler(new FocusHandler() {
                public void onFocus(FocusEvent event) {
                    MapPopupManager.hideHelpPopup();
                }
            });

        }
        return searchBoxFrom;
    }

    public ListBoxComponent getJobList() {
        if (maxJobs == null) {
            maxJobs = new ListBoxComponent();
            for (StringKm km : jobs) {
                maxJobs.addItem(km.getKey());
            }
            maxJobs.setVisibleItemCount(1);
            maxJobs.setSelectedIndex(1);

            StyleIt.add(maxJobs, new TextLayout(0, 0, 10, 0).sizeSmall());
        }
        return maxJobs;
    }


    public TextBoxComponent getSearchBoxTo() {
        if (searchBoxTo == null) {
            searchBoxTo = new TextBoxComponent();
            searchBoxTo.getTextBox().addFocusHandler(new FocusHandler() {
                public void onFocus(FocusEvent event) {
                    MapPopupManager.hideHelpPopup();
                }
            });

        }
        return searchBoxTo;
    }


    public Integer getMaxRadius() {
        String key = getRadisListBox().getItemText(getRadisListBox().getSelectedIndex());
        return kmsMap.get(key).getKm();
    }

    public Integer getMaxJobs() {
        String key = getJobList().getItemText(getJobList().getSelectedIndex());
        return jobsMap.get(key).getKm();
    }



}