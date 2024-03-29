package com.moveit.client.language;

import com.google.gwt.user.client.Window;
import com.moveit.client.gui.*;
import com.moveit.client.guicomponents.PageController;
import com.moveit.client.model.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Language implements Serializable{
    private static final long serialVersionUID = 9050866042279373824L;

    private static Map<String, Language> nameMap = new HashMap<String, Language>();
    private static Map<Integer, Language> valueMap = new HashMap<Integer, Language>();

    public static Language DANISH = new Language("Dansk", 0);
    public static Language ENGLISH = new Language("English", 1);
    public static Language GERMAN = new Language("Deutch", 2);
    public static Language FRENCH = new Language("Français", 3);
    public static Language SPANISH = new Language("Españiol", 4);

    //the actual language
    public static Language language = DANISH;


    private String name;
    private Integer value;


    public Language(String name, Integer value) {
        this.name = name;
        this.value = value;
        nameMap.put(name, this);
        valueMap.put(value, this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isLanguageDanish(){
        return value.intValue() == DANISH.getValue();
    }


    public static String get(LanguagePage lp) {
        return lp.get(language.getValue());
    }

    public static void changeLanguage(Language l) {
        if (language.getValue().intValue() == l.getValue()) {
            return;
        }
        language = l;

        //clearing
        
        PageController.clearAll();
        MenuPanel.getInstance().changeLanguage();
        LogoPanel.getInstance().changeLanguage();
        Window.setTitle(LApplication.TITLE.text());
        FloatingMenu.getInstance().load();


        if (ApplicationController.getInstance().getActiveController() != null) {
            ApplicationController.getInstance().loadPage(ApplicationController.getInstance().getActiveController());
            ApplicationController.getInstance().setCookieLanguage(language);
        }
        else {
            LanguageSelector.getInstance().setSelected(l.getName());
        }


    }

    public static Language getLanguage(Integer languageValue){
        return valueMap.get(languageValue);
    }

    public static Language getLanguage(String language){
        return nameMap.get(language);
    }

    public static void changeLanguage(String languageText) {
        Language l = nameMap.get(languageText);
        changeLanguage(l == null ? Language.DANISH : l);
    }

    public static void changeLanguage(Integer value) {
        Language l = valueMap.get(value);
        changeLanguage(l == null ? Language.DANISH : l);
    }

    public static boolean isDanish() {
        return language.getValue().intValue() == DANISH.getValue();
    }

    public static String getNationCode(){
        if(isDanish()){
            return "DK";
        }
        else{
            return "UK";
        }
    }

    public static Language getLanguage(User user) {
        return (user.getNationality() == null || user.getNationality().equalsIgnoreCase("DK")) ? Language.DANISH : Language.ENGLISH;
    }
}
