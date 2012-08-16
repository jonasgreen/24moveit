package com.moveit.client.language;

/**
 *
 */
public class LContactInfoPanel extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LContactInfoPanel() {
    }

    public LContactInfoPanel(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LContactInfoPanel NAME = new LContactInfoPanel("Navn:", "Name:", "", "");
    public static LContactInfoPanel PHONE = new LContactInfoPanel("Tlf.nr:", "Phone:", "", "");
    public static LContactInfoPanel EMAIL = new LContactInfoPanel("Email:", "Email:", "", "");



    public static LContactInfoPanel LOGIN = new LContactInfoPanel("Log på", "Log in", "", "");
    public static LContactInfoPanel CONTACTINFO_NOT_FOUND = new LContactInfoPanel("Ku ikke finde kontaktinfo - måske er udbuddet slettet.", "Could not find contact info - maybe the request is deleted.", "", "");
    public static LContactInfoPanel CONTACTINFO_LOGIN_NEEDED = new LContactInfoPanel("Du skal være logget ind for at se kontaktinfo.", "You need to log in to see contact info.", "", "");

    public static LContactInfoPanel CONTACTINFO_LOGIN_AS_HAULIER_NEEDED = new LContactInfoPanel("Du skal være logget ind som vognmand for at se kontaktinfo på dette flytteønske.", "You need to log in as a haulier to see contact info on this request.", "", "");

    public static LContactInfoPanel CONTACTINFO_LOGIN_AS_HAULIER_NEEDED_BY_OWNER = new LContactInfoPanel("Udbyderen har valgt, at kontaktinfo kun vises for vognmænd.", "You need to log in as a haulier to see contact info on this request.", "", "");

    public static LContactInfoPanel CONTACTINFO_LOGIN_AS_HAULIER_AND_DMF_NEEDED = new LContactInfoPanel("Du skal være logget ind som vognmand og medlem af DMF for at se kontaktinfo på dette flytteønske.", "You need to log in as a danish haulier to see contact info on this request.", "", "");
    public static LContactInfoPanel CONTACTINFO_LOGIN_AS_HAULIER_AND_DMF_NEEDED_BY_OWNER = new LContactInfoPanel("Udbyderen har valgt, at kontaktinfo kun vises for vognmænd, som er medlem af DMF.", "You need to log in as a danish haulier to see contact info on this request.", "", "");





}