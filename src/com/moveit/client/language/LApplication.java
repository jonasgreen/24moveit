package com.moveit.client.language;


/**
 *
 */
public class LApplication extends LanguagePage{
    private static final long serialVersionUID = -6078637115142306757L;

    public LApplication() {
    }

    public LApplication(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LApplication TITLE = new LApplication("24moveit - den eneste 100% gratis flytteportal", "24moveit - the only 100% free moving portal", " ", "");
}