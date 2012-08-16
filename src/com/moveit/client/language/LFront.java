package com.moveit.client.language;

/**
 *
 */
public class LFront extends LanguagePage{
    private static final long serialVersionUID = 5341215900616926328L;

    public LFront() {
    }

    public LFront(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }

    
    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LFront NEED_TO_MOVE_SOMETHING = new LFront("Skal du ha' noget flyttet?", "Need to move something?", "", "");
    public static LFront GET_FREE_OFFERES = new LFront("Få GRATIS TILBUD fra vognmænd", "Get FREE quotes from movers", "", "");
    public static LFront ADD_MOVEMENT_BUTTON = new LFront("Indtast flytning", "Enter relocation", "", "");

    public static LFront HOW_DOES_IT_WORK = new LFront("HVORDAN VIRKER DET?", "HOW DOES IT WORK?", "", "");
    public static LFront YOU_ENTER_FROM_TO = new LFront("Du indtaster hvorfra og hvortil du vil ha' flyttet dine ting.", "Enter where to and from you would like your things moved.", "", "");
    public static LFront HAULIERS_GIVE_YOU_OFFERS = new LFront("Vognmænd giver dig tilbud.", "Movers contact you with quotes.", "", "");
    public static LFront YOU_CHOOSE_AN_OFFER = new LFront("Du udvælger det bedste tilbud.", "You select the best offer.", "", "");
    public static LFront ADVANTAGES = new LFront("Se fordelene her", "View the advantages here", "", "");

    public static LFront PIC_MONEY = new LFront("money.png", "money_eng.png", "", "");
    public static LFront PIC_TIME = new LFront("time.png", "time_eng.png", "", "");
    public static LFront PIC_CO2 = new LFront("co2.png", "co2_eng.png", "", "");

    public static LFront PIC_HOW = new LFront("how_da.png", "how_en.png", "", "");


    public static LFront FB_RECOMMEND = new LFront("Anbefal 24moveit", "Recommend 24moveit", "", "");


}
