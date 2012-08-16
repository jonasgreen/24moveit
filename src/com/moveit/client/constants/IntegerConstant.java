package com.moveit.client.constants;

import com.moveit.client.language.LanguagePage;

import java.io.Serializable;

/**
 *
 */
public abstract class IntegerConstant implements Serializable{

    private Integer value;
    private LanguagePage languagePage;

    protected IntegerConstant() {
    }

    public IntegerConstant(LanguagePage lp, Integer value) {
        this.languagePage = lp;
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public String getText() {
        return languagePage.text();
    }


}
