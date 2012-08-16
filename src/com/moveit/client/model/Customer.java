package com.moveit.client.model;

import com.moveit.client.constants.UserTypeConstant;

import java.io.Serializable;

/**
 *
 */
public class Customer extends UserType implements Serializable{

    private static final long serialVersionUID = -4791212645243909431L;


    public Integer getTypeValue() {
        return UserTypeConstant.CUSTOMER.getValue();
    }
}
