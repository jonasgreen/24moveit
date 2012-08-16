package com.moveit.server.mail;

import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.language.Language;
import com.moveit.client.model.User;

/**
 *
 */
public class UserCreatedMail {

    private HtmlStringBuffer sb = new HtmlStringBuffer(true);
    private User user;
    private Language language;

    public UserCreatedMail(User user) {
        this.user = user;
        this.language = Language.getLanguage(user);
    }


    public String getTitle() {
        if (language.isLanguageDanish()) {
            return user.getUserType() == UserTypeConstant.CUSTOMER.getValue() ? "Brugerkonto oprettet" : "Vognmandsfirma tilmeldt";
        }

        return user.getUserType() == UserTypeConstant.CUSTOMER.getValue() ? "Account created" : "Company signed up";

    }

    public String getEmailContent() {
        if (language.isLanguageDanish()) {
            appendDanish();
        }
        else {
            appendEnglish();
        }

        return sb.toString();
    }


    //DANISH
    private void appendDanish() {
        sb.p("Hej " + user.getName());

        if (user.isDriver()) {
            sb.p("Dit firma er nu tilmeldt 24moveit, og du kan allerede nu benytte de services, som vi tilbyder 100% gratis.");
            appendDanishMailAndPass();

            //TODO - link til videohjælp
        }
        else {
            sb.p("Din brugerkonto er nu oprettet.");
            appendDanishMailAndPass();
            sb.p("24moveit er 100% gratis at bruge - også for vognmænd - hvilket resulterer i de bedste tilbud på markedet.");
            sb.p("Husk at du også har mulighed for at tjene lidt ekstra til din egen tur, hvis du tager noget med for andre. " +
                    "Du kan se hvor andre vil have flyttet noget <a href=\"http://www.24moveit.appspot.com/#search\">her</a>.");
            //"Og der er en video <a href=\"http://www.24moveit.com/#search\">her</a>, der viser hvordan du søger efter andres flytteønsker.");
        }


        sb.p("Har du forslag til forbedringer, kritik eller andet, er du velkommen til at skrive til os. Tak fordi du valgte at benytte dig af 24moveit.");
    }

    private void appendDanishMailAndPass() {
        sb.p("Du bruger din email og dit password når du logger på systemet:", "visitcard");
        sb.p("<b>Email:</b> " + user.getEmail(), "visitcard");
        sb.p("<b>Password:</b> " + user.getPassword(), "visitcardLast");
    }

    //ENGLSIH
    private void appendEnglish() {
        sb.p("Hi " + user.getName());

        if (user.isDriver()) {
            sb.p("Your company is now signed up to 24moveit. You can use our completely free of charge services already.");
            appendEnglishMailAndPass();

            //TODO - link til videohjælp
        }
        else {
            sb.p("Your account has now been created.");
            appendEnglishMailAndPass();
            sb.p("24moveit is completely free of charge – also for moving companies. This secures the best quotes on the market.");
            sb.p("Do not forget that you may also earn a little extra on your own, if you bring something along for somebody else. You can see, where others need something moved from, <a href=\"http://www.24moveit.appspot.com/#search\">here</a>.");
        }


        sb.p("Please, do not hesitate to write to us if you have any suggestions for improvements, questions or likewise. Thank you for choosing 24moveit.");
    }

    private void appendEnglishMailAndPass() {
        sb.p("You will need your E-mail and password to log in:", "visitcard");
        sb.p("<b>Email:</b> " + user.getEmail(), "visitcard");
        sb.p("<b>Password:</b> " + user.getPassword(), "visitcardLast");
    }
}
