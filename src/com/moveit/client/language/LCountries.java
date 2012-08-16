package com.moveit.client.language;

/**
 *
 */
public class LCountries extends LanguagePage{
    private static final long serialVersionUID = 8980625717118350326L;

    public LCountries() {
    }

    public LCountries(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    

    //Verdensdele
    public static LCountries AFRICA = new LCountries("Afrika", "Africa",  "", "");
    public static LCountries EUROPE = new LCountries("Europa", "Europe",  "", "");
    public static LCountries ASIA = new LCountries("Europa", "Europe",  "", "");
    public static LCountries NORTH_AMERICA = new LCountries("Europa", "Europe",  "", "");
    public static LCountries SOUTH_AMERICA = new LCountries("Europa", "Europe",  "", "");
    //


    public static LCountries AUSTRALIA = new LCountries("Australien", "Australia",  "", "");

    public static LCountries DENMARK = new LCountries("Danmark", "Denmark",  "", "");

    public static LCountries FRANCE = new LCountries("Frankrig", "France",  "", "");

    public static LCountries GERMANY = new LCountries("Tyskland", "Germany",  "", "");


    public static LCountries INDIA = new LCountries("Indien", "India",  "", "");

    public static LCountries NEW_ZEALAND = new LCountries("New Zealand", "New Zealand",  "", "");
    public static LCountries NORWAY = new LCountries("Norge", "Norway",  "", "");

    public static LCountries SPAIN = new LCountries("Spanien", "Spain",  "", "");
    public static LCountries SWEDEN = new LCountries("Sverige", "Sweden",  "", "");

    public static LCountries UK = new LCountries("United Kingdom", "",  "United Kingdom", "");
    public static LCountries USA = new LCountries("Danmark", "Denmark",  "", "");

    public static LCountries SOUTH_AFRICA = new LCountries("Sydafrika", "South Africa",  "", "");



}