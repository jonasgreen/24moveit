package com.moveit.client.util;

import com.google.gwt.maps.client.geom.LatLng;
import com.moveit.client.model.Route;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Optimize {

    private LatLng from;
    private LatLng to;
    private Integer maxJobs;
    private Integer maxDistance;
    private List<Route> allRoutes;

    public Optimize(LatLng from, LatLng to, Integer maxJobs, Integer maxDistance, List<Route> allRoutes) {
        this.from = from;
        this.to = to;
        this.maxJobs = maxJobs;
        this.maxDistance = maxDistance;
        this.allRoutes = allRoutes;
    }

    public List<List<Route>> getOptimized() {
        OptimizedRoute or = new OptimizedRoute(null, 0, null, from, to, maxDistance, maxJobs);
        or.add(allRoutes);
        
        List<List<Route>> list = new ArrayList<List<Route>>();
        or.getOptimizedRoutes(list);
        return list;
    }

}
