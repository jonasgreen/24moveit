package com.moveit.server.repository;

import com.moveit.client.model.CreateInvitation;
import com.moveit.client.model.Invitation;
import com.moveit.server.jdo.InvitationJDO;

import java.util.Date;

/**
 *
 */
public class InvitationConverter extends Converter<InvitationJDO, Invitation, CreateInvitation> {

    public InvitationJDO convert(CreateInvitation model) {
        if (model == null) {
            return null;
        }
        InvitationJDO jdo = new InvitationJDO();

        jdo.setEmail(model.getEmail().toLowerCase());
        jdo.setCreatedDate(new Date());
        jdo.setSent(false);
        jdo.setLanguage(model.getInviLanguage());

        return jdo;
    }

    public Invitation convert(InvitationJDO jdo) {
        if (jdo == null) {
            return null;
        }

        Invitation inv = new Invitation();

        inv.setId(jdo.getKeyId());
        inv.setCreatedDate(jdo.getCreatedDate());
        inv.setEmail(jdo.getEmail());
        inv.setLastChangeDate(jdo.getLastChangeDate());
        inv.setSent(jdo.isSent());
        inv.setLanguage(jdo.getLanguage());

        return inv;
    }



}