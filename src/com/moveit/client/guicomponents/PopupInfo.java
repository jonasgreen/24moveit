package com.moveit.client.guicomponents;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.moveit.client.gui.PopupManager;
import com.moveit.client.gui.ApplicationController;

/**
 *
 */
public class PopupInfo extends PopupPanel implements ClickHandler {
    public enum InfoLevel {
        SUCCES(P.BACKGROUND_BLUE_LOGO, P.COLOR_WHITE),
        INFO(P.BACKGROUND_YELLOW, P.COLOR_BLACK),
        ERROR(P.BACKGROUND_RED, P.COLOR_BLACK);

        private P backgroundColor;
        private P textColor;

        InfoLevel(P backC, P textC) {
            this.backgroundColor = backC;
            this.textColor = textC;
        }

        public P getBackgroundColor() {
            return backgroundColor;
        }

        public P getTextColor() {
            return textColor;
        }
    }


    private Timer t;

    private VerticalComponent content = new VerticalComponent();

    public PopupInfo() {
        super();
        add(content);
        addDomHandler(this, ClickEvent.getType());


        StyleIt.add(this, Name.BORDER, "NONE");
    }

    public void onClick(ClickEvent event) {
        this.hide();
    }


    public void show(final InfoLevel level, String... labels) {
        StyleIt.add(this, level.getBackgroundColor());
        content.removeFromParent();
        content = new VerticalComponent();
        add(content);
        content.setHeight("20px");
        content.setWidth("250px");
        content.setBackgroundColor(level.getBackgroundColor());
        for (String l : labels) {
            if (l == null || l.equals("")) {
                content.add(new SimplePanelComponent(), new Layout17("10px", "10px").add(level.getBackgroundColor()));
            }
            else {
                LabelComponent la = new LabelComponent(l);
                la.addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        PopupInfo.this.hide();
                    }
                });
                la.getLabel().setWordWrap(false);
                Layout17 layout = new TextLayout(Vertical.MIDDLE).sizeSmall().add(level.getTextColor());
                if (level != InfoLevel.SUCCES) {
                    layout.add(P.FONT_WEIGHT_BOLD);
                }
                content.add(la, layout);
            }
        }


        t = new Timer() {
            @Override
            public void run() {
                setPopupPositionAndShow(new PopupPanel.PositionCallback() {
                    public void setPosition(int offsetWidth, int offsetHeight) {
                        if (PopupManager.isShowing()) {
                            //PopupManager.showCurtain();            
                            setPopupPosition((Window.getClientWidth() + Window.getScrollLeft() - offsetWidth) / 2, (PopupManager.getClientOffsetHeight()) + 1);
                            PopupManager.setBorder(level);
                        }
                        else {
                            setPopupPosition((ApplicationController.APP_WIDTH_INT + ApplicationController.PAGE_MARGIN_INT + Window.getScrollLeft() - offsetWidth) / 2, Window.getScrollTop());
                        }
                    }
                });
            }

        };
        t.scheduleRepeating(50);
    }


    public void hide() {
        if (t != null) {
            t.cancel();
        }
        super.hide();
    }
}
