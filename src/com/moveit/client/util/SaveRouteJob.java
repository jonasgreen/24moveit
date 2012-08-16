package com.moveit.client.util;

import com.moveit.client.Global;
import com.moveit.client.gui.AddPageController;
import com.moveit.client.gui.ApplicationController;
import com.moveit.client.gui.WhatToMovePanel;
import com.moveit.client.gui.WhenToMovePanel;
import com.moveit.client.model.Address;
import com.moveit.client.model.CreateRoute;
import com.moveit.client.model.User;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.RouteResult;
import com.moveit.client.service.Service;


/**
 *
 */
public class SaveRouteJob extends Job {


   
    private GetOnePlacemarkJob to;
    private GetOnePlacemarkJob from;
    private WhenToMovePanel whenToMove;
    private WhatToMovePanel whatToMove;
    private Integer contactWish;

    public SaveRouteJob(Integer contactWish, GetOnePlacemarkJob from, GetOnePlacemarkJob to, WhenToMovePanel ePanel, WhatToMovePanel whatToMove, Executer e, String inProgressText) {
        super(e, inProgressText);
        this.to = to;
        this.from = from;
        this.whenToMove = ePanel;
        this.whatToMove = whatToMove;
        this.contactWish = contactWish;
    }

    public void run() {
        try {
            CreateRoute cr = new CreateRoute();
            //extended info
            cr.setContactWish(contactWish);
            
            cr.setFromDate(whenToMove.FROMDATE.getValue());
            cr.setToDate(whenToMove.TODATE.getValue());

            cr.setOfferType(AddPageController.getInstance().getPage().getByWho().getByWhoSelector().getSelectedOffer());
            cr.setCargoDescription(whatToMove.CARGO_DESCRIPTION.getValue());
            cr.setCargoType(whatToMove.CARGO_TYPE.getValue());
            //from
            Address fromAdr = from.getAddress();
            cr.setFromCity(fromAdr.getCity());
            cr.setFromCityCode(fromAdr.getCityCode());
            cr.setFromCountryCode(fromAdr.getNationalCode());
            cr.setFromCountry(fromAdr.getNation());
            cr.setFromStreet(fromAdr.getStreet());
            cr.setFromLatitude(from.getValue().getPoint().getLatitude());
            cr.setFromLongitude(from.getValue().getPoint().getLongitude());

            //to
            Address toAdr = to.getAddress();
            cr.setToCity(toAdr.getCity());
            cr.setToCityCode(toAdr.getCityCode());
            cr.setToCountryCode(toAdr.getNationalCode());
            cr.setToCountry(toAdr.getNation());
            cr.setToStreet(toAdr.getStreet());
            cr.setToLatitude(to.getValue().getPoint().getLatitude());
            cr.setToLongitude(to.getValue().getPoint().getLongitude());

            User user = ApplicationController.getInstance().getUser();
            cr.setUserId(user.getId());

            Service.createRoute(cr, new CallBack<RouteResult>() {
                public void fail(Throwable caught) {
                    finished(false);
                    setErrorMsg(caught.getMessage() + " - "+ caught.getClass().getName());
                }

                public void success(RouteResult result) {
                    Global.setLastSavedRoute(result.getRoute());
                    finished(true);
                }
            });
        }
        catch (Exception e) {
            setErrorMsg(e.getMessage() + " - "+ e.getClass().getName());
            finished(false);
        }
    }

}
