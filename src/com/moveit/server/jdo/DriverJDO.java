package com.moveit.server.jdo;

import com.moveit.server.dao.JDO;

import java.util.Date;

/**
 *
 */
public class DriverJDO extends JDO {

    
    private String companyName;
    private String webPage;
    private Integer routeNotification;
    private String cvrNr;
    private Long userId;

    private Date createdDate;

    private Date lastChangeDate;


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public DriverJDO() {
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
}
