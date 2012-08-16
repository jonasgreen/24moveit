package com.moveit.client.gui;

import com.google.gwt.event.dom.client.*;
import com.moveit.client.constants.MailListConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.Language;
import com.moveit.client.language.LAccount;
import com.moveit.client.model.Invitation;
import com.moveit.client.model.Route;
import com.moveit.client.model.User;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.Service;
import com.moveit.client.service.VoidResult;

import java.util.*;

/**
 *
 */
public class AccountPage extends Page<AccountPageController> {

    private VerticalComponent content;
    private Map<HorizontalComponent, Route> routeMap;

    private LabelComponent titleText;
    private Layout17 subtitle = new TextLayout(null, "200px", Horizontal.LEFT, Vertical.TOP).sizeNormal().bold();
    private HorizontalComponent movements;
    private VerticalComponent routeHolder = null;
    private HorizontalComponent mailInfo;
    private HorizontalComponent deleteAccount;
    public CheckBoxComponent newsSupscription = new CheckBoxComponent(LAccount.MAIL_NEWS.text());
    public CheckBoxComponent routeSupscription = new CheckBoxComponent(LAccount.MAIL_NEW_REQUESTS.text());
    private SimplePanelComponent usersAndDriversInfo;
    private TextAreaComponent invitationTextArea;
    private ButtonComponent invitationButton;
private ListBoxComponent languageListBox;


    public AccountPage() {
        super();
        content = new VerticalComponent();
        initWidget(content);
    }

    public void init() {

        HorizontalComponent header = new HorizontalComponent();
        header.add(getTitleText(), new TextLayout(10, 0, 0, 0, Horizontal.LEFT).sizeH3().colorBlue().bold());
        content.add(header, new Layout17(null, ApplicationController.APP_WIDTH, Horizontal.CENTER, null));

        //subitems
        Layout17 subItemLayout = new Layout17(20, 0, 0, 0, null, ApplicationController.APP_WIDTH, Horizontal.CENTER, null);
        content.add(getMovements(), subItemLayout);
        content.add(getMailInfo(), subItemLayout);

        content.add(getDeleteAccount(), subItemLayout);
        User user = ApplicationController.getInstance().getUser();
        if(user != null && user.getEmail().equalsIgnoreCase("jonasgreen12345@gmail.com")){
            content.add(new LabelComponent("--------------------------------------------------------------------------------------------------------------------------------------------------------------------"), new TextLayout(10, 0,20,0));

            content.add(getUsersAndDriversInfo());

            content.add(new LabelComponent("--------------------------------------------------------------------------------------------------------------------------------------------------------------------"), new TextLayout(10, 0,20,0));

            HorizontalComponent invitationMail = new HorizontalComponent();
            invitationMail.add(getInvitationTextArea(), new TextLayout(0,20,0,0, "200px", "200px").sizeSmall());
            invitationMail.add(getLanguageListBox(), new TextLayout(0, 20, 0, 0).sizeSmall());           
            invitationMail.add(getInvitationButton(), new TextLayout().sizeSmall());


            content.add(invitationMail);

            getController().loadAdminContent();
        }

        content.setMargin(0,0,0,0);
        getController().refreshRoutes();
        getController().loadUserSettings();
    }


      public ListBoxComponent getLanguageListBox() {
        if (languageListBox == null) {
            languageListBox = new ListBoxComponent();
            languageListBox.addItem("Vælg sprog");
            languageListBox.addItem(Language.DANISH.getName());
            languageListBox.addItem(Language.ENGLISH.getName());
            languageListBox.setVisibleItemCount(1);
            languageListBox.setSelectedIndex(0);
        }
        return languageListBox;
    }



    public SimplePanelComponent getUsersAndDriversInfo() {
        if (usersAndDriversInfo == null) {
            usersAndDriversInfo = new SimplePanelComponent();
        }
        return usersAndDriversInfo;
    }

    public TextAreaComponent getInvitationTextArea() {
        if (invitationTextArea == null) {
            invitationTextArea = new TextAreaComponent();
        }
        return invitationTextArea;
    }

