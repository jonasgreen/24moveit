package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.DeleteSubscriptionAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.repository.SubscriptionRepository;

/**
 *
 */
public class DeleteSubscriptionHandler extends AbstractActionHandler implements ActionHandler<DeleteSubscriptionAction, VoidResult> {

    SubscriptionRepository repos = new SubscriptionRepository();

    public VoidResult execute(DeleteSubscriptionAction action) throws ApplicationException {
        repos.delete(action.getId());
        return new VoidResult();
    }


    public Class<DeleteSubscriptionAction> getActionType() {
        return DeleteSubscriptionAction.class;
    }


}