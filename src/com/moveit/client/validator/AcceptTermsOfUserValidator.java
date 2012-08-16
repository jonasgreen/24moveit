package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;


/**
 *
 */
public class AcceptTermsOfUserValidator extends Validator {


    private String ERROR_MSG = LValidator.ACCEPT_TERMS_OF_USE.text();

    public String validate(ValueContainer vc) {
        Boolean value = (Boolean) vc.getValue();
        if (value) {
            return null;
        }
        return ERROR_MSG;
    }


}