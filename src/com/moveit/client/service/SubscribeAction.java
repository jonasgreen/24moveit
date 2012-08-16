package com.moveit.client.service;

import com.moveit.client.model.Creater;
import com.moveit.client.model.Subscription;

import java.io.Serializable;

/**
 *
 */
public class SubscribeAction extends Creater implements Serializable{
    private static final long serialVersionUID = -7220084907652453742L;

    private Subscription subscription;


    public SubscribeAction() {
    }

    public SubscribeAction(Subscription sub) {
        this.subscription = sub;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}