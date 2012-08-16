package com.moveit.client.service;

import com.moveit.client.model.CreateRoute;

/**
 *
 */
public class CreateRouteAction extends AbstractAction implements Action<RouteResult>{
    private static final long serialVersionUID = -7220084907652453742L;

    private CreateRoute createRoute;


    public CreateRouteAction() {
    }

    public CreateRouteAction(CreateRoute createRoute) {
        this.createRoute = createRoute;
    }

    public com.moveit.client.model.CreateRoute getCreateRoute() {
        return createRoute;
    }

    public void setCreateRoute(com.moveit.client.model.CreateRoute createRoute) {
        this.createRoute = createRoute;
    }
}