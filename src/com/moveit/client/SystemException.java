package com.moveit.client;

/**
 *
 */
public class SystemException extends RuntimeException{
    private static final long serialVersionUID = -1852563586349173979L;

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }
}
