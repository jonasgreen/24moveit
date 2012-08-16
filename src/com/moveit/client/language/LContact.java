package com.moveit.client.language;

/**
 *
 */
public class LContact extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LContact() {
    }

    public LContact(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LContact CONTACT = new LContact("<html>" +
                    "<div class=helpH1>Kontakt</div>" +
                    "<div class=helpText>Har du spørgsmål, forslag, idéer eller kritik - skriv til os på " +
                    "<a href=\"mailto:contact@24moveit.com\">contact@24moveit.com</a></div></html>",

            "<html>" +
                    "<div class=helpH1>Contact</div>" +
                    "<div class=helpText>Please, do not hesitate to write to us if you have any suggestions for improvements, questions or likewise: " +
                    "<a href=\"mailto:contact@24moveit.com\">contact@24moveit.com</a></div></html>", "", "");

}