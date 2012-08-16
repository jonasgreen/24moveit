package com.moveit.client.gui;

import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.Timer;
import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.constants.CountryData;
import com.moveit.client.guicomponents.*;
import com.moveit.client.model.Route;
import com.moveit.client.model.User;

import java.util.List;

/**
 *
 */
public class SearchPageController extends PageController<SearchPage> {

    private GmapController mapController;
    private SearchState state = NormalSearchState.getInstance();
    private List<CargoTypeConstant> selectedCargoTypes;
    private boolean firstTimeLoad = true;

    private static SearchPageController instance = null;
    public static String HISTORY_NAME = "search";


    private SearchPageController() {
        super(HISTORY_NAME);
    }

    public static SearchPageController getInstance() {
        if (instance == null) {
            instance = new SearchPageController();
        }
        return instance;
    }

    public void markerDoubleClicked(MapMarker mMarker) {
        state.markerDoubleClicked(mMarker);
    }

    public void markerClicked(MapMarker mMarker) {
        state.markerClicked(mMarker);
    }

    public void listRowClicked(SearchListRow row) {
        state.listRowClicked(row);
    }

    public void routeClicked(Route r) {
        state.routeClicked(r);

    }

    public void mapDoubleClicked(LatLng point) {
        state.mapDoubleClicked(point);
    }


    public void repaintMap() {
        getMapController().repaint();
    }

    public MenuComponent getMenu() {
        return MenuPanel.getInstance().getFindMove();
    }


    public void search(SearchState state) {
        setState(state);
        state.search();
    }

    public SearchCriteriaPanel getSearchCriteriaPanel() {
        return getMapController().getMapPanel().getSearchControl().getSearchPanel();
    }


    public void showOptimizedRoutes(List<List<Route>> routes) {
        if (state instanceof OptimizedSearchState) {
            ((OptimizedSearchState) state).showOptimizedRoutes(routes);
        }
    }


    public SearchPage newInstance() {
        return new SearchPage();
    }

    public void unload() {
        state.setCenterFromLastSearch(getMapController().getMapPanel().getMapWidget().getCenter());
    }


    public void loadFromHistory() {
        doLoad();
    }

    public void load() {
        ApplicationController.scrollUp();
        doLoad();
    }

    private void doLoad() {
        getPage();
        page.setVisible(true);
        page.setWidth("100%");
        repaintMap();

        state.setFocus();
        Timer t = new Timer() {
            @Override
            public void run() {
                //else it wont repaint the correct way
                getMapController().setCenter(state.getCenterFromLastSearch() != null ? state.getCenterFromLastSearch() : GMap.WORLD);
                repaintMap();
            }
        };
        t.schedule(30);
        if (firstTimeLoad) {
            normalSearch();
            firstTimeLoad = false;
        }
    }


    public void normalSearch() {
        String searchText = getPage().getMap().getSearchControl().getSearchPanel().getSearchBox().getText();
        if (searchText == null || searchText.equalsIgnoreCase("")) {
            User user = ApplicationController.getInstance().getUser();
            if (user != null && user.isDriver()) {
                String country = CountryData.getInstance().getCountryByCode(user.getNationality());
                getPage().getMap().getSearchControl().getSearchPanel().getSearchBox().setText(country);
            }
        }

        search(NormalSearchState.getInstance());

    }


    public GmapController getMapController() {
        if (mapController == null) {
            mapController = new GmapController();
        }
        return mapController;
    }

    public Layout17 getLayout() {
        return new Layout17(0, 0, 0, 0, null, "100%", Horizontal.CENTER, null);
    }

    //this method is only called when user changes categories - balloons are added and removed from map
    public void cargoTypesChanged(List<CargoTypeConstant> selected) {
        this.selectedCargoTypes = selected;
        state.cargoTypesChanged();
    }


    public List<CargoTypeConstant> getSelectedCargoTypes() {
        return selectedCargoTypes;
    }

    public void setState(SearchState state) {
        if (this.state.equals(state)) {
            return;
        }
        getMapController().clear();
        getPage().clearSearchList();
        this.state = state;
    }


    public void setFirstTimeLoad(boolean firstTimeLoad) {
        this.firstTimeLoad = firstTimeLoad;
    }

    public void clear() {
        super.clear();
        mapController = null;
        firstTimeLoad = true;
        NormalSearchState.clear();
        OptimizedSearchState.clear();

        state = NormalSearchState.getInstance();
    }
}
