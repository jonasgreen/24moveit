package com.moveit.client.guicomponents;

import java.io.Serializable;

/**
 *
 */
public class P implements Serializable{
    private static final long serialVersionUID = 1289863916204902239L;

    public static P BACKGROUND_WHITE = new P(Name.BACKGROUND, "white");
    public static P BACKGROUND_WHITE_DARKER = new P(Name.BACKGROUND, "#F3F3F3");

    public static P BACKGROUND_BLUE_LINK = new P(Name.BACKGROUND, "#035e81");
    public static P COLOR_BLUE_LINK = new P(Name.COLOR, "#035e81");
    public static P COLOR_MENU_TOP = new P(Name.COLOR, "#0582B3");


    public static P BACKGROUND_C1 = new P(Name.BACKGROUND, "#C1C1C1");
    public static P BACKGROUND_D1 = new P(Name.BACKGROUND, "#D1D2D4");
    public static P BACKGROUND_E1 = new P(Name.BACKGROUND, "#E1E2E3");
    public static P BACKGROUND_BLUE_LOGO = new P(Name.BACKGROUND, "#0099D3");


    public static P BACKGROUND_MENU_TOP = new P(Name.BACKGROUND, "#0582B3");


    public static P BACKGROUND_BLUE = new P(Name.BACKGROUND, "#54A2D8");
    public static P BACKGROUND_BLUE_LIGHT = new P(Name.BACKGROUND, "#74C2F8");
    public static P BACKGROUND_BLUE_TIPS = new P(Name.BACKGROUND, "#A8CFEB");



    public static P BACKGROUND_BACK_PANEL = BACKGROUND_WHITE;//BACKGROUND_E1;
    public static P BACKGROUND_MENU_ORANGE = new P(Name.BACKGROUND, "#FF5a00");
    public static P BACKGROUND_MENU_ORANGE_LIGHT = new P(Name.BACKGROUND, "#FF8B4D");


    public static P BACKGROUND_CARGO_ONE = new P(Name.BACKGROUND, "#DDE8EF");
    public static P BACKGROUND_CARGO_TWO = new P(Name.BACKGROUND, "#c7ddeb");


    public static P BACKGROUND_FRONT_GREEN = new P(Name.BACKGROUND, "#00B883");
    public static P BACKGROUND_FRONT_BLUE = new P(Name.BACKGROUND, "#33BFE8");
    public static P BACKGROUND_FRONT_ORANGE = new P(Name.BACKGROUND, "#F07F4D");

    public static P BACKGROUND_MARKER_BLUE = new P(Name.BACKGROUND, "#6E9AFB");
    public static P BACKGROUND_MARKER_GREEN = new P(Name.BACKGROUND, "#95E581");
    public static P BACKGROUND_MARKER_BROWN = new P(Name.BACKGROUND, "#C79E82");
    public static P BACKGROUND_MARKER_RED = new P(Name.BACKGROUND, "#F77B72");
    public static P BACKGROUND_MARKER_PINK = new P(Name.BACKGROUND, "#F6ABFB");
    public static P BACKGROUND_MARKER_ORANGE = new P(Name.BACKGROUND, "#F69016");



    public static P BACKGROUND_YELLOW = new P(Name.BACKGROUND, "#F6E84A");
    public static P BACKGROUND_YELLOW_DARK = new P(Name.BACKGROUND, "#FFD300");




    public static P BACKGROUND_BLACK = new P(Name.BACKGROUND, "black");


    public static P BACKGROUND_DARK_GREY = new P(Name.BACKGROUND, "#9A9999");

    public static P BACKGROUND_GREY = new P(Name.BACKGROUND, "#E7E7DE");
    public static P BACKGROUND_GREY_YELLOW = new P(Name.BACKGROUND, "#F1F3E8");
    public static P BACKGROUND_GREY_YELLOW_DARK = new P(Name.BACKGROUND, "#cfcfc6");


    public static P BACKGROUND_LIGHT_BLUE = new P(Name.BACKGROUND, "#E0ECFF");
    public static P BACKGROUND_ORANGE = new P(Name.BACKGROUND, "#FF5A00");


    public static P BACKGROUND_PURPLE = new P(Name.BACKGROUND, "#E1007A");

    public static P BACKGROUND_RED = new P(Name.BACKGROUND, "#FF4100");

    public static P BACKGROUND_DARK_RED = new P(Name.BACKGROUND, "#CC0000");

    public static P BORDER_BOTTOM_SOLID = new P(Name.BORDER_BOTTOM, "solid");
    public static P BORDER_LEFT_SOLID = new P(Name.BORDER_LEFT, "solid");
    public static P BORDER_RIGHT_SOLID = new P(Name.BORDER_RIGHT, "solid");
    public static P BORDER_TOP_SOLID = new P(Name.BORDER_TOP, "solid");


    public static P BORDER_STYLE_SOLID = new P(Name.BORDER_STYLE, "solid");
    public static P BORDER_WIDTH_1px = new P(Name.BORDER_WIDTH, "1px");

