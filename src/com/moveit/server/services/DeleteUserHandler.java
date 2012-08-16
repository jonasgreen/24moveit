package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.DeleteUserAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.repository.RouteRepository;
import com.moveit.server.repository.UserRepository;
import com.moveit.server.repository.SubscriptionRepository;

/**
 *
 */
public class DeleteUserHandler extends AbstractActionHandler implements ActionHandler<DeleteUserAction, VoidResult> {

    private UserRepository reposUser = new UserRepository();
    private RouteRepository reposRoute = new RouteRepository();
    private SubscriptionRepository reposSub = new SubscriptionRepository();

    public VoidResult execute(DeleteUserAction action) throws ApplicationException {
        //important to do in this order because of no transaction here

        reposRoute.deleteAllByUserId(action.getUserId());
        reposSub.deleteAllByUserId(action.getUserId());
        reposUser.delete(action.getUserId());
        return new VoidResult();
    }


    public Class<DeleteUserAction> getActionType() {
        return DeleteUserAction.class;
    }


}