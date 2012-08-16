package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.language.LEmailPassword;
import com.moveit.client.model.User;
import com.moveit.client.service.SigninAction;
import com.moveit.client.service.UserResult;
import com.moveit.server.repository.UserRepository;

/**
 *
 */
public class SigninHandler extends AbstractActionHandler implements ActionHandler<SigninAction, UserResult> {

    private UserRepository repos = new UserRepository();

    public UserResult execute(SigninAction action) throws ApplicationException {
        User user = repos.findByEmail(action.getSignInData().getEmail());
        if (user == null) {
            throw new ApplicationException(LEmailPassword.LOGIN_EMAIL_ERROR.get(getClientLanguage()));
        }

        if (!user.getPassword().equals(action.getSignInData().getPassword())) {
            throw new ApplicationException(LEmailPassword.LOGIN_PASSWORD_ERROR.get(getClientLanguage()));
        }
        return new UserResult(user);
    }


    public Class<SigninAction> getActionType() {
        return SigninAction.class;
    }


}