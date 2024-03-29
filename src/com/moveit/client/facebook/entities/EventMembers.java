package com.moveit.client.facebook.entities;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.moveit.client.facebook.Util;

/**
 * See event members
 * 
 */
public class EventMembers extends JavaScriptObject {

    protected EventMembers() {
    }

    public final native JsArrayNumber getAttendingArray() /*-{
        return this.attending;
    }-*/;

    public final List<Long> getAttending() {
        return Util.convertNumberArray ( getAttendingArray () );
    }

    public final native JsArrayNumber getUnsureArray() /*-{
        try {
            return this.unsure;
        } catch ( err ) {
            alert ( "ERROR" ); 
            return [];
        }
    }-*/;

    public final List<Long> getUnsure() {
        return Util.convertNumberArray ( getUnsureArray () );
    }
    

    public final native JsArrayNumber getNotRepliedArray() /*-{
        return this.not_replied;
    }-*/;
    
    public final List<Long> getNotReplied() {
        return Util.convertNumberArray ( getNotRepliedArray () );
    }
   
}
