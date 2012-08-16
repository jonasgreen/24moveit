package com.moveit.client.guicomponents;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Layout20 implements Layout {
    public List<P> properties = new ArrayList<P>();


    public static Layout20 DEFAULT = new Layout20(4, 4, 4, 4);


    private int size;
    private int topMargin;
    private int rightMargin;
    private int bottomMargin;
    private int leftMargin;

    private String height;
    private String width;

    private Horizontal alignH;
    private Vertical alignV;

    public Layout20(Css css) {
        add(css);
    }

    public Layout20(P p) {
        add(p);
    }

    public Layout20(Name n, String value) {
        add(n, value);
    }

    public Layout20(int topMargin, int rightMargin, int bottomMargin, int leftMargin) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, null, null, null, null);
    }

    public Layout20(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, height, width, null, null);
    }

    public Layout20(int topMargin, int rightMargin, int bottomMargin, int leftMargin, Horizontal alignH, Vertical alignV) {
        this(topMargin, rightMargin, bottomMargin, leftMargin, null, null, alignH, alignV);
    }

    public Layout20(int topMargin, int rightMargin, int bottomMargin, int leftMargin, String height, String width, Horizontal alignH, Vertical alignV) {
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

    public Layout20 add(Css css) {
        properties.addAll(css.getProperties());
        return this;
    }

    public Layout20 add(P p) {
        properties.add(p);
        return this;
    }

    public Layout20 add(Name name, String value) {
        properties.add(new P(name, value));
        return this;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @SuppressWarnings({"CloneDoesntDeclareCloneNotSupportedException", "CloneDoesntCallSuperClone"})
    public Layout20 clone() {
        Layout20 l = new Layout20(topMargin, rightMargin, bottomMargin, leftMargin);
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