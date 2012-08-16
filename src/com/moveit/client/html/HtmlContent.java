package com.moveit.client.html;

import com.moveit.client.SystemException;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class HtmlContent {

    private int ref = 1;

    private enum Mode {
        NORMAL,
        LINK_SECTION,
    }

    private Mode mode = Mode.NORMAL;

    private class LinkSection {
        String linkCssClass;
        String textCssClass;
        String titleCssClass;
        String title;
        String text;
        String href;

        private LinkSection(String linkCssClass, String titleCssClass, String textCssClass, String title, String text, String href) {
            this.linkCssClass = linkCssClass;
            this.textCssClass = textCssClass;
            this.titleCssClass = titleCssClass;
            this.title = title;
            this.text = text;
            this.href = href;
        }
    }

    private StringBuffer buffer = new StringBuffer("<html>");
    private List<LinkSection> linkSections;


    private void startMode(Mode m) {
        if (m == Mode.NORMAL) {
            throw new SystemException("You cannot start a normal mode. It happens automatically when stopping another mode.");
        }
        if (mode == m) {
            return;
        }
        else {

        }
        if (mode == Mode.NORMAL) {
            if (m == Mode.LINK_SECTION) {
                linkSections = new ArrayList<LinkSection>();
            }
            else {
                throw new SystemException("Starting mode:" + m + " is not supported");
            }
        }
        else {
            throw new SystemException("You cannot start a mode:" + mode + " when htmlConent is in mode:" + m + ".");
        }
        mode = m;

    }


    private void stopMode() {
        if (mode == Mode.NORMAL) {
            return;
        }
        if (mode == Mode.LINK_SECTION) {
            stopLinkSection();
        }
        else {
            throw new SystemException("Stopping mode:" + mode + " is not supported");
        }
        mode = Mode.NORMAL;
    }

    private void stopLinkSection() {
        for (LinkSection ls : linkSections) {
            addDivHref(ls);
        }
        for (LinkSection ls : linkSections) {
            addDiv(ls.titleCssClass, ls.href, ls.title);
            addDiv(ls.textCssClass, null, ls.text);
        }
    }


    public void addLinkAndSection(String linkCssClass, String titleCssClass, String textCssClass, String title, String text) {
        startMode(Mode.LINK_SECTION);
        linkSections.add(new LinkSection(linkCssClass, titleCssClass, textCssClass, title, text, String.valueOf(ref++)));
    }


    public void addSection(String cssClass, String text) {
        stopMode();
        if (mode != Mode.NORMAL) {
            throw new SystemException("You cannot addLinkSection in mode:" + mode);
        }
        addDiv(cssClass, null, text);
    }

    public String getHtml() {
        stopMode();
        buffer.append("</html>");
        return buffer.toString();
    }


    protected void addDivHref(LinkSection ls) {
        buffer.append("<div class=").append(ls.linkCssClass).append("><a href=#").append(ls.href).append(">").append(ls.title).append("</a>").append("</div>\n");
    }


    protected void addDiv(String cssClass, String id, String text) {
        if (cssClass == null) {
            buffer.append("<div>");
        }
        else {
            buffer.append("<div class=").append(cssClass);
            if (id == null) {
                buffer.append(">");
            }
            else {
                buffer.append(" id=").append(id).append(">");
            }
        }

        buffer.append(text).append("</div>\n");
    }

    public static void main(String[] args) {
        HtmlContent html = new HtmlContent();
        html.addSection("helpH1", "Søgning efter flyttejobs");
        html.addSection("helpText", "Du foretager en søgning ved at indtaste en by i søgefeltet og trykke på den blå søgeknap. Hvis " +
                "systemet finder nogen flyttejobs, som opfylder søgekriterierne, vises de på kortet og i en tabel nederst på siden.");
        html.addLinkAndSection("helpIndex", "helpH3", "helpText", "Søgekriterier", "Som udgangspunkt søger systemet efter...");
        System.out.println(html.getHtml());
    }

}
