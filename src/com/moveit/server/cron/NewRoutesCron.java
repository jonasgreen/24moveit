package com.moveit.server.cron;

import java.util.Collection;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.moveit.client.ApplicationException;
import com.moveit.client.constants.CounterConstant;
import com.moveit.client.constants.MailListConstant;
import com.moveit.client.model.Counter;
import com.moveit.client.model.Route;
import com.moveit.client.model.Subscription;
import com.moveit.server.Logger;
import com.moveit.server.QueueEmailListServiceImpl;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.repository.CounterRepository;
import com.moveit.server.repository.RouteRepository;
import com.moveit.server.repository.SubscriptionRepository;

/**
 *
 */
public class NewRoutesCron {

    private SubscriptionRepository reposSubs = new SubscriptionRepository();
    private CounterRepository counterRepos = new CounterRepository();
    private RouteRepository routeRepos = new RouteRepository();

    public void doJob() throws ApplicationException {
        try {
            Logger.log("NEW-ROUTES CRON-JOB START");
            Counter c = counterRepos.getCounter(CounterConstant.NEW_ROUTES);
            Logger.log("Counter: " + c.getCounter());

            //if no new routes are created then return
            Collection<Route> newRoutes = routeRepos.findByCounter(c.getCounter());
            if (newRoutes == null || newRoutes.isEmpty()) {
                Logger.log("FOUND 0 Routes");
                return;
            }
            Logger.log("FOUND " + newRoutes.size() + " Routes");


            counterRepos.increaseCounter(c);

            FindByOneParam param = FindByOneParam.findSubscriptionsByMailList();
            param.setValue(MailListConstant.NEW_ROUTE_ONCE_A_DAY.getValue());
            Collection<Subscription> subs = reposSubs.findBy(param);

            Logger.log("FOUND " + subs.size() + " SUBSCRIPTIONS");

            Queue queue = QueueFactory.getQueue("emaillist");

            for (Subscription sub : subs) {

                TaskOptions opt = Url("/gwtmodule/emaillist");
                opt = opt.param(QueueEmailListServiceImpl.NEW_ROUTES_USERID, String.valueOf(sub.getUserId()));
                opt = opt.param(QueueEmailListServiceImpl.NEW_ROUTES_COUNTERVALUE, String.valueOf(c.getCounter()));

                queue.add(opt);
                Logger.log("ADDED TO QUEUE");
            }
        }
        finally {
            Logger.log("NEW-ROUTES CRON-JOB END");
        }
    }


}
