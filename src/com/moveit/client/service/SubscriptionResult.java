package com.moveit.client.service;

import com.moveit.client.model.Subscription;

/**
 *
 */
public class SubscriptionResult implements Result{
    private static final long serialVersionUID = -627670950474985346L;

    private Subscription subscription;

    public SubscriptionResult() {
    }

    public SubscriptionResult(Subscription subscription) {
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}