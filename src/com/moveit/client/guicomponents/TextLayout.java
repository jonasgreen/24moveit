package com.moveit.client.guicomponents;

/**
 *
 */
public class TextLayout extends Layout17 {


    public static Css FONT_BASIS = new Css(
            P.X_SYSTEM_FONT_NONE,
            P.FONT_FAMILY_ARIAL_HELV_SANS,
            P.FONT_STRETCH_NORMAL,
            P.FONT_STYLE_NORNAL,
            P.FONT_VARIANT_NORMAL,
            P.FONT_WEIGHT_NORMAL,
            P.LINE_HEIGHT_1_25);

    public TextLayout() {
        super();
    }

    public TextLayout(Css css) {
        super(css);
    }

    public TextLayout(P p) {
        super(p);
    }

    public TextLayout(Horizontal alignH) {
        super(alignH);
    }

    public TextLayout(Vertical alignV) {
        super(alignV);
    }

    public TextLayout(String height, String width) {
        super(height, width);
    }

    public TextLayout(Horizontal alignH, Vertical alignV) {
        super(alignH, alignV);
    }

    public TextLayout(String height, String width, Horizontal alignH, Vertical alignV) {
        super(height, width, alignH, alignV);
    }

    public TextLayout(String height, String width, Horizontal alignH) {
        super(height, width, alignH);
    }

    public TextLayout(String height, String width, Vertical alignV) {
        super(height, width, alignV);
    }

    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin) {
        super(topMargin, rightMargin, bottomMargin, leftMargin);
    }

    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, height, width);
    }

    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Horizontal alignH) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, alignH);
    }

    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Vertical alignV) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, alignV);
    }


    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Horizontal alignH) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, height, width, alignH);
    }


    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Vertical alignV) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, height, width, alignV);
    }

    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Horizontal alignH, Vertical alignV) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, alignH, alignV);
    }

    public TextLayout(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Horizontal alignH, Vertical alignV) {
        super(topMargin, rightMargin, bottomMargin, leftMargin, height, width, alignH, alignV);
    }


    public TextLayout sizeTitle() {
        this.add(FONT_BASIS.and(P.FONT_SIZE_2_5EM));
        return this;
    }

    public TextLayout sizeH1() {
        this.add(FONT_BASIS.and(P.FONT_SIZE_1_9EM));
        return this;
    }



    public TextLayout sizeH2() {
        this.add(FONT_BASIS.and(P.FONT_SIZE_1_4EM));
        return this;
    }

    public TextLayout sizeH3() {
        add(FONT_BASIS.and(P.FONT_SIZE_1_1EM));
        return this;
    }

    public TextLayout sizeLargeButton() {
        add(FONT_BASIS.and(P.FONT_SIZE_1_2EM));
        return this;
    }

    //used with normal text - like help site.
    public TextLayout sizeNormal() {
        this.add(FONT_BASIS.and(P.FONT_SIZE_1_0EM));
        return this;
    }

    //used in Menu, labels, small buttons, shorter text messages and lines.
    public TextLayout sizeSmall() {
        add(FONT_BASIS.and(P.FONT_SIZE_0_9EM));
        return this;
    }

    //used for buttons in tables
    public TextLayout sizeEkstraEkstraSmall() {
        add(FONT_BASIS.and(P.FONT_SIZE_0_65EM));
        return this;
    }

    //used at top and bottom pages and popuphelp
    public TextLayout sizeEkstraSmall() {
        add(FONT_BASIS.and(P.FONT_SIZE_0_75EM));
        return this;
    }

    public TextLayout sizeInput() {
        add(FONT_BASIS.and(P.FONT_SIZE_1_4EM));
        return this;
    }

    public TextLayout sizeSearchInput() {
        add(FONT_BASIS.and(P.FONT_SIZE_1_4EM));
        return this;
    }

    public TextLayout borderColor(P color){
        add(Name.BORDER_COLOR, color.getValue());
        return this;
    }

    public TextLayout border(int size) {
        add(P.BORDER_STYLE_SOLID).add(new P(Name.BORDER_WIDTH, size + "px"));
        return this;
    }

    public TextLayout borderTop(int size) {
        add(P.BORDER_TOP_SOLID).add(new P(Name.BORDER_WIDTH, size + "px"));
        return this;
    }

    public TextLayout borderBottom(int size) {
        add(P.BORDER_BOTTOM_SOLID).add(new P(Name.BORDER_WIDTH, size + "px"));
        return this;
    }

    public TextLayout borderRight(int size) {
            add(P.BORDER_RIGHT_SOLID).add(new P(Name.BORDER_WIDTH, size + "px"));
            return this;
        }
    public TextLayout borderLeft(int size) {
            add(P.BORDER_LEFT_SOLID).add(new P(Name.BORDER_WIDTH, size + "px"));
            return this;
        }


    public TextLayout zIndex(int index){
        add(Name.Z_INDEX, String.valueOf(index));
        return this;
    }


    public TextLayout bold() {
        add(P.FONT_WEIGHT_BOLD);
        return this;
    }

    public TextLayout alignRight() {
        add(new P(Name.TEXT_ALIGN, "right"));
        return this;
    }

    public TextLayout alignLeft() {
        add(new P(Name.TEXT_ALIGN, "left"));
        return this;
    }

    public TextLayout alignCenter() {
        add(P.TEXT_ALIGN_CENTER);
        return this;
    }

    public TextLayout paddingLeft(int size) {
        add(Name.PADDING_LEFT, size + "px");
        return this;
    }

    public TextLayout paddingRight(int size) {
        add(Name.PADDING_RIGHT, size + "px");
        return this;
    }

    public TextLayout paddingTop(int size) {
        add(Name.PADDING_TOP, size + "px");
        return this;
    }

    public TextLayout paddingBottom(int size) {
        add(Name.PADDING_Bottom, size + "px");
        return this;
    }

    public TextLayout padding(int top, int right, int bottom, int left) {
        add(Name.PADDING, top + "px "+ right + "px "+ bottom + "px "+ left + "px");
        return this;

    }

    public TextLayout padding(int size) {
        add(Name.PADDING, size + "px");
        return this;
    }



    public TextLayout colorWhite() {
        add(P.COLOR_WHITE);
        return this;
    }

    public TextLayout colorOrange() {
        add(P.COLOR_ORANGE);
        return this;
    }

    public TextLayout colorBlue() {
        add(P.COLOR_BLUE);
        return this;
    }

    public TextLayout colorBlueLink() {
        add(P.COLOR_BLUE_LINK);
        return this;
    }

    public TextLayout colorRed() {
            add(P.COLOR_RED);
            return this;
        }



    public TextLayout colorBlueLogo() {
        add(P.COLOR_BLUE_LOGO);
        return this;
    }


    public TextLayout colorMenuTop() {
           add(P.COLOR_MENU_TOP);
           return this;
       }


    public TextLayout colorC1() {
        add(P.COLOR_C1);
        return this;
    }

    public TextLayout color4D() {
        add(P.COLOR_4D);
        return this;
    }

    public TextLayout noWrap(){
        add(P.NO_WRAP);
        return this;
    }

    public TextLayout backgroundBlue() {
        add(P.BACKGROUND_BLUE);
        return this;
    }


    public TextLayout backgroundBlack() {
        add(P.BACKGROUND_BLACK);
        return this;
    }

    public TextLayout backgroundBlueTips() {
        add(P.BACKGROUND_BLUE_TIPS);
        return this;
    }


    public TextLayout underline() {
        add(P.TEXT_DECORATION_UNDERLINE);
        return this;
    }
}
