package com.moveit.client.language;

/**
 *
 */
public class LAdd extends LanguagePage{
    private static final long serialVersionUID = 8980625717118350326L;

    public LAdd() {
    }

    public LAdd(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LAdd TITLE_1_WHO = new LAdd("1. Hvem vil du modtage tilbud fra?", "", "", "");
    public static LAdd TITLE_2_FROM = new LAdd("2. Hvorfra skal det flyttes?", "1. Moving from", "", "");
    public static LAdd TITLE_3_TO = new LAdd("3. Hvortil skal det flyttes?", "2. Moving to", "", "");
    public static LAdd TITLE_4_WHO = new LAdd("4. Hvornår skal det flyttes?", "3. Moving date", "", "");
    public static LAdd TITLE_5_WHO = new LAdd("5. Hvad skal flyttes?", "4. What needs to be moved?", "", "");


    public static LAdd I_WISH_OFFERS = new LAdd("Jeg ønsker at modtage tilbud via", "I prefer to receive quotes by",  "", "");
    

    public static LAdd SAVE_BUTTON = new LAdd("Gem", "Save",  "", "");

    public static LAdd REMEMBER_TO_SAVE = new LAdd("HUSK AT GEMME - din flytning er ikke gemt endnu.", "REMEMBER TO SAVE - your relocation has not been saved yet.",  "", "");

    public static LAdd ACCOUNT_NEEDED = new LAdd("Du skal ha' en brugerkonto for at kunne oprette en flytning.", "You need an account to enter a relocation.",  "", "");

    public static LAdd SAVED_WITH_SUCCES_1 = new LAdd("Gemt med succes", "Saved succesfully",  "", "");
    public static LAdd SAVED_WITH_SUCCES_2 = new LAdd("Dine oplysninger er gemt, du vil blive kontaktet med tilbud.", "Your information have been saved, companies will contact you with offers.",  "", "");
    public static LAdd SAVED_WITH_SUCCES_3 = new LAdd("Ønsker du at slå dit flytteønske op på din facebook væg?", "You can puplish your request on your facebook wall if you like?",  "", "");

    public static LAdd TO_ADDRESS_NOT_IDENTIFIED = new LAdd("Til-adressen kunne ikke identificeres.", "Unable to identify the to-address",  "", "");
    public static LAdd FROM_ADDRESS_NOT_IDENTIFIED = new LAdd("Fra-adressen kunne ikke identificeres.", "Unable to identify the from-address",  "", "");

    public static LAdd VALIDATE_FROM_ADDRESS = new LAdd("Validerer fra-adresse", "Validating to-address",  "", "");
    public static LAdd VALIDATE_TO_ADDRESS = new LAdd("Validerer til-adresse", "Validating from-address",  "", "");

    public static LAdd SAVE_ERROR = new LAdd("Kunne ikke gemme data", "Unable to save",  "", "");


    public static LAdd ADDRESS_ERROR = new LAdd("Ugyldig adresse", "Unvalid address",  "", "");
    public static LAdd TRY_STREET_NAME = new LAdd("Prøv at indtaste vejnavn.", "Add street",  "", "");
    public static LAdd CHECK_POSTAL_CODE = new LAdd("Tjek at postnummer og vejnavn er korrekt.", "Validate that postal code and street is correct.",  "", "");

}