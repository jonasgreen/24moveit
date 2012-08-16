package com.moveit.client.language;

/**
 *
 */
public class LDialogbox extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LDialogbox() {
    }

    public LDialogbox(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LDialogbox OK = new LDialogbox("Ok", "Ok", "", "");
    public static LDialogbox CANCEL = new LDialogbox("Annullér", "Cancel", "", "");





}