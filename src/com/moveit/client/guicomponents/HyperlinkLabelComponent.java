package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;

/**
 *
 */
public class HyperlinkLabelComponent extends LabelComponent implements MouseOverHandler{

    public HyperlinkLabelComponent(String text){
        this(text, new TextLayout());
    }

    public HyperlinkLabelComponent(String text, TextLayout l) {
        super(text);
        addDomHandler(this, MouseOverEvent.getType());
        StyleIt.add(this, l);
    }


    public void underline(){
        StyleIt.add(this, P.TEXT_DECORATION_UNDERLINE);
    }

    public void onMouseOver(MouseOverEvent event) {
        event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
    }


}