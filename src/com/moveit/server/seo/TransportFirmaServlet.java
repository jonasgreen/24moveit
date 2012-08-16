package com.moveit.server.seo;

/**
 *
 */
public class TransportFirmaServlet extends StaticContentServlet{
    private static final long serialVersionUID = 2833760648967055803L;

    private Body body = new TransportFirmaBody();


    public void createBody(StringBuffer sb) {
        Body.create(sb, body);
    }

    public boolean isDanish() {
        return true;
    }

    public String getWordsPhrase() {
        return body.getWordPhrase();
    }

}