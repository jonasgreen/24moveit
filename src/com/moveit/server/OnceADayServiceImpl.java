package com.moveit.server;

import com.moveit.server.services.ActionHandlerRegistry;
import com.moveit.client.service.OnceADayCronJobAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implementing once a day cron job. url /gwtmodule/onceaday
 */
public class OnceADayServiceImpl extends HttpServlet {
    private static final long serialVersionUID = 274804192869160632L;


    public void init() {
        ActionHandlerRegistry.init(getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request);
    }


    private void handleRequest(HttpServletRequest request) {
        Logger.log("CRON-JOB START");
        //only requests from google cron job maschine should be handled
        String cronJob = request.getHeader("X-AppEngine-Cron");

        if (cronJob == null || !cronJob.equalsIgnoreCase("true")) {
            Logger.log("CRON-JOB END - not a cron job - cronjob:"+cronJob);

            return;
        }
        try {
            ActionHandlerRegistry.executeAction(new OnceADayCronJobAction());
            Logger.log("CRON-JOB END");

        }
        catch (Exception e) {
            Logger.log("CRON-JOB EXCEPTION "+ e);
            //Ignore - handled in ActionHandlerRegistry
            
        }
    }

}

/*
    *  X-AppEngine-QueueName, the name of the queue (possibly default)
    * X-AppEngine-TaskName, the name of the task, or a system-generated unique ID if no name was specified
    * X-AppEngine-TaskRetryCount, the number of times this task has been retried; for the first attempt, this value is 0




*/
