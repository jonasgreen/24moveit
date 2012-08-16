package com.moveit.client.guicomponents;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Layout17 implements Layout {
    public List<P> properties = new ArrayList<P>();


    public static Layout17 DEFAULT = new Layout17(4, 4, 4, 4);


    private int topMargin;
    private int rightMargin;
    private int bottomMargin;
    private int leftMargin;

    private String height;
    private String width;

    private Horizontal alignH;
    private Vertical alignV;

    public Layout17() {
        this(0, 0, 0, 0);
    }

    public Layout17(Css css) {
        add(css);
    }

    public Layout17(P p) {
        add(p);
    }


    public Layout17(Horizontal alignH) {
        this(alignH, null);
    }

    public Layout17(Vertical alignV) {
        this(null, alignV);
    }

    public Layout17(String height, String width) {
        this(height, width, null, null);
    }

    public Layout17(String height, String width, Horizontal alignH, Vertical alignV) {
        this(0, 0, 0, 0, height, width, alignH, alignV);
    }

    public Layout17(String height, String width, Horizontal alignH) {
        this(height, width, alignH, null);
    }

    public Layout17(String height, String width, Vertical alignV) {
        this(height, width, null, alignV);
    }

    public Layout17(Horizontal alignH, Vertical alignV) {
        this(0, 0, 0, 0, null, null, alignH, alignV);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, null, null, null, null);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, height, width, null, null);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Horizontal alignH) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, height, width, alignH, null);
    }


    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Vertical alignV) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, height, width, null, alignV);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Horizontal alignH) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, alignH, null);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Vertical alignV) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, null, alignV);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Horizontal alignH, Vertical alignV) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, null, null, alignH, alignV);
    }

    public Layout17(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Horizontal alignH, Vertical alignV) {
        this.height = height;
        this.width = width;
        this.topMargin = topMargin;
        this.rightMargin = rightMargin;
        this.bottomMargin = bottomMargin;
        this.leftMargin = leftMargin;
        this.alignH = alignH;
        this.alignV = alignV;
    }

    public int getTopMargin() {
        return topMargin;
    }

    public int getRightMargin() {
        return rightMargin;
    }

    public int getBottomMargin() {
        return bottomMargin;
    }

    public int getLeftMargin() {
        return leftMargin;
    }

    public Horizontal getAlignH() {
        return alignH;
    }

    public Vertical getAlignV() {
        return alignV;
    }


    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
    }

    public void setRightMargin(int rightMargin) {
        this.rightMargin = rightMargin;
    }

    public void setBottomMargin(int bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    public void setLeftMargin(int leftMargin) {
        this.leftMargin = leftMargin;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setAlignH(Horizontal alignH) {
        this.alignH = alignH;
    }

    public void setAlignV(Vertical alignV) {
        this.alignV = alignV;
    }

    public Layout17 add(Css css) {
        properties.addAll(css.getProperties());
        return this;
    }

    public Layout17 add(P p) {
        properties.add(p);
        return this;
    }

    public Layout17 add(Name name, String value) {
        properties.add(new P(name, value));
        return this;
    }


    @SuppressWarnings({"CloneDoesntDeclareCloneNotSupportedException", "CloneDoesntCallSuperClone"})
    public Layout17 clone() {
        Layout17 l = new Layout17(topMargin, rightMargin, bottomMargin, leftMargin);
        l.setHeight(height);
        l.setWidth(width);
        l.setAlignH(alignH);
        l.setAlignV(alignV);
        l.add(getProperties());
        return l;
    }

    public List<P> getProperties() {
        return properties;
    }

    public void add(List<P> ps) {
        this.properties.addAll(ps);
    }
}
