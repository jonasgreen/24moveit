package com.moveit.client.model;

import com.moveit.client.constants.UserTypeConstant;

import java.io.Serializable;

/**
 *
 */
public class Driver extends UserType implements Serializable{

    private static final long serialVersionUID = 7249618256395249193L;

    private String companyName;
    private String webPage;
    private Integer routeNotification;
    private String cvrNr;
    private Long userId;

    public Driver() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public Integer getRouteNotification() {
        return routeNotification;
    }

    public void setRouteNotification(Integer routeNotification) {
        this.routeNotification = routeNotification;
    }

    public String getCvrNr() {
        return cvrNr;
    }

    public void setCvrNr(String cvrNr) {
        this.cvrNr = cvrNr;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTypeValue() {
        return UserTypeConstant.DRIVER.getValue();
    }
}
