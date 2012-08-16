package com.moveit.client.validator;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.moveit.client.guicomponents.DateContainer;
import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;

import java.util.Date;

/**
 *
 */
public class DateValidator extends Validator{

    private String ERROR_MSG = LValidator.DATE_FORMAT.text() + REPLACE_ITEM;


    public String validate(ValueContainer vc) {
        if (vc.isEmpty()) {
            return null;
        }
        String textDate = ((DateContainer)vc).getStringValue();
        String checkDate = "Empty_xxx";
        DateTimeFormat dateFormat = ((DateContainer)vc).getDateFormat();
        try {
            Date d = dateFormat.parse(textDate);
            checkDate = dateFormat.format(d);
        }
        catch (Throwable t) {
            //ignore
        }
        if(textDate.equals(checkDate)){
            return null;
        }
        return format(ERROR_MSG, dateFormat.getPattern().toLowerCase());
    }
}
