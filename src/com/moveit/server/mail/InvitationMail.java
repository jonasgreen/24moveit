package com.moveit.server.mail;

import com.moveit.client.language.Language;

/**
 *
 */
public class InvitationMail {

    private HtmlStringBuffer sb = new HtmlStringBuffer(true);
    private String title;
    private String reciver;

    public InvitationMail(Language language) {
        if (language.isLanguageDanish()) {
            title = "Ny transport- og flytteportal - www.24moveit.com";
            reciver = "Vognmand/Flyttemand";
            createMailContentDanish();
        }
        else {
            title = "New moving portal - www.24moveit.com";
            reciver ="Moving company";
            createMailContentEnglish();
        }
    }

    private String createMailContentDanish() {
        sb.append("Hej vognmand/flyttemand,<br><br><br><a href=\"http://www.24moveit.com\" target=\"_blank\"><b>www.24moveit.com</b></a> er en nyåbent transport- og flytteside, som formidler flytte- og transportopgaver mellem kunder og vognmænd i danmark og europa.<br>\n" +
                    "<br>Visionen er et fælles og centralt sted på nettet, hvor kunder og vognmænd skaber gensidig værdi for hinanden.<br><br><b>Siden er 100% gratis at benytte for både vognmænd og kunder.</b><br>\n" +
                    "<br>Du kan tilmelde dit vognmandsfirma <a href=\"http://24moveit.appspot.com/#addfirm\" target=\"_blank\">her</a> og du få løbende infomationer om nye transport- og flyttejob via mail, når de oprettes på siden.<br><br><b>Hvordan virker det?</b><br>1) Kunden indtaster hvorfra og hvortil han vil ha' flyttet sine ting.<br>\n" +
                    "\n" +
                    "2) Du ser hans flytteønske og kontakter ham, hvis det har interesse.<br>3) Mange flytteønsker i systemet gør at du i højere grad undgår tomme læs.<br><br>Det er meget simpelt - mange bække små gør som bekendt en stor å. Med mange flytteønsker i systemet, vil du være i stand til at planlægge og optimere dine ture og på den måde øge din konkurrenceevne og indtjening.<br>\n" +
                    "<br><b>Dine fordele</b><br>1) Adgang til folks flytteønsker, så du kan kontakte dem med tilbud.<br>2) Information om nye flytteønsker via mail.<br>3) 24moveit indeholder nemt <a href=\"http://24moveit.appspot.com/#search\" target=\"_blank\">ruteplanlægningsværktøj</a>, så du kan finde nye ture og undgå tomme læs - se <a href=\"http://24moveit.appspot.com/#search\" target=\"_blank\">her</a><br>\n" +
                    "4) Du får flere jobs.<br>5) Færre tomme læs.<br>6) Du tjener flere penge.<br><br><b>Kundens fordele<br></b>1) Nemmere for kunden af finde vognmænd. Gør det mere attraktivt at få flyttet noget.<br>2) Bedre priser.<br><br><br>\n" +
                    "\n" +
                    "OBS!<br>Danmark har overfor EU forpligtiget sig til at nedsætte CO2-udslippet med 20% inden år 2020. Den grønne tænketank CONCITO, anbefaler staten at indfører kørselsafgift pr. kørt kilometer. Ved at være med i 24moveit, er du med til sænke CO2 udslippet og dermed også en eventuel kørselsafgift.<br>\n" +
                    "<br><br>Håber du synes ligeså meget om idéen som vi gør. Du kan se mere og tilmelde dig på <a href=\"http://www.24moveit.com\" target=\"_blank\">www.24moveit.com</a>.");
        return sb.toString();
    }


    private String createMailContentEnglish() {
        sb.append("Hi moving company,<br><br><br><a href=\"http://www.24moveit.com\" target=\"_blank\"><b>www.24moveit.com</b></a> is a new relocation portal arranging relocation requests between customers and moving companies throughout Europe, United States and Australia.<br>\n" +
                    "<br>The idea is a joint and accessible centre online, where customers and moving companies create mutual value from each other.<br><br><b>The site is 100% free to use for both customers and moving companies.</b><br>\n" +
                    "<br>You can register your moving company <a href=\"http://24moveit.appspot.com/#addfirm\" target=\"_blank\">here</a> and you will receive new requests by E-mail when they are entered on the site.<br><br><b>How does it work?</b><br>1) The customer enters wherefrom and whereto he would like something moved.<br>\n" +
                    "\n" +
                    "2) You see his request and contact him with a quote if you are interested.<br>3) The many requests in the system prevent you from having empty loads.<br><br>It is quite simple – with many requests in the system you will be able to plan and optimize your trips, thus enhancing your competitiveness and your earnings.<br>\n" +
                    "<br><b>Your advantages:</b><br>1) Access to peoples requests, so that you may contact them with quotes.<br>2) Information about new requests by email<br>3) 24moveit has an easy to use <a href=\"http://24moveit.appspot.com/#search\" target=\"_blank\">online route planner tool</a>, so that you can find new requests and avoid empty loads – see <a href=\"http://24moveit.appspot.com/#search\" target=\"_blank\">here</a>.<br>\n" +
                    "4) You will get more requests. <br>5) You will have fewer empty loads.<br>6) You will earn more money.<br><br><b>The customer’s advantages:<br></b>1) Easier for the customer to find moving companies, making it more appealing to use a professional moving company.<br>2) Better quotes.<br><br><br>\n" +
                    "\n" +
                    "<br><br>We hope you like this idea as much as us. You can see more and register on: <a href=\"http://www.24moveit.com\" target=\"_blank\">www.24moveit.com</a>.");
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }


    public String getReciver() {
        return reciver;
    }

    public String getEmailContent() {
        return sb.toString();
    }


}