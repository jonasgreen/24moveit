package com.moveit.client.util;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.maps.client.geocode.LocationCallback;
import com.google.gwt.maps.client.geocode.Placemark;
import com.moveit.client.gui.SearchPageController;
import com.moveit.client.guicomponents.*;
import com.moveit.client.language.LAddress;
import com.moveit.client.model.Address;
import com.moveit.client.model.GoogleMapService;
import com.moveit.client.service.Service;
import com.moveit.client.service.LogAction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GetOnePlacemarkJob extends Job {


    private final Address adr;
    private Placemark value = null;

    public GetOnePlacemarkJob(Address adr, Executer e, String inProgressText) {
        super(e, inProgressText);
        this.adr = adr;
    }

    public void run() {
        try {
            getGoogleAddress(true);
        }
        catch (Exception e) {
            Service.log(LogAction.Type.address_not_found, adr.toString(), e);
            setErrorMsg(e.getMessage());
            finished(false);
        }
    }

    private void getGoogleAddress(final boolean withAddress) {
        GoogleMapService.newInstance(adr, withAddress, new LocationCallback() {
            public void onFailure(int statusCode) {
                Service.log(LogAction.Type.address_not_found, "parameter 'withAddress='"+withAddress + ". "+ adr.toString() + " Googlemap status code:" + statusCode, null);
                setStatusCode(statusCode);
                if (withAddress) {
                    getGoogleAddress(false);
                }
                else {
                    finished(false);
                }
            }

            public void onSuccess(final JsArray<Placemark> locations) {
                if (locations.length() == 1) {
                    value = locations.get(0);
                    finished(true);
                }
                else {
                    if (areTheSame(locations)) {
                        value = locations.get(0);
                        finished(true);
                        return;
                    }
                    List<String> items = new ArrayList<String>();
                    for (int i = 0; i < locations.length(); i++) {
                        items.add(locations.get(i).getAddress());
                    }
                    final ChooseDialog dc = new ChooseDialog(items, LAddress.MULTIPLE_ADDRESS_FOUND.text(), DialogComponent.Response.CANCEL, DialogComponent.Response.OK);
                    VerticalComponent vc = new VerticalComponent();
                    vc.add(new LabelComponent(LAddress.CHOOSE_ONE_OR_TRY_WITH.text()), new Layout17(0, 4, 0, 4));
                    vc.add(new LabelComponent(LAddress.UNVALID_ADDRESS_TRY_WITH_3.text()), new Layout17(0, 4, 12, 4).add(P.FONT_WEIGHT_BOLD));
                    dc.add(vc, new Layout17(12, 0, 6, 0));
                    dc.show(new DialogComponent.DialogCallBack() {
                        public void onClose(DialogComponent.Response r) {
                            if (r == DialogComponent.Response.OK) {
                                SearchPageController.getInstance().getSearchCriteriaPanel().getSearchBox().setText(locations.get(dc.getChosenItem()).getAddress());
                                value = locations.get(dc.getChosenItem());
                                finished(true);

                            }
                            else {
                                finished(false);
                            }
                        }
                    });
                }
            }
        });
    }

    private boolean areTheSame(JsArray<Placemark> locations) {
        Placemark pm = locations.get(0);
        for (int i = 1; i < locations.length(); i++) {
            if (!areTheSame(pm, locations.get(i))) {
                return false;
            }

        }
        return true;
    }

    private boolean areTheSame(Placemark pm, Placemark placemark) {
        return pm.getAddress().equalsIgnoreCase(placemark.getAddress());
    }


    public Placemark getValue() {
        return value;
    }

    public Address getAddress() {
        return adr;
    }
}
