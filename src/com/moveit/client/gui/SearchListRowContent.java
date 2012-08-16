package com.moveit.client.gui;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.constants.CargoTypeConstant;
import com.moveit.client.guicomponents.*;
import com.moveit.client.model.Address;
import com.moveit.client.model.Route;
import com.moveit.client.util.DateUtil;
import com.moveit.client.language.LSearchPage;

import java.util.Date;

/**
 *
 */
public class SearchListRowContent extends VerticalComponent implements ClickHandler, MouseOverHandler, MouseOutHandler{

    private Route route;
    private P color;
        private HorizontalComponent content = null;
        private boolean highlighted = false;

        private LabelComponent subFromAdr;
        private LabelComponent subToAdr;
        private LabelComponent description;
        private ButtonComponent showButton;
    private SearchListController controller;


        private static DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd. MMM.");

        //panels

        private Layout17 lCreatedPanel;
        private Layout17 lAdrFromPanel;
        private Layout17 lAdrToPanel;
        private Layout17 lDatePanel;
        private Layout17 lDescPanel;
        private Layout17 lTypePanel;

        //labels inside panels
        private static Layout17 lCreated = new TextLayout(3, 0, 0, 0, "20px", null).sizeEkstraSmall().padding(1).paddingTop(3).paddingLeft(4);

        private static Layout17 lAdrTop = new TextLayout(3, 0, 0, 0, "20px", null).sizeNormal().bold().padding(1).add(P.COLOR_ORANGE);
        private static Layout17 lAdrMiddle = new TextLayout(0, 0, 0, 0).sizeEkstraSmall().padding(1).add(P.COLOR_BLUE_DARK);

        private static Layout17 lDateTop = new TextLayout(3, 0, 0, 0).sizeEkstraSmall().padding(1).paddingTop(3);
        private static Layout17 lDateMiddle = new TextLayout(0, 0, 0, 0).sizeEkstraSmall().add(Name.LINE_HEIGHT, "0.25");
        private static Layout17 lDateBottom = new TextLayout(0, 0, 0, 0).sizeEkstraSmall().padding(1);

        private static Layout17 lDescription = new TextLayout(3, 0, 0, 0).sizeEkstraSmall().padding(1).paddingTop(3);
        private static Layout17 lShowButton = new TextLayout(3, 0, 0, 0).sizeEkstraSmall().padding(2);

        private static Layout17 lType = new TextLayout(Horizontal.CENTER, Vertical.MIDDLE).sizeEkstraSmall().padding(1);

        private ContactInfoPanel contactInfoPanel;
        private HorizontalComponent contactWrapper;
        private SearchListRow parent;



    public SearchListRowContent(SearchListController ctrl, Route r, SearchListRow parent, P color) {
        super();
        this.controller = ctrl;
        route = r;
        this.parent = parent;
        this.color = color;
        this.route = r;

        lCreatedPanel = new Layout17(4, 0, 4, 0, "100%", controller.CREATED_HEADER.getWidth(), null, Vertical.TOP);
        lAdrFromPanel = new Layout17(4, 0, 4, 0, "100%", controller.FROM_HEADER.getWidth(), null, Vertical.TOP);
        lAdrToPanel = new Layout17(4, 0, 4, 0, "100%", controller.TO_HEADER.getWidth(), null, Vertical.TOP);
        lDatePanel = new Layout17(4, 0, 4, 0, "100%", controller.PERIODE_HEADER.getWidth(), null, Vertical.TOP);
        lDescPanel = new Layout17(4, 0, 4, 0, "100%", controller.DESCRIPTION_HEADER.getWidth(), null, Vertical.TOP);
        lTypePanel = new Layout17(0, 0, 0, 0, "65%", controller.CATEGORI_HEADER.getWidth(), null, Vertical.MIDDLE);


        init();
        setBackgroundColor(this.color);
        setTitle(LSearchPage.CONTACT_INFO_TITLE.text());




        addDomHandler(this, MouseOverEvent.getType());
        addDomHandler(this, MouseOutEvent.getType());
        addDomHandler(this, ClickEvent.getType());
    }

    private void init() {
        add(getContent());
        contactWrapper = getContactWrapper();
        contactWrapper.setVisible(false);
        add(contactWrapper, new TextLayout(null, "100%"));
    }


    public void setCellHorizontalAlignment(Widget w, HasHorizontalAlignment.HorizontalAlignmentConstant align) {
        getContent().setCellHorizontalAlignment(w, align);
    }


    public HorizontalComponent getContent() {
        if (content == null) {
            content = new HorizontalComponent();
            content.add(getCreated(route), lCreatedPanel);
            content.add(getAddressFrom(route.getFromPoint().getAddress()), lAdrFromPanel);
            content.add(getAddressTo(route.getToPoint().getAddress()), lAdrToPanel);
            content.add(getPeriode(route), lDatePanel);
            content.add(getDescription(route), lDescPanel);
            content.add(getCargoType(route), lTypePanel);
        }
        return content;
    }


