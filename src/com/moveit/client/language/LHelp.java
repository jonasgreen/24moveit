package com.moveit.client.language;

/**
 *
 */
public class LHelp extends LanguagePage {
    private static final long serialVersionUID = 4551614896582915909L;

    public LHelp() {
    }

    public LHelp(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    private static String HELP_DANISH = "<html>" +
            "<div class=helpH1>Hjælp</div>" +
            "<div class=helpText>Her finder du den hjælp du søger, ellers skriv endelig til os på " +
            "<span class=a1><a href=\"mailto:contact@24moveit.com\">contact@24moveit.com</a></span>.</div>" +

            "<div class=helpH3 id=kosterDetPenge>Koster det penge at bruge 24moveit?</div>" +
            "<div class=helpText>Nej. Det er gratis at bruge 24moveit hvad enten man gerne vil ha' flyttet noget, eller man " +
            "som vognmand eller fragtmand vil flytte noget for andre.</div>" +

            "<div class=helpH3 id=betalingAfVognmand>Sker betaling af vognmand gennem 24moveit?</div>" +
            "<div class=helpText>Nej. 24moveit formidler kun kontakten mellem flytteren og vognmanden. Aftaler omkring betaling, " +
            "skal indgås med vognmanden på samme måde, som hvis man havde kontaktet ham på anden vis uden om 24moveit.</div>" +

            "<div class=helpH3 id=ansvarOgBeskadigelse>Har 24moveit ansvaret, hvis noget går i stykker under transporten?</div>" +
            "<div class=helpText>Nej. 24moveit formidler kun kontakten mellem flytteren og vognmanden. Aftaler omkring ansvar for gods under transport, " +
            "skal indgås med vognmanden på samme måde, som hvis man havde kontaktet ham på anden vis uden om 24moveit.</div>" +

            "<div class=helpH3 id=redigerFlytning>Jeg har indtastet en flytning, hvordan redigerer eller sletter jeg den?</div>" +
            "<div class=helpText>Flytninger kan ikke redigeres. Du sletter den gamle og oprette en ny istedet. Du finder " +
            "dine indtastede flytninger under menupunktet 'Min konto', som dukker op på menuen, når du er logget ind - " +
            "her kan du slette din indtastede flytning.</div>" +

            "<div class=helpH3 id=sletkonto>Hvordan sletter jeg min konto?</div>" +
            "<div class=helpText>Du sletter sletter din konto under menuen 'Min Konto', som dukker op på menubjælken når du er logget ind.</div>" +


            "<div class=helpH3 id=soegehjaelp>Hvor kan jeg finde hjælp til søgning efter flyttejob?</div>" +
            "<div class=helpText>På søgesiden. Du finder hjælp til søgning efter flyttejob på søgesiden 'Find Flyttejob', " +
            "ved at klikke på linket 'Hjælp til søgning' lige under søgefeltet.</div></html>";



    private static String HELP_ENGLISH = "<html>" +
            "<div class=helpH1>Help</div>" +
            "<div class=helpText>Here you will find the help you need – if not, then please do not hesitate to write to us at " +
            "<span class=a1><a href=\"mailto:contact@24moveit.com\">contact@24moveit.com</a></span>.</div>" +

            "<div class=helpH3 id=kosterDetPenge>How much does it cost to use 24moveit?</div>" +
            "<div class=helpText>It is free to use 24moveit whether you would like to have something moved or you are a moving company who would like to move something for somebody else.</div>" +

            "<div class=helpH3 id=betalingAfVognmand>Do I pay the moving company via 24moveit?</div>" +
            "<div class=helpText>No. 24moveit merely arrange the contact between the customer and the moving company. All arrangements regarding freight, is made with the moving company, in the same way as if you had contacted him without 24moveit.</div>" +

            "<div class=helpH3 id=ansvarOgBeskadigelse>Is 24moveit responsible in case anything breaks during the move?</div>" +
            "<div class=helpText>No. 24moveit merely arrange the contact between the customer and the moving company. All arrangements regarding liability, is made with the moving company, in the same way as if you had contacted him without 24moveit.</div>" +

            "<div class=helpH3 id=redigerFlytning>I have entered a request, how do I edit or delete it?</div>" +
            "<div class=helpText>You cannot edit a request. You must delete the old one and enter a new one instead. You can see your requests under 'My account', which will appear in the menu bar, when you have logged in – here you can delete your request.</div>" +

            "<div class=helpH3 id=sletkonto>How do I delete my account?</div>" +
            "<div class=helpText>You can delete your account under “My account”, which will appear in the menu bar, when you have logged in.</div>" +


            "<div class=helpH3 id=soegehjaelp>Where can I find help in searching for requests?</div>" +
            "<div class=helpText>You can find it in 'Search for relocation jobs'. You will find help for searching requests by clicking 'Help' just beneath the search area.</div></html>";


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LHelp HELP = new LHelp(HELP_DANISH, HELP_ENGLISH, "", "");


}