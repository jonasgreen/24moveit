package com.moveit.server.dao;

import com.moveit.client.SystemException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.util.Map;
import java.util.HashMap;

/**
 *
 */
public class PMF {


    private static Map<Thread, PersistenceManager> pmMap = new HashMap<Thread, PersistenceManager>();

    private static final PersistenceManagerFactory pmfInstance = JDOHelper
            .getPersistenceManagerFactory("transactions-optional");


    private PMF() {
    }


    private static PersistenceManager getGlobalPersistenceManager() {
        PersistenceManager pm = pmMap.get(Thread.currentThread());
        if (pm != null) {
            return pm;
        }
        pm = pmfInstance.getPersistenceManager();
        pmMap.put(Thread.currentThread(), pm);
        return pm;
    }

    public static void startTransaction() {
        PersistenceManager pm = getGlobalPersistenceManager();
        pm.currentTransaction().begin();
    }

    public static void endTransaction() {
        PersistenceManager pm = pmMap.remove(Thread.currentThread());
        if (pm == null) {
            throw new SystemException("Trying to end transaction on persistence manager, that does not exist");
        }

        if (pm.currentTransaction().isActive()) {
            pm.currentTransaction().rollback();
        }
        pm.close();
    }

    public static void commitTransaction() {
        PersistenceManager pm = pmMap.get(Thread.currentThread());
        if (pm == null) {
            throw new SystemException("Trying to commit transaction on persistence manager, that does not exist");
        }
        pm.currentTransaction().commit();

    }


    public static PersistenceManager getPersistenceManager() {
        PersistenceManager pm = pmMap.get(Thread.currentThread());
        if (pm != null) {
            return pm;
        }
        return pmfInstance.getPersistenceManager();
    }


    public static void close(PersistenceManager pm) {
        if (pmMap.get(Thread.currentThread()) == null) {
            pm.close();
        }
    }


}
