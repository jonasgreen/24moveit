package com.moveit.client.language;

/**
 *
 */
public class LService extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LService() {
    }

    public LService(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LService DELETE = new LService("Sletter", "Deleting", "", "");
    public static LService SEARCH = new LService("Søger", "Searching", "", "");
    public static LService SIGN_ON = new LService("Logger på", "Logging in", "", "");
    public static LService USER_INFO_ALL = new LService("Henter info for alle brugere", "Getting user info", "", "");
    public static LService CREATE_ACCOUNT_USER = new LService("Opretter brugerkonto", "Creating account", "", "");
    public static LService CREATE_ACCOUNT_FIRM = new LService("Tilmelder firma", "Creating company account", "", "");
    public static LService DELETE_ACCOUNT = new LService("Sletter konto", "Deleting account", "", "");
    public static LService WORKING = new LService("Arbejder", "Working", "", "");
    public static LService SAVING_DATA = new LService("Gemmer data", "Saving data", "", "");
    public static LService SENDING_EMAIL = new LService("Sender email", "Sending email", "", "");
    public static LService CREATING_INVITATIONS = new LService("Opretter invitationer", "Creating invitations", "", "");
    public static LService PINGING = new LService("Pinger", "Pinging", "", "");

    public static LService ERROR_TRY_AGAIN = new LService("Der er sket en fejl, prøv igen", "An error occurred, try agan later", "", "");



}