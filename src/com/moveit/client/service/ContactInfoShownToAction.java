package com.moveit.client.service;

/**
 *
 */
public class ContactInfoShownToAction extends AbstractAction implements Action<VoidResult>{
    private static final long serialVersionUID = -8574419573129030160L;

    private Long userId;
    private Long routeId;

    public ContactInfoShownToAction() {
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}