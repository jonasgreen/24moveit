package com.moveit.client;

import com.moveit.client.model.Route;

/**
 *
 */
public class Global {

    private static Route lastSavedRoute;

    public static Route getLastSavedRoute() {
        return lastSavedRoute;
    }

    public static void setLastSavedRoute(Route lastSavedRoute) {
        Global.lastSavedRoute = lastSavedRoute;
    }
}
