package com.moveit.client.language;

/**
 *
 */
public class LMailList extends LanguagePage{
    private static final long serialVersionUID = -8371292055819696415L;

    public LMailList() {
    }

    public LMailList(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LMailList NEWS = new LMailList("Nyheder", "News", "", "");
    public static LMailList NEW_ROUTES = new LMailList("Nye ruter", "", "", "");


}