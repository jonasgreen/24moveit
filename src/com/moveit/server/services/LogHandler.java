package com.moveit.server.services;

import com.moveit.client.ApplicationException;
import com.moveit.client.service.LogAction;
import com.moveit.client.service.VoidResult;
import com.moveit.server.Logger;

/**
 *
 */
public class LogHandler extends AbstractActionHandler implements ActionHandler<LogAction, VoidResult> {


    public VoidResult execute(LogAction action) throws ApplicationException {
        log(action);
        return new VoidResult();
    }

    private void log(LogAction a) {
        StringBuffer sb = new StringBuffer("CLIENT_LOG: ");
        sb.append(a.getType().name()).append(" ").append(a.getLogMessage());

        @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"})
        Throwable t = a.getThrowable();
        if (t != null) {
            Logger.log(sb.toString(), t);
        }
        else {
            Logger.log(sb.toString());
        }

    }


    public Class<LogAction> getActionType() {
        return LogAction.class;
    }


}