package com.moveit.client.guicomponents;

import com.moveit.client.constants.KeyValueConstant;
import com.moveit.client.language.Language;
import com.moveit.client.language.LAddress;
import com.moveit.client.model.Address;

/**
 *
 */
public class AddressPanel extends FlexTableComponent {
    private TipsManagerAddPage tipsManager = TipsManagerAddPage.getInstance();

    private ListContainer<String> country = new ListContainer<String>(LAddress.COUNTRY.text(), KeyValueConstant.COUNTRIES, 55, false, true);
    private StringContainer street = new StringContainer(LAddress.STREET.text(), true);
    private StringContainer city = new StringContainer(LAddress.CITY.text(), true);
    private StringContainer cityCode = new StringContainer(LAddress.POSTCODE.text(), true);


    public AddressPanel() {
        super();
        init();
    }

    private void init() {
        tipsManager.add(country, Language.get(LAddress.COUNTRY_TIP));


        Layout17 ll = new TextLayout().sizeSmall().bold();

        Layout17 tbl = new TextLayout(2, 0, 2, 10, "32px", "300px", null, Vertical.MIDDLE).sizeInput().add(P.VERTICAL_ALIGN_MIDDLE);

        setLabel(0, 0, street, ll);
        setWidget(0, 1, street, tbl);

        setLabel(1, 0, cityCode, ll);
        setWidget(1, 1, cityCode, tbl);

        setLabel(2, 0, city, ll);
        setWidget(2, 1, city, tbl);


        setLabel(3, 0, country, ll);
        setWidget(3, 1, country, new TextLayout(0, 0, 0, 10).sizeSmall());

    }


    public String getNation() {
        return country.getKey();
    }

    public String getNationCode() {
        return country.getValue();
    }

    public ListContainer getCountry() {
        return country;
    }

    public StringContainer getStreet() {
        return street;
    }

    public StringContainer getCity() {
        return city;
    }

    public StringContainer getCityCode() {
        return cityCode;
    }

    public Address getValue() {
        Address a = new Address();
        a.setNation(country.getKey());
        a.setNationalCode(country.getValue());
        a.setCity(city.getValue());
        a.setCityCode(cityCode.getValue());
        a.setStreet(street.getValue());

        return a;
    }

}
