package com.moveit.server.mail;

import com.moveit.client.model.Route;
import com.moveit.client.constants.CargoTypeConstant;

import java.util.Collection;

/**
 *
 */
public class NewRoutesMail {

    private HtmlStringBuffer sb = new HtmlStringBuffer(true);
    private String title;

    public NewRoutesMail(String nationCode, Collection<Route> rs) {
        if (nationCode != null && nationCode.equalsIgnoreCase("DK")) {
            title = "Nye flytteønsker på www.24moveit.dk";
            createMailContentDanish(rs);
        }
        else {
            title = "New requests at www.24moveit.com";
            createMailContentEnglish(rs);
        }
    }

    private String createMailContentDanish(Collection<Route> routes) {
        sb.append("<p>Det er kommet nye 'flyttejob' på www.24moveit.com, se kontaktinfo og detaljer <a href=http://24moveit.appspot.com/#search>her<a>. Husk at logge ind.</p>");
        for (Route r : routes) {
            createDescription(sb, r);
        }
        return sb.toString();
    }

        
    private String createMailContentEnglish(Collection<Route> routes) {
        sb.append("<p>New requests have been made at www.24moveit.com. Please find details and contact information <a href=http://24moveit.appspot.com/#search>here<a>.</p>");
        for (Route r : routes) {
            createDescription(sb, r);
        }
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    private void createDescription(HtmlStringBuffer sb, Route r) {
        sb.append("<h3>");
        sb.append(r.getFromPoint().getAddress().getCityCityCodeAndNationCode());
        sb.append(" --> ");
        sb.append(r.getToPoint().getAddress().getCityCityCodeAndNationCode());

        sb.append("</h3>");

        sb.append("<p>");
        sb.append(CargoTypeConstant.itemMap.get(r.getCargoType()).getText());
        sb.append("</p>");
        sb.append("<p>");
        sb.append(r.getCargoDescription());
        sb.append("</p>");
        sb.append("<hr>");

    }


    public String getEmailContent() {
        return sb.toString();
    }


}