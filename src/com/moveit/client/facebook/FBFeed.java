package com.moveit.client.facebook;

import com.google.gwt.user.client.ui.Image;
import com.moveit.client.facebook.entities.Attachment;
import com.moveit.client.facebook.entities.Media;

/**
 *
 */
public class FBFeed {
    private String feedText;
    private String feedTitle;
    private Attachment attachment;


    public FBFeed(String feedText, String feedTitle, String link, Image img, String attMessage, String attTitle, String attPart1, String attPart2) {
        this.feedText = feedText;
        this.feedTitle = feedTitle;
        attachment = Attachment.newInstance();
        attachment.setName(attTitle);
        attachment.setCaption(attMessage);
        attachment.setHref(link);
        attachment.addProperty(attPart1, attPart2, link);

        Media m1 = Media.newInstance(Media.Type.image, img.getUrl(), link);
        attachment.addMedia(m1);
    }

    public String getFeedText() {
        return feedText;
    }

    public String getFeedTitle() {
        return feedTitle;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}
