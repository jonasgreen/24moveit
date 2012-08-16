package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.User;
import com.moveit.client.service.GetUserByIdAction;
import com.moveit.client.service.UserResult;
import com.moveit.server.repository.UserRepository;

/**
 *
 */
public class GetUserByIdHandler extends AbstractActionHandler implements ActionHandler<GetUserByIdAction, UserResult> {

    private UserRepository repos = new UserRepository();

    public UserResult execute(GetUserByIdAction action) throws ApplicationException {
        User user = null;
        try{
            user = repos.get(action.getUserId());
        }
        catch(Throwable e){
            //ignore
        }
        return new UserResult(user);
    }


    public Class<GetUserByIdAction> getActionType() {
        return GetUserByIdAction.class;
    }


}