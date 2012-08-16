package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.language.LEmailPassword;
import com.moveit.client.model.User;
import com.moveit.client.service.EmailPasswordToUserAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.MailService;
import com.moveit.server.repository.UserRepository;

/**
 *
 */
public class EmailPasswordToUserHandler extends AbstractActionHandler implements ActionHandler<EmailPasswordToUserAction, VoidResult> {

    private UserRepository repos = new UserRepository();

    public VoidResult execute(EmailPasswordToUserAction action) throws ApplicationException {

        User user = repos.findByEmail(action.getEmail());
        if (user == null) {
            throw new ApplicationException(LEmailPassword.EMAIL_PASSWORD_ERROR.get(getClientLanguage()));
        }
        MailService m = new MailService();


        m.sendMail(user, LEmailPassword.YOUR_PASSWORD.get(getClientLanguage()), LEmailPassword.YOUR_PASSWORD_IS.get(getClientLanguage()) + user.getPassword(), getClientLanguage());

        return new VoidResult();
    }


    public Class<EmailPasswordToUserAction> getActionType() {
        return EmailPasswordToUserAction.class;
    }


}