package com.moveit.client.constants;

import com.moveit.client.language.LMailList;
import com.moveit.client.language.LanguagePage;

/**
 *
 */
public class MailListConstant extends IntegerConstant {
    private static final long serialVersionUID = -4420468271852454239L;

    public static MailListConstant NEW_ROUTE_ONCE_A_DAY = new MailListConstant(LMailList.NEWS, 10);
    public static MailListConstant NEWS_24MOVEIT = new MailListConstant(LMailList.NEW_ROUTES, 20);

    static {
        Constant.put(NEW_ROUTE_ONCE_A_DAY);
        Constant.put(NEWS_24MOVEIT);
    }

    public MailListConstant() {
    }

    public MailListConstant(LanguagePage lp, Integer value) {
        super(lp, value);
    }

    public static MailListConstant get(Integer value) {
        return (MailListConstant) Constant.get(MailListConstant.class, value);
    }

}
