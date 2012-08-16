package com.moveit.client.gui;

import com.google.gwt.dom.client.Style;
import com.moveit.client.guicomponents.*;

/**
 *
 */
public class AppFrame extends VerticalComponent {
    public static double LOGO_HEIGHT = 70;
    public static double MENU_HEIGHT = 45;
    public static double BOTTOM_HEIGHT = 20;
    public static Style.Unit PX = Style.Unit.PX;


    private HorizontalComponent logoFrame;
    private HorizontalComponent menuFrame;
    private HorizontalComponent centerFrame;
    private HorizontalComponent bottomFrame;

    private static AppFrame instance;

    private VerticalComponent centerPageHolder = new VerticalComponent();
    private SimplePanelComponent fillRightMarginCenter = new SimplePanelComponent();
    private SimplePanelComponent fillLeftMarginCenter = new SimplePanelComponent();
    private GuiComponent centerPage;


    private SimplePanelComponent fillRightMarginLogo = new SimplePanelComponent();
    private SimplePanelComponent fillLeftMarginLogo = new SimplePanelComponent();


    private SimplePanelComponent fillRightMarginBottom = new SimplePanelComponent();
    private SimplePanelComponent fillLeftMarginBottom = new SimplePanelComponent();



    private AppFrame() {
        super();
        init();
    }

    public static AppFrame getInstance() {
        if (instance == null) {
            instance = new AppFrame();

        }
        return instance;
    }


    private void init() {
        add(getLogoFrame(), new Layout17(0, 0, 0, 0, LOGO_HEIGHT + "px", "100%"));
        add(getMenuFrame(), new Layout17(0, 0, 0, 0, MENU_HEIGHT + "px", "100%"));

        add(getCenterFrame(), new Layout17(0, 0, 0, 0, "100%", "100%", Horizontal.LEFT, null));
        add(BottomPageController.getInstance().getPage(), new Layout17(0, 0, 0, 0, BOTTOM_HEIGHT + "px", "100%"));
        
    }


    public HorizontalComponent getMenuFrame() {
        if (menuFrame == null) {
            menuFrame = new HorizontalComponent();
            menuFrame.setBackgroundColor(P.BACKGROUND_MENU_TOP);

            menuFrame.add(MenuPanel.getInstance().getPanel(), new Layout17(0, 0, 0, ApplicationController.PAGE_MARGIN_INT, MENU_HEIGHT + "px",  null, Horizontal.LEFT, null));

        }
        return menuFrame;
    }


    public HorizontalComponent getLogoFrame() {
        if (logoFrame == null) {
            logoFrame = new HorizontalComponent();
            logoFrame.add(fillLeftMarginLogo, new Layout17(0, 0, 0, 0, LOGO_HEIGHT + "px", ApplicationController.PAGE_MARGIN).add(P.BACKGROUND_BACK_PANEL));
            logoFrame.add(LogoPanel.getInstance().getPanel(), new Layout17(0,0,0,0, LOGO_HEIGHT + "px", "100%"));
            logoFrame.setBackgroundColor(P.BACKGROUND_BACK_PANEL);

        }
        return logoFrame;
    }


    public HorizontalComponent getCenterFrame() {
        if (centerFrame == null) {
            centerFrame = new HorizontalComponent();
            centerFrame.add(fillLeftMarginCenter, new Layout17(0, 0, 0, 0, "100%", ApplicationController.PAGE_MARGIN));
            centerFrame.add(centerPageHolder);
            centerFrame.add(fillRightMarginCenter, new Layout17(0, 0, 0, 0, "100%", "100%"));
            centerFrame.setBackgroundColor(P.BACKGROUND_BACK_PANEL);
        }
        return centerFrame;
    }

    public void addCenterContent(GuiComponent gc, Layout17 l) {
        //ensure logopanel is added
       // getLogoFrame();

        if (centerPage != null) {
            centerPage.removeFromParent();
        }
        centerPage = gc;
        centerPageHolder.add(gc, l);


        if (l.getWidth() != null && l.getWidth().equals("100%")) {
            fillRightMarginCenter.setVisible(false);
            fillLeftMarginCenter.setVisible(false);
            centerPageHolder.setWidth(l.getWidth());

            if(fillRightMarginLogo != null){
                fillRightMarginLogo.removeFromParent();
            }
            LogoPanel.getInstance().getLogoMenues().setWidth(l.getWidth());

            BottomPageController.getInstance().getPage().removeFromParent();
            add(BottomPageController.getInstance().getPage(), new Layout17(0, 0, 0, 0, BOTTOM_HEIGHT + "px", "100%"));

        }
        else {
            fillLeftMarginCenter.setVisible(true);
            fillRightMarginCenter.setVisible(true);
            centerPageHolder.setWidth(ApplicationController.APP_WIDTH);
            StyleIt.add(getLogoFrame(), Name.PADDING_RIGHT, "0px");

            if(fillRightMarginLogo != null){
                fillRightMarginLogo.removeFromParent();
            }
            fillRightMarginLogo = new SimplePanelComponent();
             LogoPanel.getInstance().getPanel().add(fillRightMarginLogo, new Layout17(0,0,0,0, LOGO_HEIGHT + "px", "100%").add(P.BACKGROUND_BACK_PANEL));
            LogoPanel.getInstance().getLogoMenues().setWidth("200px");

            BottomPageController.getInstance().getPage().removeFromParent();
            add(BottomPageController.getInstance().getPage(), new Layout17(0, 0, 0, ApplicationController.PAGE_MARGIN_INT, BOTTOM_HEIGHT + "px", ApplicationController.APP_WIDTH, Horizontal.LEFT));




        }


    }



}
