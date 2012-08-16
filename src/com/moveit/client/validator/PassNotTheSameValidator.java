package com.moveit.client.validator;

import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.guicomponents.PasswordContainer;
import com.moveit.client.language.LValidator;

/**
 *
 */
public class PassNotTheSameValidator extends Validator {
    private PasswordContainer pwContainer;

    public PassNotTheSameValidator(PasswordContainer container) {
        this.pwContainer = container;
    }

    public String validate(ValueContainer vc) {
        String value = (String) vc.getValue();
        if (value != null && !value.equals(pwContainer.getValue())) {
            return LValidator.PASS_NOT_THE_SAME.text()+pwContainer.getName();
        }
        return null;
    }


}