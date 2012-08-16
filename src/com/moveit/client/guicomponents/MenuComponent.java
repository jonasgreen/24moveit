package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.*;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class MenuComponent extends VerticalComponent implements MouseOverHandler, MouseOutHandler, ClickHandler {

    private P backGroundOff = P.BACKGROUND_MENU_TOP;
    private P backGroundOn = P.BACKGROUND_BLACK;
    private P mouseOver = P.BACKGROUND_MENU_ORANGE;
    private P textColor = P.COLOR_WHITE;
    private boolean selected = false;
    private boolean active = true;
    private LabelComponent label;

    private List<ClickHandler> clickHandlers = new ArrayList<ClickHandler>();


    public MenuComponent(String text) {
        super();
        addDomHandler(this, MouseOverEvent.getType());
        addDomHandler(this, MouseOutEvent.getType());
        addDomHandler(this, ClickEvent.getType());

        setBackgroundColor(backGroundOff);
        add(getLabel(), new TextLayout(Vertical.MIDDLE).sizeSmall().alignCenter());
                getLabel().getLabel().setWordWrap(false);
        getLabel().setText(text);
        setActive(true);
        StyleIt.add(this, new TextLayout().sizeSmall());

    }

    public LabelComponent getLabel() {
        if (label == null) {
            label = new LabelComponent("");
        }
        return label;
    }

    public void underline() {
        StyleIt.add(this, P.TEXT_DECORATION_UNDERLINE);
    }

    public void onMouseOver(MouseOverEvent event) {
        if (!isSelected() && isActive()) {
            event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
            setBackgroundColor(mouseOver);
        }
    }

    public void onMouseOut(MouseOutEvent event) {
        event.getRelativeElement().getStyle().setProperty("cursor", "auto");
        updateBackgroundColor();

    }


    public void setSelected(boolean sel) {
        selected = sel;
        updateBackgroundColor();
    }

    private void updateBackgroundColor() {
        setBackgroundColor(selected ? backGroundOn : backGroundOff);
    }

    public boolean isSelected() {
        return selected;
    }

    public P getBackGroundOff() {
        return backGroundOff;
    }

    public P getBackGroundOn() {
        return backGroundOn;
    }

    public P getTextColor() {
        return textColor;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        StyleIt.add(getLabel(), active ? P.COLOR_WHITE : P.COLOR_GREY);
    }

    public void onClick(ClickEvent clickEvent) {
        for (ClickHandler ch : clickHandlers) {
            ch.onClick(clickEvent);
        }
    }

    public void addClickHandler(ClickHandler clickHandler) {
        clickHandlers.add(clickHandler);
    }
}