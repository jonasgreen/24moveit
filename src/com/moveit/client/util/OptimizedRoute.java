package com.moveit.client.util;

import com.moveit.client.model.Route;
import com.moveit.client.model.GeoPoint;
import com.google.gwt.maps.client.geom.LatLng;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class OptimizedRoute {
    private LatLng start;
    private LatLng end;
    private int maxDistance;
    private int maxJobs;
    private OptimizedRoute parent = null;
    private Route route = null;
    private List<OptimizedRoute> childs = new ArrayList<OptimizedRoute>();
    private int numberInPath;


    public OptimizedRoute(OptimizedRoute parent, int numberInPath, Route route, LatLng start, LatLng end, int maxDistance, int maxJobs) {
        this.route = route;
        this.start = start;
        this.end = end;
        this.maxDistance = maxDistance;
        this.maxJobs = maxJobs;
        this.numberInPath = numberInPath;
        this.parent = parent;
    }

    //recursiv upward to ensure that route is not contained in path.
    public boolean containsUp(Route r) {
        return route != null && (route.getId().longValue() == r.getId() || parent.containsUp(r));
    }

    public void add(List<Route> allroutes) {
        for (Route r : allroutes) {
            if (accepts(r)) {
                childs.add(new OptimizedRoute(this, numberInPath+1, r, start, end, maxDistance, maxJobs));
            }
        }
        for (OptimizedRoute child : childs) {
            child.add(allroutes);
        }
    }


    protected void collectUp(List<Route> list) {
        if (route != null) {
            list.add(0, route);
            parent.collectUp(list);
        }
    }

    public void getOptimizedRoutes(List<List<Route>> collector) {
        for (OptimizedRoute child : childs) {
            child.getOptimizedRoutes(collector);
        }
        if (qualifies()) {
            //creates a list representing the path, by crawling upwards through parents.
            List<Route> list = new ArrayList<Route>();
            list.add(0, route);
            parent.collectUp(list);
            collector.add(list);
        }
    }


    public boolean accepts(Route r) {
        if (numberInPath >= maxJobs || containsUp(r)) {
            return false;
        }

        double lon;
        double lat;
        if (route != null) {
            lon = route.getToPoint().getLongitude();
            lat = route.getToPoint().getLatitude();
        }
        else {
            lon = start.getLongitude();
            lat = start.getLatitude();
        }
        GeoPoint fromPoint = r.getFromPoint();

        double latDist = GeoPointUtil.getInstance().getLatitudeDistance(maxDistance);
        double lonDist = GeoPointUtil.getInstance().getLongitudeDistance(lat, maxDistance);

        //noinspection RedundantIfStatement
        return fromPoint.isInside(lat, lon, latDist, lonDist);
    }

    public boolean qualifies() {
        if (route == null) {
            return false;
        }

        double lon = end.getLongitude();
        double lat = end.getLatitude();

        GeoPoint toPoint = route.getToPoint();

        double latDist = GeoPointUtil.getInstance().getLatitudeDistance(maxDistance);
        double lonDist = GeoPointUtil.getInstance().getLongitudeDistance(lat, maxDistance);

        //noinspection RedundantIfStatement
        return toPoint.isInside(lat, lon, latDist, lonDist);

    }

    public void print(StringBuffer sb) {
        sb.append(numberInPath);
        if (parent == null) {

        }
        else {
            appendTap(sb);
            sb.append(route.getFromPoint().getAddress().getCityCityCodeAndNationCode()).append(" - ").append(route.getToPoint().getAddress().getCityCityCodeAndNationCode()).append("\n");

        }
        for (OptimizedRoute child : childs) {
            child.print(sb);
        }
    }

    private void appendTap(StringBuffer sb) {
        int i = 0;
        while (i++ < numberInPath) {
            sb.append("    ");
        }
    }


}
