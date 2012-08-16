package com.moveit.server.repository;

import com.moveit.client.model.Counter;
import com.moveit.client.model.CreateCounter;
import com.moveit.server.jdo.CounterJDO;

import java.util.Date;

/**
 *
 */
public class CounterConverter extends Converter<CounterJDO, Counter, CreateCounter> {


    public CounterJDO convert(CreateCounter cr) {
        CounterJDO jdo = new CounterJDO();
        jdo.setCounter((long) 0);
        jdo.setCreatedDate(new Date());
        jdo.setKey(cr.getCounterConstant().getValue());
        jdo.setName(cr.getCounterConstant().getName());
        return jdo;
    }


    public Counter convert(CounterJDO jdo) {
        if (jdo == null) {
            return null;
        }
        Counter model = new Counter();
        model.setCounter(jdo.getCounter());
        model.setId(jdo.getKeyId());
        model.setKey(jdo.getKey());
        model.setName(jdo.getName());
        model.setCreatedDate(jdo.getCreatedDate());

        return model;
    }


}