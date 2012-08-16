package com.moveit.client.language;

/**
 *
 */
public class LWhenToMove extends LanguagePage{
    private static final long serialVersionUID = 8926905192346522709L;

    public LWhenToMove() {
    }

    public LWhenToMove(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LWhenToMove FROM = new LWhenToMove("Fra-dato", "From date", "", "");
    public static LWhenToMove TO = new LWhenToMove("Til-dato", "To date", "", "");


    private static String toAndFromDateDanish = "Fra- og tildato angiver i hvilken periode du gerne vil ha' flyttet dine ting. " +
                    "Skal det være én bestemt dag, så angiv samme dato i begge felter. Når til-datoen overskrides, " +
                    "kan dit flytteønske ikke længere fremsøges af vognmænd.";

    private static String toAndFromDateEnglish = "'From-' and 'to date' indicate in what period of time you would like your things moved. " +
                        "If you prefer a fixed date, choose the same date in both fields. When the 'to date' expires, " +
                        "your request is no longer visible to moving companies.";

    public static LWhenToMove TIP = new LWhenToMove(toAndFromDateDanish, toAndFromDateEnglish, "", "");


}