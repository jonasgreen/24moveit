package com.moveit.client.gui;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moveit.client.FacebookService;
import com.moveit.client.Global;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LAdd;
import com.moveit.client.language.LService;
import com.moveit.client.language.Language;
import com.moveit.client.model.Address;
import com.moveit.client.model.Route;
import com.moveit.client.util.*;
import com.moveit.client.validator.ValidateManager;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class AddPageController extends PageController<AddPage> {

    private static AddPageController instance = null;
    public static String HISTORY_NAME = "add";


    private AddPageController() {
        super(HISTORY_NAME);
    }

    public static AddPageController getInstance() {
        if (instance == null) {
            instance = new AddPageController();
        }
        return instance;
    }


    public AddPage newInstance() {
        return new AddPage();
    }

    public void loadFromHistory() {
        doLoad();
    }

    public MenuComponent getMenu() {
        return MenuPanel.getInstance().getAddMove();
    }

    private void doLoad() {
        if(Language.language == Language.DANISH){
           getPage().getByWho().setFocus();
        }
        else{
            getPage().getFromAddr().getStreet().setFocus(true);            
        }
        TipsManagerAddPage.getInstance().setRelativePlacementLeft(getPage().getFromAddr());
        page.setWidth("100%");
        page.setVisible(true);

    }

    public void load() {
        doLoad();
        clearFields();
    }

    private void clearFields() {


    }

    public void unload() {
        TipsManagerAddPage.getInstance().clear();
    }

    public void save() {
        if (ApplicationController.getInstance().getUser() == null) {
            getPage().showRememberToSave(true);
            ApplicationController.getInstance().loadPage(SignUpPageController.getInstance());
            InfoManager.showInfo(LAdd.ACCOUNT_NEEDED.text());
            return;
        }
        getPage().showRememberToSave(false);
        if (!validate(page.getFromAddr()) || !validate(page.getToAddr())) {
            return;
        }
        ValidateManager vm = new ValidateManager();

        Collection<DataContainer> toValidate = new ArrayList<DataContainer>();
        toValidate.addAll(page.getWhenToMovePanel().getDataContainerChildren());
        toValidate.addAll(page.getWhatToMovePanel().getDataContainerChildren());

        boolean succes = vm.validate(toValidate);
        if (!succes) {
            vm.showErrors();
            return;
        }


        final Address fromAdr = getAddress(page.getFromAddr());
        final Address toAdr = getAddress(page.getToAddr());

        Executer e = new Executer();




        e.setHandler(new SuccesFailureHandler() {
            public void succes() {
                //ignore
            }

            public void failure() {
                //is handled by the individuel handlers of the jobs.
            }
        });

        //creating and adding jobs
        final GetOnePlacemarkJob jobFromAdr = getOnePlacemarkJob(fromAdr, e, LAdd.FROM_ADDRESS_NOT_IDENTIFIED.text(), LAdd.VALIDATE_FROM_ADDRESS.text());
        final GetOnePlacemarkJob jobToAdr = getOnePlacemarkJob(toAdr, e, LAdd.TO_ADDRESS_NOT_IDENTIFIED.text(), LAdd.VALIDATE_TO_ADDRESS.text());

        e.add(jobFromAdr);
        e.add(jobToAdr);

        final SaveRouteJob saveJob = new SaveRouteJob(getPage().contactWishes.getValue(), jobFromAdr, jobToAdr, page.getWhenToMovePanel(), page.getWhatToMovePanel(), e, LService.SAVING_DATA.text());
        saveJob.setHandler(new SuccesFailureHandler() {
            public void succes() {
                handleSaveSucces(Global.getLastSavedRoute());
            }

            public void failure() {
                DialogComponent.showSimpleOk(LAdd.SAVE_ERROR.text(), saveJob.getErrorMsg());
            }
        });

        e.add(saveJob);

        //executing all jobs - one at the time.
        e.execute();

    }

    private void handleSaveSucces(final Route route){
        GoogleAnalytics.logAction(GoogleAnalytics.ROUTE_CREATED);
        DialogComponent.DialogCallBack dCallback = new DialogComponent.DialogCallBack() {
            public void onClose(DialogComponent.Response r) {
                if(r == DialogComponent.Response.OK){
                    GoogleAnalytics.logAction(GoogleAnalytics.FACEBOOK_RECOOMEND_ROUTE);                    
                    FacebookService fs = new FacebookService();

                    fs.puplish(route, new AsyncCallback() {
                        public void onFailure(Throwable throwable) {
                             ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
                        }

                        public void onSuccess(Object o) {
                            ApplicationController.getInstance().loadPage(FrontPageController.getInstance());
                        }
                    });
                }
            }
        };

        DialogComponent.showSimpleOkCancel(LAdd.SAVED_WITH_SUCCES_1.text(), dCallback,
                        LAdd.SAVED_WITH_SUCCES_2.text(),
                        "",
                        LAdd.SAVED_WITH_SUCCES_3.text());

    }


    private boolean validate(AddressPanel adr) {
        ValidateManager val = new ValidateManager();
        boolean hasErrors = val.validate(adr.getDataContainerChildren());
        if (!hasErrors) {
            val.showErrors();
        }
        return hasErrors;
    }

    private GetOnePlacemarkJob getOnePlacemarkJob(final Address fromAdr, Executer e, final String errorReason, String progressText) {
        GetOnePlacemarkJob job = new GetOnePlacemarkJob(fromAdr, e, progressText);
        job.setHandler(new SuccesFailureHandler() {
            public void succes() {
                //ignore
            }

            public void failure() {
                //DialogComponent dc = new DialogComponent(false, true, DialogComponent.Response.OK);
                showAddressError(fromAdr, errorReason);
            }
        });
        return job;
    }


    private void showAddressError(Address address, String reason) {
        String title = LAdd.ADDRESS_ERROR.text();

        if (address.getStreet() == null || address.getStreet().equals("")) {
            DialogComponent.showSimpleOk(title, reason, LAdd.TRY_STREET_NAME.text());

        }
        else {
            DialogComponent.showSimpleOk(title, reason, LAdd.CHECK_POSTAL_CODE.text());
        }
    }


    private Address getAddress(AddressPanel panel) {
        Address adr = new Address();
        adr.setNation(panel.getNation());
        adr.setNationalCode(panel.getNationCode());
        adr.setCity(panel.getCity().getValue());
        adr.setCityCode(panel.getCityCode().getValue());
        adr.setStreet(panel.getStreet().getValue());
        return adr;
    }


}





