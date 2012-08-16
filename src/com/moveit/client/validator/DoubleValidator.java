package com.moveit.client.validator;

import com.moveit.client.guicomponents.DoubleContainer;
import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;

/**
 *
 */
public class DoubleValidator extends Validator{

    private String ERROR_MSG = LValidator.DOUBLE_FORMAT.text();


    public String validate(ValueContainer vc) {
        if (vc.isEmpty()) {
            return null;
        }
        try {
            ((DoubleContainer)vc).getValue();            
            return null;
        }
        catch (Throwable t) {
            return ERROR_MSG;
        }

    }
}