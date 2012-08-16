package com.moveit.client.service;

/**
 *
 */
public class GetUserSettingsAction extends AbstractAction implements Action<UserSettingsResult>{
    private static final long serialVersionUID = 7151805293703488314L;

    private Long userId;


    public GetUserSettingsAction() {
    }

    public GetUserSettingsAction(Long id) {
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}