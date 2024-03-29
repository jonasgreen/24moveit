package com.moveit.client.guicomponents;

/**
 *
 */
public class ColorWheel {
    private P[] colors;
    private int index = 0;

    public ColorWheel(P ... cls) {
        this.colors = cls;
    }


    public P getNext(){
        if(index == colors.length){
            index = 0;
        }
        return colors[index++];
    }

    public void rollBack(){
        index = 0;
    }
}
