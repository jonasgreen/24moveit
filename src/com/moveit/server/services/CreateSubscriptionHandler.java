package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.SystemException;
import com.moveit.client.model.Subscription;
import com.moveit.client.model.User;
import com.moveit.client.service.CreateSubscriptionAction;
import com.moveit.client.service.SubscriptionResult;
import com.moveit.server.repository.SubscriptionRepository;
import com.moveit.server.repository.UserRepository;

import java.util.Collection;

/**
 * NOTICE - this handler can also delete subscriptions
 */
public class CreateSubscriptionHandler extends AbstractActionHandler implements ActionHandler<CreateSubscriptionAction, SubscriptionResult> {

    private SubscriptionRepository repos = new SubscriptionRepository();
    private UserRepository userRepos = new UserRepository();

    public SubscriptionResult execute(CreateSubscriptionAction action) throws ApplicationException {
        User user = userRepos.get(action.getCreateSubscription().getUserId());
        if (user == null) {
            throw new SystemException(this.getClass().getSimpleName() + ": Unable to identify user with id=" + action.getCreateSubscription().getUserId());
        }

        //find the subscription this user has that match the MailListConstant.
        Collection<Subscription> subs = repos.findByUserId(user.getId());
        subs = Subscription.extract(action.getCreateSubscription().getMailList(), subs);

        if (action.isDelete()) {
            return delete(subs);
        }
        else {
            return create(action, subs);
        }
    }

    private SubscriptionResult create(CreateSubscriptionAction action, Collection<Subscription> subs) {
        if (!subs.isEmpty()) {
            return new SubscriptionResult(subs.iterator().next());
        }
        return new SubscriptionResult(repos.create(action.getCreateSubscription()));
    }

    private SubscriptionResult delete(Collection<Subscription> subs) {
        if (!subs.isEmpty()) {
            //more than one should not could exist but if - they are all deleted.
            for (Subscription sub : subs) {
                repos.delete(sub.getId());
            }
        }
        return new SubscriptionResult(null);
    }


    public Class<CreateSubscriptionAction> getActionType() {
        return CreateSubscriptionAction.class;
    }


}