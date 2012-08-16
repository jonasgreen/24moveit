package com.moveit.client.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Counter extends Model implements Serializable {
    private static final long serialVersionUID = 7930835722959317232L;

    private Long id;
    private Date createdDate;

    private Integer key;
    private String name;
    private Long counter;


    public Counter() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}