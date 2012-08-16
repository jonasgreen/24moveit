package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.User;
import com.moveit.client.service.GetUserByEmailAction;
import com.moveit.client.service.UserResult;
import com.moveit.server.repository.UserRepository;

/**
 *
 */
public class GetUserByEmailHandler extends AbstractActionHandler implements ActionHandler<GetUserByEmailAction, UserResult> {

    private UserRepository repos = new UserRepository();

    public UserResult execute(GetUserByEmailAction action) throws ApplicationException {
        User user = repos.findByEmail(action.getEmail());
        return new UserResult(user);
    }


    public Class<GetUserByEmailAction> getActionType() {
        return GetUserByEmailAction.class;
    }


}