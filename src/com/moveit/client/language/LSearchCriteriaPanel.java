package com.moveit.client.language;


/**
 *
 */
public class LSearchCriteriaPanel extends LanguagePage{
    private static final long serialVersionUID = 4611511556659687648L;

    public LSearchCriteriaPanel() {
    }

    public LSearchCriteriaPanel(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LSearchCriteriaPanel FROM = new LSearchCriteriaPanel("Flytninger fra området", "Relocations from area", "", "");
    public static LSearchCriteriaPanel TO = new LSearchCriteriaPanel("Flytninger til området", "Relocations to area", "", "");



    public static LSearchCriteriaPanel FROM_DATE = new LSearchCriteriaPanel("Fra", "From", "", "");
    public static LSearchCriteriaPanel TO_DATE = new LSearchCriteriaPanel("Til", "To", "", "");
    public static LSearchCriteriaPanel RADIUS = new LSearchCriteriaPanel("Radius", "Radius", "", "");

    public static LSearchCriteriaPanel SHOW_ADJUSTMENTS = new LSearchCriteriaPanel("Vis søgeindstillinger", "Show search settings", "", "");
    public static LSearchCriteriaPanel HIDE_ADJUSTMENTS = new LSearchCriteriaPanel("Skjul søgeindstillinger", "Hide search settings", "", "");

    public static LSearchCriteriaPanel SEARCH_HELP = new LSearchCriteriaPanel("Søgehjælp", "Search help", "", "");
    public static LSearchCriteriaPanel SEARCH_BUTTON = new LSearchCriteriaPanel("Søg", "Search", "", "");

    public static LSearchCriteriaPanel AREA = new LSearchCriteriaPanel("Området", "Area", "", "");

    public static LSearchCriteriaPanel RADIUS_0 = new LSearchCriteriaPanel("Radius", "Radius", "", "");

    public static LSearchCriteriaPanel IN_THE_PERIOD = new LSearchCriteriaPanel("I perioden:", "In the period:", "", "");


}