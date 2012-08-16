package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.CreateInvitation;
import com.moveit.client.model.Invitation;
import com.moveit.client.service.CreateInvitationsAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.repository.InvitationRepository;

public class CreateInvitationsHandler extends AbstractActionHandler implements ActionHandler<CreateInvitationsAction, VoidResult> {

    private InvitationRepository inviRepos = new InvitationRepository();

    public VoidResult execute(CreateInvitationsAction action) throws ApplicationException {
        for (String email : action.getEmails()) {
            createInvitation(email, action.getInvitationLanguage());
        }
        return new VoidResult();
    }

    private void createInvitation(String email, int language) {
        Invitation inv = inviRepos.findByEmail(email);
        if(inv != null){
            return;
        }
        CreateInvitation ic = new CreateInvitation(email, language);
        ic.setInviLanguage(language);
        inviRepos.create(ic);
    }


    public Class<CreateInvitationsAction> getActionType() {
        return CreateInvitationsAction.class;
    }


}