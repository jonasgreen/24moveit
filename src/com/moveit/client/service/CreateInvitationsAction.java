package com.moveit.client.service;

import java.util.List;

/**
 *
 */
public class CreateInvitationsAction extends AbstractAction implements Action<VoidResult>{
    private static final long serialVersionUID = -5040314418734046895L;

    private List<String> emails;
    private Integer invitationLanguage;

    public CreateInvitationsAction() {
    }

    public CreateInvitationsAction(Integer invitationLanguage, List<String> emails) {
        this.emails = emails;
        this.invitationLanguage = invitationLanguage;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Integer getInvitationLanguage() {
        return invitationLanguage;
    }

    public void setInvitationLanguage(int invitationLanguage) {
        this.invitationLanguage = invitationLanguage;
    }
}