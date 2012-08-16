package com.moveit.client.service;

import com.moveit.client.model.User;

/**
 *
 */
public class UserResult implements Result{
    private static final long serialVersionUID = 2536342536769646854L;

    private User user;

    public UserResult() {
    }

    public UserResult(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
