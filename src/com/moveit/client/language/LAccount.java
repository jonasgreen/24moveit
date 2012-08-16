package com.moveit.client.language;

/**
 *
 */
public class LAccount extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LAccount() {
    }

    public LAccount(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LAccount MAIL_NEWS = new LAccount("Jeg vil gerne informeres om nyheder o.l.", "I would like to be informed about news, etc. by mail.", "", "");
    public static LAccount MAIL_NEW_REQUESTS = new LAccount("Jeg vil gerne informeres om nye flyttejobs.", "I would like to be informed about new requests.", "", "");


    public static LAccount YOUR_ACCOUNT = new LAccount("Din 24moveit konto", "Your 24moveit account", "", "");
    public static LAccount YOUR_ACCOUNT_TITLE = new LAccount("Din konto", "Your account", "", "");

    public static LAccount DELETE_ACCOUNT = new LAccount("Nedlæg min konto", "Delete my account", "", "");
    public static LAccount DELETE_ACCOUNT_TITLE = new LAccount("Nedlæg brugerkonto", "Delete account", "", "");
    public static LAccount DELETE_ACCEPT = new LAccount("Klik på Ok for at nedlægge din brugerkonto.", "Press the Ok button to delete your account.", "", "");
    public static LAccount ACCOUNT_DELETED = new LAccount("Din brugerkonto er blevet slettet.", "Your account have been deleted.", "", "");


    public static LAccount BUTTON_SAVE = new LAccount("Gem", "Save", "", "");
    public static LAccount BUTTON_DELETE = new LAccount("Slet", "Delete", "", "");
    public static LAccount INFORMATION_BY_MAIL = new LAccount("Information via email", "Information by mail", "", "");
    public static LAccount ACTIVE_REQUESTS = new LAccount("Aktive flytninger", "Active requests", "", "");
    public static LAccount NO_ACTIVE_REQUESTS = new LAccount("Du har ingen aktive flytninger.", "You have no active requests", "", "");


}