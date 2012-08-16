package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.SystemException;
import com.moveit.client.constants.OfferTypeConstant;
import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.service.Action;
import com.moveit.client.service.Result;
import com.moveit.server.Logger;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ActionHandlerRegistry {

    private static boolean isLoaded = false;
    private static Map<Class, ActionHandler> handlers = new HashMap<Class, ActionHandler>();

    public static synchronized void init(ServletContext context) {
        if (isLoaded) {
            return;
        }
        Logger.init(context);

        //loading constants - a bit ugly
        CargoTypeConstant.init();
        OfferTypeConstant.init();

        initHandlers();
        isLoaded = true;
    }


    private static void initHandlers() {
       
        //USER
        add(new CreateUserHandler());
        add(new SigninHandler());
        add(new DeleteUserHandler());
        add(new GetUserByIdHandler());
        add(new GetUserByEmailHandler());
        add(new EmailPasswordToUserHandler());
        add(new GetUserSettingsHandler());
        add(new GetAllUsersHandler());

        //ROUTE
        add(new CreateRouteHandler());
        add(new DeleteRouteHandler());
        add(new FindAllRoutesHandler());
        add(new FindRoutesByUserHandler());
        add(new ContactInfoShownHandler());

        //EMAIL - SUBSCRIPTIONS
        add(new CreateSubscriptionHandler());
        add(new DeleteSubscriptionHandler());
        add(new CreateInvitationsHandler());

        //PING
        add(new PingHandler());

        //LOG
        add(new LogHandler());

        //CRON JOB
        add(new OnceADayCronJobHandler());

        //EMAIL LIST QUEUE JOB
        add(new NewRoutesMailJobHandler());
        add(new InvitationsJobHandler());
    }

    private static void add(ActionHandler handler) {
        handlers.put(handler.getActionType(), handler);
    }


    public static Result executeAction(Action a) throws Exception {
        try {
            ActionHandler actionHandler = getHandler(a);
            if(actionHandler == null){
                String s = a.getClass().getName() + " has no ActionHandler";
                Logger.log(s);
                throw new SystemException(s);
            }

            actionHandler.setClientLanguage(a.getLanguage());
            return actionHandler.execute(a);
        }
        catch (Throwable t) {
            String s = "Error caught in Servlet: " + t.getClass().getName();
            Logger.log(s, t);
            if (t instanceof SystemException) {
                throw (SystemException) t;
            }
            if (t instanceof ApplicationException) {
                throw (ApplicationException) t;
            }
            throw new SystemException(t.getMessage());
        }
    }

    private static ActionHandler getHandler(Action a) {
        ActionHandler handler = handlers.get(a.getClass());
        if (handler == null) {
            throw new SystemException("ActionHandler not setup for Action: " + a.getClass());
        }
        return handler;
    }

}