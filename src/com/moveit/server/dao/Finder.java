package com.moveit.server.dao;

import javax.jdo.PersistenceManager;
import java.util.List;

/**
 *
 */
public abstract class Finder <J extends JDO>{

    public abstract List<J> execute(Class jdoClass, PersistenceManager pm);



}
