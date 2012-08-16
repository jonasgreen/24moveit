package com.moveit.client.service;

/**
 *
 */
public class FindAllRoutesAction extends AbstractAction implements Action<RouteListResult>{
    private static final long serialVersionUID = -8171763415623943576L;

    private String countryCode;

    public FindAllRoutesAction() {
    }

    public FindAllRoutesAction(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}