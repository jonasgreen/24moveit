package com.moveit.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moveit.client.service.Action;
import com.moveit.client.service.Result;

/**
 *
 */
public class ServerWrapper implements ServerWrapperAsync {

    private static final GreetingServiceAsync server = GWT.create(GreetingService.class);


    public ServerWrapper() {
    }

    public <A extends Action<R>, R extends Result> void execute(A action, final AsyncCallback<R> callback ) {

        server.execute( action, new AsyncCallback<Result>() {
            public void onFailure( Throwable caught ) {
                callback.onFailure( caught );
            }

            public void onSuccess( Result result ) {
                callback.onSuccess( ( R ) result );
            }
        } );
    }

}
