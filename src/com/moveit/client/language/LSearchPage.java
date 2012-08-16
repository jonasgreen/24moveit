package com.moveit.client.language;

/**
 *
 */
public class LSearchPage extends LanguagePage{
    private static final long serialVersionUID = 4611511556659687648L;

    public LSearchPage() {
    }

    public LSearchPage(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LSearchPage SEARCH_HELP = new LSearchPage("Hjælp til søgning", "Search help", "", "");
    


    public static LSearchPage ADJUST_SEARCH = new LSearchPage("Tilpas søgning", "Adjust search", "", "");

    public static LSearchPage FOUND_ROUTES = new LSearchPage(" flyttejobs fundet.", " requests found.", "", "");

    public static LSearchPage HEADER_CREATED = new LSearchPage("Oprettet", "Created", "", "");
    public static LSearchPage HEADER_FROM = new LSearchPage("Fra", "From", "", "");
    public static LSearchPage HEADER_TO = new LSearchPage("Til", "To", "", "");
    public static LSearchPage HEADER_PERIOD = new LSearchPage("Flyttetidspunkt","Moving date", "", "");
    public static LSearchPage HEADER_DESCRIPTION = new LSearchPage("Beskrivelse", "Description", "", "");
    public static LSearchPage HEADER_CATEGORI = new LSearchPage("Kategori", "Category", "", "");



    public static LSearchPage SHOW_CONTACT_INFO_1 = new LSearchPage("Vis kontaktinfo (vist ", "Show contact info (shown ", "", "");
    public static LSearchPage SHOW_CONTACT_INFO_2 = new LSearchPage(" gange)", " times)", "", "");
    public static LSearchPage CONTACT_INFO_TITLE = new LSearchPage("Klik for at se kontaktinfo", "Click to see contact info", "", "");

    public static LSearchPage SHOW_DESCRIPTION = new LSearchPage("Vis beskrivelse", "Show description", "", "");

    public static LSearchPage TODAY = new LSearchPage("Idag", "Today", "", "");
    public static LSearchPage YESTERDAY = new LSearchPage("Igår", "Yesterday", "", "");

    public static LSearchPage SELECT_ALL = new LSearchPage("Vælg alle", "Select all", "", "");
    public static LSearchPage SELECT_NONE = new LSearchPage("Fjern alle", "Remove all", "", "");


    public static LSearchPage HELP_1 = new LSearchPage("Sådan søger du efter flytteøsnker", "Searching for requests", "", "");
    public static LSearchPage HELP_2 = new LSearchPage("Søgninger foretages ved at indtaste en by i søgefeltet og trykke på 'søg'. De fundne flyttejobs vises på kortet og i en tabel nederst på siden. <b>Kontaktinformation</b> for det enkelte flyttejob findes ved at klikke på en række i resultatlisten.", "You search by entering a city in the search field and pressing, 'Search'. The found requests are indicated on the map and in a table at the bottom of the page. The <b>contact information</b> of the request in question is found by clicking a row in the result list.", "", "");
    public static LSearchPage HELP_3 = new LSearchPage("Flytteønsker vises på kortet som  <img src=\"route.png\"/> og symboliserer hvor kunden vil have sine ting flyttet 'fra' og 'til'.", "Requests are shown on the map as <img src=\"route.png\"/> and indicate where the customer would like his things moved from and to.", "", "");

    private static String HELP_4_DANISH = "Under <b>avancerede søgeindstillinger</b> kan 'radius' og andre indstillinger ændres. Indstillingsmulighederne er:" +
                "<ul><li><b>Radius</b>: Angiver indenfor hvilken radius fra centrum af den indtastede by der søges.</li>" +
                "<li><b>Flytninger fra området</b>: Angiver om flytteønsker hvor 'fra' ligger indenfor radius skal medtages.</li>" +
                "<li><b>Flytninger til området</b>: Angiver om flytteønsker hvor 'til' ligger indenfor radius skal medtages. På den måde kan man styre, om man kun vil se flytteønsker til området, fra området - eller begge dele.</li>" +
                "<li><b>Fra- og tildato</b>: Søgningen medtager kun de flytteønsker, vis ønskede flytteperiode ligger indenfor - eller delvist indenfor - den her angivne periode.</li></ul>";

private static String HELP_4_ENGLISH = "In <b>advanced search</b> radius and other defaults can be changed. The options are:" +
                "<ul><li><b>Radius</b>: Indicates the radius from the centre of the entered city.</li>" +
                "<li><b>Relocations from the area</b>: Indicates if requests starting in the area (within the radius) should be included.</li>" +
                "<li><b>Relocations to the area</b>: Indicates if requests ending in the area (within the radius) should be included. In this way you can choose if you prefer to just see requests to the area, from the area, or both.</li>" +
                "<li><b>From and to date</b>: The search only includes the requests with a timeframe within or partly within the entered date.</li></ul>";


    public static LSearchPage HELP_4 = new LSearchPage(HELP_4_DANISH, HELP_4_ENGLISH, "", "");
    public static LSearchPage HELP_5 = new LSearchPage("<b>Tips:</b> Klikker man på 'fra' eller 'til'-ballonen på kortet, forstørres ballonerne og bliver gule. Samtidig udvides det tilhørende resultat i resultatlisten nederst på siden, hvor man nu kan se kontaktinformationer. Det samme sker, hvis man klikker på et resultat i resultatlisten.", "<b>Tip</b>: If you click the 'from' or 'to' balloon on the map, the balloons will enlarge and become yellow. At the same time the result in the result list will be opened and you can now see the contact information of the request. You can also double click the request in the result list to view the contact information.", "", "");

    public static LSearchPage SEARCH_PANE = new LSearchPage("Søgeresultat", "Search result", "", "");


}