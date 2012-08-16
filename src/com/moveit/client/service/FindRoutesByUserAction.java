package com.moveit.client.service;

import java.io.Serializable;

/**
 *
 */
public class FindRoutesByUserAction extends AbstractAction implements Action<RouteListResult>, Serializable{
    private static final long serialVersionUID = 6143318859077194634L;
    private Long userId;


    public FindRoutesByUserAction() {
    }

    public FindRoutesByUserAction(Long id) {
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}