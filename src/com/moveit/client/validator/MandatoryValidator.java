package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;

/**
 *
 */
public class MandatoryValidator extends Validator {

    private String ERROR_MSG = LValidator.MANDATORY.text();

    public String validate(ValueContainer vc) {
        return vc.isEmpty() ? ERROR_MSG : null;
    }
}
