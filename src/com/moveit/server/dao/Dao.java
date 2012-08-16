package com.moveit.server.dao;

import com.moveit.client.SystemException;
import com.moveit.server.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class Dao<J extends JDO> {

    private Class jdoClass;

    public Dao(Class jdoClass) {
        this.jdoClass = jdoClass;
    }


    public J create(J jdo) {
        try {
            setCreatedDate(jdo);
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                J newJdo = pm.makePersistent(jdo);
                return pm.detachCopy(newJdo);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("create", jdo, t);
        }
    }


    public J read(Long id) {
        try {
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                J jdo = read(id, pm);
                return pm.detachCopy(jdo);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("read", id, t);
        }
    }


    public Collection<J> updateAll(Collection<J> jdos) {
        try {
            setLastChangeDate(jdos);
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                Collection<J> newJdos = pm.makePersistentAll(jdos);
                return pm.detachCopyAll(newJdos);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("updateAll", jdos, t);
        }
    }

    public J update(J jdo) {
        try {
            setLastChangeDate(jdo);
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                J newJdo = pm.makePersistent(jdo);
                return pm.detachCopy(newJdo);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("update", jdo, t);
        }
    }

    public Collection<J> readAll() {
        try {
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                String query = "select from " + jdoClass.getName();
                //noinspection unchecked
                List<J> list = (List<J>) pm.newQuery(query).execute();
                return pm.detachCopyAll(list);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("readAll", null, t);
        }
    }


    public void delete(Long id) {
        try {
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                J jdo = read(id, pm);
                if (jdo != null) {
                    pm.deletePersistent(jdo);
                }
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("delete", id, t);
        }
    }

    public void delete(J jdo) {
        try {
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                pm.deletePersistent(jdo);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("delete", jdo, t);
        }
    }

    public void deleteAll(Collection<J> list) {
        try {
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                pm.deletePersistentAll(list);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("deleteAll", list, t);
        }
    }


    public Collection<J> deleteAll(FindByOneParam param) {
        Collection<J> all = findBy(param);
        deleteAll(all);
        return all;
    }



    public Collection<J> findBy(FindByOneParam param) {
        try {
            if (param.getValue() == null) {
                throw new SystemException("Unable to perform FindBy. Value not set. param:" + param);
            }
            PersistenceManager pm = PMF.getPersistenceManager();
            try {
                Query query = pm.newQuery(jdoClass);
                query.setFilter(param.getFilter());
                if (param.getOrdering() != null) {
                    query.setOrdering(param.getOrdering());
                }
                query.declareParameters(param.getDeclaredParameters());
                List<J> jdos = (List<J>) query.execute(param.getValue());

                return pm.detachCopyAll(jdos);
            }
            finally {
                PMF.close(pm);
            }
        }
        catch (Throwable t) {
            throw log("findBy", param, t);
        }
    }


    private J read(Long routeId, PersistenceManager pm) {
        return pm.getObjectById((Class<J>) jdoClass, routeId);
    }


    private void setCreatedDate(J jdo) {
        jdo.setCreatedDate(new Date());
    }

    private void setLastChangeDate(Collection<J> jdos) {
        for (J j : jdos) {
            setLastChangeDate(j);
        }
    }

    private void setLastChangeDate(J j) {
        j.setLastChangeDate(new Date());
    }


    private SystemException log(String type, Object obj, Throwable t) {
        String s = "DAO: " + type + ". " + t.getClass().getName() + (obj != null ? " Object=" + obj.toString() : "");
        Logger.log(s, t);
        return new SystemException(s);
    }

}
