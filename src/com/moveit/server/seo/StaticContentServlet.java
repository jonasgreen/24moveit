package com.moveit.server.seo;

import com.moveit.server.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public abstract class StaticContentServlet extends HttpServlet {

    private static String REDIRECT_HTML = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><HTML><HEAD><TITLE>24moveit.com</TITLE><script type=\"text/javascript\">window.location = \"http://www.24moveit.appspot.com/\"</script>)</HEAD><BODY><H1>24moveit</H1>";


    public void init() {
        Logger.init(getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }


    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isNormalBrowser(request)) {
            out.println(REDIRECT_HTML);
        }
        else {
            StringBuffer sb = new StringBuffer();
            sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
            sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n");
            sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
            createTitle(sb);
            createDescription(sb);
            createKeyWords(sb);
            sb.append("<meta name=\"googlebot\" content=\"noodp\" />");
            createContentLanguage(sb);

            sb.append("</head>");
            createBody(sb);
            sb.append("<h2>").append("<a href=\"").append("http://www.24moveit.appspot.com").append("\">").append("Home").append("</a></h2>");
            sb.append("<h2>").append("<a href=\"").append("http://www.24moveit.appspot.com/gwtmodule/seoindex.html").append("\">").append("Index").append("</a></h2>");

            sb.append("\n</html>");

            out.println(sb.toString());
        }
        out.close();

    }

    private void createKeyWords(StringBuffer sb) {

        sb.append("<meta name=\"keywords\" content=\"").append(getWordsPhrase());
        if (isDanish()) {
            sb.append(",flyttefirma, flytte, flyttetilbud, flyttemand, vognmand, møbel opbevaring, opmagasinering, flytteportal, gratis flyttetilbud, flyttefirma københavn, international flytning, transport");
        }
        else {
            sb.append(",moving company, movers, free quotes from movers, moving portal, relocation");
        }
        sb.append("\" />");
    }

    private void createContentLanguage(StringBuffer sb) {
        if (isDanish()) {
            sb.append("<meta http-equiv=\"Content-Language\" content=\"da\" />");
        }
        else {
            sb.append("<meta http-equiv=\"Content-Language\" content=\"en-us\" />");
        }
    }

    private boolean isNormalBrowser(HttpServletRequest request) {
        String s = request.getHeader("User-Agent");
        Logger.log("USER-AGENT: "+s);
        if (s == null) {
            return false;
        }
        s = s.toLowerCase();
        return !s.contains("googlebot") && ((s.indexOf("msie") > -1)
                || (s.indexOf("opera") > -1)
                || (s.indexOf("safari") > -1)
                || (s.indexOf("chrome") > -1)
                || (s.indexOf("mozilla") > -1));
    }


    public void createTitle(StringBuffer sb) {
        sb.append("<title>");

        if (isDanish()) {
            sb.append(getWordsPhrase()).append(" - 100% GRATIS flyttepotal - 24moveit.appspot.com");
        }
        else {
            sb.append(getWordsPhrase()).append(" - 100% FREE moving portal - 24moveit.appspot.com");
        }
        sb.append("</title>");

    }


    public void createDescription(StringBuffer sb) {
        sb.append("<meta name=\"description\" content=\"");
        if (isDanish()) {
            sb.append("Her får du gratis tilbud på ").append(getWordsPhrase()).append(". ");
            sb.append("24moveit er en den eneste 100% GRATIS flytteportal, hvor du får uforpligtende tilbud på ").append(getWordsPhrase()).append(" fra kvalificerede flyttefirmaer, flyttemænd og vognmænd.");
        }
        else {
            sb.append(getWordsPhrase()).append(" - get free quotes.");
            sb.append("24moveit is the only 100% FREE moving portal, where you get free quotes on ").append(getWordsPhrase()).append(" from qualified movers and moving companies.");
        }
        sb.append("\" />");
    }

    public abstract void createBody(StringBuffer sb);

    public abstract boolean isDanish();

    public abstract String getWordsPhrase();
}