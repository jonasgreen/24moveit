package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.constants.OfferTypeConstant;
import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.language.Language;
import com.moveit.client.model.Route;
import com.moveit.client.model.User;
import com.moveit.client.service.NewRoutesMailJobAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.Logger;
import com.moveit.server.MailService;
import com.moveit.server.mail.MailTemplate;
import com.moveit.server.mail.NewRoutesMail;
import com.moveit.server.repository.RouteRepository;
import com.moveit.server.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

public class NewRoutesMailJobHandler extends AbstractActionHandler implements ActionHandler<NewRoutesMailJobAction, VoidResult> {

    UserRepository reposUser = new UserRepository();
    RouteRepository routeRepos = new RouteRepository();

    public VoidResult execute(NewRoutesMailJobAction action) throws ApplicationException {
        try {
            Logger.log("START - NewRoutesMailJobHandler");
            //getUser
            User user = null;
            try {
                user = reposUser.get(action.getUserId());
                Logger.log("USER: " + user.getName() + " nationality: " + user.getNationality() + " userType:"+user.getUserType());
            }
            catch (Throwable t) {
                //ignore
            }
            if (user == null) {
                Logger.log("WARNING DATA ERROR - could not find user wiht id=" + action.getUserId() + ". Unable to send mail from maillist.");
                return new VoidResult();
            }

            Collection<Route> routes = findByCounter(action);
            routes = extractByCountryCode(user, routes);
            routes = extractByOfferType(user, routes);

            if (routes.isEmpty()) {
                return new VoidResult();
            }

            sendMail(user, routes);
            return new VoidResult();
        }
        finally {
            Logger.log("END - NewRoutesMailJobHandler");
        }
    }


    private Collection<Route> extractByCountryCode(User user, Collection<Route> routes) {
        if(user.getEmail().equalsIgnoreCase("jonasgreen12345@gmail.com")){
            return routes;
        }
        Collection<Route> rs = Route.extractByCountryCode(routes, user.getNationality());
        Logger.log("After extract by countrycode: " + rs.size() + " routes.");
        return rs;
    }

    private Collection<Route> extractByOfferType(User user, Collection<Route> routes) {
        Collection<Route> rs = new ArrayList<Route>();
        if (user.isDanish() && user.isDriver()) {
            for (Route r : routes) {
                int offerType = r.getOfferType().getValue();
                if (offerType != OfferTypeConstant.EXCLUSIVE.getValue()) {
                    rs.add(r);
                }
                else {
                    if (user.getUserType() == UserTypeConstant.DRIVER_DMF.getValue()) {
                        rs.add(r);
                    }
                }
            }
        }
        else {
            rs = routes;
        }
        Logger.log("After extract by OfferType: " + rs.size() + " routes.");
        return rs;
    }

    private Collection<Route> findByCounter(NewRoutesMailJobAction action) {
        Collection<Route> rs = routeRepos.findByCounter(action.getRouteCounter());
        Logger.log("Found " + rs.size() + " routes by counter: "+action.getRouteCounter());
        return rs;
    }

    private void sendMail(User user, Collection<Route> routes) throws ApplicationException {
        NewRoutesMail mail = new NewRoutesMail(user.getNationality(), routes);

        Logger.log("sending mail start");
        Language l = Language.getLanguage(user);
        MailTemplate mt = new MailTemplate(l, mail.getTitle());
        new MailService().sendMail(user, mail.getTitle(), mt.createMail(mail.getEmailContent(), true), l.getValue());

        Logger.log("sending mail end");
    }


    public Class<NewRoutesMailJobAction> getActionType() {
        return NewRoutesMailJobAction.class;
    }


}