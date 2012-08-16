package com.moveit.client.constants;

import com.moveit.client.language.LanguagePage;
import com.moveit.client.language.LMoverType;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class OfferTypeConstant extends IntegerConstant {
    private static final long serialVersionUID = -2367152568742660982L;

    //filled in constructor
    public static Map<Integer, OfferTypeConstant> map = new HashMap<Integer, OfferTypeConstant>();


    public static OfferTypeConstant BASIS = new OfferTypeConstant(LMoverType.BASIS, 0);
    public static OfferTypeConstant PRO = new OfferTypeConstant(LMoverType.PRO, 1);
    public static OfferTypeConstant EXCLUSIVE = new OfferTypeConstant(LMoverType.EXCLUSIVE, 2);


    public static void init() {

    }

    public OfferTypeConstant() {
        super();
    }

    public OfferTypeConstant(LanguagePage lp, Integer value) {
        super(lp, value);
        map.put(value, this);
    }
}