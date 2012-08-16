package com.moveit.client.guicomponents;

/**
 *
 */
public interface ValueContainer{

    public abstract void setValue(Object obj);

    public abstract Object getValue();

    public abstract boolean isEmpty();
}
