package com.moveit.client.service;

/**
 *
 */
public class DeleteUserAction extends AbstractAction implements Action<VoidResult>{
    private static final long serialVersionUID = 6411689227609728779L;

    private Long userId;


    public DeleteUserAction() {
    }

    public DeleteUserAction(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}