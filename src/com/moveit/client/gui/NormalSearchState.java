package com.moveit.client.gui;

import com.moveit.client.model.*;
import com.moveit.client.guicomponents.*;
import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.constants.CountryData;
import com.moveit.client.language.LAddress;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.geocode.LocationCallback;
import com.google.gwt.maps.client.geocode.Placemark;
import com.google.gwt.core.client.JsArray;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class NormalSearchState extends SearchState {
    private static NormalSearchState instance;
    private SearchListController listController = new SearchListController();

    private List<Route> routes = null;


    private NormalSearchState() {
    }

    public static NormalSearchState getInstance() {
        if (instance == null) {
            instance = new NormalSearchState();
        }
        return instance;
    }

    public void searchAll() {
        SearchPageController.getInstance().setState(this);
        search(new SearchCriteria());
    }

    public void search() {
        MapPopupManager.hideHelpPopup();

        SearchCriteria sr = new SearchCriteria();
        //fill up search rute
        SearchCriteriaPanel p = SearchPageController.getInstance().getSearchCriteriaPanel();


        String address = p.getSearchBox().getText();
        sr.setRadius(p.getRadius());
        sr.setFromArea(p.getRouteFrom().getCheckBox().getValue());
        sr.setToArea(p.getRouteTo().getCheckBox().getValue());


        search(sr, address);
    }

    public void setFocus() {
        SearchPageController.getInstance().getSearchCriteriaPanel().getSearchBox().setFocus(true);
    }

    public void cargoTypesChanged() {
        updateMap();
    }

    public static void clear() {
        instance = null;
    }

    private void search(final SearchCriteria rs, final String address) {
        if (address == null || address.equals("")) {
            search(rs);
        }
        else {
            //getting geopoint from address.
            GoogleMapService.newInstance(address, new LocationCallback() {
                public void onFailure(int statusCode) {
                    handleFailure();
                }

                public void onSuccess(JsArray<Placemark> locations) {
                    handleSucces(locations, rs);
                }
            });
        }
    }


    private void handleFailure() {
        InfoManager.showInfo(LAddress.UNVALID_ADDRESS_TRY_WITH_1.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_2.text(), LAddress.UNVALID_ADDRESS_TRY_WITH_3.text());
    }


    private void handleSucces(final JsArray<Placemark> locations1, final SearchCriteria rs) {
        if (locations1.length() == 1) {
            Placemark pl = locations1.get(0);
//            System.out.println(pl.getCountry());
            rs.setLatitude(locations1.get(0).getPoint().getLatitude());
            rs.setLongitude(locations1.get(0).getPoint().getLongitude());
            rs.setCountryCode(CountryData.getInstance().secureCountryCode(locations1.get(0).getCountry()));
            search(rs);
        }
        else {
            List<String> items = new ArrayList<String>();
            for (int i = 0; i < locations1.length(); i++) {
                items.add(locations1.get(i).getAddress());
            }
            final ChooseDialog dc = new ChooseDialog(items, LAddress.MULTIPLE_ADDRESS_FOUND.text(), DialogComponent.Response.CANCEL, DialogComponent.Response.OK);
            VerticalComponent vc = new VerticalComponent();
            vc.add(new LabelComponent(LAddress.CHOOSE_ONE_OR_TRY_WITH.text()), new Layout17(0, 4, 0, 4));
            vc.add(new LabelComponent(LAddress.UNVALID_ADDRESS_TRY_WITH_3.text()), new Layout17(0, 4, 12, 4).add(P.FONT_WEIGHT_BOLD));
            dc.add(vc, new Layout17(12, 0, 6, 0));
            dc.show(new DialogComponent.DialogCallBack() {
                public void onClose(DialogComponent.Response r) {
                    if (r == DialogComponent.Response.OK) {
                        SearchPageController.getInstance().getSearchCriteriaPanel().getSearchBox().setText(locations1.get(dc.getChosenItem()).getAddress());
                        Placemark pm = locations1.get(dc.getChosenItem());
                        rs.setLatitude(pm.getPoint().getLatitude());
                        rs.setLongitude(pm.getPoint().getLongitude());
                        rs.setCountryCode(CountryData.getInstance().secureCountryCode(pm.getCountry()));
                        search(rs);
                    }
                    else {
                        SearchPageController.getInstance().getSearchCriteriaPanel().getSearchBox().setFocus(true);
                    }
                }
            });

        }
    }


    public void markerDoubleClicked(MapMarker mMarker) {
    }

    public void markerClicked(MapMarker mMarker) {
        routeClicked(mMarker.getMapRoute().getRoute());
    }

    public void listRowClicked(SearchListRow row) {
        routeClicked(row.getRoute());
    }

    public void routeClicked(Route r) {
        listController.routeClicked(r);
        SearchPageController.getInstance().getMapController().routeClicked(r);
    }

    public void mapDoubleClicked(LatLng point) {
        //search(point);
    }

    private void search(final SearchCriteria rs) {

        RouteManager.getInstance().getRoutes(rs, new RouteManagerCallBack() {
            public void onSucces(List<Route> routes) {

                SearchCriteriaPanel p = SearchPageController.getInstance().getSearchCriteriaPanel();
                p.getSearchBox().setFocus(true);

                if (rs.getCountryCode() == null) {
                    setCenterFromLastSearch(GMap.WORLD);
                    SearchPageController.getInstance().getMapController().setCenter(getCenterFromLastSearch());
                    SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().setZoomLevel(2);
                }
                else {
                    setCenterFromLastSearch(LatLng.newInstance(rs.getLatitude(), rs.getLongitude()));
                    SearchPageController.getInstance().getMapController().setCenter(getCenterFromLastSearch());
                    Integer zoomLevel = CountryData.getInstance().getZoomByCode(rs.getCountryCode());
                    SearchPageController.getInstance().getMapController().getMapPanel().getMapWidget().setZoomLevel(zoomLevel);

                }
                SearchPageController.getInstance().getMapController().repaint();

                setRoutes(routes == null ? new ArrayList<Route>() : routes);
                updateMap();
                listController.sortDateCreated(false);

            }

            public void onFailure(Throwable t) {

            }
        });
    }

    //this one is called when a search is performed - balloons on map is rebuild from scratch.
    private void updateMap() {
        if (routes == null) {
            return;
        }
        List<Route> sortedRoutes = new ArrayList<Route>();
        for (Route r : routes) {
            if (isAccepted(r)) {
                sortedRoutes.add(r);
            }
        }

        SearchPageController.getInstance().getPage().addSearchResults(listController.createSearchList(sortedRoutes));
        SearchPageController.getInstance().getMapController().load(sortedRoutes);
    }

    private boolean isAccepted(Route r) {
        List<CargoTypeConstant> listTypes = SearchPageController.getInstance().getSelectedCargoTypes();
        if (listTypes == null) {
            return true;
        }
        for (CargoTypeConstant c : listTypes) {
            if (r.getCargoType() == c.getValue()) {
                return true;
            }
        }
        return false;
    }


    private void setRoutes(List<Route> list) {
        routes = list;
    }

}
