package com.moveit.client.service;

import com.moveit.client.model.Route;

/**
 *
 */
public class RouteResult implements Result{
    private static final long serialVersionUID = -4735170017724185929L;

    private Route route;

    public RouteResult() {
    }

    public RouteResult(Route route) {
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}