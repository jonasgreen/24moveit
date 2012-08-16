package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.model.Invitation;
import com.moveit.client.model.User;
import com.moveit.client.service.AllUsersResult;
import com.moveit.client.service.GetAllUsersAction;
import com.moveit.server.repository.InvitationRepository;
import com.moveit.server.repository.UserRepository;

import java.util.Collection;

/**
 *
 */
public class GetAllUsersHandler extends AbstractActionHandler implements ActionHandler<GetAllUsersAction, AllUsersResult> {

    private UserRepository repos = new UserRepository();
    private InvitationRepository inviRepos = new InvitationRepository();

    public AllUsersResult execute(GetAllUsersAction action) throws ApplicationException {
        Collection<User> users = repos.getAll();
        Collection<Invitation> invis = inviRepos.getAll();

        AllUsersResult aur = new AllUsersResult();
        aur.setUsers(users);
        aur.setInvitations(invis);

        return aur;
    }


    public Class<GetAllUsersAction> getActionType() {
        return GetAllUsersAction.class;
    }


}