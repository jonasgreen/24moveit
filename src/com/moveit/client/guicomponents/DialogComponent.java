package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.moveit.client.gui.ApplicationController;
import com.moveit.client.gui.FrontPageController;
import com.moveit.client.language.LDialogbox;

import java.util.HashMap;

/**
 *
 */
public class DialogComponent extends DialogBox {


    public static enum Response {
        OK,
        CANCEL
    }


    private java.util.Map<Response, ButtonComponent> buttons = new HashMap<Response, ButtonComponent>();
    private VerticalComponent content = new VerticalComponent();
    protected DialogCallBack callBack;
    private Response[] responses;

    public interface DialogCallBack {
        public void onClose(Response r);
    }


    public DialogComponent(boolean autoHide, boolean modal, Response... responses) {
        super(autoHide, modal);
        this.responses = responses;
        //fails if initWidget is called
        //    initWidget(dialogBox);
    }

    public void show(DialogCallBack callBack) {
        center();
        this.callBack = callBack;
        show();
    }


    public void add(GuiComponent gc, Layout17 l) {
        content.add(gc);
        gc.layout(l);
        content.add(getButtons(), new Layout17(12, 4, 4, 4, Horizontal.RIGHT, null));
        add(content);
        content.setWidth("100%");
    }


    protected void buttonClicked(Response r) {
        hide();
        if (callBack != null) {
            callBack.onClose(r);
        }
    }

    private HorizontalComponent getButtons() {
        HorizontalComponent hc = new HorizontalComponent();
        for (Response r : responses) {
            hc.add(createButton(r), new Layout17(0, 4, 0, 0, Horizontal.RIGHT, null));
        }
        return hc;
    }

    private ButtonComponent createButton(Response r) {
        ButtonComponent b = new ButtonComponent();
        if (r == Response.OK) {
            b.setText(LDialogbox.OK.text());
            b.getButton().setFocus(true);
            b.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    buttonClicked(Response.OK);
                }
            });
        }
        else {
            b.setText(LDialogbox.CANCEL.text());
            b.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    buttonClicked(Response.CANCEL);
                }
            });
        }
        buttons.put(r, b);
        return b;
    }

    public ButtonComponent getButton(Response r) {
        return buttons.get(r);
    }


    public static DialogComponent showSimpleOk(String title, final PageController nextPage, String... labels) {
        DialogComponent dc = showSimpleOk(title, labels);
        dc.getButton(Response.OK).getButton().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (nextPage != null) {
                    ApplicationController.getInstance().loadPage(nextPage);
                }
                else{
                    ApplicationController.getInstance().loadPage(FrontPageController.getInstance());                    
                }
            }
        });
        return dc;
    }


    public static DialogComponent showSimpleOk(String title, String... labels) {
        DialogComponent dc = new DialogComponent(false, true, Response.OK);
        dc.setWidth("300px");
        dc.setText(title);
        VerticalComponent vc = new VerticalComponent();
        for (String l : labels) {
            if (l == null || l.equals("")) {
                vc.add(new SimplePanelComponent(), new Layout17(0, 0, 0, 0, "20px", "20px"));
            }
            else {
                LabelComponent la = new LabelComponent(l);
                la.getLabel().setWordWrap(false);
                vc.add(la, new Layout17(0, 0, 0, 0));
            }
        }
        dc.add(vc, new Layout17(12, 4, 12, 4));
        dc.show(null);
        dc.getButton(Response.OK).getButton().setFocus(true);
        return dc;
    }

    public static DialogComponent showSimpleOkCancel(String title, DialogCallBack cb, String... labels) {
        DialogComponent dc = new DialogComponent(false, true, Response.OK, Response.CANCEL);
        dc.setWidth("300px");
        dc.setText(title);
        VerticalComponent vc = new VerticalComponent();
        for (String l : labels) {
            if (l == null || l.equals("")) {
                vc.add(new SimplePanelComponent(), new Layout17(0, 0, 0, 0, "20px", "20px"));
            }
            else {
                LabelComponent la = new LabelComponent(l);
                la.getLabel().setWordWrap(false);
                vc.add(la, new Layout17(0, 0, 0, 0));
            }
        }
        dc.add(vc, new Layout17(12, 4, 12, 4));
        dc.show(cb);
        dc.getButton(Response.OK).getButton().setFocus(true);
        return dc;
    }

}
