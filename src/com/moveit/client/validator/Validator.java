package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;

/**
 *
 */
public abstract class Validator {

    public static String REPLACE_ITEM = "#";








    public static AcceptTermsOfUserValidator ACCEPT_TERMS_OF_USE = new AcceptTermsOfUserValidator();


    public abstract String validate(ValueContainer vc);

    public String format(String msg, Object ... values){
        String retMsg = msg;
        for (Object value : values) {
            
            retMsg = retMsg.replaceFirst(REPLACE_ITEM, String.valueOf(value));
        }
        return retMsg;
    }

}
