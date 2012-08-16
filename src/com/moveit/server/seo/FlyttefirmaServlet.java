package com.moveit.server.seo;

/**
 *
 */
public class FlyttefirmaServlet extends StaticContentServlet{
    private static final long serialVersionUID = -8988211984767058735L;


    private Body body = new FlyttefirmaBody();


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