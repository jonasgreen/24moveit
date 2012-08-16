package com.moveit.server.seo;

/**
 *
 */
public abstract class DanishBody extends Body {

    private static String[] H1 = new String[]{
            "#",
            "Ting du skal overveje ved transport og #",
            "Når du skal have # og billige flyttemænd",
            "flytteportal 24moveit giver uforpligtende tilbud på # fra vognmænd",
            "Du får gode og gratis forslag på # via flytteportalen 24moveit",
            "# uden problemer",
            "Konklusion ved flytning og transport"};

    private static String[] H2 = new String[]{
            "# i Danmark",
            "# gode råd og kvalitet",
            "# i europa",
            "Du skal have #",
            "Når du flytter",
            "Top ti gode råd",
            "# anbefales af vognmænd"};

    private static String[] H3 = new String[]{
            "Bil og #",
            "# og flyttekaser",
            "# og kvalitet",
            "Du skal huske # hver gang",
            "# hver gang",
            "Kommune og #",
            "# af private"};


    private static String s1 = "Med 24moveit får du mulighed for at benytte dig af danmarks bedste flytteportal. " +
            "Skal du fx #, så er dette siden for dig. Man kommer ikke uden om at 24moveit.appspot.com giver de bedste tilbud med de bedste vognmænd og flyttefirmaer. " +
            "# finde nemt og billigt og er kvalitetssikret gennem 24moveit.com.appspot. De sparer masser af penge ved at bruge denne side.";

    private static String s2 = "# er kvaliteten helt i top. Du skal ikke bekymrer dig om sikkerheden, da der er masser af garanti. Det er ikke sikkert at du kan bruge denne " +
            "side, men du kan da prøve. Transport burde ikke være noget problem. En ladvogn kan gøre det billigt for dig. Er du tilgængæld ikke vognmand, så" +
            " skal du ikke regne med at det koster penge. Her får du de billigste tilbud.";

    private static String s3 = "Mange forskellige typer af lastbiler er understøtet. Lastbil med lad, uden lad. Når du # undgår flyttemanden tomt læs og du sparer penge." +
            " Flytteportalen sørger for at det sker. Du får tilbud via telefon eller email. Fatisk kan man sige at det er en flyttebørs.";

    private static String s4 = "Der findes flytteforretninger i hele europa. I usa er der store flyttefirmaer usa, flyttefirma danmark, flyttefirma europa osv. " +
            "En international flytning er fx flytning til sverige eller flytning til tyskland, men kan også bare foregå til england.";


    private static String s5 = "Når flytteforretningen er bestilt, skal du huske at pakke alt ned inden du #. Flyttekasser er en god ide at invistere i - " +
            "men kan være dyre, hvis du skal købe dem fra ny. Overvej # istedet. Eller benyt 24moveit og spar penge på din flytning. Du kan også tage noget med for " +
            "andre i din egen bil. På den måde er du med til at redde miljøet - hvilket er rigtig godt for mange folk, som dig og mig.";

    private static String s6 = "Transporten foregår via planlagte ruter. På den måde sikres vognmænd en stor gevinst og sparer en masser penge. " +
            "# i hele danmark, tyskland, norge og europa. Du får uforpligtende flyttetilbud og sparer en masse penge. Skal du ha en anden lejlighed " +
            "eller et købe hus, kan det også svarer sig at benytte 24moveit.appspot.com - helt sikkert.";

    private static String s7 = "Hos os bestræber vi os på at levere en hvilken som helst flytning af høj kvalitet, #, til priser hvor alle kan være med. Essensen for en god flytning ligger for os i dialogen med kunden, derfor ønsker vi også at komme til Dem for at få en snak for ønske om den nær forestående flytning.\n" +
            "Tilbuddet bliver givet skriftligt og er et gratis uforpligtigende tilbud." +
            "Vi er naturligvis medlem af DTL og Dansk Møbeltransport Foreningen.";

    private static String[] sections = new String[]{s1, s2, s3, s4, s5, s6, s7};


    private static String[] pictures = new String[]{
            "#",
            "Vognmand og #",
            "# og transport",
            "Det går hurtigt og # er nemt med flyttefirma",
            "# Når du flytter internationalt",
            "Top ti gode råd og #",
            "# kan kun anbefales"};


