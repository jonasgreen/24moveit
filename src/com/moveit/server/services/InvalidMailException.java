package com.moveit.server.services;

/**
 *
 */
public class InvalidMailException extends Exception{
    private static final long serialVersionUID = 6847320009969322442L;

    public InvalidMailException() {
        super();
    }

    public InvalidMailException(String message) {
        super(message);
    }
}
