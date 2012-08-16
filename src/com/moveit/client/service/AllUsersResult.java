package com.moveit.client.service;

import com.moveit.client.model.Invitation;
import com.moveit.client.model.User;

import java.util.Collection;

/**
 *
 */
public class AllUsersResult implements Result{
    private static final long serialVersionUID = 2974990987593495529L;

    private Collection<User> users;
    private Collection<Invitation> invitations;

    public AllUsersResult() {
    }


    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(Collection<Invitation> invitations) {
        this.invitations = invitations;
    }
}