package com.moveit.client.constants;

import java.util.Map;
import java.util.HashMap;

/**
 *
 */
public class Constant {
    private static Map<Class, Map<Integer, IntegerConstant>> intMap = new HashMap<Class, Map<Integer, IntegerConstant>>();

    public static void put(IntegerConstant ic){
        getMap(ic.getClass()).put(ic.getValue(), ic);
    }

    public static IntegerConstant get(Class clss, Integer value){
        return getMap(clss).get(value);
    }

    public static Map<Integer, IntegerConstant> getMap(Class clss){
        Map<Integer, IntegerConstant> map = intMap.get(clss);
        if(map == null){
            map = new HashMap<Integer, IntegerConstant>();
            intMap.put(clss, map);
        }
        return map;
    }
}
