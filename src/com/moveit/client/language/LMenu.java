package com.moveit.client.language;

/**
 *
 */
public class LMenu extends LanguagePage{
    private static final long serialVersionUID = -9120669087503300279L;

    public LMenu() {
    }

    public LMenu(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LMenu FRONT_PAGE = new LMenu("Forside", "Home", "", "");
    public static LMenu ADD_MOVEMENT = new LMenu("Indtast Flytning", "Enter Relocation", "", "");
    public static LMenu FIND_JOB = new LMenu("Find Flyttejob", "Search For Relocation Jobs", "", "");
    public static LMenu REGISTER_FIRM = new LMenu("Tilmeld Vognmandsfirma", "Register Moving Company", "", "");
    public static LMenu YOUR_ACCOUNT = new LMenu("Din Konto", "Your Account", "", "");
    public static LMenu HELP = new LMenu("Hjælp", "Help", "", "");

    public static LMenu TOOLTIP_ADD_MOVEMENT = new LMenu("Indhent gratis tilbud fra vognmænd. Indtast din flytning her.", "Get free offers from hauliers. Enter your movement here.", "", "");
    public static LMenu TOOLTIP_FIND_JOB = new LMenu("Se hvor folk vil ha' flyttet noget fra og til", "Search and see where people need to have something moved.", "", "");


}