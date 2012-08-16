package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.language.Language;
import com.moveit.client.model.Invitation;
import com.moveit.client.model.User;
import com.moveit.client.service.InvitationsJobAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.Logger;
import com.moveit.server.MailService;
import com.moveit.server.mail.InvitationMail;
import com.moveit.server.mail.MailTemplate;
import com.moveit.server.repository.InvitationRepository;
import com.moveit.server.repository.UserRepository;


public class InvitationsJobHandler extends AbstractActionHandler  implements ActionHandler<InvitationsJobAction, VoidResult> {

    private InvitationRepository reposInvi = new InvitationRepository();
    private UserRepository reposUser = new UserRepository();

    public VoidResult execute(InvitationsJobAction action) throws ApplicationException {
        Invitation invitation = reposInvi.get(action.getInvitationId());
        if (invitation == null) {
            Logger.log("WARNING - could not find invitation wiht id=" + action.getInvitationId() + ". Unable to send mail from maillist.");
            return new VoidResult();
        }
        if(invitation.isSent()){
            Logger.log("WARNING invitation has been sent before to "+ invitation.getEmail()+ " - no invitation sent");
            return new VoidResult();
        }
        User user = reposUser.findByEmail(invitation.getEmail());
        if (user != null) {
            //users should not recieve invitations
            Logger.log("WARNING user already exist: "+ invitation.getEmail()+ "- no invitation is sent");
            updateInvitation(invitation);
            return new VoidResult();
        }

        sendInvitation(invitation);
        updateInvitation(invitation);
        return new VoidResult();
    }



    private void updateInvitation(Invitation invitation) {
        //update invitation
        invitation.setSent(true);
        reposInvi.update(invitation);
    }


    private void sendInvitation(Invitation invitation) throws ApplicationException {
        Language l = Language.getLanguage(invitation.getLanguage());
        InvitationMail mail = new InvitationMail(l);

        MailTemplate mt = new MailTemplate(l, mail.getTitle());
        new MailService().sendMail(invitation.getEmail(), mail.getReciver(), mail.getTitle(), mt.createMail(mail.getEmailContent(), true), invitation.getLanguage());
    }


    public Class<InvitationsJobAction> getActionType() {
        return InvitationsJobAction.class;
    }


}