package com.moveit.client.guicomponents;

/**
 *
 */
public class ColorButtonFactory {

    private static String bluelight_180x60 = "bluelight_180x60";
    private static String bluelight_90x60 = "bluelight_90x60";
    private static String purple_90x60 = "purple_90x60";
    private static String orange_90x60 = "orange_90x60";


    public static ColorButton getBlue180x60(String text) {
        return new ColorButton(text, "180px", "60px", bluelight_180x60);
    }

    public static ColorButton getBlue90x60(String text) {
        return new ColorButton(text, "90px", "60px", bluelight_90x60);
    }

    public static ColorButton getOrange90x60(String text) {
        return new ColorButton(text, "90px", "60px", orange_90x60);
    }

    public static ColorButton getPurple90x60(String text) {
        return new ColorButton(text, "90px", "60px", purple_90x60);
    }

}