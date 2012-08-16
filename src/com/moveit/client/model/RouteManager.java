package com.moveit.client.model;

import com.moveit.client.gui.ApplicationController;
import com.moveit.client.service.CallBack;
import com.moveit.client.util.GeoPointUtil;
import com.moveit.client.service.Service;
import com.moveit.client.service.RouteListResult;

import java.util.*;

/**
 * Includes a chache of searching.
 */
public class RouteManager {

    private static RouteManager instance = null;
    private ApplicationController appController = ApplicationController.getInstance();

    private Map<SearchCriteria, List<RouteManagerCallBack>> pendingCallBacks = new HashMap<SearchCriteria, List<RouteManagerCallBack>>();
    private Map<SearchCriteria, List<Route>> cache = new HashMap<SearchCriteria, List<Route>>();
    private List<Route> allRoutes = null;


    private RouteManager() {
    }

    public static RouteManager getInstance() {
        if (instance == null) {
            instance = new RouteManager();
        }
        return instance;
    }

    public void getAllRoutes(RouteManagerCallBack cb) {
        getRoutes(new SearchCriteria(), cb);
    }


    public void getRoutes(SearchCriteria sc, RouteManagerCallBack cb) {
        fetchRoutes(sc == null ? new SearchCriteria() : sc, cb);
    }

    private void fetchRoutes(final SearchCriteria sc, final RouteManagerCallBack cb) {
        Service.getAllRoutes(sc.getCountryCode(), new CallBack<RouteListResult>() {
            //notify all pending - on succes or failure
            public void fail(Throwable caught) {
                cb.onFailure(caught);
            }

            public void success(RouteListResult result) {
                allRoutes = result.getRoutes();
                cb.onSucces(extractByCriteria(sc));
            }
        });
        /*}
        else {
            cb.onSucces(extractByCriteria(criteria));
        }
        */
    }


    private List<Route> extractByCriteria(SearchCriteria sc) {
        List<Route> rs = new ArrayList<Route>();
        for (Route route : allRoutes) {
            if (match(sc, route)) {
                rs.add(route);
            }
        }
        return rs;
    }

    private boolean match(SearchCriteria sc, Route r) {
        return matchRadius(sc, r);
    }

    private boolean matchRadius(SearchCriteria sc, Route r) {
        if (sc.hasAreaRestrictions()) {
            if (sc.getLatitude() == null || sc.getLongitude() == null || sc.getRadius() == null) {
                return true;
            }
            double lon = sc.getLongitude();
            double lat = sc.getLatitude();

            GeoPoint from = r.getFromPoint();
            GeoPoint to = r.getToPoint();

            double latDist = GeoPointUtil.getInstance().getLatitudeDistance(sc.getRadius());
            double lonDist = GeoPointUtil.getInstance().getLongitudeDistance(lat, sc.getRadius());
            //noinspection RedundantIfStatement
            if (sc.getFromArea() && from.isInside(lat, lon, latDist, lonDist)) {
                return true;
            }
            //noinspection RedundantIfStatement
            if (sc.getToArea() && to.isInside(lat, lon, latDist, lonDist)) {
                return true;
            }

            //none set = all set
            //noinspection SimplifiableIfStatement
            if (!sc.getFromArea() && !sc.getToArea()) {
                return to.isInside(lat, lon, latDist, lonDist) || from.isInside(lat, lon, latDist, lonDist);
            }
            return false;
        }
        return true;
    }


    //asynchron
    private void fetchRoutesWithCache(final SearchCriteria criteria, final RouteManagerCallBack cb) {
        appController.debug("d");
        //first check if in cache
        List<Route> foundRoutes = cache.get(criteria);
        if (foundRoutes != null) {
            appController.debug("e");
            List<Route> copy = new ArrayList<Route>(foundRoutes);
            Collections.copy(copy, foundRoutes);
            cb.onSucces(copy);
            return;
        }

        //if someone is pending on theese search parameteres - join them
        List<RouteManagerCallBack> cbs = pendingCallBacks.get(criteria);
        if (cbs != null) {
            appController.debug("f");
            cbs.add(cb);
        }
        //make new pending - so others can join.  - in end update cache
        else {
            appController.debug("g");
            cbs = new ArrayList<RouteManagerCallBack>();
            cbs.add(cb);
            pendingCallBacks.put(criteria, cbs);
            Service.getAllRoutes(null, new CallBack<RouteListResult>() {

                //notify all pending - on succes or failure
                public void fail(Throwable caught) {
                    appController.debug("h");
                    List<RouteManagerCallBack> cbs = pendingCallBacks.get(criteria);
                    for (RouteManagerCallBack back : cbs) {
                        back.onFailure(caught);
                    }
                    pendingCallBacks.remove(criteria);
                }

                public void success(RouteListResult result) {
                    appController.debug("i");
                    List<RouteManagerCallBack> cbs = pendingCallBacks.get(criteria);
                    for (RouteManagerCallBack back : cbs) {
                        appController.debug("i1");

                        List<Route> copy = new ArrayList<Route>();
                        appController.debug("i2");

                        Collections.copy(copy, result.getRoutes());
                        appController.debug("i3");

                        back.onSucces(copy);
                        appController.debug("i4");

                    }
                    pendingCallBacks.remove(criteria);
                    //prevent to much memory use
                    if (cache.size() < 30) {
                        cache.put(criteria, result.getRoutes());
                    }
                }
            });
        }
    }


}
