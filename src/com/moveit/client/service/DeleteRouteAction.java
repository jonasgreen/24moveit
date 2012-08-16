package com.moveit.client.service;

/**
 *
 */
public class DeleteRouteAction extends AbstractAction implements Action<VoidResult>{

    private static final long serialVersionUID = -4586244796114641499L;
    private Long id;


    public DeleteRouteAction() {
    }

    public DeleteRouteAction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}