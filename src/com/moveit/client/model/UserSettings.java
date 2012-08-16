package com.moveit.client.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class UserSettings extends Model{
    private static final long serialVersionUID = 991047465206950941L;

    private Collection<Subscription> subscriptions = new ArrayList<Subscription>();


    public UserSettings() {
    }

    public Collection<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Collection<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
