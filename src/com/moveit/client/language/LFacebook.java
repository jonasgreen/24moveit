package com.moveit.client.language;

/**
 *
 */
public class LFacebook extends LanguagePage{
    private static final long serialVersionUID = 8980625717118350326L;

    public LFacebook() {
    }

    public LFacebook(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LFacebook FEED_TITLE = new LFacebook("Dit flytteønske", "Your relocation request", "", "");
    public static LFacebook ATT_MESSAGE = new LFacebook("24moveit skaber synergi mellem flyttemænd og kunder.\nDu får den billigste flytning på markedet og vognmanden får færre tomme læs.",
            "24moveit is devoted to achieve synergy between customers and movers, You get the cheapest offer in the market and the moving company avoids empty loads.", "", "");
    public static LFacebook ATT_TITLE = new LFacebook("Eneste 100% gratis flytteportal", "The only 100% free relocation portal", "", "");
    public static LFacebook ATT_PART1 = new LFacebook("Skal du ha noget flyttet?", "Need to move something?", "", "");
    public static LFacebook ATT_PART2 = new LFacebook("Få GRATIS og uforpligtende tilbud her.", "Get FREE quotes here.", "", "");
    public static LFacebook ATT_MESSEAGE_START = new LFacebook("Har opslået et flytteønske på 24moveit: ", "Has requested free moving quotes on 24moveit: ", "", "");


    public static LFacebook INFO_CONNECTING = new LFacebook("Forbinder til Facebook", "Connecting to Facebook", "", "");
    public static LFacebook INFO_FACEBOOK_SUCCES = new LFacebook("Flytteønske publiseret på din facebookvæg", "Request published on your facebook wall", "", "");

}

