package com.moveit.client.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 */
public class CountryData {


    private static java.util.SortedMap<String, String> mapCountriesCodes = new TreeMap<String, String>();
    private static java.util.SortedMap<String, String> mapCodesCountries = new TreeMap<String, String>();
    private static java.util.SortedMap<String, String> mapBrowserLanguages = new TreeMap<String, String>();
    private static java.util.SortedMap<String, Integer> mapCodesZoom = new TreeMap<String, Integer>();

    private static CountryData instance;


    public static CountryData getInstance() {
        if (instance == null) {
            instance = new CountryData();
            initMaps();
        }
        return instance;
    }

    public SortedMap<String, String> getMap(){
        return mapCountriesCodes;
    }

    public List<String> getCountries(){
        return new ArrayList<String>(mapCodesCountries.values());
    }

    public List<String> getCountryCodes(){
        return new ArrayList<String>(mapCountriesCodes.values());
    }

    public String getCountryByCode(String countryCode){
        return mapCodesCountries.get(secureCountryCode(countryCode));
    }
    
    public Integer getZoomByCode(String countryCode){
        return mapCodesZoom.get(secureCountryCode(countryCode));
    }

    public String getCountryCode(String country){
        return mapCountriesCodes.get(country);
    }

    public String getCountryByBrowser(String browserLanguage){
        return mapBrowserLanguages.get(browserLanguage);
    }

    public String secureCountryCode(String code){
        if(code == null || code.equals("")){
            return code;
        }
        if(code.equalsIgnoreCase("GB")){
            return "UK";
        }
        return code;
    }

