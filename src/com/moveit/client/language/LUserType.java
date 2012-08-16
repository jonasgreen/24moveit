package com.moveit.client.language;

/**
 *
 */
public class LUserType extends LanguagePage{
    private static final long serialVersionUID = -8371292055819696415L;

    public LUserType() {
    }

    public LUserType(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LUserType CUSTOMER = new LUserType("Alm. bruger som skal ha' flyttet noget", "", "", "");
    public static LUserType DRIVER = new LUserType("Vognmand/Fragtmand", "", "", "");
    public static LUserType DRIVER_DMF = new LUserType("Vognmand/Fragtmand medlem af DMF", "", "", "");


}