    private static String[] genericLinks = new String[]{
            "http://www.flytning-dmf.dk/"
            , "http://www.holger-danske.dk"
            , "http://www.flyttemandolsen.dk"
            , "http://www.hoejlundsflyttefirma.dk"
            , "http://www.dupont-flytning.dk"
            , "http://www.moveit-int.dk"
            , "http://www.jonas-co.dk"
            , "http://www.interexpress.dk"
            , "http://www.bjflyt.dk"
            , "http://www.bjflyt.dk"
            , "http://www.frederiksholm.dk"
            , "http://www.gundermann-flyt.dk"
            , "http://www.vanloese-flyt.dk"
            , "http://www.mobel.dk"
            , "http://www.packman-worldwide.dk"
            , "http://www.bft.dk"
            , "http://www.flytning.dk"
            , "http://www.43735555.dk"
            , "http://www.adam.dk"
            , "http://www.kleberg.dk"
            , "http://www.partner-co.dk"
            , "http://www.rixflyt.dk"
            , "http://www.bryde-as.dk"
            , "http://www.flyttexperten.dk"
            , "http://www.flyt.dk"
            , "http://www.jd-transport.dk"
            , "http://www.lyngby-flyt.dk"
            , "http://www.holte-flyt.dk"
            , "http://www.sjacobsen.dk"
            , "http://www.hjort-olsen.dk"
            , "http://www.goliat.dk"
            , "http://www.windum.dk"
            , "http://www.hmflyt.dk"
            , "http://www.frederikssundflyt.dk"
            , "http://www.schou-flyt.dk"
            , "http://www.usisaat.gl"
            , "http://www.mosgaard.dk"
            , "http://www.handyflyt.dk"
            , "http://www.jp-distribution.dk"
            , "http://www.slagelseflytteforretning.dk"
            , "http://www.bagsvaerd-flyt.dk"
            , "http://www.fuglebjerg-flyt.dk"
            , "http://www.den-lille-groenne.dk"
            , "http://www.fti.dk"
            , "http://www.koegeflyt.dk"
            , "http://www.knflytteservice.dk"
            , "http://www.continental-removal.dk"
            , "http://www.hshtransport.dk"
            , "http://www.sydhavsflyt.dk"
            , "http://www.fyns-flyt.dk"
            , "http://www.mobel.dk"
            , "http://www.flytnemt.dk"
            , "http://www.just-justesen.dk"
            , "http://www.royalflyt.dk"
            , "http://www.svendborg-moebeltransport.dk"
            , "http://www.cp-flyt.dk"
            , "http://www.A9-flyt.dk"
            , "http://www.abcflytteforretning.dk"
            , "http://www.aabmobeltrans.dk"
            , "http://www.kvik-flyt.dk"
            , "http://www.aarsland.dk"
            , "http://www.aagaardflyt.dk"
            , "http://www.dueholm-vf.dk"
            , "http://www.bechsflytteforretning.dk"
            , "http://www.falks.dk"
            , "http://www.universaltransport.dk"
            , "http://www.holstebro-flytteforretning.dk"
            , "http://www.thyflytteservice.dk"
            , "http://www.skive-flytteforretning.dk"
            , "http://www.mobel.dk"
            , "http://www.cityflyttetransport.dk"
            , "http://www.hvejsel.com"
            , "http://www.aarhus-moebeltransport.dk"
            , "http://www.jydsk-flytteforretning.dk"
            , "http://www.djurslandflytteforretning.dk"
            , "http://www.gerdsen.dk"
            , "http://www.silkeborg-flytteforretning.dk"
            , "http://www.hff.dk"
            , "http://www.bmtrans.dk"
            , "http://www.viborg-ny-flytteforretning.dk"
            , "http://www.al-trans.dk"
            , "http://www.j-odum.dk"
            , "http://www.pc-oestergaard.dk"
            , "http://www.obro.dk"
            , "http://www.scantransport.dk"
            , "http://www.himmerlandsflyt.dk"
            , "http://www.brflyt.dk"
            , "http://www.flem-flyt.dk"
            , "http://www.tps-flytteforretning.dk"
            , "http://www.frederikshavn-flytteforretning.dk"};


    public String[] getH1s() {
        return H1;
    }


    public String[] getH2s() {
        return H2;
    }


    public String[] getH3s() {
        return H3;
    }

    public String[] getSections() {
        return sections;
    }

    public String[] getGenericLinks() {
        return genericLinks;
    }

    public String[] getPics() {
        return pictures;
    }

    public abstract String[] getSpecificLinks();


}
