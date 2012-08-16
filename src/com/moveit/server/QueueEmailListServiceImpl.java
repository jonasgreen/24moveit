package com.moveit.server;

import com.moveit.client.SystemException;
import com.moveit.client.service.InvitationsJobAction;
import com.moveit.client.service.NewRoutesMailJobAction;
import com.moveit.server.services.ActionHandlerRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implementing queue jobs /gwtmodule/emaillist
 */
public class QueueEmailListServiceImpl extends HttpServlet {


    private static final long serialVersionUID = 8354270027885124245L;


    public static String NEW_ROUTES_USERID = "newRoutesUserId";
    public static String NEW_ROUTES_COUNTERVALUE = "newRoutesCounterValue";

    public static String INVITATION_ID = "invitationEmail";


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
        try {
            Logger.log("QUEUEMAILLISTSERVICE - handling request");

            //email types
            String newRoutesUserId = request.getParameter(NEW_ROUTES_USERID);
            String newRoutesCounterValue = request.getParameter(NEW_ROUTES_COUNTERVALUE);

            String invitationEmail = request.getParameter(INVITATION_ID);



            //supports only two retries
            String retried = request.getHeader("X-AppEngine-TaskRetryCount");
            if (retried != null && retried.equals("2")) {
                Logger.log("QueueEmailList exceeded maximum number of tries for subscribtionId=" + newRoutesUserId);
                return;
            }


            //only supports subscriptions and invitations
            if (newRoutesUserId != null && !newRoutesUserId.equals("")) {
                Logger.log("newRoutesUserID = "+ newRoutesUserId);

                ActionHandlerRegistry.executeAction(new NewRoutesMailJobAction(Long.valueOf(newRoutesUserId), Long.valueOf(newRoutesCounterValue)));
            }
            else if (invitationEmail != null && !invitationEmail.equals("")) {
                Logger.log("InvitationID = "+ invitationEmail);
                ActionHandlerRegistry.executeAction(new InvitationsJobAction(Long.valueOf(invitationEmail)));
            }
            else {
                Logger.log("QUEUEMAILLISTSERVICE - no subscriptionId or invitationId parameter");
            }
        }
        catch (Exception e) {
            Logger.log("EXCEPTION CAUGHT IN QUEUEEMAILLISTSERVICE-SERVLET", e);
            throw new SystemException(e.getMessage());
        }
    }



}