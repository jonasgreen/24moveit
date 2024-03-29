package com.moveit.client.language;

/**
 *
 */
public class LSignIn extends LanguagePage{
    private static final long serialVersionUID = -6195082573786326950L;

    public LSignIn() {
    }

    public LSignIn(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LSignIn TITLE = new LSignIn("Log på din brugerkonto", "Login to your account", "", "");
    public static LSignIn EMAIL = new LSignIn("Email", "Email", "", "");
    public static LSignIn PASSWORD = new LSignIn("Password", "Password", "", "");

    public static LSignIn REMEMBER_ME = new LSignIn("Husk mig", "Remember me", "", "");

    public static LSignIn FORGOT_PASSWORD = new LSignIn("Jeg har glemt mit password, send det venligst til min email", "I forgot my password, please send it to my email", "", "");

    public static LSignIn CREATE_FREE_ACCOUNT = new LSignIn("Opret en gratis brugerkonto", "Create a free account", "", "");
    public static LSignIn SIGNIN_BUTTON = new LSignIn("Log på", "Login", "", "");
    public static LSignIn SIGNIN_SUCCES = new LSignIn("Du er succesfuldt logget på", "You are now logged in", "", "");

    public static LSignIn PASSWORD_SEND_1 = new LSignIn("Dit password er blevet sendt til den angivne mail", "Your password have been sent to the given mail", "", "");
    public static LSignIn PASSWORD_SEND_2 = new LSignIn("og burde være fremme inden for få minutter", "and should arrive within minuttes", "", "");


}