package com.moveit.client.model;


import com.moveit.client.constants.CounterConstant;

import java.io.Serializable;

/**
 *
 */
public class CreateCounter extends Creater implements Serializable {
    private static final long serialVersionUID = -3099175629769938469L;

    private CounterConstant counterConstant;

    public CreateCounter(CounterConstant cc){
        this.counterConstant = cc;
    }

    public CounterConstant getCounterConstant() {
        return counterConstant;
    }
}