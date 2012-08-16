package com.moveit.server.seo;

/**
 *
 */
public class KoeletransportServlet extends StaticContentServlet{

    private static final long serialVersionUID = -2800656175450032774L;

    private Body body = new KoeleTransportBody();

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