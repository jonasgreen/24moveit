package com.moveit.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moveit.client.service.Action;
import com.moveit.client.service.Result;

/**
 *
 */
public interface ServerWrapperAsync {

    <A extends Action<R>, R extends Result> void execute( A action, AsyncCallback<R> callback );

}
