package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.Route;
import com.moveit.client.service.CreateRouteAction;
import com.moveit.client.service.RouteResult;
import com.moveit.server.Sms;
import com.moveit.server.dao.Dao;
import com.moveit.server.jdo.NewRouteToMailJDO;
import com.moveit.server.repository.RouteRepository;

/**
 *
 */
public class CreateRouteHandler extends AbstractActionHandler implements ActionHandler<CreateRouteAction, RouteResult> {

    private RouteRepository repos = new RouteRepository();
    private Dao routeMailDao = new Dao<NewRouteToMailJDO>(NewRouteToMailJDO.class);

    public RouteResult execute(CreateRouteAction action) throws ApplicationException {
        Route route = repos.create(action.getCreateRoute());

        sendSms();
        return new RouteResult(route);
    }

    private void sendSms(){
        StringBuffer sb = new StringBuffer("RUTE_OPRETTET.");
        Sms.writeSms(sb.toString());        
    }



    public Class<CreateRouteAction> getActionType() {
        return CreateRouteAction.class;
    }


}