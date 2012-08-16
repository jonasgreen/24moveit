package com.moveit.client.util;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.maps.client.geocode.LocationCallback;
import com.google.gwt.maps.client.geocode.Placemark;
import com.google.gwt.maps.client.geom.LatLng;
import com.moveit.client.gui.InfoManager;
import com.moveit.client.gui.RouteOptimizingPanel;
import com.moveit.client.gui.SearchPageController;
import com.moveit.client.guicomponents.*;
import com.moveit.client.model.GoogleMapService;
import com.moveit.client.model.Route;
import com.moveit.client.service.CallBack;
import com.moveit.client.service.RouteListResult;
import com.moveit.client.service.Service;
import com.moveit.client.language.LAddress;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OptimizeRouteController {

    private List<Route> allRoutes = null;

    private String fromAdr;
    private String toAdr;

    private LatLng from;
    private LatLng to;

    private RouteOptimizingPanel panel;

    private Runnable validateFromAdr = new Runnable() {
        public void run() {
            GoogleMapService.newInstance(panel.getSearchBoxFrom().getText(), new LocationCallback() {
                public void onFailure(int statusCode) {
                    handleAdrFailer(panel.getSearchBoxFrom(), LAddress.UNVALID_ADDRESS_TRY_WITH_1_FROM.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_2.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_3.text());
                }

                public void onSuccess(JsArray<Placemark> locations) {
                    if (locations == null || locations.length() == 0) {
                        handleAdrFailer(panel.getSearchBoxFrom(), LAddress.UNVALID_ADDRESS_TRY_WITH_1_FROM.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_2.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_3.text());
                    }
                    else if (locations.length() == 1) {
                        from = locations.get(0).getPoint();
                        validateToAdr.run();
                    }
                    else {
                        handleMultiple(locations, LAddress.MULTIPLE_ADDRESS_FOUND_FROM.text(), validateFromAdr);
                    }
                }
            });
        }
    };

    private Runnable validateToAdr = new Runnable() {
        public void run() {
            GoogleMapService.newInstance(panel.getSearchBoxTo().getText(), new LocationCallback() {
                public void onFailure(int statusCode) {
                    handleAdrFailer(panel.getSearchBoxFrom(), LAddress.UNVALID_ADDRESS_TRY_WITH_1_TO.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_2.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_3.text());
                }

                public void onSuccess(JsArray<Placemark> locations) {
                    if (locations == null || locations.length() == 0) {
                        handleAdrFailer(panel.getSearchBoxFrom(), LAddress.UNVALID_ADDRESS_TRY_WITH_1_TO.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_2.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_3.text());
                    }
                    else if (locations.length() == 1) {
                        to = locations.get(0).getPoint();
                        getAllRoutes.run();
                    }
                    else {
                        handleMultiple(locations, LAddress.MULTIPLE_ADDRESS_FOUND_TO.text(), getAllRoutes);
                    }
                }
            });
        }
    };


    private Runnable getAllRoutes = new Runnable() {
        public void run() {
            Service.getAllRoutes(null, new CallBack<RouteListResult>() {
                @Override
                public void success(RouteListResult result) {
                    OptimizeRouteController.this.allRoutes = result.getRoutes();
                    optimize();
                }

                @Override
                public void fail(Throwable t) {
                    //
                }
            });
        }
    };


    private void optimize() {
        int i = 1;
        Optimize or = new Optimize(from, to, panel.getMaxJobs(), panel.getMaxRadius(), allRoutes);
        List<List<Route>> list = or.getOptimized();
        list = removeDuplicates(list);

        SearchPageController.getInstance().showOptimizedRoutes(list);
        /*for (List<Route> routes : list) {
            print(i++, routes);
        }
        */

    }

    private List<List<Route>> removeDuplicates(List<List<Route>> list) {
        List<List<Route>> qualified = new ArrayList<List<Route>>();

        while (list.size() > 0){
            List<Route> firstItem = list.remove(0);

            //remove duplicates
            List<Route> temp = null;
            for (int i = 0; i<list.size(); i++){
                temp = list.get(i);
                if(containsTheSame(temp, firstItem)){
                    list.remove(temp);
                    i--;
                }
            }
            qualified.add(firstItem);
        }

        return qualified;      
    }

    private boolean containsTheSame(List<Route> temp, List<Route> list) {
        if(temp.size() != list.size()){
            return false;
        }
        for (Route route : temp) {
            if(!contains(list, route)){
                return false;
            }
        }
        return true;
    }

    private boolean contains(List<Route> list, Route route) {
        for (Route r : list) {
            if(r.getId().longValue() == route.getId()){
                return true;
            }
        }
        return false;
    }

    private void print(int i, List<Route> list){
        System.out.println("RUTE "+i);
        for (Route route : list) {
            System.out.println(route.getFromPoint().getAddress().getCityCityCodeAndNationCode() + "  -  "+ route.getToPoint().getAddress().getCityCityCodeAndNationCode());
        }
        System.out.println("");
    }


    public OptimizeRouteController() {
        panel = SearchPageController.getInstance().getMapController().getMapPanel().getSearchControl().getRouteOptimizingPanel();

    }


    public void perform() {
        validateFromAdr.run();//runs another one and so on.

    }


    private void handleAdrFailer(TextBoxComponent toFocus, String... msg) {
        InfoManager.showInfo(msg);
        toFocus.setFocus(true);
    }


    private void handleMultiple(final JsArray<Placemark> locations, String title, final Runnable nextStep) {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < locations.length(); i++) {
            items.add(locations.get(i).getAddress());
        }
        final ChooseDialog dc = new ChooseDialog(items, title, DialogComponent.Response.CANCEL, DialogComponent.Response.OK);
        VerticalComponent vc = new VerticalComponent();
        vc.add(new LabelComponent(LAddress.CHOOSE_ONE_OR_TRY_WITH.text()), new Layout17(0, 4, 0, 4));
        vc.add(new LabelComponent(LAddress.UNVALID_ADDRESS_TRY_WITH_3.text()), new Layout17(0, 4, 12, 4).add(P.FONT_WEIGHT_BOLD));
        dc.add(vc, new Layout17(12, 0, 6, 0));
        dc.show(new DialogComponent.DialogCallBack() {
            public void onClose(DialogComponent.Response r) {
                if (r == DialogComponent.Response.OK) {
                    //comming from address field to
                    if (nextStep.equals(getAllRoutes)) {
                        panel.getSearchBoxTo().setText(locations.get(dc.getChosenItem()).getAddress());
                        to = locations.get(dc.getChosenItem()).getPoint();
                    }
                    else {
                        panel.getSearchBoxFrom().setText(locations.get(dc.getChosenItem()).getAddress());
                        from = locations.get(dc.getChosenItem()).getPoint();
                    }
                    nextStep.run();
                }
                else {
                    //comming from address field to
                    if (nextStep.equals(getAllRoutes)) {
                        panel.getSearchBoxTo().setFocus(true);
                    }
                    else {
                        panel.getSearchBoxFrom().setFocus(true);
                    }
                }
            }
        });

    }

}
