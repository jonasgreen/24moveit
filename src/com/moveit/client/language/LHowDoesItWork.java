package com.moveit.client.language;

/**
 *
 */
public class LHowDoesItWork extends LanguagePage {
    private static final long serialVersionUID = 4551614896582915909L;

    public LHowDoesItWork() {
    }

    public LHowDoesItWork(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.


    private static String HOW_DANISH = "<html>" +
            "<div class=helpH1>Hvordan virker det?</div>" +
            "<div class=helpNumberSpace><span class=helpNumber>1</span><span class=helpNumberText>Du indtaster hvorfra og hvortil du vil ha' flyttet dine ting. Informationerne gemmes i systemet.</span></div>" +
            "<div class=helpNumberSpace><span class=helpNumber>2</span><span class=helpNumberText>Vognmænd ser dit flytte-ønske og kontakter dig med uforpligtende tilbud.</span></div>" +
            "<div class=helpNumberSpace><span class=helpNumber>3</span><span class=helpNumberText>Du udvælger det billigste og laver en aftale med vognmanden, som flytter dine ting.</span></div>" +

            "<div class=helpH3>Du sparer penge</div>" +
            "<div class=helpText>Vognmanden planlægger sine ruter ud fra forskellige flytteønsker, og undgår derfor i højere " +
            "grad at køre med tomme læs. Alt andet lige, kan han tilbyde dig en bedre pris.</div>" +

            "<div class=helpH3>Du sparer tid</div>" +
            "<div class=helpText>Du behøver ikke bruge tid på at undersøge markedet - markedet kommer til dig. " +
            "Slut med at ringe rundt til vognmænd, " +
            "som enten er for dyre, ikke har tid, eller ikke vil fordi de ikke har noget at fragte den anden vej.</div>" +

            "<div class=helpH3>Du sparer CO2</div>" +
            "<div class=helpText>Hver dag kører tusindevis og atter tusindevis af lastbiler rundt i verden med tomme læs. Hvis " +
            "vi kan effektivisere den kørsel og undgå unødige ture, kan der spares rigtig meget CO2 til fordel for miljøet.</div>" +

            "<div class=helpH3>Vognmanden har bedre indtjeningsmuligheder</div>" +
            "<div class=helpText>Ud fra de forskellige flytteønsker i systemet, " +
            "kan vognmanden planlægge og optimere sine ruter, så han undgår at kører med tomme læs. På den måde sparer han både tid og penge. Samtidig finder han nemmere " +
            "folk, som vil ha' flyttet noget, hvilket giver mere arbejde og bedre indtjeningsmuligheder.</div>" +

            "</html>";


    private static String HOW_ENGLISH = "<html>" +
            "<div class=helpH1>How does it work?</div>" +
            "<div class=helpNumberSpace><span class=helpNumber>1</span><span class=helpNumberText>You enter wherefrom and whereto you would like your things removed. The entered information will be saved in the system.</span></div>" +
            "<div class=helpNumberSpace><span class=helpNumber>2</span><span class=helpNumberText>Moving companies will see your request and contact you with free quotes.</span></div>" +
            "<div class=helpNumberSpace><span class=helpNumber>3</span><span class=helpNumberText>You choose the best quote and make arrangemens with the moving company, who moves your things.</span></div>" +

            "<div class=helpH3>You save money</div>" +
            "<div class=helpText>Cheaper relocations. The moving company plans its routes from different relocation jobs thus avoiding empty loads. This makes it easier for the moving company to give you a good quote.</div>" +

            "<div class=helpH3>You save time</div>" +
            "<div class=helpText>You don’t need to spend time searching the market – the market will come to you. No more contacting different moving companies, who are either too expensive, don’t have the time, or won’t because they will have an empty load in one direction.</div>" +

            "<div class=helpH3>You save CO2</div>" +
            "<div class=helpText>Every day thousands of vans around the world ride with empty loads. If we can optimize and avoid unnecessary trips, lots of CO2 can be reduced to the benefit of the environment.</div>" +

            "<div class=helpH3>The moving company have better earning options</div>" +
            "<div class=helpText>From the various requests in the system, the moving company can plan and optimize his routes to avoid riding with empty loads. This way he can save both money and time. At the same time it is easier for him to find people who need to have something moved – meaning more work and better earnings.</div>" +

            "</html>";

    public static LHowDoesItWork HOW = new LHowDoesItWork(HOW_DANISH, HOW_ENGLISH, "", "");

}