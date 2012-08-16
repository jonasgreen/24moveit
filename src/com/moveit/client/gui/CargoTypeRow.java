package com.moveit.client.gui;

import com.moveit.client.guicomponents.*;
import com.moveit.client.constants.CargoTypeConstant;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 *
 */
public class CargoTypeRow extends HorizontalComponent {
    private P backgroundColor;
    private CargoTypeConstant cargoTypeConstant;
    private ImageComponent image;
    private LabelComponent label;
    private CheckBoxComponent checkBox;
    private CargoTypePanel parent;

    public CargoTypeRow(CargoTypePanel parent, P color, CargoTypeConstant cargoType) {
        super();
        this.parent = parent;
        this.backgroundColor = color;
        this.cargoTypeConstant = cargoType;
        init();
    }

    private void init() {
        this.setBackgroundColor(backgroundColor);
        HorizontalComponent hc = new HorizontalComponent();
        hc.add(getImage(), new Layout17(2, 0, 2, 4, Horizontal.LEFT, Vertical.MIDDLE));
        image.setWidth("15px");
        image.setHeight("26px");

        hc.add(getLabel(), new TextLayout(0, 0, 0, 4, Horizontal.RIGHT, Vertical.MIDDLE).sizeEkstraSmall());


        add(hc, new Layout17(0, 0, 0, 0, Horizontal.LEFT, null));
        add(getCheckBox(), new Layout17(0, 4, 0, 0, Horizontal.RIGHT, Vertical.MIDDLE));

    }

    public ImageComponent getImage() {
        if (image == null) {
            image = new ImageComponent(MapMarker.markerPics.get(cargoTypeConstant.getValue()));
            image.getImage().addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    getCheckBox().getCheckBox().setValue(!getCheckBox().getCheckBox().getValue());
                    parent.updateMap();
                }
            });

        }
        return image;
    }

    public LabelComponent getLabel() {
        if (label == null) {
            label = new LabelComponent(cargoTypeConstant.getText());
            label.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    getCheckBox().getCheckBox().setValue(!getCheckBox().getCheckBox().getValue());
                    parent.updateMap();
                }
            });
        }
        return label;
    }

    public CheckBoxComponent getCheckBox() {
        if (checkBox == null) {
            checkBox = new CheckBoxComponent("");
            checkBox.getCheckBox().setValue(true);
            checkBox.getCheckBox().addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                public void onValueChange(ValueChangeEvent<Boolean> booleanValueChangeEvent) {
                    parent.updateMap();
                }
            });
        }
        return checkBox;
    }

    public CargoTypeConstant getCargoTypeConstant() {
        return cargoTypeConstant;
    }
}
