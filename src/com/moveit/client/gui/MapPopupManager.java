package com.moveit.client.gui;

import com.moveit.client.guicomponents.StyleIt;
import com.moveit.client.guicomponents.Name;

/**
 *
 */
public class MapPopupManager {

    //private static MapPopupSelectedCity mapSelPopup = null;
    private static MapPopupSameCity mapPopup = null;
    private static MapPopupSearchHelp help = null;



    public static void showRoutePopup(MapRoute mr, String city) {
        hideRoute();
        mapPopup = new MapPopupSameCity(false, false);
        mapPopup.show(mr, city);

      //  mapSelPopup = new MapPopupSelectedCity(false, false);
      //  mapSelPopup.show(mr);
    }

    public static void showHelpPopup(){
        hideHelpPopup();
        help = new MapPopupSearchHelp(false, false);
        StyleIt.add(help, Name.OPACITY, "0.90");
        StyleIt.add(help, Name.FILTER, "alpha(opacity=90)");
        help.show("asdf");
    }

    public static void hideAll(){
        hideHelpPopup();
        hideRoute();
      //  hideSelRoute();
    }

    public static void hideHelpPopup(){
        if(help != null){
            help.cancelIt();
        }
    }

    public static void hideRoute() {
        if(mapPopup != null){
            mapPopup.cancelIt();
        }
        //hideSelRoute();
    }

    /*public static void hideSelRoute() {
        if(mapSelPopup != null){
            mapSelPopup.cancelIt();
        }
    }
    */

    public static void flipHelp(){
        if(isHelpShowing()){
            hideHelpPopup();
        }
        else{
            showHelpPopup();
        }
    }

    public static boolean isHelpShowing(){
        return help != null && help.isShowing();
    }


}
