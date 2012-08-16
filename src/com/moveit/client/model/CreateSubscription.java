package com.moveit.client.model;

import com.moveit.client.constants.MailListConstant;

import java.io.Serializable;

/**
 *
 */
public class CreateSubscription extends Creater implements Serializable{
    private static final long serialVersionUID = -6151868885667878972L;

    private Long userId;
    private MailListConstant mailList;

    public CreateSubscription() {
    }

    public CreateSubscription(Long userId, MailListConstant mailList) {
        this.userId = userId;
        this.mailList = mailList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MailListConstant getMailList() {
        return mailList;
    }

    public void setMailList(MailListConstant mailList) {
        this.mailList = mailList;
    }
}