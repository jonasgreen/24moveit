package com.moveit.client.language;

/**
 *
 */
public class LAddress extends LanguagePage{
    private static final long serialVersionUID = -1610681048125225494L;

    public LAddress() {
    }

    public LAddress(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LAddress STREET = new LAddress("Vejnavn, nr, sal", "Street, No.", "", "");
    public static LAddress POSTCODE = new LAddress("Postnummer", "Postal/zip code", "", "");
    public static LAddress CITY = new LAddress("By", "City", "", "");

    public static LAddress COUNTRY = new LAddress("Land", "Country", "", "");
    public static LAddress COUNTRY_TIP = new LAddress("OBS! landene står på engelsk", null, "", "");

    public static LAddress UNVALID_ADDRESS_TRY_WITH_1 = new LAddress("Adressen kunne ikke identificeres.", "The address is not valid.", "", "");
    public static LAddress UNVALID_ADDRESS_TRY_WITH_1_TO = new LAddress("Til-adressen kunne ikke identificeres.", "The 'to' address is not valid.", "", "");
    public static LAddress UNVALID_ADDRESS_TRY_WITH_1_FROM = new LAddress("Fra-adressen kunne ikke identificeres.", "The 'from' address is not valid.", "", "");

    public static LAddress UNVALID_ADDRESS_TRY_WITH_2 = new LAddress("Prøv eventuelt med følgende format:", "Try with the following format:", "", "");
    public static LAddress UNVALID_ADDRESS_TRY_WITH_3 = new LAddress("vejnavn, by, postnummer, land.", "street, city, zip code, country.", "", "");

    public static LAddress MULTIPLE_ADDRESS_FOUND = new LAddress("Flere addresser fundet", "Multiple addresses found", "", "");
    public static LAddress CHOOSE_ONE_OR_TRY_WITH = new LAddress("Vælg en elller prøv eventuelt igen med følgende format:", "Choose one or try again with the following format:", "", "");

    public static LAddress MULTIPLE_ADDRESS_FOUND_TO = new LAddress("Til-addressen kunne ikke identificeres entydigt - vælg én.", "The 'to' address is not unique - choose one.", "", "");
    public static LAddress MULTIPLE_ADDRESS_FOUND_FROM = new LAddress("Fra-addressen kunne ikke identificeres entydigt - vælg én.", "The 'from' address is not unique - choose one.", "", "");


}