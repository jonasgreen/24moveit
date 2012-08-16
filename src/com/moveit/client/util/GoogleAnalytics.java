package com.moveit.client.util;

/**
 *
 */
public class GoogleAnalytics {


    public static String ROUTE_CREATED = "route_oprettet";
    public static String FACEBOOK_RECOOMEND_ROUTE = "facebook_recommend_route";
    public static String FACEBOOK_RECOOMEND = "facebook_recommend";
    public static String SHOW_CONTACTINFO_DRIVER = "show_contact_info_driver";


    public static void logPage(String pageName) {
        runGoogleAnalytics("PAGE: " + pageName);
    }


    public static void logAction(String action, String... params) {
        StringBuffer sb = new StringBuffer("ACTION: ").append(action);
        if (params != null && params.length > 0) {
            for (String param : params) {
                sb.append(" [").append(param).append("]");
            }
        }
        runGoogleAnalytics(sb.toString());
    }


    @SuppressWarnings({"AppEngineForbiddenCode"})
    public static native void runGoogleAnalytics() /*-{
        try {
                $wnd.gaTrack = $wnd._gat._getTracker("UA-12456452-1");
                $wnd.gaTrack._trackPageview();
        } catch(err) {}
    }-*/;


    @SuppressWarnings({"AppEngineForbiddenCode"})
    private static native void runGoogleAnalytics(String pageName) /*-{
            try {
                    $wnd.gaTrack._trackPageview(pageName);
            } catch(err) {}
        }-*/;


}
