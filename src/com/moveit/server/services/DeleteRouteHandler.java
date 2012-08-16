package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.DeleteRouteAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.repository.RouteRepository;

/**
 *
 */
public class DeleteRouteHandler extends AbstractActionHandler implements ActionHandler<DeleteRouteAction, VoidResult> {

    private RouteRepository repos = new RouteRepository();

    public VoidResult execute(DeleteRouteAction action) throws ApplicationException {
        repos.delete(action.getId());
        return new VoidResult();
    }


    public Class<DeleteRouteAction> getActionType() {
        return DeleteRouteAction.class;
    }


   

}