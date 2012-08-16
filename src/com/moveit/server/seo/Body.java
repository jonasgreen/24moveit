package com.moveit.server.seo;

import java.util.Random;

/**
 *
 */
public abstract class Body {

    public static String DELIMITER = "#";
    private static Random random = new Random();

    public abstract String[] getH1s();
    public abstract String[] getH2s();
    public abstract String[] getH3s();
    public abstract String[] getSections();
    public abstract String[] getGenericLinks();
    public abstract String[] getPics();
    public abstract String[] getSpecificLinks();
    public abstract String getWordPhrase();


    public static void create(StringBuffer sb, Body body) {
        sb.append("\n<body>\n");
        int i = 0;
        while (i < body.getH1s().length){
            createChapter(body, sb, i);
            i++;
        }

        createGenericLinks(sb, body);
        sb.append("\n</body>\n");
    }

    private static void createGenericLinks(StringBuffer sb, Body body) {
        sb.append("<p>links: ");

        int i = 0;
        while (i < body.getH3s().length){
            sb.append("<a href=\"").append(body.getGenericLinks()[random.nextInt(body.getGenericLinks().length-1)]).append("\">");
            sb.append(body.getH3s()[i].replaceAll(DELIMITER, body.getWordPhrase()));
            sb.append("</a>, ");
            i++;
        }
        sb.append("</p>");
    }

    private static void createChapter(Body b, StringBuffer sb, int i) {
        sb.append("<h1>").append(b.getH1s()[i].replaceAll(DELIMITER, b.getWordPhrase())).append("</h1>\n");
        sb.append("<h2>").append(b.getH2s()[i].replaceAll(DELIMITER, b.getWordPhrase())).append("</h2>\n");
        sb.append("<h3>").append(b.getH3s()[i].replaceAll(DELIMITER, b.getWordPhrase())).append("</h3>\n");
        sb.append("<p>").append(b.getSections()[i].replaceAll(DELIMITER, b.getWordPhrase())).append("</p>\n");
        sb.append("<img alt=\"").append(b.getPics()[i].replaceAll(DELIMITER, b.getWordPhrase())).append("\" src=\"/").append(i).append(".png\" />");
    }
}
