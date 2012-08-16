package com.moveit.server.repository;

import com.moveit.client.model.CreateRoute;
import com.moveit.client.model.Route;
import com.moveit.server.dao.Dao;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.jdo.RouteJDO;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class RouteRepository extends Repository<RouteJDO, Route, CreateRoute> {

    public RouteRepository() {
        super(new Dao<RouteJDO>(RouteJDO.class), new RouteConverter());
    }

    public RouteRepository(Dao<RouteJDO> routeJDODao, Converter<RouteJDO, Route, CreateRoute> con) {
        super(routeJDODao, con);
    }

    public Class<Route> getRepositoryType() {
        return Route.class;
    }


    //FINDERS

    public Collection<Route> findByUserId(Long userId) {
        FindByOneParam p = FindByOneParam.findRoutesByUserId();
        p.setValue(userId);
        return removeDeleted(findBy(p));
    }

    public Collection<Route> findByCounter(Long counter) {
        FindByOneParam p = FindByOneParam.findRoutesByCounter();
        p.setValue(counter);
        return removeDeleted(findBy(p));
    }

    public Collection<Route> removeDeleted(Collection<Route> routes) {
        if (routes == null) {
            return null;
        }
        Collection<Route> retCol = new ArrayList<Route>();
        for (Route r : routes) {
            if (!r.isDeleted()) {
                retCol.add(r);
            }
        }
        return retCol;
    }

    public void deleteAllByUserId(Long userId) {
        FindByOneParam param = FindByOneParam.findRoutesByUserId();
        param.setValue(userId);
        deleteAll(param);
    }


    public void delete(Long id) {
        RouteJDO jdo = getDao().read(id);
        jdo.setDeleted(true);
        getDao().update(jdo);
    }


    public void deleteAll(FindByOneParam param) {
        Collection<RouteJDO> jdos = getDao().findBy(param);
        for (RouteJDO jdo : jdos) {
            jdo.setDeleted(true);
        }
        getDao().updateAll(jdos);
    }


    public void updateShownTo(Long routeId, String newInfoShownTo) {
        RouteJDO jdo = getDao().read(routeId);
        jdo.setInfoShowedTo(newInfoShownTo);
        getDao().update(jdo);
    }
}
