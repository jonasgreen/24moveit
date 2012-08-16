package com.moveit.server.seo;

/**
 *
 */
public class FlyttefirmaKoebenhavnServlet extends StaticContentServlet{

    private static final long serialVersionUID = 1915367105851478965L;

    private Body body = new FlyttefirmaKoebenhavnBody();

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