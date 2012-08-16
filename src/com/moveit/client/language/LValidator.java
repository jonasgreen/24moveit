package com.moveit.client.language;

/**
 *
 */
public class LValidator extends LanguagePage{
    private static final long serialVersionUID = 4551614896582915909L;

    public LValidator() {
    }

    public LValidator(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LValidator PROBLEM = new LValidator("problem", "problem", "", "");
    public static LValidator PROBLEMS = new LValidator("problemer", "problems", "", "");



    public static LValidator ACCEPT_TERMS_OF_USE = new LValidator("er ikke accepteret", "is not accepted", "", "");

    public static LValidator CVR = new LValidator("er ikke gyldigt", "is not valid", "", "");
    public static LValidator CVR_FORMAT = new LValidator("skal bestå af 8 cifre", "has to be 8 digits long", "", "");





    public static LValidator DATE_LARGER_OR_EQUALS_OHTER_DATE = new LValidator("må ikke være før ", "must not be before ", "", "");
    public static LValidator DATE_LARGER_OR_EQUALS_TODAY = new LValidator("må ikke være før dags dato", "must not be before today", "", "");

    public static LValidator DATE_FORMAT = new LValidator("har et ugyldigt format. Lovligt format er: ", "has an incorrect format. Correct format is: ", "", "");

    public static LValidator DOUBLE_FORMAT = new LValidator("har et ugyldigt format. Skal være et tal (fx 3 eller 3,4)", "has an incorrect format. Has to be a number (eg 3 or 3.4)", "", "");

    public static LValidator MANDATORY = new LValidator("skal udfyldes", "is missing", "", "");

    public static LValidator PASS_NOT_THE_SAME = new LValidator("er ikke magen til ", "is not the same as ", "", "");

    public static LValidator STRING_MIN_1 = new LValidator("skal minimum indholde ", "must be at least ", "", "");
    public static LValidator STRING_MIN_2 = new LValidator("karakterer", "characters", "", "");


    public static LValidator STRING_MAX_1 = new LValidator("må ikke være længere end ", "must not exceed ", "", "");
    public static LValidator STRING_MAX_2 = new LValidator("karakterer", "caracters", "", "");

}