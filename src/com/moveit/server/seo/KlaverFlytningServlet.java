package com.moveit.server.seo;

/**
 *
 */
public class KlaverFlytningServlet extends StaticContentServlet{
    private static final long serialVersionUID = 1257411965161884179L;


    private Body body = new KlaverflytningBody();


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
