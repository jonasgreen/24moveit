package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.moveit.client.guicomponents.*;
import com.moveit.client.html.HtmlContent;
import com.moveit.client.language.LSearchPage;

/**
 *
 */
public class MapPopupSearchHelp extends PopupPanel implements ClickHandler {

    private int maxHeight = 260;
    private Timer timerRoll = null;
    private Timer endTimer = null;
    private ScrollPanel content = new ScrollPanel();
    private ImageComponent closeImage;


    public MapPopupSearchHelp(boolean autoHide, boolean modal) {
        super(autoHide, modal);
        add(content);
        VerticalComponent vc = new VerticalComponent();
        vc.add(getCloseImage(), new Layout17(Horizontal.RIGHT));
        HtmlComponent htmlC = getHtml();
        vc.add(htmlC,new TextLayout(0, 20,20,20, null, "600px").sizeSmall());
        

        content.add(vc);
        vc.setWidth("100%");

        StyleIt.add(this, Name.BORDER_LEFT, "NONE");
        StyleIt.add(this, Name.BORDER_RIGHT, "NONE");
        StyleIt.add(this, Name.BORDER_BOTTOM, "NONE");

        StyleIt.add(this, Name.BORDER_COLOR, P.COLOR_GREY_LIGHT.getValue());
        StyleIt.add(this, P.BACKGROUND_BACK_PANEL);

        addDomHandler(this, ClickEvent.getType());
    }

    public ImageComponent getCloseImage() {
        if (closeImage == null) {
            closeImage = new ImageComponent("close.png");
            closeImage.getImage().setHeight("20px");
            closeImage.getImage().setWidth("20px");
            closeImage.getImage().addMouseOverHandler(new MouseOverHandler() {
                public void onMouseOver(MouseOverEvent event) {
                    event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
                }
            });
            closeImage.getImage().addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    MapPopupManager.hideHelpPopup();
                }
            });
        }
        return closeImage;
    }

    public HtmlComponent getHtml() {
        HtmlComponent html = new HtmlComponent();
        HtmlContent hc = new HtmlContent();

        hc.addSection("helpSearchH2", LSearchPage.HELP_1.text());
        hc.addSection("helpSearchText", LSearchPage.HELP_2.text());
        hc.addSection("helpSearchText", LSearchPage.HELP_3.text());
        hc.addSection("helpSearchText", LSearchPage.HELP_4.text());
        hc.addSection("helpSearchText", LSearchPage.HELP_5.text());

        html.setHtml(hc.getHtml());
        return html;
    }


    public void cancelIt() {
        if (timerRoll != null) {
            timerRoll.cancel();
        }
        if (endTimer != null) {
            endTimer.cancel();
        }
        this.hide();
    }

    //dont remove dummy
    public void show(String dummy) {
        showResult();
    }

    private void showResult() {
        timerRoll = new Timer() {
            int max = 10;
            int count = 0;
            int step = maxHeight / max;
            int acutalHeight = step;

            @Override
            public void run() {
                setWidth();
                content.setHeight(acutalHeight + "px");
                acutalHeight = acutalHeight + step;
                showItAll(acutalHeight - 20);
                count++;
                if (count == 10) {
                    content.setHeight(maxHeight - 6 + "px");
                    showItAll(maxHeight + 4);

                    endTimer = new Timer() {
                        @Override
                        public void run() {
                            setWidth();
                            showItAll(maxHeight + 4);
                        }
                    };
                    endTimer.scheduleRepeating(100);
                    this.cancel();

                }
            }
        };

        timerRoll.scheduleRepeating(10);
    }

    private void showItAll(final int contentHeight) {
        setPopupPositionAndShow(new PositionCallback() {
            public void setPosition(int offsetWidth, int offsetHeight) {
                int offsetLeft = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetLeft();
                int offsetTop = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetTop();
                int height = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getOffsetHeight();


                //setPopupPosition((Window.getClientWidth() + Window.getScrollLeft() - offsetWidth) / 2, (PopupManager.getClientOffsetHeight()) + 3);
                setPopupPosition(offsetLeft, offsetTop + height - contentHeight);

            }
        });
    }


    public void onClick(ClickEvent event) {
        //cancelIt();
    }

    private void setWidth() {
        int width = SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().getElement().getClientWidth();
        content.setWidth(width - 6 + "px");

    }
}