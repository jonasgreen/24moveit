package com.moveit.client.about;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.gui.ApplicationController;
import com.moveit.client.gui.Page;
import com.moveit.client.guicomponents.*;
import com.moveit.client.history.HistorySupport;
import com.moveit.client.language.LAllAbout;

/**
 *
 */
public class AllAboutPage extends Page<AllAboutPageController> {

    private VerticalComponent content;
    private VerticalComponent indexColumn;
    private HyperlinkLabelComponent howDoesItWork;
    private HyperlinkLabelComponent help;
    private HorizontalComponent insideContent;
    private HyperlinkLabelComponent tips;
    private HyperlinkLabelComponent contact;
    private P backGroundColor = P.BACKGROUND_WHITE;
    private HyperlinkLabelComponent searchHelp;

    public AllAboutPage() {
        super();
        content = new VerticalComponent();
        initWidget(content);
    }

    public void init() {
        content.add(getInsideContent(), new Layout17(15,0,0,0, null, ApplicationController.APP_WIDTH, Horizontal.CENTER, null));
        content.add(new SimplePanelComponent(), new Layout17(0,0,0,0, "100%", null).add(backGroundColor));
    }

    public HorizontalComponent getInsideContent() {
        if (insideContent == null) {
            insideContent = new HorizontalComponent();
            VerticalComponent vc = new VerticalComponent();
            vc.add(getIndexColumn(), new TextLayout(0, 0, 10, 0, null, "182px").colorBlueLink().add(backGroundColor).add(P.BORDER_STYLE_SOLID).add(P.BORDER_WIDTH_1px).add(Name.BORDER_COLOR, P.BACKGROUND_C1.getValue()));
            //vc.add(new ImageComponent("TruckHelpBlue.png"));
            insideContent.add(vc, new Layout17(0,0,0,0, Horizontal.LEFT));
        }
        return insideContent;
    }

    public VerticalComponent getIndexColumn() {
        if (indexColumn == null) {
            indexColumn = new VerticalComponent();
            Layout17 l = new TextLayout(4,4,0,4).sizeNormal().padding(2);
            indexColumn.add(getHowDoesItWork(), l);
            //indexColumn.add(getSearchHelp(), l);
            //indexColumn.add(getTips(), l);
            indexColumn.add(getHelp(), l);
            indexColumn.add(getContact(), l);
            indexColumn.add(new SimplePanelComponent(), new Layout17(0,0,0,0, "100px", null).add(backGroundColor));
        }
        return indexColumn;
    }

    public HyperlinkLabelComponent getHowDoesItWork() {
        if (howDoesItWork == null) {
            howDoesItWork = new HyperlinkLabelComponent(LAllAbout.HOW_DOES_IT_WORK.text());
            howDoesItWork.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    HistorySupport.getInstance().addHistory(AllAboutPageController.getInstance());
                    getController().loadPage(HowController.getInstance());
                }
            });
        }
        return howDoesItWork;
    }

    public HyperlinkLabelComponent getHelp() {
        if (help == null) {
            help = new HyperlinkLabelComponent(LAllAbout.HELP.text());

            help.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    HistorySupport.getInstance().addHistory(AllAboutPageController.getInstance());
                    getController().loadPage(HelpController.getInstance());
                }
            });
        }
        return help;
    }

    public HyperlinkLabelComponent getTips() {
        if (tips == null) {
            tips = new HyperlinkLabelComponent(LAllAbout.TIPS.text());

            tips.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    HistorySupport.getInstance().addHistory(AllAboutPageController.getInstance());
                    getController().loadPage(TipsController.getInstance());
                }
            });
        }
        return tips;
    }

    public HyperlinkLabelComponent getContact() {
        if (contact == null) {
            contact = new HyperlinkLabelComponent(LAllAbout.CONTACT.text());

            contact.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    HistorySupport.getInstance().addHistory(AllAboutPageController.getInstance());
                    getController().loadPage(ContactController.getInstance());
                }
            });
        }
        return contact;
    }

    public HyperlinkLabelComponent getSearchHelp() {
        if (searchHelp == null) {
            searchHelp = new HyperlinkLabelComponent(LAllAbout.SEARCH_FOR_JOBS.text());
            searchHelp.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    HistorySupport.getInstance().addHistory(AllAboutPageController.getInstance());
                    getController().loadPage(SearchHelpController.getInstance());
                }
            });
        }
        return searchHelp;
    }

    public void setAsPresent(HyperlinkLabelComponent hc){
        StyleIt.add(hc, new TextLayout().border(1).add(Name.BORDER_COLOR, P.BACKGROUND_MENU_ORANGE.getValue()));

        //hc.setBackgroundColor(P.BACKGROUND_ORANGE);
    }

    public void removeAsPresent(HyperlinkLabelComponent hc){
        StyleIt.add(hc, new TextLayout().border(0));

        hc.setBackgroundColor(backGroundColor);
    }


}
