package com.moveit.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.moveit.client.service.Action;
import com.moveit.client.service.Result;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
    Result execute( Action<?> action ) throws Exception;


}
