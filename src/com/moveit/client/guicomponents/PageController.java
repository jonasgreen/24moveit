package com.moveit.client.guicomponents;

import com.moveit.client.gui.Page;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class PageController <P extends Page>{
    private static List<PageController> controllers = new ArrayList<PageController>();

    protected Layout17 defaultLayout = new Layout17(0, 0, 0, 0, Horizontal.LEFT, null);
    protected P page;
    protected String historyName;

    protected PageController(String historyName) {
        this.historyName = historyName;
        controllers.add(this);
    }
    
    public String getHistoryName(){
        return historyName;
    }

    public abstract P newInstance();


    public void load() {
    }

    public void unload() {
    }


    public void loadFromHistory() {
        load();
    }

    //lazy loading
    public P getPage() {
        if(page == null){
            page = newInstance();
            page.setController(this);
            page.init();
        }
        return page;
    }

    public Layout17 getLayout() {
        return defaultLayout;
    }

    public abstract MenuComponent getMenu();


    public void clear(){
        this.page = null;
    }

    public static void clearAll(){
        for (PageController c : controllers) {
            c.clear();
        }
    }
}
