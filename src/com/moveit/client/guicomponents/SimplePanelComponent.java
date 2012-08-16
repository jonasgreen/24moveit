package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class SimplePanelComponent extends GuiComponent implements MouseOverHandler, ClickHandler{
    private List<MouseOverHandler> handlers = new ArrayList<MouseOverHandler>();
    private List<ClickHandler> clickHandlers = new ArrayList<ClickHandler>();

    private SimplePanel panel = new SimplePanel();

    public SimplePanelComponent() {
        super();
        addDomHandler(this, MouseOverEvent.getType());
        addDomHandler(this, MouseOverEvent.getType());
        initWidget(panel);
      
    }

    public SimplePanel getSimplePanel(){
        return panel;
    }

    public void add(GuiComponent gc) {
        panel.add(gc);
    }

    public void add(Widget w){
        panel.add(w);
    }
    

    public void add(GuiComponent gc, Layout17 l) {
        panel.add(gc);
        gc.layout(l);
    }



    public void addMouseOverHandler(MouseOverHandler handler) {
        this.handlers.add(handler);
    }


    public void onMouseOver(MouseOverEvent event) {
        for (MouseOverHandler handler : handlers) {
            handler.onMouseOver(event);
        }
    }

    public void addClickHandler(ClickHandler handler){
        clickHandlers.add(handler);
    }


    public void onClick(ClickEvent event) {
        for (ClickHandler handler : clickHandlers) {
            handler.onClick(event);
        }
    }
}
