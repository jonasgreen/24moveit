package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TipsManagerAddPage implements FocusHandler {

    private static TipsManagerAddPage instance;

    private Widget relativePlacementLeft = null;

    private Timer t;
    PopupPanel popupPanel = null;

    private Map<Widget, String> tips = new HashMap<Widget, String>();

    private TipsManagerAddPage() {

    }

    public static TipsManagerAddPage getInstance() {
        if (instance == null) {
            instance = new TipsManagerAddPage();
        }
        return instance;
    }


    public void add(DataContainer dc, String tip) {
        tips.put(dc.getDataWidget(), tip);
        dc.addFocusHandler(this);
    }

    public void onFocus(final FocusEvent event) {

        showTip((Widget) event.getSource());

    }


    private void showTip(Widget w) {
        String tip = tips.get(w);
        if (tip == null) {
            return;
        }
        showTip(w, "<div class=\"tipsText\">"+tip+"</div>");
    }

    public void showTip(final Widget w, String message) {

        clear();
        popupPanel = new PopupPanel(false, false);
        popupPanel.setWidth("250px");
        popupPanel.addCloseHandler(new CloseHandler<PopupPanel>() {
            public void onClose(CloseEvent<PopupPanel> popupPanelCloseEvent) {
                clear();
            }
        });


        SimplePanelComponent rc = new SimplePanelComponent();
        rc.add(new HtmlComponent(message), new TextLayout().sizeSmall());
        rc.setBackgroundColor(P.BACKGROUND_BLUE_TIPS);
        StyleIt.add(popupPanel, Name.BORDER_COLOR, P.COLOR_DARK_GREY.getValue());
        StyleIt.add(popupPanel, Name.BORDER_WIDTH, "1px");
        StyleIt.add(popupPanel, P.BACKGROUND_BLUE_TIPS);

        popupPanel.add(rc);

        t = new Timer() {
            @Override
            public void run() {
                popupPanel.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
                    public void setPosition(int offsetWidth, int offsetHeight) {

                        int offsetLeft = relativePlacementLeft.getElement().getAbsoluteRight();
                        int offsetTop = w.getElement().getAbsoluteTop()-15;
                        popupPanel.setPopupPosition(offsetLeft + 100, offsetTop);
                    }
                });
            }
        };
        t.scheduleRepeating(100);

    }


    public void clear() {
        if (t != null) {
            t.cancel();
        }
        if (popupPanel != null) {
            popupPanel.hide();
        }
    }

    public Widget getRelativePlacementLeft() {
        return relativePlacementLeft;
    }

    public void setRelativePlacementLeft(Widget relativePlacementLeft) {
        this.relativePlacementLeft = relativePlacementLeft;
    }
}
