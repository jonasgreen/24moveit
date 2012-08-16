package com.moveit.client.validator;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.moveit.client.guicomponents.DateContainer;
import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;

import java.util.Date;

/**
 *
 */
public class DateLargerOrEqualsTodayValidator extends Validator{

    private String ERROR_MSG = LValidator.DATE_LARGER_OR_EQUALS_TODAY.text();


    public String validate(ValueContainer vc) {
        if (vc.isEmpty()) {
            return null;
        }
        String textDate = ((DateContainer)vc).getStringValue();
        DateTimeFormat dateFormat = ((DateContainer)vc).getDateFormat();
        Date d = dateFormat.parse(textDate);
        Date today = dateFormat.parse(dateFormat.format(new Date()));

        if(d.getTime() < today.getTime()){
            return ERROR_MSG;
        }
        return null;
    }
}