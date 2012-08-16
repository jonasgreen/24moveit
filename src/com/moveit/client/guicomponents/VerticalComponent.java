package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class VerticalComponent extends CellComponent implements MouseOverHandler {

    private List<MouseOverHandler> handlers = new ArrayList<MouseOverHandler>();

    protected VerticalPanel panel = new VerticalPanel();

    public VerticalComponent() {
        super();
        addDomHandler(this, MouseOverEvent.getType());
        initWidget(panel);
    }


    public VerticalPanel getPanel() {
        return panel;
    }


    public void addMouseOverHandler(MouseOverHandler handler) {
        this.handlers.add(handler);
    }


    public void onMouseOver(MouseOverEvent event) {
        for (MouseOverHandler handler : handlers) {
            handler.onMouseOver(event);
        }

    }

    public void remove(Widget w) {
        panel.remove(w);

    }


}
