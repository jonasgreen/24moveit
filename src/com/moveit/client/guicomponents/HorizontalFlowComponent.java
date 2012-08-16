package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 */
public class HorizontalFlowComponent extends GuiComponent{

    public enum Flow{
        LEFT("horizontal-flow-left"),
        RIGHT("horizontal-flow-right"),;

        private String styleName;

        Flow(String styleName) {
            this.styleName = styleName;
        }

        public String getStyleName() {
            return styleName;
        }
    }



    private FlowPanel panel;

    public HorizontalFlowComponent() {
        super();
        this.panel = new FlowPanel();
        initWidget(panel);
    }


    public void add(GuiComponent gc, Flow flow, Layout17 l){
        panel.add(gc);
        gc.setStyleName(flow.getStyleName());
        gc.layout(l);
    }



}
