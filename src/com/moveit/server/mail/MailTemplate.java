package com.moveit.server.mail;

import com.moveit.client.language.Language;
import com.moveit.server.services.EmailStyle;

/**
 *
 */
public class MailTemplate {

    private String title;
    private Language language;

    public MailTemplate(Language l, String title) {
        this.language = l;
        this.title = title;
    }

    public String createMail(String content, boolean styleInElem) {
        HtmlStringBuffer sb = new HtmlStringBuffer(styleInElem);
        sb.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        sb.append("<html>\n<head>\n");
        if (!styleInElem) {
            sb.append(EmailStyle.getStyle());
        }
        sb.append("\n</head>\n");
        sb.append("<body>\n");
        appendHeader(sb);
        sb.append(content);
        appendGreetings(sb);
        sb.append("\n</body>\n</html>");
        return sb.toString();
    }


    private void appendHeader(HtmlStringBuffer sb) {
        //sb.start("table", null).start("row", "logo");
        //sb.start("td", "logo");
        //start(sb, "div", "logo");
        sb.start("a", null, "href=\"http://www.24moveit.com\"");
        sb.closed("img", "logoImg", "src=\"http://www.24moveit.com/newLogo.png\"");
        sb.end("a");

        //sb.end("td");
        //sb.start("td", null);

        //sb.end("td").end("row").end("table");
        sb.start("div", "menu");
        if (title != null) {
            sb.p(title.toUpperCase(), "title");
        }
        sb.end("div");


    }

    private void appendGreetings(HtmlStringBuffer sb) {
        sb.start("div", "divgreetings");
        if (language.isLanguageDanish()) {
            sb.p("Med venlig hilsen", "greetings");
        }
        else{
            sb.p("Best regards", "greetings");
        }
        sb.end("div");

        sb.p("<b>Jonas Green, 24moveit</b>", "visitcard");
        sb.p("contact@24moveit.com", "visitcard");
        sb.p("<a href=\"http://www.24moveit.com\">www.24moveit.com</a>", "visitcard");

        // vision

        sb.end("div");

    }



}
