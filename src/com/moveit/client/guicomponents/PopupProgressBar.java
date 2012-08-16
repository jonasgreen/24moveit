package com.moveit.client.guicomponents;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.moveit.client.gui.PopupManager;
import com.moveit.client.language.LService;

/**
 *
 */
public class PopupProgressBar extends PopupPanel {

    private SmallProgressBar bar = new SmallProgressBar(P.BACKGROUND_BLUE_LIGHT);

    Timer t;

    public PopupProgressBar() {
        super();
        this.add(bar);
        StyleIt.add(this, P.BACKGROUND_BLUE_LIGHT);
        StyleIt.add(this, Name.BORDER, "NONE");
    }


    public void start(String text) {
        StyleIt.add(this, P.BACKGROUND_BLUE_LIGHT);
        bar.start(text == null ? LService.WORKING.text() : text);
        t = new Timer() {
            @Override
            public void run() {
                setPopupPositionAndShow(new PopupPanel.PositionCallback() {
                    public void setPosition(int offsetWidth, int offsetHeight) {
                        if (PopupManager.isShowing()) {
                            setPopupPosition((Window.getClientWidth() + Window.getScrollLeft() - offsetWidth) / 2, (PopupManager.getClientOffsetHeight()) + 3);

                        }
                        else {
                            setPopupPosition((Window.getClientWidth() + Window.getScrollLeft() - offsetWidth) / 2, Window.getScrollTop());
                        }
                    }
                });
            }
        };
        t.scheduleRepeating(50);

    }

    public void stop() {
        StyleIt.add(this, P.BACKGROUND_WHITE);
        bar.stop();
        if (t != null) {
            t.cancel();
        }
        this.setVisible(false);
        hide();
    }


}
