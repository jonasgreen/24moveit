package com.moveit.server.repository;

import com.moveit.client.SystemException;
import com.moveit.client.model.CreateInvitation;
import com.moveit.client.model.Invitation;
import com.moveit.server.dao.Dao;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.jdo.InvitationJDO;

import java.util.Collection;
import java.util.Date;

/**
 *
 */
public class InvitationRepository extends Repository<InvitationJDO, Invitation, CreateInvitation> {


    public InvitationRepository() {
        this(new Dao(InvitationJDO.class), new InvitationConverter());
    }

    public InvitationRepository(Dao dao, Converter con) {
        super(dao, con);
    }

    public Class<Invitation> getRepositoryType() {
        return Invitation.class;
    }

    public Invitation update(Invitation inv) {
        InvitationJDO jdo = dao.read(inv.getId());
        jdo.setLastChangeDate(new Date());
        jdo.setSent(inv.isSent());
        return conv.convert(dao.update(jdo));
    }


    //FINDERS

    public Invitation findByEmail(String email) {
        if (email == null || email.equals("")) {
            return null;
        }
        FindByOneParam findByParam = FindByOneParam.findByEmail();
        findByParam.setValue(email.toLowerCase());
        Collection<Invitation> invitations = findBy(findByParam);
        if (invitations.size() > 1) {
            throw new SystemException("Data error - " + invitations.size() + " invitations with same email exist. Email=" + email);
        }
        return invitations.isEmpty() ? null : invitations.iterator().next();
    }
}