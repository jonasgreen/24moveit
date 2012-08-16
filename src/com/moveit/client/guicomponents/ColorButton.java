package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ColorButton extends VerticalComponent implements MouseOverHandler, MouseOutHandler, ClickHandler, KeyDownHandler {
    private LabelComponent label;

    private final String width;
    private final String height;

    private List<ClickHandler> clickHandlers = new ArrayList<ClickHandler>();
    private List<KeyDownHandler> keyDownHandlers = new ArrayList<KeyDownHandler>();

    public ColorButton(String text, String width, String height, String css) {
        super();
        this.height = height;
        this.width = width;

        label = getLabel();
        label.setText(text);

        add(label, new TextLayout(Horizontal.CENTER, Vertical.MIDDLE).sizeLargeButton().bold().colorWhite().alignCenter().noWrap().padding(5, 10, 5, 10).add(P.VERTICAL_ALIGN_MIDDLE));
        setStyleName(css);

        addDomHandler(this, ClickEvent.getType());
        addDomHandler(this, MouseOverEvent.getType());
        addDomHandler(this, MouseOutEvent.getType());

        addDomHandler(this, KeyDownEvent.getType());

    }

    public LabelComponent getLabel() {
        if (label == null) {
            label = new LabelComponent("");
        }
        return label;
    }


    public void setText(String msg) {
        getLabel().setText(msg);
    }


    public void onMouseOver(MouseOverEvent event) {
        event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
        
    }

    public void onMouseOut(MouseOutEvent event) {

    }



    public void addKeyDownHandler(KeyDownHandler handler) {
        keyDownHandlers.add(handler);
    }

    public void addClickHandler(ClickHandler handler) {
        clickHandlers.add(handler);
    }

    public void onClick(ClickEvent event) {
        for (ClickHandler clickHandler : clickHandlers) {
            clickHandler.onClick(event);
        }
    }


    public void onKeyDown(KeyDownEvent event) {
        for (KeyDownHandler handler : keyDownHandlers) {
            handler.onKeyDown(event);
        }
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }


}
