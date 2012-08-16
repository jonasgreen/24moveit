package com.moveit.client.constants;

import com.moveit.client.language.LCargoType;
import com.moveit.client.language.LanguagePage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CargoTypeConstant extends IntegerConstant{
    private static final long serialVersionUID = -6066364641909605187L;

    //filled in constructor
    public static Map<Integer, CargoTypeConstant> itemMap = new HashMap<Integer, CargoTypeConstant>();

    public static CargoTypeConstant FURNITURE = new CargoTypeConstant(LCargoType.FURNITURE, 10);
    public static CargoTypeConstant FREEZE = new CargoTypeConstant(LCargoType.FREEZE, 20);
    public static CargoTypeConstant STONE_SAND = new CargoTypeConstant(LCargoType.STONE_SAND, 30);
    public static CargoTypeConstant DANGER = new CargoTypeConstant(LCargoType.DANGER, 40);
    public static CargoTypeConstant ANIMALS = new CargoTypeConstant(LCargoType.ANIMALS, 50);
    public static CargoTypeConstant OTHER = new CargoTypeConstant(LCargoType.OTHER, 100);

    public static void init(){

    }

    private CargoTypeConstant(LanguagePage lp, Integer value) {
        super(lp, value);
        itemMap.put(value, this);
    }

    public static KeyValueList<Integer> getList(){
        KeyValueList<Integer> list = new KeyValueList<Integer>();
        list.add(FURNITURE.getText(), FURNITURE.getValue());
        list.add(FREEZE.getText(), FREEZE.getValue());
        list.add(STONE_SAND.getText(), STONE_SAND.getValue());
        list.add(DANGER.getText(), DANGER.getValue());
        list.add(ANIMALS.getText(), ANIMALS.getValue());
        list.add(OTHER.getText(), OTHER.getValue());
        return list;
    }
}