package com.moveit.client.language;

/**
 *
 */
public class LQuoteType extends LanguagePage{
    private static final long serialVersionUID = -8371292055819696415L;


    public LQuoteType() {
    }

    public LQuoteType(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LQuoteType EMAIL_AND_PHONE = new LQuoteType("Telefon og mail", "Phone and mail", "", "");
    public static LQuoteType EMAIL = new LQuoteType("Email", "Email", "", "");
    public static LQuoteType PHONE = new LQuoteType("Telefon", "Phone", "", "");


}