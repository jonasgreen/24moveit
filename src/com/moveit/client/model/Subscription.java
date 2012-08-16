package com.moveit.client.model;

import com.moveit.client.constants.MailListConstant;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class Subscription extends Model{
    private static final long serialVersionUID = -6151868885667878972L;

    
    private Long id;
    private Long userId;
    private MailListConstant mailList;

    public Subscription() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static Collection<Subscription> extract(MailListConstant c, Collection<Subscription> col){
        List<Subscription> list = new ArrayList<Subscription>();
        for (Subscription s : col) {
            if(s.getMailList().getValue() == c.getValue()){
                list.add(s);
            }
        }
        return list;
    }
}
