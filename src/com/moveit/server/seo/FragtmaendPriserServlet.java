package com.moveit.server.seo;

/**
 *
 */
public class FragtmaendPriserServlet extends StaticContentServlet{


    private static final long serialVersionUID = -6888285815430307943L;
    private Body body = new FragtmaendPriserBody();


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