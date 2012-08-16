package com.moveit.client.language;

/**
 *
 */
public class LMoverType extends LanguagePage{
    private static final long serialVersionUID = -8371292055819696415L;

    public LMoverType(){

    }

    public LMoverType(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LMoverType BASIS = new LMoverType("Basis", "", "", "");
    public static LMoverType PRO = new LMoverType("Pro", "", "", "");
    public static LMoverType EXCLUSIVE = new LMoverType("Exclusive", "", "", "");


}