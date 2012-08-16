package com.moveit.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.moveit.client.guicomponents.*;
import com.moveit.client.model.Route;
import com.moveit.client.util.MouseOver;
import com.moveit.client.language.LSearchPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class SearchListController {

    public static class Header {

        private String name;
        private String width;

        private Header(String name, String width) {
            this.name = name;
            this.width = width;
        }

        public String getWidth() {
            return width;
        }

        public String getName() {
            return name;
        }
    }

    public SearchListController(){

    }


    public Header CREATED_HEADER = new Header(LSearchPage.HEADER_CREATED.text(), "70px");
    public Header FROM_HEADER = new Header(LSearchPage.HEADER_FROM.text(), "210px");
    public Header TO_HEADER = new Header(LSearchPage.HEADER_TO.text(), "210px");
    public Header PERIODE_HEADER = new Header(LSearchPage.HEADER_PERIOD.text(), "130px");
    public Header DESCRIPTION_HEADER = new Header(LSearchPage.HEADER_DESCRIPTION.text(), "235px");
    public Header CATEGORI_HEADER = new Header(LSearchPage.HEADER_CATEGORI.text(), "85px");


    public Header[] headers = new Header[]{CREATED_HEADER, FROM_HEADER, TO_HEADER, PERIODE_HEADER, DESCRIPTION_HEADER, CATEGORI_HEADER};


    private SearchList searchList;
    private ColorWheel cw = new ColorWheel(P.BACKGROUND_WHITE_DARKER, P.BACKGROUND_WHITE);
    private Layout17 lRow = new TextLayout().borderBottom(1).borderColor(P.COLOR_BLACK);
    private boolean sortByCreatedDesc = false;
    private boolean sortByDate = true;
    private boolean sortByTo = true;
    private boolean sortByCategori = true;
    private boolean sortByFrom = true;
    private LabelComponent numberOfJobsLabel;


    public SearchList getSearchList() {
        return searchList;
    }

    public SearchList createSearchList(List<Route> routes) {
        if (searchList == null) {
            searchList = new SearchList();

            Layout17 topHeaderL = new TextLayout(Horizontal.LEFT, null);
            searchList.addTopPanel(getTopPanel(routes), topHeaderL);
            searchList.addHeader(getHeader(), topHeaderL);
            cw.rollBack();
            for (Route route : routes) {
                searchList.addRow(new SearchListRow(this, route, cw.getNext()), lRow);
            }
            return searchList;
        }
        else {
            //update search list like Map is updated.  and re-run colorwheel.            
            List<Route> cloneList = new ArrayList<Route>();
            for (Route r : routes) {
                cloneList.add(r);
            }

            List<SearchListRow> orgList = searchList.getRows();
            List<SearchListRow> alive = new ArrayList<SearchListRow>();
            List<SearchListRow> toRemove = new ArrayList<SearchListRow>();
            for (SearchListRow slr : orgList) {
                if (existIn(slr.getRoute(), routes)) {
                    alive.add(slr);
                }
                else {
                    toRemove.add(slr);
                }
            }

            for (SearchListRow slr : toRemove) {
                slr.removeFromParent();
                orgList.remove(slr);
            }


            for (SearchListRow slr : alive) {
                if (existIn(slr.getRoute(), cloneList)) {
                    cloneList.remove(slr.getRoute());
                }
            }

            for (Route r : cloneList) {
                searchList.addRow(new SearchListRow(this, r, cw.getNext()), lRow);
            }

            //setting correct colors in new list
            cw.rollBack();
            for (SearchListRow slr : searchList.getRows()) {
                slr.setupColor(cw.getNext());
            }

            //setting top label
            setNumberOfJobsFound(searchList.getRows().size());
        }
        return searchList;
    }


    private boolean existIn(Route r, List<Route> routes) {
        for (Route route : routes) {
            if (route.getId().longValue() == r.getId()) {
                return true;
            }
        }
        return false;

    }

    private LabelComponent getNumberOfFoundJobsLabel() {
        if (numberOfJobsLabel == null) {
            numberOfJobsLabel = new LabelComponent("");
        }
        return numberOfJobsLabel;
    }

    private void setNumberOfJobsFound(int number) {
        getNumberOfFoundJobsLabel().getLabel().setText(number + LSearchPage.FOUND_ROUTES.text());
    }

    private HorizontalComponent getTopPanel(List<Route> routes) {
        setNumberOfJobsFound(routes.size());
        HorizontalComponent sp = new HorizontalComponent();
        sp.add(getNumberOfFoundJobsLabel(), new TextLayout().paddingRight(4).sizeEkstraSmall());
        if (!SearchPageController.getInstance().getSearchCriteriaPanel().isAdvancedSearchShowing()) {
            HyperlinkComponentOld ajust = new HyperlinkComponentOld(LSearchPage.ADJUST_SEARCH.text(), false, SearchPageController.HISTORY_NAME);
            ajust.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    SearchPageController.getInstance().getSearchCriteriaPanel().adjustSearch();
                    ApplicationController.scrollUp();
                }
            });
            sp.add(ajust, new TextLayout(0, 0, 4, 0).sizeEkstraSmall());

        }
        return sp;
    }


    private HorizontalComponent getHeader() {
        HorizontalComponent hp = new HorizontalComponent();
        TextLayout l = new TextLayout().sizeSmall().bold().borderBottom(1);
        for (Header h : headers) {
            l.setWidth(h.getWidth());
            hp.add(getHeaderColumn(h), l);
        }
        return hp;
    }

    private SimplePanelComponent getHeaderColumn(Header header) {
        TextLayout la = new TextLayout().alignLeft();

        SimplePanelComponent sp = new SimplePanelComponent();
        LabelComponent l = new LabelComponent(header.getName());
        l.getLabel().setWordWrap(false);
        if (header.equals(CREATED_HEADER)) {
            setUpLabelCreated(l);
            la.paddingLeft(4);
        }
        else if (header.equals(FROM_HEADER)) {
            setUpLabelFrom(l);
        }
        else if (header.equals(TO_HEADER)) {
            setUpLabelTo(l);
        }
        else if (header.equals(PERIODE_HEADER)) {
            setUpLabelDate(l);
        }
        else if (header.equals(CATEGORI_HEADER)) {//categori
            setupLabelCategori(l);
        }
        sp.add(l, la);
        return sp;
    }

    private void setupLabelCategori(LabelComponent l) {
        l.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                sortByCategori();
            }
        });
        l.addMouseOver(MouseOver.POINTER);
    }

    private void setUpLabelDate(LabelComponent l) {
        l.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                sortDateFrom();
            }
        });
        l.addMouseOver(MouseOver.POINTER);

    }

    private void setUpLabelCreated(LabelComponent l) {
        l.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                sortDateCreated();
            }
        });
        l.addMouseOver(MouseOver.POINTER);

    }


    private void setUpLabelTo(LabelComponent l) {
        l.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                sortByTo();
            }
        });
        l.addMouseOver(MouseOver.POINTER);
    }


    private void setUpLabelFrom(LabelComponent l) {
        l.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                sortByFrom();
            }
        });
        l.addMouseOver(MouseOver.POINTER);
    }

    public void sortByCategori() {
        List<SearchListRow> list = searchList.getRows();
        Collections.sort(list, new Comparator<SearchListRow>() {
            public int compare(SearchListRow r1, SearchListRow r2) {
                int result = r1.getRoute().getCargoType().
                        compareTo(r2.getRoute().getCargoType());
                if (sortByCategori) {
                    return result;
                }
                else {
                    return result * -1;
                }
            }
        });
        sortByCategori = !sortByCategori;
        searchList.removeRows();
        cw.rollBack();
        searchList.addRows(list, cw, lRow);
    }


    private void sortByTo() {
        List<SearchListRow> list = searchList.getRows();
        Collections.sort(list, new Comparator<SearchListRow>() {
            public int compare(SearchListRow r1, SearchListRow r2) {
                int result = r1.getRoute().getToPoint().getAddress().getCity().
                        compareTo(r2.getRoute().getToPoint().getAddress().getCity());
                if (sortByTo) {
                    return result;
                }
                else {
                    return result * -1;
                }
            }
        });
        sortByTo = !sortByTo;
        searchList.removeRows();
        cw.rollBack();
        searchList.addRows(list, cw, lRow);
    }

    private void sortDateFrom() {
        List<SearchListRow> list = searchList.getRows();
        Collections.sort(list, new Comparator<SearchListRow>() {
            public int compare(SearchListRow r1, SearchListRow r2) {
                int result = r1.getRoute().getFromDate().
                        compareTo(r2.getRoute().getFromDate());
                if (sortByDate) {
                    return result;
                }
                else {
                    return result * -1;
                }
            }
        });
        sortByDate = !sortByDate;
        searchList.removeRows();
        cw.rollBack();
        searchList.addRows(list, cw, lRow);
    }

    public void sortDateCreated() {
        sortDateCreated(sortByCreatedDesc);
    }

    public void sortDateCreated(final boolean desc) {
        List<SearchListRow> list = searchList.getRows();
        Collections.sort(list, new Comparator<SearchListRow>() {
            public int compare(SearchListRow r1, SearchListRow r2) {
                int result = r1.getRoute().getCreatedDate().
                        compareTo(r2.getRoute().getCreatedDate());
                if (desc) {
                    return result;
                }
                else {
                    return result * -1;
                }
            }
        });
        sortByCreatedDesc = !desc;
        searchList.removeRows();
        cw.rollBack();
        searchList.addRows(list, cw, lRow);
    }


    private void sortByFrom() {
        List<SearchListRow> list = searchList.getRows();
        Collections.sort(list, new Comparator<SearchListRow>() {
            public int compare(SearchListRow r1, SearchListRow r2) {
                int result = r1.getRoute().getFromPoint().getAddress().getCity().
                        compareTo(r2.getRoute().getFromPoint().getAddress().getCity());
                if (sortByFrom) {
                    return result;
                }
                else {
                    return result * -1;
                }
            }
        });
        sortByFrom = !sortByFrom;
        searchList.removeRows();
        cw.rollBack();
        searchList.addRows(list, cw, lRow);
    }

    public void routeClicked(Route route) {
        for (SearchListRow row : searchList.getRows()) {
            if (row.getRoute().equals(route)) {
                row.clicked();
            }
        }
    }
}
