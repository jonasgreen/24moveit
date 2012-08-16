package com.moveit.client.model;

import java.io.Serializable;

/**
 *
 */
public class Stamp implements Serializable{
    private static final long serialVersionUID = -6283847183759368097L;

    private Long userId;

    public Stamp(){

    }

    public Stamp(User user){
        this.userId = user.getId();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
