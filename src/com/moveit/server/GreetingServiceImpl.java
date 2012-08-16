package com.moveit.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.moveit.client.GreetingService;
import com.moveit.client.service.Action;
import com.moveit.client.service.Result;
import com.moveit.server.services.ActionHandlerRegistry;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {


    public Result execute(Action action) throws Exception {
        return ActionHandlerRegistry.executeAction(action);
    }

    public void init() {
        ActionHandlerRegistry.init(getServletContext());
    }


}
