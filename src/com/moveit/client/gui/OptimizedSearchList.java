package com.moveit.client.gui;

import com.moveit.client.guicomponents.TextLayout;
import com.moveit.client.guicomponents.VerticalComponent;
import com.moveit.client.guicomponents.LabelComponent;
import com.moveit.client.model.Route;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class OptimizedSearchList extends VerticalComponent {

    private List<List<Route>> result;
    private OptimizedSearchListRow activeRow;
    private List<OptimizedSearchListRow> rows = new ArrayList<OptimizedSearchListRow>();

    public OptimizedSearchList(List<List<Route>> list) {
        super();
        this.result = list;
        init();
    }

    private void init() {
        add(new LabelComponent(result.size() + " ruter med sammenhængende job fundet."), new TextLayout(0, 0, 20, 0).bold().sizeSmall());

        TextLayout tl = new TextLayout(0, 0, 20, 0);
        for (List<Route> routes : result) {

            OptimizedSearchListRow listRow = new OptimizedSearchListRow(this, routes);
            rows.add(listRow);
            add(listRow, tl);
        }

    }

    public void routeClicked(Route r) {
        if (activeRow != null) {
            activeRow.getSlc().routeClicked(r);
        }
    }

    public void unselectAll() {
        for (OptimizedSearchListRow optRow : rows) {
            optRow.unselct();
            SearchListController slc = optRow.getSlc();
            if (slc != null) {
                SearchList list = slc.getSearchList();
                if (list != null) {
                    for (SearchListRow row : list.getRows()) {
                        row.selected(false);
                    }
                }
            }
        }

    }

    public void setActive(OptimizedSearchListRow optimizedSearchListRow) {
        activeRow = optimizedSearchListRow;
    }
}
