package com.moveit.client.service;

import com.moveit.client.model.Route;

import java.util.List;

/**
 *
 */
public class RouteListResult implements Result{
    private static final long serialVersionUID = -4735170017724185929L;

    private List<Route> routes;

    public RouteListResult() {
    }

    public RouteListResult(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}