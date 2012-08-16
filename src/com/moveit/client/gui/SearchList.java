package com.moveit.client.gui;

import com.moveit.client.guicomponents.*;

import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class SearchList extends GuiComponent{

    private VerticalComponent content = new VerticalComponent();


    private List<SearchListRow> rows = new ArrayList<SearchListRow>();
    private SimplePanelComponent header;
    private SimplePanelComponent topPanel;
    private VerticalComponent rowPanel;

    public SearchList() {
        content.add(getTopPanel());
        content.add(getHeader());
        content.add(getRowPanel());
        initWidget(content);
    }

    public List<SearchListRow> getRows(){
        return rows;
    }

    public void addTopPanel(GuiComponent gc, Layout17 l) {
        getTopPanel().add(gc, l);
    }

    public void addHeader(GuiComponent gc, Layout17 l) {
        getHeader().add(gc, l);
    }

    public void addRow(SearchListRow row, Layout17 l){
        //SimplePanelComponent spc = new SimplePanelComponent();
        //spc.add(row);
        getRowPanel().add(row, l);
        rows.add(row);
    }

    public VerticalComponent getRowPanel() {
        if (rowPanel == null) {
            rowPanel = new VerticalComponent();
        }
        return rowPanel;
    }

    public SimplePanelComponent getHeader() {
        if (header == null) {
            header = new SimplePanelComponent();
        }
        return header;
    }

    public SimplePanelComponent getTopPanel() {
        if (topPanel == null) {
            topPanel = new SimplePanelComponent();
        }
        return topPanel;
    }

    public void removeRows(){
        rows = new ArrayList<SearchListRow>();
        getRowPanel().removeFromParent();
        rowPanel = new VerticalComponent();
        content.add(rowPanel);
    }

    public void addRows(List<SearchListRow> rows, ColorWheel cw, Layout17 l){
        for (SearchListRow row : rows) {
            row.setColor(cw.getNext());
            addRow(row, l);
        }
    }
}