    public ButtonComponent getInvitationButton() {
        if (invitationButton == null) {
            invitationButton = new ButtonComponent("Send invitationsmail");
            invitationButton.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    getController().sendInvitations();
                }
            });
        }
        return invitationButton;
    }



    public HorizontalComponent getDeleteAccount() {
        if (deleteAccount == null) {
            deleteAccount = new HorizontalComponent();
            deleteAccount.add(new LabelComponent(LAccount.YOUR_ACCOUNT.text()), subtitle);
            final LabelComponent delete = new LabelComponent(LAccount.DELETE_ACCOUNT.text());
            delete.setBackgroundColor(P.BACKGROUND_BACK_PANEL);
            delete.getLabel().setWordWrap(false);
            deleteAccount.add(delete, new TextLayout(Vertical.MIDDLE).sizeSmall());
            StyleIt.add(delete, Name.COLOR, P.BACKGROUND_ORANGE.getValue());

            delete.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    DialogComponent dc = new DialogComponent(false, true, DialogComponent.Response.CANCEL, DialogComponent.Response.OK);
                    dc.setText(LAccount.DELETE_ACCOUNT_TITLE.text());
                    StyleIt.add(dc, Name.BORDER_COLOR, P.BACKGROUND_ORANGE.getValue());
                    VerticalComponent vc = new VerticalComponent();
                    LabelComponent lc = new LabelComponent(LAccount.DELETE_ACCEPT.text());

                    vc.add(lc, new Layout17(0, 10, 4, 4).add(P.FONT_WEIGHT_BOLD).add(Name.COLOR, P.BACKGROUND_ORANGE.getValue()));

                    dc.add(vc, new Layout17(0, 0, 10, 0));
                    dc.show(new DialogComponent.DialogCallBack() {
                        public void onClose(DialogComponent.Response r) {
                            if (r == DialogComponent.Response.OK) {
                                Service.deleteUser(ApplicationController.getInstance().getUser(), new CallBack<VoidResult>() {
                                    @Override
                                    public void success(VoidResult result) {
                                        ApplicationController.getInstance().loggedOut();
                                        InfoManager.showSucces(LAccount.ACCOUNT_DELETED.text());
                                    }

                                    @Override
                                    public void fail(Throwable t) {
                                    }
                                });
                            }
                        }
                    });

                }
            });


            delete.addMouseOver(new MouseOverHandler() {
                public void onMouseOver(MouseOverEvent event) {
                    delete.setBackgroundColor(P.BACKGROUND_ORANGE);
                    StyleIt.add(delete, P.COLOR_WHITE);
                    event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
                }
            });

            delete.addMouseOut(new MouseOutHandler() {
                public void onMouseOut(MouseOutEvent event) {
                    delete.setBackgroundColor(P.BACKGROUND_BACK_PANEL);
                    StyleIt.add(delete, Name.COLOR, P.BACKGROUND_ORANGE.getValue());
                    event.getRelativeElement().getStyle().setProperty("cursor", "auto");
                }
            });

            deleteAccount.add(new HorizontalComponent(), new Layout17(0, 0, 0, 0, "10px", "100%"));
        }
        return deleteAccount;
    }

    public HorizontalComponent getSubscriptionRow(final CheckBoxComponent chBox, final MailListConstant mailCons) {
        HorizontalComponent hc = new HorizontalComponent();

        Layout17 l = new TextLayout(0, 10, 0, 0, Horizontal.LEFT, Vertical.MIDDLE).sizeSmall();
        hc.add(chBox, l);

        ButtonComponent button = new ButtonComponent(LAccount.BUTTON_SAVE.text());
        hc.add(button, new TextLayout(Horizontal.RIGHT, Vertical.MIDDLE).sizeSmall());
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getController().subscripe(mailCons, !chBox.getCheckBox().getValue());
            }
        });

        return hc;
    }


    public HorizontalComponent getMailInfo() {
        if (mailInfo == null) {
            mailInfo = new HorizontalComponent();
            mailInfo.add(new LabelComponent(LAccount.INFORMATION_BY_MAIL.text()), subtitle);

            VerticalComponent vc = new VerticalComponent();
            Layout17 l = new TextLayout(0, 10, 3, 0, null, "100%", Horizontal.LEFT, Vertical.MIDDLE).sizeSmall();
            vc.add(getSubscriptionRow(newsSupscription, MailListConstant.NEWS_24MOVEIT), l);
            vc.add(getSubscriptionRow(routeSupscription, MailListConstant.NEW_ROUTE_ONCE_A_DAY), l);

            mailInfo.add(vc, new Layout17(0, 0, 0, 0, null, "100%"));
        }
        return mailInfo;
    }

    public HorizontalComponent getMovements() {
        if (movements == null) {
            movements = new HorizontalComponent();
            movements.add(new LabelComponent(LAccount.ACTIVE_REQUESTS.text()), subtitle);
        }
        return movements;
    }

    public void addRoutes(Collection<Route> routes) {
        if (routeHolder != null) {
            routeHolder.removeFromParent();
        }
        routeHolder = new VerticalComponent();
        if (routes == null || routes.isEmpty()) {
            routeHolder.add(new LabelComponent(LAccount.NO_ACTIVE_REQUESTS.text()), new TextLayout().sizeSmall());
        }
        else {
            routeMap = new HashMap<HorizontalComponent, Route>();
            Layout17 l = new TextLayout(0, 0, 4, 0, null, "100%").sizeSmall();
            for (Route route : routes) {
                HorizontalComponent hc = createFrom(route);
                routeHolder.add(hc, l);
                routeMap.put(hc, route);
            }
        }
        getMovements().add(routeHolder, new Layout17(0, 0, 0, 0, null, "100%"));
    }

    private HorizontalComponent createFrom(Route r) {
        final HorizontalComponent hc = new HorizontalComponent();
        LabelComponent l = new LabelComponent(r.getFromPoint().getAddress().getCityCityCodeAndNationCode() + " --> " + r.getToPoint().getAddress().getCityCityCodeAndNationCode());
        hc.add(l, new TextLayout(Horizontal.LEFT, Vertical.MIDDLE).sizeSmall());

        ButtonComponent b = new ButtonComponent(LAccount.BUTTON_DELETE.text());
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                deleteRoute(hc);
            }
        });

        hc.add(b, new TextLayout(Horizontal.RIGHT, Vertical.MIDDLE).sizeSmall());
        return hc;
    }

    private void deleteRoute(HorizontalComponent hc) {
        Route r = routeMap.get(hc);
        Service.deleteRoute(r.getId(), new CallBack<VoidResult>() {
            @Override
            public void success(VoidResult result) {
                getController().refreshRoutes();
                SearchPageController.getInstance().setFirstTimeLoad(true);
            }

            @Override
            public void fail(Throwable t) {
            }
        });
    }

    public LabelComponent getTitleText() {
        if (titleText == null) {
            titleText = new LabelComponent(LAccount.YOUR_ACCOUNT_TITLE.text());
        }
        return titleText;
    }

    public VerticalComponent getContent() {
        return content;
    }

    public void loadAdminUsers(List<User> drivers, List<User> nonDrivers, List<Invitation> invitations) {

        getUsersAndDriversInfo().add(createUsersAndDriversInfo(drivers, nonDrivers, invitations));

    }

    private HorizontalComponent createUsersAndDriversInfo(List<User> drivers, List<User> customers, List<Invitation> invis){
        HorizontalComponent hc = new HorizontalComponent();


        Collections.sort(drivers, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });


        Collections.sort(customers, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });

        Collections.sort(invis, new Comparator<Invitation>() {
            public int compare(Invitation o1, Invitation o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });


        VerticalComponent vcDrivers = new VerticalComponent();
        vcDrivers.add(new LabelComponent("Vognmænd"), new TextLayout(0,0,6,0).sizeH2().bold());
        for (User d : drivers) {
            vcDrivers.add(new LabelComponent(d.getEmail()), new TextLayout(2,0,0,0).sizeEkstraSmall());
        }

        VerticalComponent vcCustomers = new VerticalComponent();
        vcCustomers.add(new LabelComponent("Kunder"), new TextLayout(0,0,6,0).sizeH2().bold());
        for (User d : customers) {
            vcCustomers.add(new LabelComponent(d.getEmail()), new TextLayout(2,0,0,0).sizeEkstraSmall());
        }


        VerticalComponent vcInvitations = new VerticalComponent();
        vcInvitations.add(new LabelComponent("Invitationer"), new TextLayout(0,0,6,0).sizeH2().bold());
        for (Invitation d : invis) {
            vcInvitations.add(new LabelComponent(d.getEmail()), new TextLayout(2,0,0,0).sizeEkstraSmall());
        }


        hc.add(vcCustomers, new TextLayout(0,50,0,0));
        hc.add(vcDrivers, new TextLayout(0,50,0,0));
        hc.add(vcInvitations);

        return hc;

    }
}