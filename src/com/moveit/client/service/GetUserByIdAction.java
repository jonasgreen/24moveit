package com.moveit.client.service;

/**
 *
 */
public class GetUserByIdAction extends AbstractAction implements Action<UserResult>{
    private static final long serialVersionUID = 7627323125082048835L;

    private Long userId;


    public GetUserByIdAction() {
    }

    public GetUserByIdAction(Long id) {
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}