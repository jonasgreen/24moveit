package com.moveit.client.service;

/**
 *
 */
public class InvitationsJobAction extends AbstractAction implements Action<VoidResult> {
    private static final long serialVersionUID = -1188482392860957527L;

    private Long invitationId;


    public InvitationsJobAction() {
    }

    public InvitationsJobAction(Long subscriptionId) {
        this.invitationId = subscriptionId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }

}