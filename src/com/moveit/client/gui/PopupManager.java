package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.guicomponents.*;
import com.moveit.client.util.MouseOver;

/**
 *
 */
public class PopupManager {

    private static PopupPanel curtain = initCurtain();
    private static PopupPanel panel = new PopupPanel(true, false);


    static {
        panel.addCloseHandler(new CloseHandler<PopupPanel>() {
            public void onClose(CloseEvent<PopupPanel> popupPanelCloseEvent) {
                hideAndShowNormalPage();
            }
        });


    }

    private static Widget showingComponent = null;
    private static ImageComponent closeImage;

    private static PopupPanel initCurtain() {
        PopupPanel pp = new PopupPanel(true, false);
        StyleIt.add(pp, Name.OPACITY, "0.7");
        StyleIt.add(pp, Name.FILTER, "alpha(opacity=70)");
        LabelComponent labelComponent = new LabelComponent("hide");
        labelComponent.setBackgroundColor(P.BACKGROUND_DARK_GREY);
        StyleIt.add(labelComponent, P.COLOR_DARK_GREY);

        VerticalComponent vc = new VerticalComponent();
        vc.add(labelComponent);
        pp.add(vc);
        vc.setWidth("2000px");
        vc.setHeight("2000px");
        StyleIt.add(pp, P.BACKGROUND_DARK_GREY);
        StyleIt.add(pp, Name.BORDER, "NONE");

        return pp;
    }

  
    public static void showCurtain() {
        curtain.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
            public void setPosition(int offsetWidth, int offsetHeight) {
                curtain.setPopupPosition(0, 0);
                curtain.setWidth("2000px");
                curtain.setHeight("2000px");
            }
        });
    }

    public static void showComponentFromHistory(PageController pc) {
        show(pc);
        pc.loadFromHistory();
    }

    public static void showComponent(PageController pc) {
        show(pc);
        pc.load();

    }

    private static void show(PageController pc) {
        if (showingComponent != null) {
            showingComponent.removeFromParent();
        }
        showCurtain();

        VerticalComponent content = new VerticalComponent();
        content.add(getCloseImage(), new Layout17(Horizontal.RIGHT));
        content.add(pc.getPage());
        panel.add(content);
        StyleIt.add(pc.getPage(), new TextLayout(0,0,0,0).padding(0,10,10,10));
        showingComponent = content;

        panel.center();
        panel.show();
    }


    public static ImageComponent getCloseImage() {
        if (closeImage == null) {
            closeImage = new ImageComponent("close.png");
            closeImage.getImage().setHeight("20px");
            closeImage.getImage().setWidth("20px");
            closeImage.getImage().addMouseOverHandler(MouseOver.POINTER);
            closeImage.getImage().addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                   hideAndShowNormalPage();
                }
            });
        }
        return closeImage;
    }



    public static boolean isShowing() {
        return panel.isShowing();
    }

    public static int getClientHeight() {
        return panel.getElement().getClientHeight();
    }

    public static int getClientWidth() {
        return panel.getElement().getClientWidth();
    }

    public static int getClientOffsetWidth() {
        return panel.getElement().getOffsetWidth();
    }

    
    public static int getClientOffsetHeight() {
        return panel.getElement().getAbsoluteTop();
    }

    public static void setBorder(PopupInfo.InfoLevel level) {
        StyleIt.add(panel, Name.BORDER_WIDTH, "1px");        
        StyleIt.add(panel, Name.BORDER_COLOR, level.getBackgroundColor().getValue());
    }

    public static void hideAndShowNormalPage() {
        ApplicationController.getInstance().addActiveControllerToHistory();
        hide();
    }



    public static void hide() {
        if (panel != null && panel.isShowing()) {
            panel.hide();
        }
        if (curtain != null && curtain.isShowing()) {
            curtain.hide();
        }
        if (showingComponent != null) {
            showingComponent.removeFromParent();
        }
    }
}
