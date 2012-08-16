package com.moveit.client.guicomponents;

/**
 *
 */
public class LayoutWheel {

    private Layout17[] layouts;
    private int index = 0;

    public LayoutWheel(Layout17[] layouts) {
        this.layouts = layouts;
    }


    public Layout17 getNext(){
        if(index == layouts.length){
            index = 0;
        }
        return layouts[index++];
    }
}
