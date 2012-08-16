package com.moveit.client.service;

import com.moveit.client.model.User;

import java.util.Collection;

/**
 *
 */
public class UserListResult implements Result{
    private static final long serialVersionUID = 5009014408847651797L;

    private Collection<User> users;

    public UserListResult() {
    }

    public UserListResult(Collection<User> users) {
        this.users = users;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}