package com.moveit.client.validator;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.moveit.client.guicomponents.DateContainer;
import com.moveit.client.guicomponents.ValueContainer;
import com.moveit.client.language.LValidator;

import java.util.Date;

/**
 *
 */
public class DateLargerOrEqualsOtherDateValidator extends Validator{

    private String ERROR_MSG = LValidator.DATE_LARGER_OR_EQUALS_OHTER_DATE.text()+REPLACE_ITEM;
    private DateContainer dc;

    public DateLargerOrEqualsOtherDateValidator(DateContainer dc) {
        this.dc = dc;
    }

    public String validate(ValueContainer vc) {
        if (vc.isEmpty()) {
            return null;
        }
        String textDate = ((DateContainer)vc).getStringValue();
        DateTimeFormat dateFormat = ((DateContainer)vc).getDateFormat();
        Date d = dateFormat.parse(textDate);

        textDate = dc.getStringValue();
        Date otherDate = dateFormat.parse(textDate);


        if(d.getTime() < otherDate.getTime()){
            return format(ERROR_MSG, dc.getName());
        }
        return null;
    }
}