package com.moveit.client.guicomponents;

import com.google.gwt.user.client.ui.Image;

/**
 *
 */
public class ImageComponent extends GuiComponent {

    private final Image image;

    public ImageComponent(String url) {
        super();
        image = new Image(url);
        initWidget(image);
    }


    public Image getImage() {
        return image;
    }
}
