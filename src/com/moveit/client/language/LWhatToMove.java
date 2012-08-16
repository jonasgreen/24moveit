package com.moveit.client.language;

/**
 *
 */
public class LWhatToMove extends LanguagePage{
    private static final long serialVersionUID = -1208764841065231352L;

    public LWhatToMove() {
    }

    public LWhatToMove(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.


    public static LWhatToMove CATEGORI = new LWhatToMove("Kategori", "Category", "", "");
    public static LWhatToMove DESCRIPTION = new LWhatToMove("Beskrivelse", "Description", "", "");

    public static LWhatToMove TIP_CATEGORI = new LWhatToMove("Vælg hvilken kategori, det du skal ha flyttet, hører ind under.", "Choose which categori the things you need to move belong to.", "", "");
    public static LWhatToMove TIP_DESCRIPTION = new LWhatToMove("Beskriv hvad der skal flyttets - fx 'et klaver' eller 'alt inventar fra 80 kvm. lejlighed på 4. sal'. Nævn de specielle ting der gør sig gældende ved flytningen, som vognmanden vil ha gavn af at vide. Står det fx på en palle? Eller hvor meget fylder det ca. i kubikmeter", "Descripe what you want to be moved - i.e. a piano or all furniture from a four beedroom flat on the third floor. Describe all the things that are relevant to the moving company regarding the move. Is everything packed? Is it on a pallet? Or how much space approximately does it fill up?", "", "");

}