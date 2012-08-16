package com.moveit.client.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class CollectionUtil {
    
    public static <K> ArrayList<K> toArrayList(Collection<K> col) {
        if (col == null) {
            return new ArrayList<K>();
        }
        ArrayList<K> result = new ArrayList<K>();
        for (K k : col) {
            result.add(k);
        }
        return result;
    }
}
