package com.moveit.client.util;

import com.moveit.client.guicomponents.*;

/**
 *
 */
public class Border {
    public static void addBorder(GuiComponent gc, String color){
        Css css = new Css(P.BORDER_STYLE_SOLID).and(P.BORDER_WIDTH_1px).and(Name.BORDER_COLOR, color);
        StyleIt.add(gc, css);
    }
}
