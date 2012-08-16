package com.moveit.server.seo;

/**
 *
 */
public class InternationalFlytningServlet extends StaticContentServlet{
    private static final long serialVersionUID = -7243719603707582713L;


    private Body body = new InternationalFlytningBody();


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