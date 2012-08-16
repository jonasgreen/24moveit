package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.about.AllAboutPageController;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LMenu;
import com.moveit.client.language.Language;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MenuPanel {

    private static MenuPanel instance;
    private HorizontalComponent content;

    private MenuComponent addMove;
    private MenuComponent addFirm;
    private MenuComponent search;
    private MenuComponent account;

    private List<MenuComponent> allMenues = new ArrayList<MenuComponent>();
    private MenuComponent home;
    private MenuComponent help;

    private MenuPanel() {

    }

    public static MenuPanel getInstance() {
        if (instance == null) {
            instance = new MenuPanel();
        }
        return instance;
    }


    public HorizontalComponent getPanel() {
        if (content == null) {
            allMenues.add(getAccount());
            allMenues.add(getAddFirm());
            allMenues.add(getAddMove());
            allMenues.add(getFindMove());
            allMenues.add(getHome());
            allMenues.add(getHelp());


            content = new HorizontalComponent();
            setup(content, getHome());
            setup(content, getAddMove());
            setup(content, getFindMove());
            setup(content, getAddFirm());
            setup(content, getAccount());
            setup(content, getHelp());

            //hc.add(new SimplePanelComponent(), new Layout17(0, 0, 0, 0, null, "100%", Horizontal.RIGHT, Vertical.MIDDLE));
            //content.add(hc, new Layout17(0, 0, 0, 0, AppFrame.MENU_HEIGHT + "px", "100%", Horizontal.LEFT, null).add(Name.PADDING_LEFT, "40px"));
            content.setBackgroundColor(P.BACKGROUND_MENU_TOP);


        }
        return content;
    }

    private void setup(HorizontalComponent hc, MenuComponent mc) {
        hc.add(mc, new Layout17(0, 0, 0, 0, "100%", null, null, Vertical.MIDDLE).add(Name.PADDING_LEFT, "25px").add(Name.PADDING_RIGHT, "25px").add(Name.PADDING_TOP, "14px"));

    }


    public MenuComponent getAddMove() {
        if (addMove == null) {
            addMove = new MenuComponent(Language.get(LMenu.ADD_MOVEMENT));
            addMove.setTitle(Language.get(LMenu.TOOLTIP_ADD_MOVEMENT));
            addMove.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    if (!addMove.isSelected()) {
                        ApplicationController.getInstance().loadPage(AddPageController.getInstance());
                        setSelected(addMove);
                    }
                }
            });
        }
        return addMove;
    }


    public MenuComponent getHome() {
        if (home == null) {
            home = new MenuComponent(Language.get(LMenu.FRONT_PAGE));
            home.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    if (!home.isSelected()) {
                        ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
                        setSelected(home);
                    }
                }
            });
        }
        return home;
    }

    public MenuComponent getHelp() {
        if (help == null) {
            help = new MenuComponent(Language.get(LMenu.HELP));
            help.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    if (!help.isSelected()) {
                        ApplicationController.getInstance().loadPage(AllAboutPageController.getInstance());
                        setSelected(help);
                    }
                }
            });
        }
        return help;
    }

    public MenuComponent getAddFirm() {
        if (addFirm == null) {
            addFirm = new MenuComponent(Language.get(LMenu.REGISTER_FIRM));
            addFirm.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    if (!addFirm.isSelected()) {
                        ApplicationController.getInstance().loadPage(AddFirmController.getInstance());
                        setSelected(addFirm);
                    }
                }
            });
        }
        return addFirm;
    }

    public MenuComponent getFindMove() {
        if (search == null) {
            search = new MenuComponent(Language.get(LMenu.FIND_JOB));
            search.setTitle(Language.get(LMenu.TOOLTIP_FIND_JOB));
            search.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    if (!search.isSelected()) {
                        ApplicationController.getInstance().loadPage(SearchPageController.getInstance());
                        setSelected(search);
                    }
                }
            });
        }
        return search;
    }

    public MenuComponent getAccount() {
        if (account == null) {
            account = new MenuComponent(Language.get(LMenu.YOUR_ACCOUNT));
            account.setActive(false);
            account.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    if (!account.isSelected() && account.isActive()) {
                        ApplicationController.getInstance().loadPage(AccountPageController.getInstance());
                        setSelected(account);
                    }
                }
            });
            boolean loggedOn = ApplicationController.getInstance().getUser() != null;
            account.setActive(loggedOn);
            account.setVisible(loggedOn);
        }
        return account;
    }

    public void setSelected(MenuComponent mc) {
        for (MenuComponent m : allMenues) {
            m.setSelected(false);
        }
        if (mc != null) {
            mc.setSelected(true);
        }
    }
/*

    public CenterComponent getMenuPanelSearch() {
        if (menuPanelSearch == null) {
            menuPanelSearch = createComponent("Er du vognmand?", SearchPageController.getInstance());
        }
        return menuPanelSearch;
    }


    public CenterComponent getMenuPanelAdd() {
        if (menuPanelAdd == null) {
            menuPanelAdd = createComponent("Indtast flytning", AddPageController.getInstance());
        }
        return menuPanelAdd;
    }
    */

    /*private CenterComponent createComponent(String label, final PageController pageContrl) {
        CenterComponent cc = new CenterComponent();
        MenuComponent hl = new MenuComponent(label);
        hl.getLabel().setWordWrap(false);
        hl.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ApplicationController.getInstance().loadPage(pageContrl);
            }
        });
        hl.setBackgroundColor(P.BACKGROUND_FRONT_ORANGE_ORG);
        cc.add(hl, new Layout17(0, 0, 10, 0, "100%", null, Horizontal.RIGHT, Vertical.BOTTOM).add(Css.TOP_MENU_LINK).add(P.COLOR_WHITE).add(P.FONT_WEIGHT_BOLD));
        cc.setBackgroundColor(P.BACKGROUND_GREY_TOP);
        return cc;
    }
    */


    public void changeLanguage() {
        getAccount().getLabel().setText(Language.get(LMenu.YOUR_ACCOUNT));
        getAddFirm().getLabel().setText(Language.get(LMenu.REGISTER_FIRM));
        getAddMove().getLabel().setText(Language.get(LMenu.ADD_MOVEMENT));
        getAddMove().setTitle(Language.get(LMenu.TOOLTIP_ADD_MOVEMENT));
        getFindMove().getLabel().setText(Language.get(LMenu.FIND_JOB));
        getFindMove().getLabel().setTitle(Language.get(LMenu.TOOLTIP_FIND_JOB));
        getHome().getLabel().setText(Language.get(LMenu.FRONT_PAGE));
        getHelp().getLabel().setText(Language.get(LMenu.HELP));

    }
}