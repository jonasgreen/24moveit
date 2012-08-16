package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.Route;
import com.moveit.client.service.ContactInfoShownToAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.Logger;
import com.moveit.server.repository.RouteRepository;

public class ContactInfoShownHandler extends AbstractActionHandler implements ActionHandler<ContactInfoShownToAction, VoidResult> {

    private RouteRepository rep = new RouteRepository();

    public VoidResult execute(ContactInfoShownToAction action) throws ApplicationException {
        Route r = rep.get(action.getRouteId());
        if(r == null){
            Logger.log("Unable to find Route "+action.getRouteId() +" in ContactInfoShownHandler");
        }
        else{
            if(!r.hasBeenShownTo(action.getUserId())){
                rep.updateShownTo(action.getRouteId(), r.getInfoShownTo()+" "+String.valueOf(action.getUserId()));
            }
        }

        return new VoidResult();
    }



    public Class<ContactInfoShownToAction> getActionType() {
        return ContactInfoShownToAction.class;
    }


}