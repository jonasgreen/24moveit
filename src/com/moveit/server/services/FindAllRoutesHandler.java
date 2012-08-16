package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.Route;
import com.moveit.client.service.FindAllRoutesAction;
import com.moveit.client.service.RouteListResult;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.repository.RouteRepository;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class FindAllRoutesHandler extends AbstractActionHandler implements ActionHandler<FindAllRoutesAction, RouteListResult> {

    private RouteRepository repos = new RouteRepository();

    public RouteListResult execute(FindAllRoutesAction action) throws ApplicationException {
        FindByOneParam param = FindByOneParam.findRoutesByTodateGreaterThan();
        param.setValue(new Date());

        List<Route> list = Route.extractNotDeleted(repos.findBy(param));

        if(action.getCountryCode() != null){
            list = Route.extractByCountryCode(list, action.getCountryCode());
        }
        return new RouteListResult(list);
    }


    public Class<FindAllRoutesAction> getActionType() {
        return FindAllRoutesAction.class;
    }





}