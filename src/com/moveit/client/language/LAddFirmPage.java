package com.moveit.client.language;

/**
 *
 */
public class LAddFirmPage extends LanguagePage {
    private static final long serialVersionUID = 4611511556659687648L;

    public LAddFirmPage() {
    }

    public LAddFirmPage(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LAddFirmPage VAT = new LAddFirmPage("CVR-nr.", "VAT number", "", "");

    public static LAddFirmPage FIRM_NAME = new LAddFirmPage("Firmanavn", "Company name", "", "");
    public static LAddFirmPage WEB_SITE = new LAddFirmPage("Webside", "Web site", "", "");

    //contactperson
    public static LAddFirmPage NAME = new LAddFirmPage("Navn", "Name", "", "");
    public static LAddFirmPage PHONE = new LAddFirmPage("Tlf.nr", "Phone", "", "");
    public static LAddFirmPage EMAIL = new LAddFirmPage("Email", "Email", "", "");
    public static LAddFirmPage PASS = new LAddFirmPage("Password", "Password", "", "");
    public static LAddFirmPage REPEAT_PASS = new LAddFirmPage("Gentag pass", "Repeat pass", "", "");


    public static LAddFirmPage TIPS_START = new LAddFirmPage("Det er <b>100% gratis</b> for dig at tilmelde dit vognmandsfirma. Bagefter får du:", "To register your moving company is <b>completely free</b>. After registration you will get:", "", "");
    public static LAddFirmPage TIPS_1 = new LAddFirmPage("<b>1) Adgang til folks flytteønsker</b>, så du kan kontakte dem med tilbud.", "<b>1) Access to people's requests</b> so that you can contact them with quotes.", "", "");
    public static LAddFirmPage TIPS_2 = new LAddFirmPage("<b>2) Information om nye flytteønsker</b>, via mail.", "<b>2) Information about new requests</b> via email.", "", "");
    public static LAddFirmPage TIPS_3 = new LAddFirmPage("<b>3) Ruteplanlægningsværktøj</b>. Optimér dine ruter og undgå tomme læs.", "<b>3) Online route planner tool</b>. Optimize your routes and avoid empty loads.", "", "");


    public static LAddFirmPage TITLE_1_BASIS = new LAddFirmPage("1. Grundlæggende oplysninger", "1. Basic company information", "", "");
    public static LAddFirmPage TITLE_2_ADDRESS = new LAddFirmPage("2. Firmaadresse", "2. Company address", "", "");
    public static LAddFirmPage TITLE_3_PERSON = new LAddFirmPage("3. Kontaktperson hos firma", "3. Contact person at company", "", "");


    public static LAddFirmPage I_WISH_OFFERS = new LAddFirmPage("Jeg vil gerne informeres om nye flyttejobs via mail.", "I would like to receive new requests via email.", "", "");
    public static LAddFirmPage I_WISH_NEWS = new LAddFirmPage("Jeg vil gerne modtage nyheder o.l. via mail.", "I would like to receive news, via email.", "", "");

    public static LSignUp USING_CONDITIONS_1 = new LSignUp("Ja, jeg accepterer 24moveits", "Yes, I accept 24moveit's", "", "");
    public static LSignUp USING_CONDITIONS_2 = new LSignUp("brugsbetingelser", "terms of use", "", "");
    public static LSignUp USING_CONDITIONS_LINK = new LSignUp("http://www.24moveit.com/terms_da.html", "http://www.24moveit.com/terms_eng.html", "", "");


    public static LAddFirmPage SAVE_BUTTON = new LAddFirmPage("Gem", "Save", "", "");

    public static LAddFirmPage FIRM_ADDED_WITH_SUCCES_1 = new LAddFirmPage("Firma succesfuldt tilmeldt", "Succesfully registration of company", "", "");

    public static LAddFirmPage FIRM_ADDED_WITH_SUCCES_2 = new LAddFirmPage("Tak fordi du tilmeldte dit firma. Du er nu logget ind som ", "Thank you for registrating your company at 24moveit. You are now logged in as ", "", "");
    public static LAddFirmPage FIRM_ADDED_WITH_SUCCES_3 = new LAddFirmPage("Du kan nu gratis benytte de service som 24moveit stiller til rådighed.", "Now you can freely use 24moveit and all its services.", "", "");
    public static LAddFirmPage FIRM_ADDED_WITH_SUCCES_4 = new LAddFirmPage("Du omdirigeres til forsiden.", "You will be redirected to the front page.", "", "");




}