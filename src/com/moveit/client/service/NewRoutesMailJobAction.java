package com.moveit.client.service;

/**
 *
 */
public class NewRoutesMailJobAction extends AbstractAction implements Action<VoidResult> {
    private static final long serialVersionUID = -4495806514001436131L;

    private Long userId;
    private Long routeCounter;

    public NewRoutesMailJobAction() {
    }

    public NewRoutesMailJobAction(Long userId, Long rCounter) {
        this.userId = userId;
        this.routeCounter = rCounter;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRouteCounter() {
        return routeCounter;
    }

    public void setRouteCounter(Long routeCounter) {
        this.routeCounter = routeCounter;
    }
}