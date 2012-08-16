package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.Language;
import com.moveit.client.language.LValidator;
import com.moveit.client.util.CvrNr;


/**
 *
 */
public class CvrValidator extends Validator {


    private String ERROR_FORMAT_MSG = LValidator.CVR_FORMAT.text();
    private String ERROR_CVR_MSG = LValidator.CVR.text();


    public CvrValidator() {
    }

    public String validate(ValueContainer vc) {
        //only validate danish cvr
        if(Language.language != Language.DANISH){
            return null;
        }

        String value = (String) vc.getValue();
        Long cvrNr = null;
        if (value == null || value.length() != 8) {
            return ERROR_FORMAT_MSG;
        }
        try {
            Long.valueOf(value);
        }
        catch (Throwable e) {
            return ERROR_FORMAT_MSG;
        }

        if (!CvrNr.validate(value)) {
            return ERROR_CVR_MSG;
        }

        return null;
    }


}