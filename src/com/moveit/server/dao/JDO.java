package com.moveit.server.dao;

import java.util.Date;

/**
 *
 */
public abstract class JDO {

    public abstract void setCreatedDate(Date createdDate);
    public abstract Date getCreatedDate();

    public abstract void setLastChangeDate(Date lastChangeDate);
    public abstract Date getLastChangeDate();


    
}
