package com.moveit.client.constants;

import java.io.Serializable;

/**
 *
 */
public class CounterConstant implements Serializable {
    private static final long serialVersionUID = -8195397317754514340L;

    public static CounterConstant NEW_ROUTES = new CounterConstant("NEW_ROUTES", 1);


    public static void init() {

    }


    private String name;
    private Integer value;

    public CounterConstant() {
        super();
    }

    public CounterConstant(String name, Integer value) {
        this.name= name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}