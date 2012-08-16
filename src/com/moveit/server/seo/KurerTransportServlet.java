package com.moveit.server.seo;

/**
 *
 */
public class KurerTransportServlet extends StaticContentServlet{
    private static final long serialVersionUID = -3666852215536945360L;


    private Body body = new KurerTransportBody();


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