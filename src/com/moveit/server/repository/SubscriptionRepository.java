package com.moveit.server.repository;

import com.moveit.client.model.CreateSubscription;
import com.moveit.client.model.Subscription;
import com.moveit.server.dao.Dao;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.jdo.SubscriptionJDO;

import java.util.Collection;

/**
 *
 */
public class SubscriptionRepository extends Repository<SubscriptionJDO, Subscription, CreateSubscription> {

    public SubscriptionRepository() {
        super(new Dao<SubscriptionJDO>(SubscriptionJDO.class), new SubscriptionConverter());
    }

    public SubscriptionRepository(Dao<SubscriptionJDO> SubscriptionJDODao, Converter<SubscriptionJDO, Subscription, CreateSubscription> con) {
        super(SubscriptionJDODao, con);
    }


    public Class<Subscription> getRepositoryType() {
        return Subscription.class;
    }


    //FINDERS

    public Collection<Subscription> findByUserId(Long userId) {
        FindByOneParam findByParam = FindByOneParam.findSubscribtionsByUserid();
        findByParam.setValue(userId);
        return findBy(findByParam);
    }

    public void deleteAllByUserId(Long userId) {
        FindByOneParam param = FindByOneParam.findSubscribtionsByUserid();
        param.setValue(userId);
        deleteAll(param);
    }





}