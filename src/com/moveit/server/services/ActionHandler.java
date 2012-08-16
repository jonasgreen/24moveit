package com.moveit.server.services;

import com.moveit.client.service.Action;
import com.moveit.client.service.Result;
import com.moveit.client.ApplicationException;

/**
 *
 */
public interface ActionHandler <A extends Action, R extends Result>{

    public R execute(A action) throws ApplicationException;

    public Class<A> getActionType();


    public Integer getClientLanguage();
    
    public void setClientLanguage(Integer clientLanguage);
}
