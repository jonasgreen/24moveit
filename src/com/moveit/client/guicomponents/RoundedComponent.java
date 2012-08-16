package com.moveit.client.guicomponents;

import org.cobogw.gwt.user.client.ui.RoundedPanel;

/**
 *
 */
public class RoundedComponent extends GuiComponent {

    private RoundedPanel panel;
    private VerticalComponent contentPanel = new VerticalComponent();
    private final int size;

    public RoundedComponent(int size){
        this(size, RoundedPanel.ALL);
    }
    public RoundedComponent(int size, int corners) {
        super();
        panel = new RoundedPanel(corners, size);
        panel.setWidget(contentPanel);
        this.size = size;
        initWidget(panel);
    }

    public void add(GuiComponent gc, Layout17 l) {
        add(gc);
        gc.layout(l);
    }

    public void add(GuiComponent gc) {
        contentPanel.add(gc);
        gc.setMargin(0, size, 0, size);
    }


    public void setColor(P color) {
        StyleIt.add(contentPanel, Name.BACKGROUND, color.getValue());
        panel.setCornerColor(color.getValue());
    }

    public void setWidth(String width) {
        contentPanel.setWidth(width);
        panel.setWidth(width);

    }

    public void setHeight(String height) {
        contentPanel.setHeight(height);
        panel.setHeight(height);
    }


}
