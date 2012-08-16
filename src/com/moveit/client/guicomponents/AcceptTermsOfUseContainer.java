package com.moveit.client.guicomponents;

/**
 *
 */
public class AcceptTermsOfUseContainer extends CheckBoxContainer {
    private static String name = "Brugsbetingelser";


    public AcceptTermsOfUseContainer(String name, boolean mandatory) {
        super(name, mandatory);
    }


    public String getName() {
        return name;
    }


}