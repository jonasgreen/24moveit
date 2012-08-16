package com.moveit.client.service;

/**
 *
 */
public class GetUserByEmailAction extends AbstractAction implements Action<UserResult> {
    private static final long serialVersionUID = 1759607661966602481L;

    private String email;

    public GetUserByEmailAction() {
    }

    public GetUserByEmailAction(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}