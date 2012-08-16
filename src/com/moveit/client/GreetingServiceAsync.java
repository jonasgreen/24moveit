package com.moveit.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moveit.client.service.Action;
import com.moveit.client.service.Result;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

    

    void execute( Action<?> action, AsyncCallback<Result> callback );


}
