package com.moveit.client.guicomponents;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.guicomponents.Name;
import com.moveit.client.guicomponents.P;
import com.moveit.client.guicomponents.HorizontalComponent;
import com.moveit.client.guicomponents.RoundedComponent;

/**
 *
 */
public class WidgetUtil {


    public static HorizontalComponent createHPanel(Widget... ws) {
        HorizontalComponent hc = new HorizontalComponent();
        for (Widget w : ws) {
            hc.add(w);
        }
        return hc;
    }

    public static VerticalComponent createVPanel(Widget... ws) {
        VerticalComponent vp = new VerticalComponent();
        for (Widget w : ws) {
            vp.add(w);
        }
        return vp;
    }


    public static void setWidth(String width, Widget... ws) {
        for (Widget w : ws) {
            w.setWidth(width);
        }
    }


    public static void alignHorizontalCenter(Widget... ws) {
        for (Widget w : ws) {
            Widget parent = w.getParent();
            if (parent != null) {
                Element e = DOM.getParent(w.getElement());
                DOM.setElementProperty(e, "align", "center");
            }
        }
    }

    public static void setMargin(Widget left, String s) {

        StyleIt.add(left, Name.MARGIN, s);
    }

    public static RoundedComponent embraceWhite(RoundedComponent rc, int size) {
        RoundedComponent rcWhite = new RoundedComponent(size);
        rcWhite.setColor(P.BACKGROUND_WHITE);
        rcWhite.add(rc);

        return rcWhite;
    }
    
    public static RoundedComponent embrace(RoundedComponent rc, int size, P color) {
        RoundedComponent rcWhite = new RoundedComponent(size);
        rcWhite.setColor(color);
        rcWhite.add(rc);

        return rcWhite;
    }
}
