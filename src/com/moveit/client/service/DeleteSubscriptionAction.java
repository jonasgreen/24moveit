package com.moveit.client.service;

/**
 *
 */
public class DeleteSubscriptionAction extends AbstractAction implements Action<VoidResult>{
    private static final long serialVersionUID = 3241278763070501142L;

    private Long id;


    public DeleteSubscriptionAction() {
    }

    public DeleteSubscriptionAction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}