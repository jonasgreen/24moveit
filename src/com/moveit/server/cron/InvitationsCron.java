package com.moveit.server.cron;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.Invitation;
import com.moveit.server.QueueEmailListServiceImpl;
import com.moveit.server.Logger;
import com.moveit.server.repository.InvitationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class InvitationsCron {

    private InvitationRepository repos = new InvitationRepository();

    public void doJob() throws ApplicationException {
        try {
            Logger.log("INVITATIONS CRON-JOB START");

            Collection<Invitation> invitations = repos.getAll();
            List<Invitation> unsent = new ArrayList<Invitation>();
            for (Invitation inv : invitations) {
                if (!inv.isSent()) {
                    unsent.add(inv);
                }
            }
            Logger.log("found " + unsent.size() + " invitations.");


            Queue queue = QueueFactory.getQueue("emaillist");
            for (Invitation inv : unsent) {
                queue.add(url("/gwtmodule/emaillist").param(QueueEmailListServiceImpl.INVITATION_ID, String.valueOf(inv.getId())));
                Logger.log("added to queue");                
            }
        }
        finally {
            Logger.log("INVITATIONS CRON-JOB END");

        }
    }


}