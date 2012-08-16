package com.moveit.client.gui;

import com.google.gwt.maps.client.geom.LatLng;
import com.moveit.client.model.Route;
import com.moveit.client.util.OptimizeRouteController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OptimizedSearchState extends SearchState {
    private static OptimizedSearchState instance;


    private OptimizedSearchList optSearchList = null;

    private OptimizedSearchState() {
    }

    public static OptimizedSearchState getInstance() {
        if (instance == null) {
            instance = new OptimizedSearchState();
        }
        return instance;
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
        optSearchList.routeClicked(r);
        SearchPageController.getInstance().getMapController().routeClicked(r);
    }

    public void mapDoubleClicked(LatLng point) {
    }

    public void search() {
        OptimizeRouteController or = new OptimizeRouteController();
        or.perform();
    }

    public void setFocus() {
        SearchPageController.getInstance().getMapController().getMapPanel().getSearchControl().getRouteOptimizingPanel().getSearchBoxFrom().setFocus(true);
    }

    public void cargoTypesChanged() {
    }

    public static void clear() {
        instance = null;
    }

    public void showOptimizedRoutes(List<List<Route>> list) {
        optSearchList = new OptimizedSearchList(sortByLength(list));
        SearchPageController.getInstance().getPage().addSearchResults(optSearchList);
    }


    private List<List<Route>> sortByLength(List<List<Route>> all){
        List<List<Route>> one = new ArrayList<List<Route>>();
        List<List<Route>> two = new ArrayList<List<Route>>();
        List<List<Route>> three = new ArrayList<List<Route>>();
        List<List<Route>> more = new ArrayList<List<Route>>();

        for (List<Route> routes : all) {
            if(routes.size() == 1){
                one.add(routes);
            }
            else if(routes.size() == 2){
                two.add(routes);
            }
            else if(routes.size() == 3){
                three.add(routes);
            }
            else {
                more.add(routes);
            }
        }

        List<List<Route>> retVal = new ArrayList<List<Route>>();
        retVal.addAll(more);
        retVal.addAll(three);
        retVal.addAll(two);
        retVal.addAll(one);
        return retVal;




    }

}
