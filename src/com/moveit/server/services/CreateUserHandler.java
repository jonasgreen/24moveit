package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.language.LEmailPassword;
import com.moveit.client.constants.MailListConstant;
import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.model.CreateSubscription;
import com.moveit.client.model.User;
import com.moveit.client.service.CreateUserAction;
import com.moveit.client.service.UserResult;
import com.moveit.server.MailService;
import com.moveit.server.Sms;
import com.moveit.server.dao.PMF;
import com.moveit.server.repository.SubscriptionRepository;
import com.moveit.server.repository.UserRepository;

/**
 *
 */
public class CreateUserHandler extends AbstractActionHandler implements ActionHandler<CreateUserAction, UserResult> {

    private UserRepository repos = new UserRepository();
    private SubscriptionRepository reposSub = new SubscriptionRepository();

    public UserResult execute(CreateUserAction action) throws ApplicationException {
        try {
            PMF.startTransaction();

            User user = createUser(action);

            //Mail - should be before commit to ensure correct email of user.
            new MailService().accountCreated(user, getClientLanguage());

            PMF.commitTransaction();
            sendSms(user);
            handleSubscriptions(action, user);

            return new UserResult(user);
        }
        finally {
            PMF.endTransaction();
        }
    }

    private void sendSms(User u) {
        StringBuffer sb = new StringBuffer();
        if (u.isDriver()) {
            sb.append("VOGNMAND_OPRETTET.");
        }
        else {
            sb.append("BRUGER_OPRETTET.");
        }

        Sms.writeSms(sb.toString());
    }


   

    private User createUser(CreateUserAction action) throws ApplicationException {
        User user = repos.findByEmail(action.getSignup().getEmail());
        if (user != null) {
            if (action.getSignup().getUserType() == UserTypeConstant.CUSTOMER.getValue()) {
                throw new ApplicationException(LEmailPassword.EMAIL_ALREADY_IN_USE_ACCOUNT.get(getClientLanguage()));
            }
            throw new ApplicationException(LEmailPassword.EMAIL_ALREADY_IN_USE_FIRM.get(getClientLanguage()));
        }

        user = repos.create(action.getSignup());
        return user;
    }

    private void handleSubscriptions(CreateUserAction action, User user) {
        for (MailListConstant mc : action.getSignup().getMailLists()) {
            reposSub.create(new CreateSubscription(user.getId(), mc));
        }
    }


    public Class<CreateUserAction> getActionType() {
        return CreateUserAction.class;
    }


}
