package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.PingAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.repository.RouteRepository;
import com.moveit.server.repository.UserRepository;
import com.moveit.server.repository.SubscriptionRepository;

/**
 * 
 */
public class PingHandler extends AbstractActionHandler implements ActionHandler<PingAction, VoidResult> {



    public VoidResult execute(PingAction action) throws ApplicationException {
        //to keep google app engine varm
        RouteRepository r = new RouteRepository();
        UserRepository userR = new UserRepository();
        SubscriptionRepository sR= new SubscriptionRepository();

        return new VoidResult();
    }



    public Class<PingAction> getActionType() {
        return PingAction.class;
    }


}