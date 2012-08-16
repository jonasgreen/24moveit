package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.FindRoutesByUserAction;
import com.moveit.client.service.RouteListResult;
import com.moveit.client.util.CollectionUtil;
import com.moveit.server.repository.RouteRepository;

/**
 *
 */
public class FindRoutesByUserHandler extends AbstractActionHandler implements ActionHandler<FindRoutesByUserAction, RouteListResult> {

    private RouteRepository repos = new RouteRepository();

    public RouteListResult execute(FindRoutesByUserAction action) throws ApplicationException {
        return new RouteListResult(CollectionUtil.toArrayList(repos.findByUserId(action.getUserId())));
    }


    public Class<FindRoutesByUserAction> getActionType() {
        return FindRoutesByUserAction.class;
    }


}