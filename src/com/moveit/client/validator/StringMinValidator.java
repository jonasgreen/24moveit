package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;

/**
 *
 */
public class StringMinValidator extends Validator {
    private String ERROR_MSG = LValidator.STRING_MIN_1.text() + REPLACE_ITEM + LValidator.STRING_MIN_2.text();

    private int minLength = 0;

    public StringMinValidator(int minLength) {
        this.minLength = minLength;
    }

    public String validate(ValueContainer vc) {
        String value = (String) vc.getValue();
        if (value == null || value.trim().length() < minLength) {
            return format(ERROR_MSG, minLength);
        }
        return null;
    }


}
