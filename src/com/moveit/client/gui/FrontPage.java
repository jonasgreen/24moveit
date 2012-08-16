package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.about.AllAboutPageController;
import com.moveit.client.about.HowController;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LFront;
import com.moveit.client.language.Language;
import com.moveit.client.util.MouseOver;


/**
 *
 */
public class FrontPage extends Page<FrontPageController> {

    private CenterComponent content;
    private HorizontalComponent bottom;
    private HorizontalComponent top;
    private VerticalComponent howDoesItWork;
    private static String cubicWidth = "260px";
    private ImageComponent how;


    public FrontPage() {
        super();
        content = new CenterComponent();
        initWidget(content);
    }

    public void init() {

        VerticalComponent vc = new VerticalComponent();

        vc.add(getTop(), new Layout17(40, 0, 30, 0, Horizontal.CENTER, Vertical.MIDDLE));

        //vc.add(newSplitter(), new Layout17("15px", "100%"));

        //vc.add(getBottom(), new TextLayout(80, 0, 10, 0, null, ApplicationController.APP_WIDTH));
        vc.setBackgroundColor(P.BACKGROUND_BACK_PANEL);

        ClickHandler ch = new ClickHandler() {
            public void onClick(ClickEvent event) {
                ApplicationController.getInstance().loadPage(AllAboutPageController.getInstance());
                AllAboutPageController.getInstance().loadPage(HowController.getInstance());
            }
        };

        HorizontalComponent images = new HorizontalComponent();

        ImageComponent im1 = new ImageComponent(Language.get(LFront.PIC_MONEY));
        im1.getImage().addClickHandler(ch);
        im1.getImage().addMouseOverHandler(MouseOver.POINTER);
        images.add(im1, new TextLayout(10, 45, 0, 6));

        ImageComponent im2 = new ImageComponent(Language.get(LFront.PIC_TIME));
        im2.getImage().addClickHandler(ch);
        im2.getImage().addMouseOverHandler(MouseOver.POINTER);
        images.add(im2, new TextLayout(10, 45, 0, 0));

        ImageComponent im3 = new ImageComponent(Language.get(LFront.PIC_CO2));
        im3.getImage().addClickHandler(ch);
        im3.getImage().addMouseOverHandler(MouseOver.POINTER);
        images.add(im3, new TextLayout(10, 0, 0, 0));

        
        vc.add(images, new TextLayout(35, 0, 0, 0).backgroundBlack());


        //  LabelComponent top0 = new LabelComponent("Danmarks eneste 100% gratis flytteportal - for både dig og vognmanden");
        //  vc.add(top0, new TextLayout(20, 0, 0, 0).sizeH3().colorOrange().alignCenter());


        //vc.add(new ImageComponent("TruckBlue2.png"));

        content.add(vc, new Layout17(null, ApplicationController.APP_WIDTH, Horizontal.CENTER));
    }



    public HorizontalComponent getTop() {
        if (top == null) {
            top = new HorizontalComponent();

            CenterComponent cc = new CenterComponent();

            cc.add(getQuestion(), new TextLayout(0, 0, 0, 0, Horizontal.CENTER, Vertical.MIDDLE));
            top.add(cc, new TextLayout("100%", "100%",Horizontal.CENTER, Vertical.MIDDLE));

            top.add(getHow(), new TextLayout(0,-17,0,0,"319px", "251px", Horizontal.RIGHT, Vertical.MIDDLE));
            top.setBackgroundColor(P.BACKGROUND_WHITE);
        }
        return top;
    }


    public VerticalComponent getQuestion() {
        VerticalComponent vp = new VerticalComponent();
        LabelComponent top = new LabelComponent(Language.get(LFront.NEED_TO_MOVE_SOMETHING));
        top.getLabel().setWordWrap(false);

        LabelComponent bottom = new LabelComponent(Language.get(LFront.GET_FREE_OFFERES));


        vp.add(top, new TextLayout().sizeTitle().bold().alignCenter());


        vp.add(bottom, new TextLayout(4, 0, 0, 0).sizeH2().alignCenter());


        ColorButton cb = ColorButtonFactory.getBlue180x60(Language.get(LFront.ADD_MOVEMENT_BUTTON));
        cb.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getController().addRouteClicked();
            }
        });
        vp.add(cb, new TextLayout(20, 0, 0, 0, cb.getHeight(), cb.getWidth(), Horizontal.CENTER, Vertical.MIDDLE));


/*
        Layout17 hl = new TextLayout(Horizontal.CENTER).sizeSmall().underline().colorBlueLink().alignCenter();
        HyperlinkLabelComponent why = new HyperlinkLabelComponent("Se hvorfor her");
        vp.add(why, hl);
        why.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });

*/
        return vp;
    }

    public ImageComponent getHow() {
        if (how == null) {
            how = new ImageComponent(LFront.PIC_HOW.text());
            how.getImage().addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent clickEvent) {
                    ApplicationController.getInstance().loadPage(AllAboutPageController.getInstance());
                    AllAboutPageController.getInstance().loadPage(HowController.getInstance());
                }
            });
            how.getImage().addMouseOverHandler(MouseOver.POINTER);
                 }
        return how;
    }


    public VerticalComponent getHowDoesItWork() {
        if (howDoesItWork == null) {
            howDoesItWork = new VerticalComponent();
            howDoesItWork.add(new LabelComponent(Language.get(LFront.HOW_DOES_IT_WORK)), new TextLayout(20, 15, 20, 15, Horizontal.LEFT).sizeH3().bold().colorOrange());

            Layout17 ln = new TextLayout(0, 15, 0, 15, Horizontal.LEFT).sizeH2().bold().colorOrange();
            Layout17 lt = new TextLayout(0, 15, 20, 15, Horizontal.LEFT).sizeNormal();

            howDoesItWork.add(new LabelComponent("1"), ln);
            howDoesItWork.add(new LabelComponent(Language.get(LFront.YOU_ENTER_FROM_TO)), lt);
            howDoesItWork.add(new LabelComponent("2"), ln);
            howDoesItWork.add(new LabelComponent(Language.get(LFront.HAULIERS_GIVE_YOU_OFFERS)), lt);
            howDoesItWork.add(new LabelComponent("3"), ln);
            howDoesItWork.add(new LabelComponent(Language.get(LFront.YOU_CHOOSE_AN_OFFER)), lt);

            //driver link
            Layout17 hl = new TextLayout().sizeSmall().underline().colorBlueLink().alignLeft().paddingBottom(6).paddingLeft(15).noWrap();

            HyperlinkLabelComponent driver = new HyperlinkLabelComponent(Language.get(LFront.ADVANTAGES));
            howDoesItWork.add(driver, hl);
            driver.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    ApplicationController.getInstance().loadPage(AllAboutPageController.getInstance());
                    AllAboutPageController.getInstance().loadPage(HowController.getInstance());
                }
            });


        }
        return howDoesItWork;

    }


}
