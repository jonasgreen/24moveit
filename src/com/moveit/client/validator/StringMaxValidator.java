package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;


/**
 *
 */
public class StringMaxValidator extends Validator {


    private String ERROR_MSG = LValidator.STRING_MAX_1.text() + REPLACE_ITEM + LValidator.STRING_MAX_2.text();

    private int maxLength = 0;

    public StringMaxValidator(int maxLength) {
        this.maxLength = maxLength;
    }

    public String validate(ValueContainer vc) {
        String value = (String) vc.getValue();
        if (value != null) {
            if (value.length() > maxLength) {
                return format(ERROR_MSG, maxLength);
            }
        }
        return null;
    }


    public int getMaxLength() {
        return maxLength;
    }
}
