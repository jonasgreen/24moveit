package com.moveit.client.guicomponents;

import com.moveit.client.language.LSearchPage;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 *
 */
public class MapPanel extends HorizontalComponent{


    private ImageComponent rightShadow;//, new TextLayout(3, 0,0,0);
    private HorizontalComponent insideContent;


    public MapPanel() {
        init();
    }

    private void init() {

        final LabelComponent w = new LabelComponent(LSearchPage.SEARCH_PANE.text());


        getInsideContent().add(w, new TextLayout().padding(8));

        getInsideContent().setStyleName("mappanel");
        getInsideContent().setBackgroundColor(P.BACKGROUND_WHITE);
        w.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent
                    event) {
                StyleIt.add(w, new TextLayout().paddingBottom(4));
            }
        });

        add(getInsideContent(), new TextLayout(Vertical.BOTTOM));

        add(getRightShadow(), new TextLayout(5,0,0,0));
    }

    public HorizontalComponent getInsideContent() {
        if (insideContent == null) {
            insideContent = new HorizontalComponent();
        }
        return insideContent;
    }

    public ImageComponent getRightShadow() {
        if (rightShadow == null) {
            rightShadow = new ImageComponent("mappanelshadow.png");
        }
        return rightShadow;
    }



}
