package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.gui.ApplicationController;

/**
 *
 */
public abstract class PanelComponent extends GuiComponent {


    public PanelComponent() {
    }

    public void add(Widget w) {
        try {
            getPanel().add(w);
        }
        catch (Throwable t) {
            ApplicationController.getInstance().error(this.getClass().getName() +" adding "+w.getClass().getName()+ ". "+ t.getMessage());
        }
    }

    public void add(GuiComponent gc, Layout17 l) {
        getPanel().add(gc);
        gc.layout(l);
    }

    public void add(DataContainer md, Layout17 l){
        GuiComponent gc = md.getGui();
        getPanel().add(gc);
        gc.layout(l);
        super.add(md);
    }

    public abstract Panel getPanel();


    public void addLabel(DataContainer md, Layout17 l) {
        getPanel().add(md.getLabel());
        md.getLabel().layout(l);
    }


}
