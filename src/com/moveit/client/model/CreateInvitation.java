package com.moveit.client.model;

import java.io.Serializable;


/**
 *
 */
public class CreateInvitation extends Creater implements Serializable {
    private static final long serialVersionUID = 358125402522721784L;

    private String email;
    private Integer inviLanguage;

    public CreateInvitation(String email, Integer inviLanguage) {
        this.email = email;
        this.inviLanguage = inviLanguage;
    }

    public CreateInvitation() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getInviLanguage() {
        return inviLanguage;
    }

    public void setInviLanguage(Integer inviLanguage) {
        this.inviLanguage = inviLanguage;
    }
}