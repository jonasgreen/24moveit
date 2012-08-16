package com.moveit.server.repository;

import com.moveit.client.constants.CounterConstant;
import com.moveit.client.constants.OfferTypeConstant;
import com.moveit.client.model.*;
import com.moveit.client.util.StringUtil;
import com.moveit.server.jdo.RouteJDO;

/**
 *
 */
public class RouteConverter extends Converter<RouteJDO, Route, CreateRoute> {


    public RouteJDO convert(CreateRoute cr) {
        Counter counter = new CounterRepository().getCounter(CounterConstant.NEW_ROUTES);
        RouteJDO jdo = new RouteJDO();
        jdo.setCounter(counter.getCounter());

        jdo.setFromCity(StringUtil.capitalizeFirst(cr.getFromCity()));
        jdo.setFromCityCode(cr.getFromCityCode());
        jdo.setFromCountryCode(cr.getFromCountryCode());
        jdo.setFromCountry(StringUtil.capitalizeFirst(cr.getFromCountry()));
        jdo.setFromDate(cr.getFromDate());
        jdo.setFromLatitude(cr.getFromLatitude());
        jdo.setFromLongitude(cr.getFromLongitude());
        jdo.setFromStreet(StringUtil.capitalizeFirst(cr.getFromStreet()));

        jdo.setToCity(StringUtil.capitalizeFirst(cr.getToCity()));
        jdo.setToCityCode(cr.getToCityCode());
        jdo.setToCountryCode(cr.getToCountryCode());
        jdo.setToCountry(StringUtil.capitalizeFirst(cr.getToCountry()));
        jdo.setToDate(cr.getToDate());
        jdo.setToLatitude(cr.getToLatitude());
        jdo.setToLongitude(cr.getToLongitude());
        jdo.setToStreet(StringUtil.capitalizeFirst(cr.getToStreet()));

        jdo.setUserId(cr.getUserId());
        jdo.setCargoDescription(StringUtil.capitalizeFirst(cr.getCargoDescription()));
        jdo.setCargoType(cr.getCargoType());
        jdo.setOfferType(cr.getOfferType().getValue());
        jdo.setDeleted(false);




        jdo.setContactWish(cr.getContactWish());
        return jdo;
    }


    public Route convert(RouteJDO jdo) {
        if (jdo == null) {
            return null;
        }
        Route r = new Route();
        r.setId(jdo.getKeyId());
        r.setCargoDescription(jdo.getCargoDescription());
        r.setFromDate(jdo.getFromDate());
        r.setToDate(jdo.getToDate());
        r.setCargoType(jdo.getCargoType());
        r.setUserId(jdo.getUserId());
        r.setCreatedDate(jdo.getCreatedDate());
        r.setLastChangeDate(jdo.getLastChangeDate());
        r.setOfferType(OfferTypeConstant.map.get(jdo.getOfferType()));
        r.setDeleted(jdo.isDeleted());

        Address adrFrom = new Address();
        adrFrom.setCity(jdo.getFromCity());
        adrFrom.setCityCode(jdo.getFromCityCode());
        adrFrom.setNation(jdo.getFromCountry());
        adrFrom.setNationalCode(jdo.getFromCountryCode());
        adrFrom.setStreet(jdo.getFromStreet());
        r.setFromPoint(new GeoPoint(jdo.getFromLatitude(), jdo.getFromLongitude(), adrFrom));


        Address adrTo = new Address();
        adrTo.setCity(jdo.getToCity());
        adrTo.setCityCode(jdo.getToCityCode());
        adrTo.setNation(jdo.getToCountry());
        adrTo.setNationalCode(jdo.getToCountryCode());
        adrTo.setStreet(jdo.getToStreet());
        r.setToPoint(new GeoPoint(jdo.getToLatitude(), jdo.getToLongitude(), adrTo));

        r.setContactWish(jdo.getContactWish());
        r.setInfoShownTo(jdo.getInfoShowedTo());
        r.setCounter(jdo.getCounter());
        return r;
    }


}
