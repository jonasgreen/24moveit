package com.moveit.client.service;

import com.moveit.client.model.CreateSubscription;

/**
 *
 */
public class CreateSubscriptionAction extends AbstractAction implements Action<SubscriptionResult>{
    private static final long serialVersionUID = -2717189375000250716L;

    private CreateSubscription createSubscription;
    private Boolean delete;


    public CreateSubscriptionAction() {
    }

    public CreateSubscriptionAction(CreateSubscription createSubscription, boolean delete) {
        this.createSubscription = createSubscription;
        this.delete = delete;
    }

    public CreateSubscription getCreateSubscription() {
        return createSubscription;
    }

    public void setCreateSubscription(CreateSubscription createSubscription) {
        this.createSubscription = createSubscription;
    }

    public Boolean isDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}