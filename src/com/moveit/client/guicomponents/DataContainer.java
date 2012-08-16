package com.moveit.client.guicomponents;

import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Widget;
import com.moveit.client.validator.Validator;
import com.moveit.client.validator.MandatoryValidator;

import java.util.ArrayList;
import java.util.List;

public abstract class DataContainer extends GuiComponent implements ValueContainer{

    private String name;
    private LabelComponent label;
    private List<Validator> validators = new ArrayList<Validator>();
    private boolean mandatory;


    public DataContainer(String name, boolean mandatory){
        super();
        if(mandatory){
            validators.add(new MandatoryValidator());
        }
        this.mandatory = mandatory;
        this.name = name;
        this.label = new LabelComponent("");
        setName(name);
        this.label.getLabel().setWordWrap(false);
    }

    public void setName(String name){
        this.name = name;
        label.setText(mandatory ? (name + " *") : name);
    }

    public String getName() {
        return name;
    }

    public LabelComponent getLabel() {
        return label;
    }

    public abstract Widget getDataWidget();

    public abstract GuiComponent getGui();

    public abstract void clear();

    public abstract boolean isEmpty();

    public abstract void setFocus(boolean focus);

    public void setDataIsIllegal(boolean dataIsIllegal){
        if(dataIsIllegal){
            StyleIt.add(getLabel().getLabel(),P.COLOR_DARK_RED);
        }
        else{
            StyleIt.add(getLabel().getLabel(),P.COLOR_BLACK);
        }
    }

    public DataContainer add(Validator v){
        getValidators().add(v);
        return this;
    }

    public List<Validator> getValidators() {
        return validators;
    }


    public abstract void addFocusHandler(FocusHandler fh);
    public abstract void setVisible(boolean visible);


}