    private GuiComponent getDescription(Route r) {
        VerticalComponent spc = new VerticalComponent();
        description = new LabelComponent(r.getCargoDescription());
        description.getLabel().setWordWrap(true);
        spc.add(description, lDescription);

        showButton = new ButtonComponent(LSearchPage.SHOW_DESCRIPTION.text());
        spc.add(showButton, lShowButton);

        description.setVisible(false);
        return spc;

    }

    private GuiComponent getPeriode(Route r) {
        VerticalComponent spc = new VerticalComponent();

        LabelComponent l = new LabelComponent(dateFormat.format(r.getFromDate()) + " - " + dateFormat.format(r.getToDate()));
        l.getLabel().setWordWrap(false);
        spc.add(l, lDateTop);
        return spc;
    }

    private GuiComponent getCreated(Route r) {
        Date today = new Date();
        String todayString = dateFormat.format(today);
        String createdString = dateFormat.format(r.getCreatedDate());

        if (todayString.equals(createdString)) {
            createdString = LSearchPage.TODAY.text();
        }
        else {
            String yesterday = dateFormat.format(new Date(today.getTime() - DateUtil.ONE_DAY));
            if (createdString.equals(yesterday)) {
                createdString = LSearchPage.YESTERDAY.text();
            }
        }


        VerticalComponent spc = new VerticalComponent();
        LabelComponent l = new LabelComponent(createdString);
        l.getLabel().setWordWrap(false);
        spc.add(l, lCreated);
        return spc;
    }


    public HorizontalComponent getContactWrapper() {
        if (contactWrapper == null) {
            contactWrapper = new HorizontalComponent();
            contactWrapper.add(getContactInfo(), new Layout17().add(P.BORDER_TOP_SOLID_2px_999).add(P.BORDER_WIDTH_1px).add(Name.BORDER_COLOR, P.COLOR_BLUE_DARK.getValue()));

        }
        return contactWrapper;
    }

    public ContactInfoPanel getContactInfo() {
        if (contactInfoPanel == null) {
            contactInfoPanel = new ContactInfoPanel(this.parent);
            contactInfoPanel.emailValue.getHtmlContent().addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    SearchListRowContent.this.onClick(null);
                }
            });
        }
        return contactInfoPanel;
    }


    private VerticalComponent getCargoType(Route r) {
        VerticalComponent sp = new VerticalComponent();
        sp.setBackgroundColor(MapMarker.markerColors.get(r.getCargoType()));
        sp.add(new LabelComponent(CargoTypeConstant.itemMap.get(r.getCargoType()).getText()), lType);
        return sp;
    }

    private GuiComponent getAddressFrom(Address adr) {
        VerticalComponent vc = new VerticalComponent();
        vc.add(new LabelComponent(adr.getCityCityCodeAndNationCode()), lAdrTop);
        subFromAdr = new LabelComponent(adr.getStreet());
        vc.add(subFromAdr, lAdrMiddle);
        subFromAdr.setVisible(false);
        return vc;
    }

    private GuiComponent getAddressTo(Address adr) {
        VerticalComponent vc = new VerticalComponent();
        vc.add(new LabelComponent(adr.getCityCityCodeAndNationCode()), lAdrTop);
        subToAdr = new LabelComponent(adr.getStreet());
        vc.add(subToAdr, lAdrMiddle);
        subToAdr.setVisible(false);
        return vc;
    }


    public void onMouseOver(MouseOverEvent event) {
        if (!highlighted) {
            StyleIt.add(content, P.BACKGROUND_YELLOW_DARK);
        }
        event.getRelativeElement().getStyle().setProperty("cursor", "pointer");
    }


    public void onClick(ClickEvent event) {
        SearchPageController.getInstance().listRowClicked(parent);
    }

    public void clicked() {
        getContactWrapper().setVisible(!highlighted);
        highlighted = !highlighted;
        setupColor();
    }

    public void setupColor(P backgroundColor) {
        this.color = backgroundColor;
        setupColor();
    }

    private void setupColor() {
        getContactInfo().setVisible(highlighted);
        getContactInfo().setVisible(false);
        if (highlighted) {
            //getContactInfo().setValue(route);
            StyleIt.add(contactWrapper, P.BACKGROUND_YELLOW);
            StyleIt.add(content, P.BACKGROUND_YELLOW);
        }
        else {
            StyleIt.add(content, color);
            StyleIt.add(contactWrapper, color);
        }
        parent.getContactInfoButton().setVisible(highlighted);
        subFromAdr.setVisible(highlighted);
        subToAdr.setVisible(highlighted);
        showButton.setVisible(!highlighted);
        description.setVisible(highlighted);
    }


    public void onMouseOut(MouseOutEvent event) {
        if (!highlighted) {
            StyleIt.add(content, color);
        }

    }


    public void selected(boolean selected) {
        getContactWrapper().setVisible(selected);
        highlighted = selected;
        setupColor();
    }

    public Route getRoute() {
        return route;
    }

    public void setColor(P color) {
        this.color = color;
        setupColor();
    }

}