    //country code, countryname, ... browser-languages.
    private static void initMaps() {
        putInMap(6, "AL", "Albania");
        putInMap(6, "DZ", "Algeria");
        putInMap(6, "AS", "American Samoa");
        putInMap(6, "AD", "Andorra");
        putInMap(6, "AO", "Angola");
        putInMap(6, "AI", "Anguilla");
        putInMap(6, "AQ", "Antarctica");
        putInMap(6, "AG", "Antigua and Barbuda");
        putInMap(5, "AR", "Argentina");
        putInMap(6, "AM", "Armenia");
        putInMap(6, "AW", "Aruba");
        putInMap(4, "AU", "Australia");
        putInMap(6, "AT", "Austria");
        putInMap(6, "AZ", "Azerbaijan");

        putInMap(6, "BS", "Bahamas");
        putInMap(6, "BH", "Bahrain");
        putInMap(6, "BD", "Bangladesh");
        putInMap(6, "BB", "Barbados");
        putInMap(6, "BY", "Belarus");
        putInMap(6, "BE", "Belgium");
        putInMap(6, "BZ", "Belize");
        putInMap(6, "BJ", "Benin");
        putInMap(6, "BM", "Bermuda");
        putInMap(6, "BT", "Bhutan");
        putInMap(6, "BO", "Bolivia");
        putInMap(6, "BA", "Bosnia and Herzegowina");
        putInMap(6, "BW", "Botswana");
        putInMap(6, "BV", "Bouvet Island");
        putInMap(4, "BR", "Brazil");
        putInMap(6, "IO", "British Indian Ocean Territory");
        putInMap(6, "BN", "Brunei Darussalam");
        putInMap(6, "BG", "Bulgaria");
        putInMap(6, "BF", "Burkina Faso");
        putInMap(6, "BI", "Burundi");

        putInMap(6, "KH", "Cambodia");
        putInMap(6, "CM", "Cameroon");
        putInMap(4, "CA", "Canada");
        putInMap(6, "CV", "Cape Verde");
        putInMap(6, "KY", "Cayman Islands");
        putInMap(6, "CF", "Central African Republic");
        putInMap(6, "TD", "Chad");
        putInMap(6, "CL", "Chile");
        putInMap(4, "CN", "China");
        putInMap(6, "CX", "Christmas Island");
        putInMap(6, "CC", "Cocos (Keeling) Islands");
        putInMap(6, "CO", "Colombia");
        putInMap(6, "KM", "Comoros");
        putInMap(6, "CG", "Congo");
        putInMap(6, "CK", "Cook Islands");
        putInMap(6, "CR", "Costa Rica");
        putInMap(6, "CI", "Cote D'ivoire");
        putInMap(6, "HR", "Croatia");
        putInMap(6, "CU", "Cuba");
        putInMap(6, "CY", "Cyprus");
        putInMap(6, "CZ", "Czech Republic");

        putInMap(6, "DK", "Denmark");
        putInMap(6, "DJ", "Djibouti");
        putInMap(6, "DM", "Dominica");
        putInMap(6, "DO", "Dominican Republic");

        putInMap(6, "TP", "East Timor");
        putInMap(6, "EC", "Ecuador");
        putInMap(6, "EG", "Egypt");
        putInMap(6, "SV", "El Salvador");
        putInMap(6, "GQ", "Equatorial Guinea");
        putInMap(6, "ER", "Eritrea");
        putInMap(6, "EE", "Estonia");
        putInMap(6, "ET", "Ethiopia");

        putInMap(6, "FK", "Falkland Islands (Malvinas)");
        putInMap(6, "FO", "Faroe Islands");
        putInMap(6, "FJ", "Fiji");
        putInMap(6, "FI", "Finland");
        putInMap(6, "FR", "France");
        putInMap(6, "GF", "French Guiana");
        putInMap(6, "PF", "French Polynesia");
        putInMap(6, "TF", "French Southern Territories");

        putInMap(6, "GA", "Gabon");
        putInMap(6, "GM", "Gambia");
        putInMap(6, "GE", "Georgia");
        putInMap(6, "DE", "Germany");
        putInMap(6, "GH", "Ghana");
        putInMap(6, "GI", "Gibraltar");
        putInMap(6, "GR", "Greece");
        putInMap(6, "GL", "Greenland");
        putInMap(6, "GD", "Grenada");
        putInMap(6, "GP", "Guadeloupe");
        putInMap(6, "GU", "Guam");
        putInMap(6, "GT", "Guatemala");
        putInMap(6, "GN", "Guinea");
        putInMap(6, "GW", "Guinea-bissau");
        putInMap(6, "GY", "Guyana");

        putInMap(6, "HT", "Haiti");
        putInMap(6, "HM", "Heard and Mc Donald Islands");
        putInMap(6, "HN", "Honduras");
        putInMap(6, "HK", "Hong Kong");
        putInMap(6, "HU", "Hungary");

        putInMap(6, "IS", "Iceland");
        putInMap(5, "IN", "India");
        putInMap(6, "ID", "Indonesia");
        putInMap(6, "IR", "Iran");
        putInMap(6, "IQ", "Iraq");
        putInMap(6, "IE", "Ireland");
        putInMap(6, "IL", "Israel");
        putInMap(6, "IT", "Italy");

        putInMap(6, "JM", "Jamaica");
        putInMap(6, "JP", "Japan");
        putInMap(6, "JO", "Jordan");

        putInMap(6, "KZ", "Kazakhstan");
        putInMap(6, "KE", "Kenya");
        putInMap(6, "KI", "Kiribati");
        putInMap(6, "KW", "Kuwait");
        putInMap(6, "KG", "Kyrgyzstan");

        putInMap(6, "LA", "Lao");
        putInMap(6, "LV", "Latvia");
        putInMap(6, "LB", "Lebanon");
        putInMap(6, "LS", "Lesotho");
        putInMap(6, "LR", "Liberia");
        putInMap(6, "LY", "Libya");
        putInMap(6, "LI", "Liechtenstein");
        putInMap(6, "LT", "Lithuania");
        putInMap(6, "LU", "Luxembourg");

        putInMap(6, "MO", "Macau");
        putInMap(6, "MK", "Macedonia");
        putInMap(6, "MG", "Madagascar");
        putInMap(6, "MW", "Malawi");
        putInMap(6, "MY", "Malaysia");
        putInMap(6, "MV", "Maldives");
        putInMap(6, "ML", "Mali");
        putInMap(6, "MT", "Malta");
        putInMap(6, "MH", "Marshall Islands");
        putInMap(6, "MQ", "Martinique");
        putInMap(6, "MR", "Mauritania");
        putInMap(6, "MU", "Mauritius");
        putInMap(6, "YT", "Mayotte");
        putInMap(6, "MX", "Mexico");
        putInMap(6, "FM", "Micronesia");
        putInMap(6, "MD", "Moldova");
        putInMap(6, "MC", "Monaco");
        putInMap(6, "MN", "Mongolia");
        putInMap(6, "MS", "Montserrat");
        putInMap(6, "MA", "Morocco");
        putInMap(6, "MZ", "Mozambique");
        putInMap(6, "MM", "Myanmar");

        putInMap(6, "NA", "Namibia");
        putInMap(6, "NR", "Nauru");
        putInMap(6, "NP", "Nepal");
        putInMap(6, "NL", "Netherlands");
        putInMap(6, "AN", "Netherlands Antilles");
        putInMap(6, "NC", "New Caledonia");
        putInMap(6, "NZ", "New Zealand");
        putInMap(6, "NI", "Nicaragua");
        putInMap(6, "NE", "Niger");
        putInMap(6, "NG", "Nigeria");
        putInMap(6, "NU", "Niue");
        putInMap(6, "NF", "Norfolk Island");
        putInMap(6, "MP", "Northern Mariana Islands");
        putInMap(4, "NO", "Norway");

        putInMap(6, "OM", "Oman");

        putInMap(6, "PK", "Pakistan");
        putInMap(6, "PW", "Palau");
        putInMap(6, "PA", "Panama");
        putInMap(6, "PG", "Papua New Guinea");
        putInMap(6, "PY", "Paraguay");
        putInMap(6, "PE", "Peru");
        putInMap(6, "PH", "Philippines");
        putInMap(6, "PN", "Pitcairn");
        putInMap(6, "PL", "Poland");
        putInMap(6, "PT", "Portugal");
        putInMap(6, "PR", "Puerto Rico");

        putInMap(6, "QA", "Qatar");

        putInMap(6, "KR", "Republic Of Korea");
        putInMap(6, "RE", "Reunion");
        putInMap(6, "RO", "Romania");
        putInMap(3, "RU", "Russian Federation");
        putInMap(6, "RW", "Rwanda");

        putInMap(6, "KN", "Saint Kitts and Nevis");
        putInMap(6, "LC", "Saint Lucia");
        putInMap(6, "VC", "Saint Vincent and The Grenadines");
        putInMap(6, "WS", "Samoa");
        putInMap(6, "SM", "San Marino");
        putInMap(6, "ST", "Sao Tome and Principe");
        putInMap(6, "SA", "Saudi Arabia");
        putInMap(6, "SN", "Senegal");
        putInMap(6, "RS", "Serbia");
        putInMap(6, "SC", "Seychelles");
        putInMap(6, "SL", "Sierra Leone");
        putInMap(6, "SG", "Singapore");
        putInMap(6, "SK", "Slovakia");
        putInMap(6, "SI", "Slovenia");
        putInMap(6, "SB", "Solomon Islands");
        putInMap(6, "SO", "Somalia");
        putInMap(6, "ZA", "South Africa");
        putInMap(6, "ES", "Spain");
        putInMap(6, "LK", "Sri Lanka");
        putInMap(6, "SH", "St. Helena");
        putInMap(6, "PM", "St. Pierre and Miquelon");
        putInMap(6, "SD", "Sudan");
        putInMap(6, "SR", "Suriname");
        putInMap(6, "SJ", "Svalbard and Jan Mayen Islands");
        putInMap(6, "SZ", "Swaziland");
        putInMap(4, "SE", "Sweden");
        putInMap(6, "CH", "Switzerland");
        putInMap(6, "SY", "Syrian Arab Republic");

        putInMap(6, "TW", "Taiwan");
        putInMap(6, "TJ", "Tajikistan");
        putInMap(6, "TZ", "Tanzania");
        putInMap(6, "TH", "Thailand");
        putInMap(6, "TG", "Togo");
        putInMap(6, "TK", "Tokelau");
        putInMap(6, "TO", "Tonga");
        putInMap(6, "TT", "Trinidad and Tobago");
        putInMap(6, "TN", "Tunisia");
        putInMap(6, "TR", "Turkey");
        putInMap(6, "TM", "Turkmenistan");
        putInMap(6, "TC", "Turks and Caicos Islands");
        putInMap(6, "TV", "Tuvalu");

        putInMap(6, "UG", "Uganda");
        putInMap(6, "UA", "Ukraine");
        putInMap(6, "AE", "United Arab Emirates");
        putInMap(5, "UK", "United Kingdom");
        putInMap(4, "US", "United States");
        putInMap(6, "UY", "Uruguay");
        putInMap(6, "UZ", "Uzbekistan");

        putInMap(6, "VU", "Vanuatu");
        putInMap(6, "VA", "Vatican City State");
        putInMap(6, "VE", "Venezuela");
        putInMap(6, "VN", "Viet Nam");
        putInMap(6, "VG", "Virgin Islands (British)");
        putInMap(6, "VI", "Virgin Islands (U.S.)");

        putInMap(6, "WF", "Wallis and Futuna Islands");
        putInMap(6, "EH", "Western Sahara");

        putInMap(6, "YE", "Yemen");
        putInMap(6, "YU", "Yugoslavia");

        putInMap(6, "ZR", "Zaire");
        putInMap(6, "ZM", "Zambia");
        putInMap(6, "ZW", "Zimbabwe");
    }

    private static void putInMap(Integer zoom, String ... args) {
        String code = args[0];
        String country = args[1];

        mapCodesCountries.put(code, country);
        mapCountriesCodes.put(country, code);
        mapCodesZoom.put(code, zoom);

        int index = 2;

        while(args.length > index){
            mapBrowserLanguages.put(args[index++], country);
        }
    }

}
