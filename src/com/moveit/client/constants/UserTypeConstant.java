package com.moveit.client.constants;

import com.moveit.client.language.LanguagePage;
import com.moveit.client.language.LUserType;

/**
 *
 */
public class UserTypeConstant extends IntegerConstant{
    private static final long serialVersionUID = 3451908949098816778L;

    public static UserTypeConstant CUSTOMER = new UserTypeConstant(LUserType.CUSTOMER, 1);
    public static UserTypeConstant DRIVER = new UserTypeConstant(LUserType.DRIVER, 2);
    public static UserTypeConstant DRIVER_DMF = new UserTypeConstant(LUserType.DRIVER_DMF, 3);


    public UserTypeConstant(LanguagePage lp, Integer value) {
        super(lp, value);
    }
}
