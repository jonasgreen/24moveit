package com.moveit.client.guicomponents;

import com.google.gwt.maps.client.geom.Point;
import com.google.gwt.maps.client.geom.Size;
import com.google.gwt.maps.client.overlay.Icon;
import com.google.gwt.maps.client.overlay.MarkerOptions;


/**
 *
 */
public class MapOptions {
    private static Icon baseIconNormal = Icon.newInstance();
    private static Icon baseIconHighlighted = Icon.newInstance();

    static {
        //baseIcon
        // Create a base icon for all of our markers that specifies the
        // shadow, icon dimensions, etc.
        baseIconNormal.setShadowURL("http://www.google.com/mapfiles/shadow50.png");
        baseIconNormal.setIconSize(Size.newInstance(20, 34));
        baseIconNormal.setShadowSize(Size.newInstance(37, 34));
        baseIconNormal.setIconAnchor(Point.newInstance(9, 34));
        baseIconNormal.setInfoWindowAnchor(Point.newInstance(9, 2));

        baseIconHighlighted.setShadowURL("http://www.google.com/mapfiles/shadow50.png");
        baseIconHighlighted.setIconSize(Size.newInstance(25, 43));
        baseIconHighlighted.setShadowSize(Size.newInstance(47, 43));
        baseIconHighlighted.setIconAnchor(Point.newInstance(12, 43));
        baseIconHighlighted.setInfoWindowAnchor(Point.newInstance(9, 2));
    }


    public static MarkerOptions getOptions(String text, String url, boolean highlighted) {
        MarkerOptions options = MarkerOptions.newInstance();
        options.setDraggable(false);
        options.setTitle(text);
        Icon icon = Icon.newInstance(highlighted ? baseIconHighlighted : baseIconNormal);
        icon.setImageURL(url);
        options.setIcon(icon);
        return options;
    }
}
