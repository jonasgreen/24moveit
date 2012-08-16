package com.moveit.client.gui;

import com.moveit.client.constants.MailListConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.model.Invitation;
import com.moveit.client.model.Subscription;
import com.moveit.client.model.User;
import com.moveit.client.model.UserSettings;
import com.moveit.client.service.*;

import java.util.*;

/**
 *
 */
public class AccountPageController extends PageController<AccountPage> {

    private List<User> drivers = new ArrayList<User>();
    private List<User> nonDrivers = new ArrayList<User>();
    private List<Invitation> invitations = new ArrayList<Invitation>();

    public static String HISTORY_NAME = "account";
    private static AccountPageController instance;

    private AccountPageController() {
        super(HISTORY_NAME);
    }

    public static AccountPageController getInstance() {
        if (instance == null) {
            instance = new AccountPageController();
        }
        return instance;
    }

    public AccountPage newInstance() {
        return new AccountPage();
    }

    public void load() {
        User user = ApplicationController.getInstance().getUser();
        if (user == null) {
            ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
            return;
        }

        getPage();
        page.setWidth("100%");
        StyleIt.add(page, Name.MARGIN_Bottom, "50px");
        if (user.isDriver()) {
            getPage().routeSupscription.setVisible(true);

        }
        else {
            getPage().routeSupscription.setVisible(false);
        }

        refreshRoutes();
    }

    public MenuComponent getMenu() {
        return MenuPanel.getInstance().getAccount();
    }

    public void refreshRoutes() {
        Service.getRoutes(ApplicationController.getInstance().getUser(), new CallBack<RouteListResult>() {
            @Override
            public void success(RouteListResult result) {
                getPage().addRoutes(result.getRoutes());
            }

            @Override
            public void fail(Throwable t) {
            }
        });
    }

    public void loadUserSettings() {
        Service.getUserSettings(ApplicationController.getInstance().getUser().getId(), new CallBack<UserSettingsResult>() {
            @Override
            public void success(UserSettingsResult result) {
                UserSettings us = result.getUserSettings();
                setUpSubscription(getPage().newsSupscription, MailListConstant.NEWS_24MOVEIT, us.getSubscriptions());
                setUpSubscription(getPage().routeSupscription, MailListConstant.NEW_ROUTE_ONCE_A_DAY, us.getSubscriptions());
            }

            @Override
            public void fail(Throwable t) {
            }
        });
    }

    private void setUpSubscription(CheckBoxComponent chBox, MailListConstant c, Collection<Subscription> subs) {
        chBox.getCheckBox().setValue(!Subscription.extract(c, subs).isEmpty());
    }

    public void subscripe(MailListConstant mailCons, boolean deleteSub) {
        Service.subscribe(ApplicationController.getInstance().getUser().getId(), mailCons, deleteSub, new CallBack<SubscriptionResult>() {
            @Override
            public void success(SubscriptionResult result) {
                //ApplicationController.getInstance().setUser(result.getUser());
                InfoManager.showSucces("Gemt med succes");
            }

            @Override
            public void fail(Throwable t) {
            }
        });
    }

    public void loadAdminContent() {
        Service.getAllUsers(new CallBack<AllUsersResult>() {
            @Override
            public void success(AllUsersResult result) {
                loadAdminContent(result.getUsers(), result.getInvitations());
            }

            @Override
            public void fail(Throwable t) {
            }
        });
    }

    private void loadAdminContent(Collection<User> users, Collection<Invitation> invis) {
        drivers = new ArrayList<User>();
        nonDrivers = new ArrayList<User>();
        invitations = new ArrayList<Invitation>();

        for (User user : users) {
            if (user.isDriver()) {
                drivers.add(user);
            }
            else {
                nonDrivers.add(user);
            }
        }


        getPage().loadAdminUsers(drivers, nonDrivers, removeDrivers(drivers, invis));

    }


    private List<Invitation> removeDrivers(Collection<User> drivers, Collection<Invitation> invis){
        Map<String, Invitation> map = new HashMap<String, Invitation>();
        for (Invitation invi : invis) {
            map.put(invi.getEmail(), invi);
        }

        for (User driver : drivers) {
            map.remove(driver.getEmail());
        }

        List<Invitation> list = new ArrayList<Invitation>();
        for (Invitation invitation : map.values()) {
            list.add(invitation);
        }

        return list;
    }


    public void sendInvitations() {
        String mailsText = getPage().getInvitationTextArea().getTextArea().getText();

        if (mailsText == null || mailsText.equals("")) {
            return;
        }

        List<String> emails = extractMails(mailsText);

        String language = getPage().getLanguageListBox().getItemText(getPage().getLanguageListBox().getSelectedIndex());
        if(language == null || language.equalsIgnoreCase("Vælg sprog")){
            DialogComponent.showSimpleOk("Husk at vælge sprog", "Husk at vælge sprog");
            return;
        }


        Service.createInvitations(Language.getLanguage(language).getValue(), emails, new CallBack<VoidResult>() {
            @Override
            public void success(VoidResult result) {
                getPage().getInvitationTextArea().setText("");
            }

            @Override
            public void fail(Throwable t) {
            }
        });


    }


    private List<String> extractMails(String mailText) {
        List<String> emails = new ArrayList<String>();

        char c = 0;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while (i < mailText.length()) {
            c = mailText.charAt(i++);
            if (c == ',' || c == ' ' || c == '\n' || c == ';' || c=='\t') {
                if (sb.length() > 0) {
                    emails.add(sb.toString());
                }
                sb = new StringBuffer();
            }
            else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            emails.add(sb.toString());
        }
        return emails;
    }


 }