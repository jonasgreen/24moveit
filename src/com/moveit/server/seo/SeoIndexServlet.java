package com.moveit.server.seo;

/**
 *
 */
public class SeoIndexServlet extends StaticContentServlet {
    private static final long serialVersionUID = -2556356909383714910L;
    private static String path = "http://24moveit.appspot.com/gwtmodule/";


    public void createBody(StringBuffer sb) {
        sb.append("\n<body>\n");
        generateIndex(sb, "klaverflytning", "klaverflytning.html");
        generateIndex(sb, "flyttefirma", "flyttefirma.html");
        generateIndex(sb, "flyttefirma-københavn", "flyttefirma-koebenhavn.html");
        generateIndex(sb, "fragtmand-priser", "fragtmand-priser.html");
        generateIndex(sb, "international-flytning", "international-flytning.html");
        generateIndex(sb, "køletransport", "koeletransport.html");
        generateIndex(sb, "kurer-transport", "kurer-transport.html");
        generateIndex(sb, "pakketransport", "pakketransport.html");
        generateIndex(sb, "transportfirma", "transport-firma.html");

        sb.append("\n</body>\n");
    }

    private void generateIndex(StringBuffer sb, String title, String link) {
        sb.append("<h1>").append("<a href=\"").append(path).append(link).append("\">").append(title).append("</a></h1>");
    }

    public boolean isDanish() {
        return true;
    }

    public String getWordsPhrase() {
        return "index content";
    }


}