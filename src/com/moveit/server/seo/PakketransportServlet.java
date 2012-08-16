package com.moveit.server.seo;

/**
 *
 */
public class PakketransportServlet extends StaticContentServlet{


    private static final long serialVersionUID = 6367858059636862510L;

    private Body body = new PakkeTransportBody();

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