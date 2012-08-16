package com.moveit.client.language;

/**
 *
 */
public class LSignUp extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LSignUp() {
    }

    public LSignUp(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LSignUp TITLE = new LSignUp("Opret en gratis brugerkonto", "Create a free account", "", "");
    public static LSignUp HAULIER_LINK = new LSignUp("Er du vognmand? Tilmeld dit firma her", "Are you a haulier? Register your company here", "", "");
    public static LSignUp NAME = new LSignUp("Navn", "Name", "", "");
    public static LSignUp PHONE = new LSignUp("Tlf.nr", "Phone", "", "");
    public static LSignUp EMAIL = new LSignUp("Email", "Email", "", "");
    public static LSignUp PASSWORD = new LSignUp("Password", "Password", "", "");
    public static LSignUp PASSWORD_AGAIN = new LSignUp("Gentag Pass.", "Retype Pass.", "", "");

    public static LSignUp REMEMBER_ME = new LSignUp("Husk mig", "Remember me", "", "");

    public static LSignUp ACCEPT_NEWS = new LSignUp("Jeg vil gerne modtage nyheder o.l. via mail.", "I would like to be informed about news, etc. by mail.", "", "");

    public static LSignUp USING_CONDITIONS_1 = new LSignUp("Ja, jeg accepterer 24moveits", "Yes, I accept 24moveits", "", "");
    public static LSignUp USING_CONDITIONS_2 = new LSignUp("brugsbetingelser", "terms of use", "", "");
    public static LSignUp USING_CONDITIONS_LINK = new LSignUp("http://www.24moveit.com/terms_da.html", "http://www.24moveit.com/terms_eng.html", "", "");

    public static LSignUp ALREADY_HAVE_ACCOUNT = new LSignUp("Jeg har allerede en konto", "I already have an account", "", "");
    public static LSignUp CREATE_BUTTON = new LSignUp("Opret", "Create", "", "");
    public static LSignUp ACCOUNT_CREATED = new LSignUp("Brugerkonto oprettet", "User account succesfully created", "", "");



}