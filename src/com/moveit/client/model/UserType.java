package com.moveit.client.model;

import java.io.Serializable;

/**
 *
 */
public abstract class UserType extends Model implements Serializable{
    private static final long serialVersionUID = 9210693082694808306L;

    public abstract Integer getTypeValue();
}
