package com.moveit.server.repository;

import com.moveit.client.SystemException;
import com.moveit.client.constants.CounterConstant;
import com.moveit.client.model.Counter;
import com.moveit.client.model.CreateCounter;
import com.moveit.server.dao.Dao;
import com.moveit.server.dao.FindByOneParam;
import com.moveit.server.dao.PMF;
import com.moveit.server.jdo.CounterJDO;

import java.util.Collection;

/**
 *
 */
public class CounterRepository extends Repository<CounterJDO, Counter, CreateCounter> {

    public CounterRepository() {
        super(new Dao<CounterJDO>(CounterJDO.class), new CounterConverter());
    }

    public CounterRepository(Dao<CounterJDO> CounterJDODao, Converter<CounterJDO, Counter, CreateCounter> con) {
        super(CounterJDODao, con);
    }

    public Class<Counter> getRepositoryType() {
        return Counter.class;
    }


    //returns the acutal counter and.
    //OBS: only use this outside any transaction.
    public Counter getCounter(CounterConstant cc) {
        try {
            PMF.startTransaction();
            CounterJDO jdo;
            FindByOneParam p = FindByOneParam.findCounterByKey();
            p.setValue(cc.getValue());
            Collection<CounterJDO> counters = getDao().findBy(p);
            if (counters == null || counters.isEmpty()) {
               jdo = createCounter(cc);
            }
            else {
                if (counters.size() > 1) {
                    String msg = "Data error in CounterJDO. " + cc.getName() + " has " + counters.size() + " rows";
                    throw new SystemException(msg);
                }
                jdo = counters.iterator().next();
            }
            Counter counter = getConverter().convert(jdo);

            getDao().update(jdo);

            PMF.commitTransaction();

            return counter;
        }
        finally {
            PMF.endTransaction();
        }
    }

    public void increaseCounter(Counter c){
        CounterJDO jdo = getDao().read(c.getId());
        jdo.setCounter(jdo.getCounter() + 1);
        getDao().update(jdo);
    }

    private CounterJDO createCounter(CounterConstant cc) {
        return getConverter().convert(new CreateCounter(cc));
    }


}