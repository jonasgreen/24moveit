package com.moveit.client.service;

import com.moveit.client.ServerWrapper;
import com.moveit.client.language.LService;
import com.moveit.client.language.Language;
import com.moveit.client.constants.MailListConstant;
import com.moveit.client.constants.UserTypeConstant;
import com.moveit.client.gui.MapPopupManager;
import com.moveit.client.model.*;

import java.util.List;

/**
 *
 */
public class Service {

    private static ServerWrapper server = new ServerWrapper();


    //LOG

    public static void log(LogAction.Type type, String msg, Throwable t) {
        executeWithRetry(new LogAction(msg, type, t), new SilentCallBack() {
            public void success(Object result) {
                //ignore
            }

            public void fail(Throwable t) {
                //ignore
            }
        });
    }


    //ROUTE

    public static void createRoute(final CreateRoute crd, final CallBack<RouteResult> cb) {
        executeWithRetry(new CreateRouteAction(crd), cb);
    }

    public static void deleteRoute(Long routeId, CallBack<VoidResult> cb) {
        cb.startProgressBar(LService.DELETE.text());
        executeWithRetry(new DeleteRouteAction(routeId), cb);
    }

    public static void getAllRoutes(String countryCode, CallBack<RouteListResult> cb) {
        MapPopupManager.hideRoute();
        cb.startProgressBar(LService.SEARCH.text());
        executeWithRetry(new FindAllRoutesAction(countryCode), cb);
    }

    public static void getRoutes(User user, CallBack<RouteListResult> cb) {
        cb.startProgressBar();
        executeWithRetry(new FindRoutesByUserAction(user.getId()), cb);
    }

    public static void contactInfoShownTo(Long userId, Long routeId, CallBack<VoidResult> ac) {
        ContactInfoShownToAction action = new ContactInfoShownToAction();
        action.setRouteId(routeId);
        action.setUserId(userId);
        executeWithRetry(action, ac);
    }


    //USER

    public static void signIn(SignInData value, CallBack<UserResult> asyncCallback) {
        asyncCallback.startProgressBar(LService.SIGN_ON.text());
        executeWithRetry(new SigninAction(value), asyncCallback);
    }

    public static void getUser(String email, CallBack<UserResult> cb) {
        cb.startProgressBar(null);
        executeWithRetry(new GetUserByEmailAction(email), cb);
    }

    public static void getAllUsers(CallBack<AllUsersResult> cb) {
        cb.startProgressBar(LService.USER_INFO_ALL.text());
        executeWithRetry(new GetAllUsersAction(), cb);

    }

    public static void createUser(CreateUser value, CallBack<UserResult> asyncCallback) {
        asyncCallback.startProgressBar(value.getUserType() == UserTypeConstant.CUSTOMER.getValue() ? LService.CREATE_ACCOUNT_USER.text() : LService.CREATE_ACCOUNT_FIRM.text());
        executeWithRetry(new CreateUserAction(value), asyncCallback);

    }

    public static void deleteUser(User user, CallBack<VoidResult> asyncCallback) {
        asyncCallback.startProgressBar(LService.DELETE_ACCOUNT.text());
        executeWithRetry(new DeleteUserAction(user.getId()), asyncCallback);
    }

    public static void getUser(Long userId, CallBack<UserResult> cb) {
        cb.startProgressBar(null);
        executeWithRetry(new GetUserByIdAction(userId), cb);
    }

    public static void emailPasswordToUser(String email, CallBack<VoidResult> cb) {
        cb.startProgressBar(LService.SENDING_EMAIL.text());
        executeWithRetry(new EmailPasswordToUserAction(email), cb);
    }

    public static void getUserSettings(Long userId, CallBack<UserSettingsResult> cb) {
        cb.startProgressBar(LService.WORKING.text());
        executeWithRetry(new GetUserSettingsAction(userId), cb);
    }


    //Mail services

    public static void unsubscribe(Long subscriptionId, CallBack<VoidResult> cb) {
        cb.startProgressBar(LService.SAVING_DATA.text());
        executeWithRetry(new DeleteSubscriptionAction(subscriptionId), cb);
    }

    public static void subscribe(Long userId, MailListConstant mailList, boolean deleteSubscription, CallBack<SubscriptionResult> cb) {
        cb.startProgressBar(LService.SAVING_DATA.text());
        executeWithRetry(new CreateSubscriptionAction(new CreateSubscription(userId, mailList), deleteSubscription), cb);
    }

    public static void createInvitations(Integer language, List<String> emails, CallBack<VoidResult> cb) {
        cb.startProgressBar(LService.CREATING_INVITATIONS.text());
        executeWithRetry(new CreateInvitationsAction(language, emails), cb);
    }


    //Ping - to avoid servlet to go to sleep while app is open.

    public static void pingServer(CallBack<VoidResult> cb) {
        cb.startProgressBar(LService.PINGING.text());
        executeWithRetry(new PingAction(), cb);
    }

    private static void executeWithRetry(Action a, CallBack cb) {
        a.setLanguage(Language.language.getValue());
        cb.setRetry(a);
        server.execute(a, cb);
    }

    public static void resend(Action a, CallBack cb) {
        server.execute(a, cb);
    }


}
