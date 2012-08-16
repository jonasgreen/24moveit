package com.moveit.server.repository;

import com.moveit.client.constants.MailListConstant;
import com.moveit.client.model.CreateSubscription;
import com.moveit.client.model.Subscription;
import com.moveit.server.jdo.SubscriptionJDO;

import java.util.Date;

/**
 *
 */
public class SubscriptionConverter extends Converter<SubscriptionJDO, Subscription, CreateSubscription> {


    public SubscriptionJDO convert(CreateSubscription creater) {
        if (creater == null) {
            return null;
        }
        SubscriptionJDO jdo = new SubscriptionJDO();
        jdo.setMailList(creater.getMailList().getValue());
        jdo.setUserId(creater.getUserId());
        return jdo;
    }


    public Subscription convert(SubscriptionJDO jdo) {
        if (jdo == null) {
            return null;
        }
        Subscription model = new Subscription();
        model.setId(jdo.getKeyId());
        model.setMailList(MailListConstant.get(jdo.getMailList()));
        model.setUserId(jdo.getUserId());
        return model;
    }



}