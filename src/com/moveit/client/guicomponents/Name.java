package com.moveit.client.guicomponents;

/**
 *
 */
public enum Name {


//OBS - ingen bindestreger - erstattes af camelCase

    ALIGN("align"),

    BACKGROUND("background"),

    BORDER("border"),
    BORDER_COLOR("borderColor"),
    BORDER_STYLE("borderStyle"),
    BORDER_BOTTOM("borderBottom"),
    BORDER_LEFT("borderLeft"),
    BORDER_RIGHT("borderRight"),
    BORDER_TOP("borderTop"),
    BORDER_WIDTH("borderWidth"),

    COLOR("color"),
    COLSPAN("colspan"),

    DISPLAY("display"),

    FILTER("filter"),

    FLOATING("float"),
    FONT_FAMILY("fontFamily"),
    FONT_SIZE("fontSize"),
    FONT_SIZE_ADJUST("fontSizeAdjust"),
    FONT_STRETCH("fontStretch"),
    FONT_STYLE("fontStyle"),
    FONT_VARIANT("fontVariant"),
    FONT_WEIGHT("fontWeight"),


    FOREGROUND("foreground"),

    HEIGHT("height"),
    HORIZONTAL_ALIGN("horizontalAlign"),

    LEFT("left"),
    LINE_HEIGHT("lineHeight"),

    MARGIN("margin"),
    MARGIN_LEFT("marginLeft"),
    MARGIN_RIGHT("marginRight"),
    MARGIN_Bottom("marginBottom"),    
    MARGIN_TOP("marginTop"),

    OPACITY("opacity"),
    OVERFLOW("overflow"),

    PADDING("padding"),
    PADDING_LEFT("paddingLeft"),
    PADDING_RIGHT("paddingRight"),

    PADDING_TOP("paddingTop"),
    PADDING_Bottom("paddingBottom"),

    POSITION("position"),



    RIGHT("right"),

    TEXT_ALIGN("textAlign"),
    TEXT_DECORATION("textDecoration"),

    TOP("top"),

    VERTICAL_ALIGN("verticalAlign"),
    WHITE_SPACE("whiteSpace"),
    WIDTH("width"),

    X_SYSTEM_FONT("xSystemFont"),

    Z_INDEX("zIndex");

    private final String name;


    Name(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public boolean isFontSize() {
        return name.equals(Name.FONT_SIZE.getName());
    }


    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
