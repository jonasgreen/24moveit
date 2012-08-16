package com.moveit.client.language;

/**
 *
 */
public class LAllAbout extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LAllAbout() {
    }

    public LAllAbout(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LAllAbout HOW_DOES_IT_WORK = new LAllAbout("Hvordan virker det?", "How does it work?", "", "");
    public static LAllAbout HELP = new LAllAbout("Hjælp", "Help", "", "");
    public static LAllAbout TIPS = new LAllAbout("Tips", "Tips", "", "");
    public static LAllAbout CONTACT = new LAllAbout("Kontakt", "Contact", "", "");
    public static LAllAbout SEARCH_FOR_JOBS = new LAllAbout("Søgning efter flyttejobs", "Search for relocation jobs", "", "");

}