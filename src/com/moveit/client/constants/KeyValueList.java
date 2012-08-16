package com.moveit.client.constants;

import com.moveit.client.gui.ApplicationController;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.io.Serializable;

/**
 *
 */
public class KeyValueList<T> implements Serializable{
    private static final long serialVersionUID = 640288844012954759L;

    private List<String> keys = new ArrayList<String>();
    private List<T> values = new ArrayList<T>();


    public KeyValueList(){

    }

    public KeyValueList(List<String> keys, List<T> values) {
        this.keys = keys;
        this.values = values;
        validate();
    }

    public KeyValueList(String[] keys, T[] values) {
        this.keys = Arrays.asList(keys);
        this.values = Arrays.asList(values);
        validate();
    }

    public KeyValueList(SortedMap<String, T> itemValues) {
        for (String s : itemValues.keySet()) {
            this.keys.add(s);
        }
        for (T t : itemValues.values()) {
            this.values.add(t);
        }
        validate();
    }

    private void validate() {
        if (keys.size() != values.size()) {
            ApplicationController.getInstance().error(this.getClass().getName() + "items.length != values.length.");
        }
    }

    public String getKey(int index){
        return keys.get(index);
    }

    

    public void add(String key, T value){
        keys.add(key);
        values.add(value);
    }

    public T getValue(int index){
        return values.get(index);
    }

    public List<String> getKeys() {
        return keys;
    }

    public List<T> getValues() {
        return values;
    }
}