    public static P BORDER_WIDTH_2px = new P(Name.BORDER_WIDTH, "2px");
    public static P BORDER_TOP_SOLID_2px_999 = new P(Name.BORDER_TOP, "2px solid #727272");


    public static P COLOR_C1 = new P(Name.COLOR, "#C1C1C1");
    public static P COLOR_4D = new P(Name.COLOR, "#4D4D4D");
    public static P COLOR_BLUE_LOGO = new P(Name.COLOR, "#0099D3");

    public static P COLOR_BLACK = new P(Name.COLOR, "#000000");

    public static P COLOR_GREY_LIGHT = new P(Name.COLOR, "#E7E7DE");


    public static P COLOR_BLUE = new P(Name.COLOR, "#54A2D8");
    public static P COLOR_BLUE_DARK = new P(Name.COLOR, "#4492C8");

    public static P COLOR_BLUE_LIGHT = new P(Name.COLOR, "#74C2F8");

    public static P COLOR_DARK_GREY = new P(Name.COLOR, "#9A9999");
    public static P COLOR_DARK_GREY_2 = new P(Name.COLOR, "#4D4D4D");

    public static P COLOR_GREEN = new P(Name.COLOR, "#A2CC4E");

    public static P COLOR_GREY = new P(Name.COLOR, "#999999");
    public static P COLOR_GREY_YELLOW = new P(Name.COLOR, "#F1F3E8");
    public static P COLOR_GREY_F8 = new P(Name.COLOR, "#F8F8F8");
    public static P COLOR_GREY_TOP = new P(Name.COLOR, "#787976");


    public static P COLOR_WHITE = new P(Name.COLOR, "white");
    public static P COLOR_LIGHT_BLUE = new P(Name.COLOR, "#E0ECFF");

    public static P COLOR_PURPLE = new P(Name.COLOR, "E0007A");
    public static P COLOR_DARK_RED = new P(Name.COLOR, "#CC0000");

    public static P COLOR_RED = new P(Name.COLOR, "red");
    public static P COLOR_ORANGE = new P(Name.COLOR, "#FF5A00");
    public static P COLOR_YELLOW = new P(Name.COLOR, "#F6E84A");

    public static P FONT_FAMILY_ARIAL_HELV_SANS = new P(Name.FONT_FAMILY, "Arial,Helvetica,sans-serif");

    public static P FONT_SIZE_2_5EM = new P(Name.FONT_SIZE, "2.5em");
    public static P FONT_SIZE_1_9EM = new P(Name.FONT_SIZE, "2.0em");

    public static P FONT_SIZE_1_6EM = new P(Name.FONT_SIZE, "1.6em");

    public static P FONT_SIZE_1_5EM = new P(Name.FONT_SIZE, "1.5em");

    public static P FONT_SIZE_1_4EM = new P(Name.FONT_SIZE, "1.4em");

    public static P FONT_SIZE_1_3EM = new P(Name.FONT_SIZE, "1.3em");
    public static P FONT_SIZE_1_2EM = new P(Name.FONT_SIZE, "1.2em");

    public static P FONT_SIZE_1_1EM = new P(Name.FONT_SIZE, "1.1em");
    public static P FONT_SIZE_1_0EM = new P(Name.FONT_SIZE, "1.0em");
    public static P FONT_SIZE_0_9EM = new P(Name.FONT_SIZE, "0.9em");

    public static P FONT_SIZE_0_75EM = new P(Name.FONT_SIZE, "0.75em");
    public static P FONT_SIZE_0_65EM = new P(Name.FONT_SIZE, "0.65em");


    public static P FONT_SIZE_ADJUST_NONE = new P(Name.FONT_SIZE_ADJUST, "none");
    public static P FONT_STRETCH_NORMAL = new P(Name.FONT_STRETCH, "normal");
    public static P FONT_STYLE_NORNAL = new P(Name.FONT_STYLE, "normal");
    public static P FONT_VARIANT_NORMAL = new P(Name.FONT_VARIANT, "normal");
    public static P FONT_WEIGHT_BOLD = new P(Name.FONT_WEIGHT, "bold");
    public static P FONT_WEIGHT_NORMAL = new P(Name.FONT_WEIGHT, "normal");

    public static P LINE_HEIGHT_1_25 = new P(Name.LINE_HEIGHT, "1.25");

    public static P TEXT_ALIGN_CENTER = new P(Name.TEXT_ALIGN, "center");
    public static P TEXT_DECORATION_UNDERLINE = new P(Name.TEXT_DECORATION, "underline");
    public static P TEXT_ALIGN_JUSTIFY = new P(Name.TEXT_ALIGN, "justify");
    public static P VERTICAL_ALIGN_MIDDLE =new P(Name.VERTICAL_ALIGN, "middle");

    public static P NO_WRAP = new P(Name.WHITE_SPACE, "nowrap");

    public static P X_SYSTEM_FONT_NONE = new P(Name.X_SYSTEM_FONT, "none");


    private Name name;
    private String value;

    public P(Name name, String value) {
        this.name = name;
        this.value = value;
    }

    public Name getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isFontSize() {
        return name.isFontSize();
    }


    @Override
    public String toString() {
        return "P{" +
                "name='" + name.getName() + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


}
