package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.OnceADayCronJobAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.cron.NewRoutesCron;
import com.moveit.server.cron.InvitationsCron;

/**
 * NOTICE - this handler can also delete subscriptions
 */
public class OnceADayCronJobHandler extends AbstractActionHandler implements ActionHandler<OnceADayCronJobAction, VoidResult> {

    public VoidResult execute(OnceADayCronJobAction action) throws ApplicationException {
        new NewRoutesCron().doJob();
        new InvitationsCron().doJob();
        //new NewNews().doJob();
        return new VoidResult();
    }



    public Class<OnceADayCronJobAction> getActionType() {
        return OnceADayCronJobAction.class;
    }


}