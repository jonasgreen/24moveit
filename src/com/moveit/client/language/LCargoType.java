package com.moveit.client.language;

/**
 *
 */
public class LCargoType extends LanguagePage{
    private static final long serialVersionUID = -8371292055819696415L;


    public LCargoType() {
    }

    public LCargoType(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LCargoType FURNITURE = new LCargoType("Møbler/indbo", "Furniture", "", "");
    public static LCargoType FREEZE = new LCargoType("Køl/frys", "Refrigerated goods", "", "");
    public static LCargoType STONE_SAND = new LCargoType("Jord/sten/sand", "Dirt/sand/gravel", "", "");
    public static LCargoType DANGER = new LCargoType("Farligt gods", "Dangerous goods", "", "");
    public static LCargoType ANIMALS = new LCargoType("Dyr", "Live stock", "", "");
    public static LCargoType OTHER = new LCargoType("Andet/diverse" , "Other", "", "");


}