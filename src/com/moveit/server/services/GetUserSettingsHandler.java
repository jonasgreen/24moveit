package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.Subscription;
import com.moveit.client.model.UserSettings;
import com.moveit.client.service.GetUserSettingsAction;
import com.moveit.client.service.UserSettingsResult;
import com.moveit.server.repository.SubscriptionRepository;

import java.util.Collection;

/**
 *
 */
public class GetUserSettingsHandler extends AbstractActionHandler implements ActionHandler<GetUserSettingsAction, UserSettingsResult> {

    private SubscriptionRepository repos = new SubscriptionRepository();

    public UserSettingsResult execute(GetUserSettingsAction action) throws ApplicationException {
        Collection<Subscription> subs = repos.findByUserId(action.getUserId());

        UserSettings us = new UserSettings();
        us.setSubscriptions(subs);

        return new UserSettingsResult(us);
    }


    public Class<GetUserSettingsAction> getActionType() {
        return GetUserSettingsAction.class;
    }


}