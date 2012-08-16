package com.moveit.client.model;

import java.util.List;

/**
 *
 */
public interface RouteManagerCallBack {


    public void onSucces(List<Route> routes);

    public void onFailure(Throwable t);


}
